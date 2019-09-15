package com.bhushxxx.villmate;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.Viewholder> {
    private List<CheckoutModelClass> checkoutModelClassList;
    private OnItemClickListener mListener;
    Context context;
    public interface OnItemClickListener {
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public CheckoutAdapter(List<CheckoutModelClass> checkoutModelClassList, Context context){
        this.checkoutModelClassList = checkoutModelClassList;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkout_recycler_view_layout,parent,false);
        Viewholder viewholder = new Viewholder(view,mListener);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, final int position) {
        final String category_name = checkoutModelClassList.get(position).getCategory_name();
        final String category_price = checkoutModelClassList.get(position).getCategory_price();
        final String shop_name = checkoutModelClassList.get(position).getShop_name();

        holder.setData(category_name,shop_name,category_price);

        holder.Recycler_view_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(),LocationActivity.class);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return checkoutModelClassList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder  {


            ConstraintLayout Recycler_view_layout;
            private TextView shop_name,category_name, category_price, total_per_item,checkout_total;
            private ImageButton checkout_per_item_delete, incr_but, decr_but;
            private EditText quantity_set;

            public Viewholder(@NonNull View itemView , final OnItemClickListener listener) {
                super(itemView);
                total_per_item();
                Recycler_view_layout = itemView.findViewById(R.id.checkout_recycler_view_layout_id);

                category_name = itemView. findViewById(R.id.category_name);
                category_price = itemView.findViewById(R.id.category_price);
                shop_name = itemView.findViewById(R.id.shop_name);
                checkout_per_item_delete = itemView.findViewById(R.id.checkout_per_item_delete);
                incr_but = itemView.findViewById(R.id.incr_but);
                decr_but = itemView.findViewById(R.id.decr_but);
                quantity_set = itemView.findViewById(R.id.quantity_set);
                total_per_item = itemView.findViewById(R.id.total_per_item);
                checkout_total= itemView.findViewById(R.id.checkout_total);





                checkout_per_item_delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION) {
                                listener.onDeleteClick(position);

                            }
                        }
                    }
                });

                incr_but.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        quantity_set.setText(String.valueOf(Integer.parseInt(quantity_set.getText().toString()) + 1));
                        total_per_item();
                    }
                });

                decr_but.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        quantity_set.setText(String.valueOf(Integer.parseInt(quantity_set.getText().toString()) - 1));
                        total_per_item();
                    }
                });
            }

        public void total_per_item() {

            total_per_item.setText(String.valueOf(Integer.parseInt(quantity_set.getText().toString())*Integer.parseInt(category_price.getText().toString().substring(4))));
        }

        private void setData(String Category_name, String Shop_name, String Category_price){

            category_name.setText(Category_name);
            category_price.setText("Rs: " + Category_price);
            shop_name.setText(Shop_name);
        }
    }

}




