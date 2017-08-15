package com.example.epavlovets.myapplication;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by epavlovets on 15.08.2017.
 */

class RecyclerViewAdapterHorizontal extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final ArrayList<TestItem> mData;

    public RecyclerViewAdapterHorizontal(ArrayList<TestItem> dataHorizontal) {
        mData = dataHorizontal;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new RecyclerViewAdapterHorizontal.MyViewHolderHeader(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String name = mData.get(position).mName;
        Log.d("###", "Setting name: " + name);
        ((RecyclerViewAdapterHorizontal.MyViewHolderHeader) holder).getmDataTextView().setText(name);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    private class MyViewHolderHeader extends RecyclerView.ViewHolder {
        private final TextView mDataTextView;

        public MyViewHolderHeader(View v) {
            super(v);
            mDataTextView = (TextView) v.findViewById(R.id.data_vertical);
        }

        public TextView getmDataTextView() {
            return mDataTextView;
        }
    }
}
