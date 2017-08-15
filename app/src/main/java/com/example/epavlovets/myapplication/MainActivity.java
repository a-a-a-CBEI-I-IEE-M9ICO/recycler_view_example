package com.example.epavlovets.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<TestItem> dataHorizontal;
    private ArrayList<TestItem> dataVertical;
    private RecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_main);
        dataHorizontal = new ArrayList<>();
        dataVertical = new ArrayList<>();

        fillTestData(dataVertical);
        fillTestData(dataHorizontal);
        mAdapter = new RecyclerViewAdapter(dataHorizontal, dataVertical, getApplicationContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    private void fillTestData(ArrayList<TestItem> dataVertical) {
        for(int i = 0; i< 50; i++) {
            dataVertical.add(TestItem.generateRandomItem(i));
        }
    }
}
