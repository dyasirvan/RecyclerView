package com.example.itemlistmlbb.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.itemlistmlbb.DetailActivity;
import com.example.itemlistmlbb.MainActivity;
import com.example.itemlistmlbb.R;
import com.example.itemlistmlbb.ItemClickListener;
import com.example.itemlistmlbb.model.barang;

import java.util.ArrayList;

public class list_barang_adapter extends RecyclerView.Adapter<list_barang_adapter.ListViewHolder>{
    private ArrayList<barang> listItem;
    //Context c;

    public list_barang_adapter(ArrayList<barang> list) {
        //this.c=c;
        this.listItem = list;
    }

    @NonNull
    @Override
    public list_barang_adapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ListViewHolder(view);
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onBindViewHolder(@NonNull final list_barang_adapter.ListViewHolder holder, final int position) {
        final barang brg = listItem.get(position);
        Glide.with(holder.itemView.getContext())
                .load(brg.getImg())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgItem);
        holder.tvName.setText(brg.getName());
        holder.tvExplain.setText(brg.getExplain());
        holder.tvPrice.setText(brg.getPrice());
        holder.tvType.setText(brg.getType());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onItemClickCallback.onItemClicked(listItem.get(holder.getAdapterPosition()));

                String img = brg.getImg();
                String name = brg.getName();
                String exp = brg.getExplain();
                String price = brg.getPrice();
                String type = brg.getType();

                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("img", img);
                intent.putExtra("name", brg.getName());
                intent.putExtra("explain",exp);
                intent.putExtra("price", price);
                intent.putExtra("type", type);
                v.getContext().startActivity(intent);

            }
        });
//        holder.setItemClickListener(new ItemClickListener() {
//            @Override
//            public void onItemClickListener(View v, int position) {
//                //BitmapDrawable image = (BitmapDrawable)holder.imgItem.getDrawable();
//                String img = listItem.get(position).getImg();
//                String name = listItem.get(position).getName();
//                String exp = listItem.get(position).getExplain();
//                String price = listItem.get(position).getPrice();
//                String type = listItem.get(position).getType();
//
//                MainActivity ma = new MainActivity();
//                Intent intent = new Intent(c, DetailActivity.class);
//                intent.putExtra("img", img);
//                intent.putExtra("name", name);
//                intent.putExtra("explain",exp);
//                intent.putExtra("price", price);
//                intent.putExtra("type", type);
//                c.startActivity(intent);
//            }
//        });
    }

    public interface OnItemClickCallback {
        void onItemClicked(barang data);
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }
    class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgItem;
        TextView tvName, tvExplain, tvPrice, tvType;
        ItemClickListener itemClickListener;
        ListViewHolder(View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.img_item);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvExplain = itemView.findViewById(R.id.tv_item_explain);
            tvPrice = itemView.findViewById(R.id.tv_item_price);
            tvType = itemView.findViewById(R.id.tv_item_type);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClickListener(view, getLayoutPosition());
        }
        public void setItemClickListener(ItemClickListener icl){
            this.itemClickListener = icl;
        }
    }


}
