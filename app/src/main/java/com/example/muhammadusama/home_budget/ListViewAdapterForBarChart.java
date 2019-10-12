package com.example.muhammadusama.home_budget;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ListViewAdapterForBarChart extends ArrayAdapter {
    private  Activity context;
    private  String[] category=new String[]{};
    private  Integer[] percent= new Integer[]{};
    private  Integer[] colors= new Integer[]{};

    public ListViewAdapterForBarChart(Activity context, String[] category, Integer[] percent,Integer[] colors) {
        super(context, R.layout.layout_for_custombar, category);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.category=category;
        this.percent=percent;
        this.colors= colors;

    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.layout_for_custombar, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.category_name_in_listview);
        TextView subtitle = (TextView) rowView.findViewById(R.id.percent_spend);
        RelativeLayout relativeLayout = rowView.findViewById(R.id.use_for_color);


        titleText.setText(category[position]);
        subtitle.setText(percent[position]+" % of whole spending");
        relativeLayout.setBackgroundColor(colors[position]);
        return rowView;

    };
}
