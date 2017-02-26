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

public class SpectrumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spectrum);
        setTitle(R.string.title_spectrum);

        final ArrayList<Computer> computers = new ArrayList<Computer>();
        computers.add(new Computer("Sinclair ZX80", R.drawable.s_zx80));
        computers.add(new Computer("Sinclair ZX81", R.drawable.s_zx81));
        computers.add(new Computer("Sinclair ZX Spectrum 16K/48K", R.drawable.s_zxspectrum));
        computers.add(new Computer("Sinclair ZX Spectrum+", R.drawable.s_zxspectrumplus));
        computers.add(new Computer("Sinclair ZX Spectrum 128", R.drawable.s_zxspectrum128));
        computers.add(new Computer("Sinclair ZX Spectrum +2", R.drawable.s_zxspectrumplus2));
        computers.add(new Computer("Sinclair ZX Spectrum +2A/+2B", R.drawable.s_zxspectrum2a));
        computers.add(new Computer("Sinclair ZX Spectrum +3", R.drawable.s_zxspectrum3));

        ComputerAdapter computerAdapter = new ComputerAdapter(this, computers);

        ListView listView = (ListView)findViewById(R.id.listComputers);
        listView.setAdapter(computerAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Computer computer = computers.get(position);
                Intent i = new Intent(SpectrumActivity.this, ComputerActivity.class);
                i.putExtra("computer", computer);
                startActivity(i);
            }
        });
    }
}
