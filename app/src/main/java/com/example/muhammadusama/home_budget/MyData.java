package com.example.muhammadusama.home_budget;

public class MyData {

    static String[] category_names = {"Top Spending Categories","HOME & UTILITY", "TRAVEL", "EDUCATION", "FOOD","RENT" ,"GROCERIES"
            ,"Health Care" ,"Saving","Personal Care","Entertainment" ,"Miscellaneous" };
    static String[] amount_spended = {"","$ 192 spent", "$ 12 spent", "$ 300 spent", "$ 130 spent","$ 152 spent", "$ 102 spent","$ 192 spent", "$ 12 spent", "$ 300 spent",
            "$ 130 spent","$ 152 spent"};

    static Integer[] drawableArray = {0, R.drawable.house,R.drawable.travel, R.drawable.education,
            R.drawable.foods,R.drawable.rent,R.drawable.grocery,R.drawable.heartbeat, R.drawable.piggy_bank, R.drawable.medicine,
            R.drawable.camera,R.drawable.choices};

    static Integer[] id_ = {DataModel.ONLY_TEXT, DataModel.REMAINING, DataModel.REMAINING,DataModel.REMAINING,DataModel.REMAINING,
            DataModel.REMAINING,DataModel.REMAINING,DataModel.REMAINING,DataModel.REMAINING,DataModel.REMAINING,DataModel.REMAINING,DataModel.REMAINING};
}
