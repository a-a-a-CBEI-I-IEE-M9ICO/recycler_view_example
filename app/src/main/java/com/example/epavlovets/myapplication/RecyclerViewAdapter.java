package com.example.epavlovets.myapplication;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by epavlovets on 15.08.2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context mContext;
    private ArrayList<TestItem> dataHorizontal;
    private ArrayList<TestItem> dataVertical;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public RecyclerViewAdapter(ArrayList<TestItem> dataHorizontal, ArrayList<TestItem> dataVertical, Context context) {
        setDataHorizontal(dataHorizontal);
        setDataVertical(dataVertical);
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            //inflate your layout and pass it to view holder
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
            return new MyViewHolder(v);
        } else if (viewType == TYPE_HEADER) {
            //inflate your layout and pass it to view holder
            View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.row_header, parent, false);
            return new MyViewHolderHeader(v);
        }
        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            String name = getDataVertical().get(position-1).mName;
            Log.d("###", "Setting name: " + name);
            ((MyViewHolder) holder).getmDataTextView().setText(name);
        } else if (holder instanceof MyViewHolderHeader) {
            //cast holder to VHHeader and set data for header.
            Log.d("####", "HEADER");
        }
    }

    @Override
    public int getItemCount() {
        return dataVertical.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;
        }

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    public void setDataHorizontal(ArrayList<TestItem> dataHorizontal) {
        this.dataHorizontal = dataHorizontal;
    }

    public ArrayList<TestItem> getDataHorizontal() {
        return dataHorizontal;
    }

    public void setDataVertical(ArrayList<TestItem> dataVertical) {
        this.dataVertical = dataVertical;
    }

    public ArrayList<TestItem> getDataVertical() {
        return dataVertical;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView mDataTextView;

        public MyViewHolder(View v) {
            super(v);
            mDataTextView = (TextView) v.findViewById(R.id.data_vertical);
        }

        public TextView getmDataTextView() {
            return mDataTextView;
        }
    }

    private class MyViewHolderHeader extends RecyclerView.ViewHolder {
        private final RecyclerView mHorizontalRecyclerView;

        public MyViewHolderHeader(View v) {
            super(v);
            mHorizontalRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_horizontal);
            RecyclerViewAdapterHorizontal mAdapter = new RecyclerViewAdapterHorizontal(getDataHorizontal());
            LinearLayoutManager layoutManager
                    = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);

            mHorizontalRecyclerView.setLayoutManager(layoutManager);
            mHorizontalRecyclerView.setAdapter(mAdapter);
        }
    }
}
