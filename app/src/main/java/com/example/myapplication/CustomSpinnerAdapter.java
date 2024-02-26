package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomSpinnerAdapter extends ArrayAdapter<String> {

    public CustomSpinnerAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View rowView = inflater.inflate(R.layout.spinner_item_layout_open, parent, false);

        TextView textView = rowView.findViewById(android.R.id.text1);
        textView.setText(getItem(position));

        return rowView;
    }
}
//public class CustomSpinnerAdapter extends ArrayAdapter<String> {
//
//    public CustomSpinnerAdapter(Context context, List<String> objects) {
//        super(context, android.R.layout.simple_spinner_dropdown_item, objects);
//    }
//
//    @Override
//    public View getDropDownView(int position, View convertView, ViewGroup parent) {
//        // No need to inflate a custom layout, use the default layout
//        return super.getDropDownView(position, convertView, parent);
//    }
//}