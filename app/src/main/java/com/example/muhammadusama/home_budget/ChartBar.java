package com.example.muhammadusama.home_budget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.os.Bundle;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

public class ChartBar extends AppCompatActivity implements OnChartValueSelectedListener {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        listView = findViewById(R.id.list_view_in_barchart_activity);
        BarChart chart = (BarChart) findViewById(R.id.chart);
      //  BarData data = new BarData(getDataSet().get(0),getDataSet().get(1));
//        data.addDataSet(getDataSet().get(0));
//        data.addDataSet(getDataSet().get(1));

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

        ListViewAdapterForBarChart listViewAdapterForBarChart = new ListViewAdapterForBarChart(this,maintitle,subtitle,colors);
        listView.setAdapter(listViewAdapterForBarChart);
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
//    private void drawChart() {
//        PieChart pieChart = findViewById(R.id.pie);
//        pieChart.setUsePercentValues(true);
//         ArrayList<PieEntry> yvalues = new ArrayList<PieEntry>();
//        yvalues.add(new PieEntry(8f, "January", 0));
//        yvalues.add(new PieEntry(15f, "February", 1));
//        yvalues.add(new PieEntry(12f, "March", 2));
//        yvalues.add(new PieEntry(25f, "April", 3));
//        yvalues.add(new PieEntry(23f, "May", 4));
//        yvalues.add(new PieEntry(17f, "June", 5));
//
//        PieDataSet dataSet = new PieDataSet(yvalues, "        Election Results");
//        PieData data = new PieData(dataSet);
//
//        data.setValueFormatter(new PercentFormatter());
//        pieChart.setData(data);
//        Description description = new Description();
//        description.setText("Pie Chart");
//        pieChart.setDescription(description);
//        pieChart.setDrawHoleEnabled(true);
//        pieChart.setTransparentCircleRadius(65f);
//        pieChart.setTransparentCircleAlpha(110);
//        pieChart.setRotationEnabled(true);
//        pieChart.setHighlightPerTapEnabled(true);
//        //color for the months name or yvalues
//        pieChart.setEntryLabelColor(Color.BLACK);
//
//        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
//        data.setValueTextSize(13f);
//        data.setValueTextColor(Color.DKGRAY);
//
//        pieChart.invalidate();
//
//        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
//            @Override
//            public void onValueSelected(Entry e, Highlight h) {
//
//                if (e == null)
//                    return;
//                Log.i("VAL SELECTED",
//                        "Value: " + e.getY() + ", index: " + h.getX()
//                                + ", DataSet index: " + h.getDataSetIndex());
//            }
//
//            @Override
//            public void onNothingSelected() {
//
//            }
//        });
//    }


    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}

