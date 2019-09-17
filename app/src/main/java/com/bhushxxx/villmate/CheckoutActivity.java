package com.bhushxxx.villmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);



        RecyclerView recyclerView = findViewById(R.id.checkout_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        final List<CheckoutModelClass> checkoutModelClassList = new ArrayList<>();
        checkoutModelClassList.add(new CheckoutModelClass("bikki","Shop_1","1652"));
        checkoutModelClassList.add(new CheckoutModelClass("bikki","Shop_123","16561"));
        checkoutModelClassList.add(new CheckoutModelClass("bikki","Shop_963","162631"));
        checkoutModelClassList.add(new CheckoutModelClass("bikki","Shop_7","16121"));
        checkoutModelClassList.add(new CheckoutModelClass("bikki","Shop_5","85261"));
        checkoutModelClassList.add(new CheckoutModelClass("bikki","Shop_5","85261"));
        checkoutModelClassList.add(new CheckoutModelClass("bikki","Shop_5","85261"));
        checkoutModelClassList.add(new CheckoutModelClass("bikki","Shop_5","85261"));
        checkoutModelClassList.add(new CheckoutModelClass("bikki","Shop_5","85261"));
        checkoutModelClassList.add(new CheckoutModelClass("bikki","Shop_5","85261"));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this , DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.horizontal_divider));
        recyclerView.addItemDecoration(dividerItemDecoration);


        final CheckoutAdapter checkoutAdapter = new CheckoutAdapter(checkoutModelClassList,getApplicationContext());
        recyclerView.setAdapter(checkoutAdapter);
        checkoutAdapter.notifyDataSetChanged();

        checkoutAdapter.setOnItemClickListener(new CheckoutAdapter.OnItemClickListener() {
            @Override
            public void onDeleteClick(int position) {

                checkoutModelClassList.remove(position);
                checkoutAdapter.notifyItemRemoved(position);
                Toast.makeText(getApplicationContext(), "Item Deleted", Toast.LENGTH_LONG).show();

            }


        });



        //Logic to retrieve the total checkout amount






    }
}
