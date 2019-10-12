package com.example.muhammadusama.home_budget;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class BarchartFragment extends Fragment {

    ListView listView ;

    String[] maintitle ={
            "HOME & UTILITY", "TRAVEL", "EDUCATION", "FOOD","RENT" ,"GROCERIES"
            ,"Health Care" ,"Saving","Personal Care","Entertainment" ,"Miscellaneous" };

    Integer[] subtitle={
            12,11,3,7,14,24,5,3,13,12,11 };
    Integer [] colors={Color.parseColor("#EFC2D2"),Color.parseColor("#E3F5B0"),
            Color.parseColor("#F4D087"),Color.parseColor("#C2F5B1"),Color.parseColor("#ACF5CF"),
            Color.parseColor("#5B80E7"),Color.parseColor("#B9D6F1"),Color.parseColor("#E4C0F2"),
            Color.parseColor("#E1A1A6"),Color.parseColor("#D0D2C5"),Color.parseColor("#62CEB3")};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_bar_chart, container, false);
        listView = view.findViewById(R.id.list_view_in_barchart_activity);
        BarChart chart = (BarChart) view.findViewById(R.id.chart);


        BarDataSet firstDS= new BarDataSet(getDataSet1(),"Expenses Categories");
        firstDS.setColors(ColorTemplate.VORDIPLOM_COLORS);

        BarDataSet secondDS = new BarDataSet(getDataSet2(),"Data Set 2");
        secondDS.setColors(ColorTemplate.COLORFUL_COLORS);


        BarData bardataa= new BarData(firstDS,secondDS);
        chart.setData(bardataa);


        XAxis xAxis = chart.getXAxis();
        xAxis.enableGridDashedLine(10f, 10f, 0f);
//        xAxis.setAxisMaximum(1);
        xAxis.setAxisMinimum(0);
        xAxis.setDrawLimitLinesBehindData(true);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(getXAxisValues()));


//
//        XAxis xAxis = chart.getXAxis();
//        xAxis.setValueFormatter(new IndexAxisValueFormatter(getXAxisValues()));
        xAxis.setCenterAxisLabels(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);


        chart.setDragEnabled(true);
//        chart.setVisibleXRangeMaximum(2);
//
//        float barSpace=0.08f;
//        float groupSpace=0.44f;
        bardataa.setBarWidth(5);
//
        // chart.getXAxis().setAxisMaximum(0);
//        chart.getXAxis().setAxisMaximum(0+chart.getBarData().getGroupWidth(groupSpace,barSpace)*6);
        //   chart.getAxisLeft().setAxisMinimum(0);


        //     chart.groupBars(0,groupSpace,barSpace);

        chart.getDescription().setText("My Spendings");
        chart.animateXY(2000, 2000);
        chart.invalidate();
        //  drawChart();

        ListViewAdapterForBarChart listViewAdapterForBarChart = new ListViewAdapterForBarChart(getActivity(),maintitle,subtitle,colors);
        listView.setAdapter(listViewAdapterForBarChart);


        return view;
    }
    private ArrayList<BarEntry> getDataSet1() {
        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(110.000f, 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(40.000f, 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(60.000f, 2); // Mar
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(30.000f, 3); // Apr
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(90.000f, 4); // May
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(100.000f, 5); // Jun
        valueSet1.add(v1e6);

        return valueSet1;

    }

    public ArrayList<BarEntry> getDataSet2(){
        ArrayList<BarEntry> valueSet2 = new ArrayList<>();
        BarEntry v2e1 = new BarEntry(150.000f, 0); // Jan
        valueSet2.add(v2e1);
        BarEntry v2e2 = new BarEntry(90.000f, 1); // Feb
        valueSet2.add(v2e2);
        BarEntry v2e3 = new BarEntry(120.000f, 2); // Mar
        valueSet2.add(v2e3);
        BarEntry v2e4 = new BarEntry(60.000f, 3); // Apr
        valueSet2.add(v2e4);
        BarEntry v2e5 = new BarEntry(20.000f, 4); // May
        valueSet2.add(v2e5);
        BarEntry v2e6 = new BarEntry(80.000f, 3.5f); // Jun
        valueSet2.add(v2e6);
        BarEntry v2e7 = new BarEntry(40.000f, 5); // Jun
        valueSet2.add(v2e7);
        BarEntry v2e8 = new BarEntry(10.000f, 2); // Jun
        valueSet2.add(v2e8);
        BarEntry v2e9 = new BarEntry(45.000f, 4); // Jun
        valueSet2.add(v2e9);
        BarEntry v2e10 = new BarEntry(88.000f, 5); // Jun
        valueSet2.add(v2e10);
        BarEntry v2e11 = new BarEntry(93.000f, 6.7f); // Jun
        valueSet2.add(v2e11);

        return valueSet2;
    }
    private String[] getXAxisValues() {
        String xAxis[] = new String[]{"JAN","FEB","MAR","APR","MAY","JUN","JAN","FEB","MAR","APR","MAY","JUN"};
        return xAxis;
    }
}
