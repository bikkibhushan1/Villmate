package com.bhushxxx.villmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NearByShopsSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by_shops_selection);



        Intent intent = getIntent();

        int cat_sel= intent.getIntExtra("cat_sel", 1);

        TextView cat_sel_text = findViewById(R.id.cat_sel_text);

        cat_sel_text.setText(cat_sel + " selected");








        }

    }

