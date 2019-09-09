package com.bhushxxx.villmate;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {
    private List<ModelClass> modelClassList;
    Context context;

    public Adapter(List<ModelClass> modelClassList,Context context){
        this.modelClassList = modelClassList;
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
        int resource = modelClassList.get(position).getImageResource();
        final String title = modelClassList.get(position).getTitle();
        holder.setData(resource,title);
        holder.Recycler_view_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




            /*    Intent intent = new Intent( context, ShopSelectedActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("shop_sel",modelClassList.get(position).getTitle());
                context.startActivity(intent);*/

            }
        });



    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder  {


        ConstraintLayout Recycler_view_layout;

        private ImageView imageView;
        private TextView title;


        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.shop_image);
            title = itemView. findViewById(R.id.shop_name);
            Recycler_view_layout = itemView.findViewById(R.id.nearby_shops_recycler_view_layout_id);



        }

        private void setData(int resource, String titleText){

            imageView.setImageResource(resource);
            title.setText(titleText);
        }



    }

}
