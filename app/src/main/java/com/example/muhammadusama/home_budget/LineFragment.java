package com.example.muhammadusama.home_budget;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LineFragment extends Fragment {

    private static final String TAG = "SomeTag";
    LineChart lineChart;
    TextView maxSpent,recentSpent,netSpent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_linechart_, container, false);

        maxSpent = view.findViewById(R.id.max_spent);
        recentSpent = view.findViewById(R.id.recent_spent);
        netSpent = view.findViewById(R.id.net_spent);


        lineChart = view.findViewById(R.id.lineChart);
        LineDataSet lineDataSet = new LineDataSet(dataValues1(),"Categories Costs");

        Description description = new Description();
        description.setText("User Monthly Spending Graph");
        lineChart.setDescription(description);


        if (Utils.getSDKInt() >= 18) {
//            Toast.makeText(this,"fadeable",Toast.LENGTH_SHORT).show();
            lineDataSet.setDrawFilled(true);
            Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.fablue);
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

           return view;
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
