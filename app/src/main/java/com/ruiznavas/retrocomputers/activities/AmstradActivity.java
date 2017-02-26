package com.ruiznavas.retrocomputers.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ruiznavas.retrocomputers.R;
import com.ruiznavas.retrocomputers.adapters.ComputerAdapter;
import com.ruiznavas.retrocomputers.entity.Computer;

import java.util.ArrayList;
import java.util.List;

public class AmstradActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amstrad);
        setTitle(R.string.title_amstrad);

        final ArrayList<Computer> computers = new ArrayList<Computer>();
        computers.add(new Computer("Amstrad CPC 464", R.drawable.s_amstrad646));
        computers.add(new Computer("Amstrad CPC 6128", R.drawable.s_amstrad6128));
        computers.add(new Computer("Amstrad CPC 6128+", R.drawable.s_amstrad6128plus));
        computers.add(new Computer("Amstrad CPC 664", R.drawable.s_amstradcpc664));
        computers.add(new Computer("Amstrad CPC PCW"));

        ComputerAdapter computerAdapter = new ComputerAdapter(this, computers);

        ListView listView = (ListView)findViewById(R.id.listComputers);
        listView.setAdapter(computerAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Computer computer = computers.get(position);
                Intent i = new Intent(AmstradActivity.this, ComputerActivity.class);
                i.putExtra("computer", computer);
                startActivity(i);
            }
        });
    }
}
