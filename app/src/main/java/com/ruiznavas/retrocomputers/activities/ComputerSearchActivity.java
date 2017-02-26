package com.ruiznavas.retrocomputers.activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ruiznavas.retrocomputers.R;
import com.ruiznavas.retrocomputers.adapters.ComputerAdapter;
import com.ruiznavas.retrocomputers.entity.Computer;
import com.ruiznavas.retrocomputers.utils.LoaderComputer;

import java.util.ArrayList;

import static android.R.attr.handle;

public class ComputerSearchActivity extends AppCompatActivity {
    ArrayList<Computer> computers;
    ComputerAdapter computerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_search);

        computers = LoaderComputer.extractComputers(this);
        computerAdapter = new ComputerAdapter(this, computers);


        ListView listView = (ListView)findViewById(R.id.listComputers);
        listView.setAdapter(computerAdapter);

        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Computer computer = computers.get(position);
                Intent i = new Intent(ComputerSearchActivity.this, ComputerActivity.class);
                i.putExtra("computer", computer);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
        final SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconified(true);

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                computerAdapter.getFilter().filter("");
                return false;
            }
        });

        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if(Intent.ACTION_SEARCH.equals(intent.getAction())){
            String query = intent.getStringExtra(SearchManager.QUERY);
            computerAdapter.getFilter().filter(query);
        }
    }
}
