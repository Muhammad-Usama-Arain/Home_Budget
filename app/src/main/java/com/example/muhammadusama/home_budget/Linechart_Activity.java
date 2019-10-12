package com.example.muhammadusama.home_budget;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;


import java.util.ArrayList;
import java.util.List;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Utils;

public class Linechart_Activity extends AppCompatActivity {


    private static final String TAG = "SomeTag";
    LineChart lineChart;
    TextView maxSpent,recentSpent,netSpent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linechart_);

        //Initializing textviews

        maxSpent = findViewById(R.id.max_spent);
        recentSpent = findViewById(R.id.recent_spent);
        netSpent = findViewById(R.id.net_spent);


        lineChart = findViewById(R.id.lineChart);
        LineDataSet lineDataSet = new LineDataSet(dataValues1(),"Categories Costs");

        Description description = new Description();
        description.setText("User Monthly Spending Graph");
        lineChart.setDescription(description);


        if (Utils.getSDKInt() >= 18) {
//            Toast.makeText(this,"fadeable",Toast.LENGTH_SHORT).show();
            lineDataSet.setDrawFilled(true);
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.fablue);
            lineDataSet.setFillDrawable(drawable);
        } else {
            lineDataSet.setFillColor(Color.DKGRAY);
            lineDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        }
//   ArrayList<LineDataSet> dataSets = new ArrayList<>();
//        dataSets.add(lineDataSet);

        ArrayList<ILineDataSet> dataSets_ = new ArrayList<>();
        dataSets_.add(lineDataSet);

        LineData data = new LineData(dataSets_);
        lineChart.setData(data);
        lineDataSet.setDrawCircleHole(false);
//       lineDataSet.setDrawCircles(false);
        lineDataSet.setDrawCircleHole(true);
  //      Toast.makeText(this,"Entries :"+lineDataSet.getEntryForIndex(lineDataSet.getEntryCount()-1),Toast.LENGTH_SHORT).show();
//        Log.i(TAG, "onCreate: "+lineDataSet.getEntryCount());
//        Toast.makeText(this,"X Maximum :"+lineDataSet.getXMax(),Toast.LENGTH_SHORT).show();
//        Toast.makeText(this,"Y Maximum :"+lineDataSet.getYMax(),Toast.LENGTH_SHORT).show();

        maxSpent.setText("$ "+lineDataSet.getYMax());
        Entry lastentry = lineDataSet.getEntryForIndex(lineDataSet.getEntryCount()-1);
        recentSpent.setText("$ "+lastentry.getY());

        //net spending

        float total=0f;
        for(int i=0;i<lineDataSet.getEntryCount();i++){
           Entry entry= lineDataSet.getEntryForIndex(i);
           total= total+ entry.getY();
        }

        netSpent.setText("$ "+total);

        //        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setCircleColor(Color.BLACK);
//        lineDataSet.setCircleHoleColor(Color.BLACK);
        lineDataSet.setColor(Color.rgb(8,127,191));
        lineDataSet.setLineWidth(3);
        lineChart.invalidate();


    }

    private ArrayList<Entry> dataValues1(){
        ArrayList<Entry> dataVals = new ArrayList<>();
        dataVals.add(new Entry(0,10));
        dataVals.add(new Entry(1,15));
        dataVals.add(new Entry(2,10));
        dataVals.add(new Entry(3,28));
        dataVals.add(new Entry(4,12));
        dataVals.add(new Entry(5,28));
        dataVals.add(new Entry(6,30));
        dataVals.add(new Entry(7,22));
        dataVals.add(new Entry(8,23));
        dataVals.add(new Entry(9,20));
        dataVals.add(new Entry(10,33));
        dataVals.add(new Entry(11,22));

            return dataVals;
    }
}

