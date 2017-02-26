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

public class CommodoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodore);
        setTitle(R.string.title_commodore);

        final ArrayList<Computer> computers = new ArrayList<Computer>();
        computers.add(new Computer("Commodore PET", R.drawable.s_commodorepet2001));
        computers.add(new Computer("Commodore VIC 20", R.drawable.s_commodorevic20));
        computers.add(new Computer("Commodore 64", R.drawable.s_commodore64));
        computers.add(new Computer("Commodore C16", R.drawable.s_commodorec16));
        computers.add(new Computer("Commodore 128", R.drawable.s_commodore128));
        computers.add(new Computer("Commodore Plus 4", R.drawable.s_commodoreplus4));
        computers.add(new Computer("Commodore Amiga 500", R.drawable.s_commodoreamiga500));
        computers.add(new Computer("Commodore Amiga 600", R.drawable.s_commodoreamiga600));
        computers.add(new Computer("Commodore Amiga 1200", R.drawable.s_commodoreamiga1200));
        computers.add(new Computer("Commodore Amiga 2000", R.drawable.s_commodoreamiga2000));
        computers.add(new Computer("Commodore Amiga 3000", R.drawable.s_commodoreamiga3000));
        computers.add(new Computer("Commodore Amiga 4000", R.drawable.s_commodoreamiga4000));

        ComputerAdapter computerAdapter = new ComputerAdapter(this, computers);

        ListView listView = (ListView)findViewById(R.id.listComputers);
        listView.setAdapter(computerAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Computer computer = computers.get(position);
                Intent i = new Intent(CommodoreActivity.this, ComputerActivity.class);
                i.putExtra("computer", computer);
                startActivity(i);
            }
        });
    }
}
