package com.bhushxxx.villmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NearByShopsSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by_shops_selection);

        TextView cat_sel_text = findViewById(R.id.cat_sel_text);
        ImageView cat_sel_image = findViewById(R.id.cat_sel_image);



        Intent intent = getIntent();
        int cat_sel= intent.getIntExtra("cat_sel", 1);

        cat_sel_text.setText(cat_sel + " selected");

        switch (cat_sel){

            case 1 : cat_sel_image.setBackgroundResource(R.drawable.fertilizers);
            break;
            case 2 : cat_sel_image.setBackgroundResource(R.drawable.seeds);
            break;
            case 3 : cat_sel_image.setBackgroundResource(R.drawable.building_materials);
            break;
            case 4 : cat_sel_image.setBackgroundResource(R.drawable.pesticides);





        }















        }

    }

