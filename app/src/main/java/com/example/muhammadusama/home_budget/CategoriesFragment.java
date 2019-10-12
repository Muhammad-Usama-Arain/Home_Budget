package com.example.muhammadusama.home_budget;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class CategoriesFragment extends Fragment {

    private static CustomAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    int[]colorClassArray=new int[]{R.color.colorBlue,R.color.colorMargenda,R.color.colorBrown,
            R.color.colorBlueDark,R.color.colorGray,R.color.colorGreen,R.color.colorLight,R.color.colorLGreen,R.color.colorLOrange
            ,R.color.colorPink,R.color.colorSky};
    PieChart pieChart;


    int[] colors= new int[]{Color.parseColor("#EFC2D2"),Color.parseColor("#E3F5B0"),
            Color.parseColor("#F4D087"),Color.parseColor("#C2F5B1"),Color.parseColor("#ACF5CF"),
            Color.parseColor("#5B80E7"),Color.parseColor("#B9D6F1"),Color.parseColor("#E4C0F2"),
            Color.parseColor("#E1A1A6"),Color.parseColor("#D0D2C5"),Color.parseColor("#62CEB3")};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.activity_categories, container, false);
        // Inflate the layout for this fragment

        recyclerView = view.findViewById(R.id.categories_cardView2);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.category_names.length; i++) {
            data.add(new DataModel(
                    MyData.category_names[i],
                    MyData.amount_spended[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]
            ));

        }

        adapter = new CustomAdapter(data);
        recyclerView.setAdapter(adapter);

        pieChart  = view.findViewById(R.id.piechart_categories);
       drawChart();

        return view;

    }

    private void drawChart() {
        pieChart.setUsePercentValues(true);
        ArrayList<PieEntry> yvalues = new ArrayList<PieEntry>();
        yvalues.add(new PieEntry(.11f, "Home & Utility"));
        yvalues.add(new PieEntry(0.00f, "Travel"));
        yvalues.add(new PieEntry(.18f, "Education"));
        yvalues.add(new PieEntry(.07f, "Food"));
        yvalues.add(new PieEntry(.09f, "Rent"));
//        yvalues.add(new PieEntry(.06f, "Groceries"));
        yvalues.add(new PieEntry(.11f, "Health Care"));
//        yvalues.add(new PieEntry(.18f, "Saving"));
//        yvalues.add(new PieEntry(.07f, "Personal Care"));
//        yvalues.add(new PieEntry(.12f, "Misc"));


        PieDataSet dataSet = new PieDataSet(yvalues, "");
        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        PieData data = new PieData(dataSet);

        data.setValueFormatter(new PercentFormatter());
        pieChart.setData(data);
        Description description = new Description();
        description.setText("Pie Chart           ");
        pieChart.setDescription(description);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setTransparentCircleRadius(55f);
        pieChart.setTransparentCircleAlpha(110);
        pieChart.setRotationEnabled(true);
        pieChart.setHighlightPerTapEnabled(true);
        //color for the months name or yvalues
        pieChart.setEntryLabelColor(Color.BLACK);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.BLACK);

        pieChart.invalidate();

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

                if (e == null)
                    return;
                Log.i("VAL SELECTED",
                        "Value: " + e.getY() + ", index: " + h.getX()
                                + ", DataSet index: " + h.getDataSetIndex());
            }

            @Override
            public void onNothingSelected() {

            }
        });
    }

}
