package com.example.muhammadusama.home_budget;

public class DataModel {

    public static final int ONLY_TEXT=0;
    public static final int REMAINING=1;

    String category;
    String spend;
    int type;
    int image;

    public DataModel(String category, String spend, int type, int image) {
        this.category = category;
        this.spend = spend;
        this.type = type;
        this.image=image;
    }

    public int getType() {
        return type;
    }
    public int getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public String getSpend() {
        return spend;
    }
}