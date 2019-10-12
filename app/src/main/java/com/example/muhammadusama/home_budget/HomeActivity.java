package com.example.muhammadusama.home_budget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;
    FragmentManager fragmentManager= null;
    FragmentTransaction fragmentTransaction;
    Fragment currentFragment =null;
    BottomNavigationView navigation;
    boolean notNow=false;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:

                    currentFragment =new HomeFragment();
                     fragmentTransaction= getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.repalce_able_frame, currentFragment,"Home");
                    fragmentTransaction.commit();
                    getSupportActionBar().setTitle("Home");

                    return true;
                    case R.id.navigation_expenses:

                        currentFragment =new CategoriesFragment();
                        fragmentTransaction= getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.repalce_able_frame, currentFragment,"Categories");
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Expenses");

                        return true;

                case R.id.navigation_statistics:

                    currentFragment =new StatisticsFragment();
                    fragmentTransaction= getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.repalce_able_frame, currentFragment,"Statistics");
                    fragmentTransaction.commit();
                    getSupportActionBar().setTitle("Statistics");

                    return true;

                case R.id.navigation_settings:

                    currentFragment =new SettingsFragment();
                    fragmentTransaction= getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.repalce_able_frame, currentFragment,"Settings");
                    fragmentTransaction.commit();
                    getSupportActionBar().setTitle("Settings");

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

         fragmentManager = getSupportFragmentManager();

         currentFragment=  new HomeFragment();
//        CategoriesFragment categoriesFragment= new CategoriesFragment();
//        StatisticsFragment statisticsFragment = new StatisticsFragment();
//        SettingsFragment settingsFragment = new SettingsFragment();

        fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.repalce_able_frame, currentFragment, "Home");
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Home");




//        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



    }

//    @Override
//    public void onBackPressed() {
//        if(  fragmentManager.findFragmentByTag("Categories") instanceof CategoriesFragment
//                ||  fragmentManager.findFragmentByTag("Settings") instanceof SettingsFragment
//           )
//        {
//
//            fragmentManager.beginTransaction().replace(R.id.repalce_able_frame,new HomeFragment()).commit();
//            navigation.setSelectedItemId(R.id.navigation_home);
//
//
//        }
//        else {
//            super.onBackPressed();
//
//        }
//    }

    private boolean doubleBackToExitPressedOnce;

    @Override
    public void onBackPressed() {

        if(fragmentManager.findFragmentByTag("Categories") instanceof CategoriesFragment
                ||  fragmentManager.findFragmentByTag("Settings") instanceof SettingsFragment)
        {

            fragmentManager.beginTransaction().replace(R.id.repalce_able_frame,new HomeFragment()).commit();
            navigation.setSelectedItemId(R.id.navigation_home);
            getSupportActionBar().setTitle("Home");

            notNow=true;


        }
        if (doubleBackToExitPressedOnce){
            super.onBackPressed();
            return;
        }

        doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press Again To Exit", Toast.LENGTH_SHORT).show();

        Timer t = new Timer();
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2500);

    }
}

