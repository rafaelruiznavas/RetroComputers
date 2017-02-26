package com.ruiznavas.retrocomputers.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.ruiznavas.retrocomputers.R;
import com.ruiznavas.retrocomputers.entity.Computer;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.R.attr.filter;

/**
 * Created by zhanos on 11/02/2017.
 */

public class ComputerAdapter  extends ArrayAdapter<Computer>{
    private ArrayList<Computer> originalList;
    private ArrayList<Computer> computerList;
    private ComputerFilter filter;

    public ComputerAdapter(Activity context, ArrayList<Computer> computers){
        super(context, 0, computers);
        this.computerList = new ArrayList<Computer>();
        this.computerList.addAll(computers);
        this.originalList = new ArrayList<Computer>();
        this.originalList.addAll(computers);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Computer currentComputer = getItem(position);

        TextView textListItem = (TextView)listItemView.findViewById(R.id.textListItem);
        textListItem.setText(currentComputer.getName());

        ImageView imageListItem = (ImageView)listItemView.findViewById(R.id.imgListItem);
        if(currentComputer.hasImage()) {
            int resourceImage = this.getContext().getResources().getIdentifier(currentComputer.getImage(),
                    "drawable", this.getContext().getPackageName());
            imageListItem.setImageResource(resourceImage);
        }

        return listItemView;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        if(filter == null){
            filter = new ComputerFilter();
        }
        return filter;
    }

    private class ComputerFilter extends Filter{
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults result = new FilterResults();
            if(!constraint.toString().isEmpty()){
                constraint = constraint.toString().toLowerCase();
                ArrayList<Computer> filteredItems = new ArrayList<Computer>();

                for(int i=0,l=originalList.size();i<l;i++){
                    Computer computer = originalList.get(i);
                    if(computer.getName().toLowerCase().contains(constraint))
                        filteredItems.add(computer);
                }
                result.count = filteredItems.size();
                result.values = filteredItems;
            }else{
                synchronized (this){
                    result.values = originalList;
                    result.count = originalList.size();
                }
            }
            return result;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            computerList = (ArrayList<Computer>)results.values;
            notifyDataSetChanged();
            clear();
            for(int i=0,l=computerList.size();i<l;i++)
                add(computerList.get(i));
            notifyDataSetChanged();
        }
    }
}
