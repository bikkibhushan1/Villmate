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

public class NearByShopsSelectionAdapter extends RecyclerView.Adapter<NearByShopsSelectionAdapter.Viewholder> {
    private List<NearByShopsSelectionModelClass> nearByShopsSelectionModelClassList;
    Context context;

    public NearByShopsSelectionAdapter(List<NearByShopsSelectionModelClass> nearByShopsSelectionModelClassList, Context context){
        this.nearByShopsSelectionModelClassList = nearByShopsSelectionModelClassList;
        this.context = context;





    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nearby_shops_recycler_view_layout,parent,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, final int position) {
        int resource = nearByShopsSelectionModelClassList.get(position).getImageResource();
        final String title = nearByShopsSelectionModelClassList.get(position).getTitle();
        final String category_price = nearByShopsSelectionModelClassList.get(position).getCategory_price();
        holder.setData(resource,title,category_price);



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
        return nearByShopsSelectionModelClassList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder  {


        ConstraintLayout Recycler_view_layout;

        private ImageView shop_image;
        private TextView shop_name;
        private TextView category_price;


        public Viewholder(@NonNull View itemView) {
            super(itemView);

            shop_image = itemView.findViewById(R.id.shop_image);
            shop_name = itemView. findViewById(R.id.shop_name);
            category_price = itemView.findViewById(R.id.category_price);

            Recycler_view_layout = itemView.findViewById(R.id.nearby_shops_recycler_view_layout_id);



        }

        private void setData(int Shop_image, String Shop_name, String Category_price){

            shop_image.setImageResource(Shop_image);
            shop_name.setText(Shop_name);
            category_price.setText("Rs: " + Category_price);
        }



    }

}
