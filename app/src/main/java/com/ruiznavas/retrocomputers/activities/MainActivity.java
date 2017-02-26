package com.ruiznavas.retrocomputers.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ruiznavas.retrocomputers.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView spectrum = (ImageView)findViewById(R.id.spectrum);
        spectrum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SpectrumActivity.class);
                startActivity(i);
            }
        });

        ImageView commodore = (ImageView)findViewById(R.id.commodore);
        commodore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CommodoreActivity.class);
                startActivity(i);
            }
        });

        ImageView amstrad = (ImageView)findViewById(R.id.amstrad);
        amstrad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AmstradActivity.class);
                startActivity(i);
            }
        });

        ImageView msx = (ImageView)findViewById(R.id.msx);
        msx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MSXActivity.class);
                startActivity(i);
            }
        });
    }
}
