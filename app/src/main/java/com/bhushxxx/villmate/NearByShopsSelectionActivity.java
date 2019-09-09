package com.bhushxxx.villmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NearByShopsSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by_shops_selection);

        TextView cat_sel_text = findViewById(R.id.cat_sel_text);
        ImageView cat_sel_image = findViewById(R.id.cat_sel_image);
        Intent intent = getIntent();

        int cat_sel= intent.getIntExtra("cat_sel", 1);

        switch (cat_sel){

            case 1 : cat_sel_image.setBackgroundResource(R.drawable.fertilizers);
                     cat_sel_text.setText("Fertilizers");
            break;
            case 2 : cat_sel_image.setBackgroundResource(R.drawable.seeds);
                     cat_sel_text.setText("Seeds");
            break;
            case 3 : cat_sel_image.setBackgroundResource(R.drawable.building_materials);
                     cat_sel_text.setText("Building Materials");
            break;
            case 4 : cat_sel_image.setBackgroundResource(R.drawable.pesticides);
                     cat_sel_text.setText("Pesticides");

        }



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



        Adapter adapter = new Adapter(modelClassList,getApplicationContext());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();















        }

    }

