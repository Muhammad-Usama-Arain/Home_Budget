package com.example.muhammadusama.home_budget;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter {

    private ArrayList<DataModel> dataSet;
    int totalTypes;


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView categoryName;
        TextView categoryCost;
        ImageView imageView;

        public MyViewHolder(View itemView) {

            super(itemView);
            this.categoryName = (TextView) itemView.findViewById(R.id.category_name);
            this.categoryCost = (TextView) itemView.findViewById(R.id.category_spend);
            this.imageView = itemView.findViewById(R.id.category_icon);

        }
    }

    public static class TextOnly extends RecyclerView.ViewHolder {

        TextView txtType;

        public TextOnly(View itemView) {
            super(itemView);

            this.txtType = (TextView) itemView.findViewById(R.id.single_text_view);
        }
    }


    public CustomAdapter(ArrayList<DataModel> data) {
        this.dataSet = data;
        totalTypes =dataSet.size();

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {

        View view;

        switch (viewType){
            case DataModel.ONLY_TEXT:
                view  = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_view_layout_for_text, parent, false);
                 return new TextOnly(view);

            case DataModel.REMAINING:
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.card_view_layout, parent, false);
                return new MyViewHolder(view);

        }
//
//         MyViewHolder myViewHolder = new MyViewHolder(view);
//        return myViewHolder;
        return null;

    }

    @Override
    public int getItemViewType(int position) {

        switch (dataSet.get(position).type){
            case 0: return DataModel.ONLY_TEXT;
            case 1: return DataModel.REMAINING;
            default: return -1;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        DataModel model= dataSet.get(listPosition);
        if(model!=null){
            switch (model.type){
                case DataModel.ONLY_TEXT:
                    ((TextOnly)holder).txtType.setText(model.category);
                    break;
                case DataModel.REMAINING:
                    ((MyViewHolder)holder).categoryName.setText(model.getCategory());
                    ((MyViewHolder)holder).categoryCost.setText(model.getSpend());
                    ((MyViewHolder)holder).imageView.setImageResource(model.getImage());
                    break;

            }
        }

//        TextView textViewName = holder.categoryName;
//        TextView textViewVersion = holder.categoryCost;
//        ImageView imageView = holder.categoryIcon;
//
//        textViewName.setText(dataSet.get(listPosition).getCategory());
//        textViewVersion.setText(dataSet.get(listPosition).getSpend());
//        imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}

