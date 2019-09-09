package com.bhushxxx.villmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShopSelectedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_selected);

        RecyclerView recyclerView = findViewById(R.id.nearby_shops_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<ModelClass> modelClassList = new ArrayList<>();
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"Shop_1"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_foreground,"Shop_2"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"Shop_3"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"Shop_4"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"Shop_5"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"Shop_6"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"Shop_7"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"Shop_8"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_background,"Shop_9"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_foreground,"Shop_10"));
        modelClassList.add(new ModelClass(R.drawable.ic_launcher_foreground,"Shop_11"));


    }
}
