package com.example.recyclerviewimagestext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private int [] images = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,
                             R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8,
                             R.drawable.pic9, R.drawable.pic1};

    private RecyclerView.LayoutManager layoutManager;

    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        layoutManager = new GridLayoutManager(this, 2);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(layoutManager);

        recyclerAdapter = new RecyclerAdapter(images, this);

        recyclerView.setAdapter(recyclerAdapter);

    }
}
