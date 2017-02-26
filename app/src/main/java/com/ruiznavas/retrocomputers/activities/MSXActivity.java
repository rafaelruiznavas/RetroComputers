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

public class MSXActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msx);
        setTitle(R.string.title_msx);

        final ArrayList<Computer> computers = new ArrayList<Computer>();
        computers.add(new Computer("Canon V-8", R.drawable.s_canonv8));
        computers.add(new Computer("Canon V-10"));
        computers.add(new Computer("Canon V-20"));
        computers.add(new Computer("Canon V-25"));
        computers.add(new Computer("Canon V-30"));
        computers.add(new Computer("Canon V-30F"));
        computers.add(new Computer("Canon V-335"));
        computers.add(new Computer("Casio MX-10", R.drawable.s_casiomx10));
        computers.add(new Computer("Casio MX-15"));
        computers.add(new Computer("Casio X-101"));
        computers.add(new Computer("Casio PV-7"));
        computers.add(new Computer("Casio PV-16"));
        computers.add(new Computer("CE-TEC MPC-80"));
        computers.add(new Computer("Daewoo DPC-100"));
        computers.add(new Computer("Daewoo DPC-200"));
        computers.add(new Computer("Daewoo CPC-51"));
        computers.add(new Computer("Daewoo CPC-300"));
        computers.add(new Computer("Daewoo CPC-330K KOVO"));
        computers.add(new Computer("Daewoo CPC-400 X-II"));
        computers.add(new Computer("Daewoo CPC-400S X-II"));
        computers.add(new Computer("Daewoo CPC-61"));
        computers.add(new Computer("Dragon MSX-64"));
        computers.add(new Computer("Fujitsu FM-X"));
        computers.add(new Computer("General PAXON-PC K50"));
        computers.add(new Computer("General PAXON-PC T50"));
        computers.add(new Computer("General PAXON-PC T55"));
        computers.add(new Computer("GoldStar FC-80"));
        computers.add(new Computer("GoldStar FC-200"));
        computers.add(new Computer("GoldStar GFC-1080"));
        computers.add(new Computer("Gradiente Expert"));
        computers.add(new Computer("Hitachi Hint"));
        computers.add(new Computer("Hitachi MB-H1"));
        computers.add(new Computer("Hitachi MB-H80"));
        computers.add(new Computer("Hitachi MB-H3"));
        computers.add(new Computer("Hitachi MB-H70"));
        computers.add(new Computer("JVC HC-7e"));
        computers.add(new Computer("JVC HC-180"));
        computers.add(new Computer("Mitsubishi ML-FX1"));
        computers.add(new Computer("Mitsubishi ML-FX2"));
        computers.add(new Computer("Mitsubishi ML-G3"));
        computers.add(new Computer("Panasonic CF 2700"));
        computers.add(new Computer("Panasonic FS-A1FX"));
        computers.add(new Computer("Panasonic FS-A1WX"));
        computers.add(new Computer("Panasonic FS-A1WSX"));
        computers.add(new Computer("Panasonic FSA1-ST"));
        computers.add(new Computer("Panasonic FSA1-GT"));
        computers.add(new Computer("Philips VG-801"));
        computers.add(new Computer("Philips VG-8020"));
        computers.add(new Computer("Philips VG-8220"));
        computers.add(new Computer("Philips VG-8235"));
        computers.add(new Computer("Philips NMS-8245"));
        computers.add(new Computer("Philips NMS-8235"));
        computers.add(new Computer("Philips NMS-8250"));
        computers.add(new Computer("Philips NMS-8255"));
        computers.add(new Computer("Philips NMS-8280"));
        computers.add(new Computer("Pioner PX-V7"));
        computers.add(new Computer("Pioner PX-V60"));
        computers.add(new Computer("Radiola MX-180"));
        computers.add(new Computer("Samsung SPC-800"));
        computers.add(new Computer("Sanyo MPC-100"));
        computers.add(new Computer("Sanyo MPC-200"));
        computers.add(new Computer("Sanyo WAVY-PHC-70FD"));
        computers.add(new Computer("Sharp hotbit"));
        computers.add(new Computer("Sony HB55P"));
        computers.add(new Computer("Sony HB10P"));
        computers.add(new Computer("Sony HB20P"));
        computers.add(new Computer("Sony HB75P"));
        computers.add(new Computer("Sony HB101 (Hit-Bit)"));
        computers.add(new Computer("Sony HB-F9S"));
        computers.add(new Computer("Sony HB-F700"));
        computers.add(new Computer("Sony HB-F1XDJ"));
        computers.add(new Computer("Spectravideo SVI-728"));
        computers.add(new Computer("Spectravideo SVI-738"));
        computers.add(new Computer("Talent DPC-200"));
        computers.add(new Computer("Talent DPC-200A"));
        computers.add(new Computer("Talent DPC-300"));
        computers.add(new Computer("Talent TPC-310"));
        computers.add(new Computer("Toshiba HX-10"));
        computers.add(new Computer("Toshiba HX-20"));
        computers.add(new Computer("Toshiba HX-23"));
        computers.add(new Computer("Toshiba HX-23F"));
        computers.add(new Computer("Toshiba HX-33"));
        computers.add(new Computer("Toshiba HX-34"));
        computers.add(new Computer("Yamaha CX5M II"));
        computers.add(new Computer("Yamaha CX7M II"));
        computers.add(new Computer("Yamaha YIS503 III"));

        ComputerAdapter computerAdapter = new ComputerAdapter(this, computers);

        ListView listView = (ListView)findViewById(R.id.listComputers);
        listView.setAdapter(computerAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Computer computer = computers.get(position);
                Intent i = new Intent(MSXActivity.this, ComputerActivity.class);
                i.putExtra("computer", computer);
                startActivity(i);
            }
        });
    }
}
