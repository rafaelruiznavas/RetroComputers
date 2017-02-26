package com.ruiznavas.retrocomputers.utils;

import android.content.Context;
import android.util.Log;

import com.ruiznavas.retrocomputers.R;
import com.ruiznavas.retrocomputers.entity.Computer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by zhanos on 19/02/2017.
 */

public final class LoaderComputer {
    public static ArrayList<Computer> extractComputers(Context context){
        ArrayList<Computer> computers = new ArrayList<>();

        try{
            JSONObject jsonObject = new JSONObject(LoaderComputer.loadJSONFromAsset(context));
            JSONArray featuresArray = jsonObject.getJSONArray("computers");
            for(int i=0;i<featuresArray.length();i++){
                JSONObject obj = featuresArray.getJSONObject(i);
                Computer computer = new Computer();
                computer.setName(obj.getString("NAME"));
                computer.setImage(obj.getString("image"));
                computer.setDescription(obj.getString("description"));
                computers.add(computer);
            }
        }catch(JSONException e){
            Log.e("QueryUtils","Problem parsing JSON results", e);
        }


        return computers;
    }

    public static String loadJSONFromAsset(Context context){
        String json = null;
        try{
            InputStream is = context.getResources().openRawResource(
                    context.getResources().getIdentifier("retrocomputers","raw", context.getPackageName()));
            int size = is.available();
            byte [] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }catch(IOException ex){
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
