package com.bhushxxx.villmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CategoryBrandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_brand);




        RecyclerView recyclerView = findViewById(R.id.category_brand_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);



        List<CategoryBrandModelClass> categoryBrandModelClassList = new ArrayList<>();
        categoryBrandModelClassList.add(new CategoryBrandModelClass(R.drawable.ic_launcher_background,"PATANJALI","161"));
        categoryBrandModelClassList.add(new CategoryBrandModelClass(R.drawable.ic_launcher_background,"PATANJALI","1651"));
        categoryBrandModelClassList.add(new CategoryBrandModelClass(R.drawable.ic_launcher_background,"PATANJALI","161"));
        categoryBrandModelClassList.add(new CategoryBrandModelClass(R.drawable.ic_launcher_background,"PATANJALI","161"));




        CategoryBrandAdapter categoryBrandAdapter = new CategoryBrandAdapter(categoryBrandModelClassList,getApplicationContext());
        recyclerView.setAdapter(categoryBrandAdapter);
        categoryBrandAdapter.notifyDataSetChanged();


    }
}
