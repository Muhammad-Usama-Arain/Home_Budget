package com.example.muhammadusama.home_budget;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListViewAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] maintitle;
    private final Integer[] imgid;

    public MyListViewAdapter(Activity context, String[] maintitle, Integer[] imgid) {
        super(context, R.layout.custom_list_view, maintitle);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.maintitle=maintitle;
        this.imgid=imgid;

    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.custom_list_view, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.text_in_list_view);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.image_in_list_view);

        titleText.setText(maintitle[position]);
        imageView.setImageResource(imgid[position]);
        return rowView;

    };
}
