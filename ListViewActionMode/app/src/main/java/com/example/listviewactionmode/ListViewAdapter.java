package com.example.listviewactionmode;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<String> {

    private List<String> fruits = new ArrayList<>();
    Context context;

    public ListViewAdapter(@NonNull Context context, int resource, List<String> list) {

        super(context, R.layout.item_layout, list);

        this.context = context;
        this.fruits = list;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = ((Activity)context).getLayoutInflater();
        View row = layoutInflater.inflate(R.layout.item_layout, parent,false);

        TextView fruitName = row.findViewById(R.id.fruit_name);
        fruitName.setText(fruits.get(position));

        CheckBox checkBox = row.findViewById(R.id.checkBox);
        checkBox.setTag(position);

        if(MainActivity.isActiveMode) {
            checkBox.setVisibility(View.VISIBLE);
        } else {
            checkBox.setVisibility(View.GONE);
        }

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                int position = (int)buttonView.getTag();

                if(MainActivity.userSelection.contains(fruits.get(position))){
                    MainActivity.userSelection.remove(fruits.get(position));
                } else {
                    MainActivity.userSelection.add(fruits.get(position));
                }

                MainActivity.actionMode.setTitle(MainActivity.userSelection.size() + "items selected");

            }
        });

        return row;

    }

    public void removeItems(List<String> list){

        fruits.removeAll(list);

        notifyDataSetChanged();

    }
}
