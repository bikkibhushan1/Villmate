package com.bhushxxx.villmate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryBrandAdapter extends RecyclerView.Adapter<CategoryBrandAdapter.Viewholder> {
    private List<CategoryBrandModelClass> categoryBrandModelClassList;
    Context context;

    public CategoryBrandAdapter(List<CategoryBrandModelClass> categoryBrandModelClassList, Context context){
        this.categoryBrandModelClassList = categoryBrandModelClassList;
        this.context = context;





    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_brand_recycler_view_layout,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, final int position) {
        int brand_image = categoryBrandModelClassList.get(position).getBrand_image();
        final String brand_name = categoryBrandModelClassList.get(position).getBrand_name();
        final String brand_price= categoryBrandModelClassList.get(position).getBrand_price();
        holder.setData(brand_image,brand_name,brand_price);



        holder.Recycler_view_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




            /*    Intent intent = new Intent( context, ShopSelectedActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("shop_sel",nearByShopsSelectionModelClassList.get(position).getTitle());
                context.startActivity(intent);*/

            }
        });



    }

    @Override
    public int getItemCount() {
        return categoryBrandModelClassList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder  {


        ConstraintLayout Recycler_view_layout;

        private ImageView brand_image;
        private TextView brand_name;
        private TextView brand_price;


        public Viewholder(@NonNull View itemView) {
            super(itemView);

            brand_image = itemView.findViewById(R.id.brand_image);
            brand_name = itemView. findViewById(R.id.brand_name);
            brand_price = itemView.findViewById(R.id.brand_price);

            Recycler_view_layout = itemView.findViewById(R.id.category_brand_recycler_view_layout_id);



        }

        private void setData(int Brand_image, String Brand_name, String Brand_price){

            brand_image.setImageResource(Brand_image);
            brand_name.setText(Brand_name);
            brand_price.setText("Rs: " + Brand_price);

        }



    }

}
