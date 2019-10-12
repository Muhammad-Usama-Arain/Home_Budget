package com.example.muhammadusama.home_budget;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class StatisticsFragment extends Fragment {


    CardView barchart,piechart,linechart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.activity_statistics_, container, false);
        barchart = view.findViewById(R.id.bar_chart_cardview);
        piechart = view.findViewById(R.id.piechart_cardview);
        linechart = view.findViewById(R.id.linechart_cardview);

        barchart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFragmentManager().beginTransaction().replace(R.id.repalce_able_frame,new BarchartFragment(),"Bar")
                        .addToBackStack("Statistics").commit();

            }
        });

        piechart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.repalce_able_frame,new CategoriesFragment(),"Categories").addToBackStack("Statistics").commit();
            }
        });

        linechart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.repalce_able_frame,new LineFragment(),"Line").addToBackStack("Statistics").commit();
            }
        });

        return view;
    }

}
