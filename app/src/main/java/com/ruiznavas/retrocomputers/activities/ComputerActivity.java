package com.ruiznavas.retrocomputers.activities;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.ruiznavas.retrocomputers.R;
import com.ruiznavas.retrocomputers.entity.Computer;

import org.w3c.dom.Text;

public class ComputerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        Computer computer = (Computer)getIntent().getSerializableExtra("computer");

        setTitle(computer.getName());

        if(computer.hasImage()){
            int resourceImage = getResources().getIdentifier(computer.getImage(),
                    "drawable", getPackageName());
            ImageView imageComputer = (ImageView) findViewById(R.id.imageComputer);
            imageComputer.setImageResource(resourceImage);
        }

        TextView title = (TextView)findViewById(R.id.titleComputer);
        title.setText(computer.getName());

        TextView description = (TextView)findViewById(R.id.descriptionComputer);
        description.setText(computer.getDescription());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
