package com.brendan.projects.swapi.utils.ui;


import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.brendan.projects.swapi.R;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    ArrayList<String[]> arrayList;
    Context c;

    public ListAdapter(Context c, ArrayList<String[]> list) {
        arrayList = list;
        this.c = c;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View row = null;
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            row = inflater.inflate(R.layout.list_adapter, parent,
                    false);
        } else {
            row = convertView;
        }
        String[] detail = arrayList.get(position);

        TextView title = (TextView) row.findViewById(R.id.title);
        title.setText(detail[0]);
        TextView content = (TextView) row.findViewById(R.id.subtitle);
        content.setText(detail[1]);

        Typeface tf = Typeface.createFromAsset(row.getContext().getAssets(), "Roboto-Medium.ttf");
        title.setTypeface(tf);
        content.setTypeface(tf);

        return row;
    }

}