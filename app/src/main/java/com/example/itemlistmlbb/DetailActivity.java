package com.example.itemlistmlbb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.itemlistmlbb.adapter.list_barang_adapter;
import com.example.itemlistmlbb.model.barang;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {
    CircleImageView img;
    TextView price, type, explain, name;

    private ArrayList<barang> listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("");

        img = findViewById(R.id.detail_img);
        name = findViewById(R.id.tv_detail_nama);
        explain = findViewById(R.id.tv_detail_item);
        price = findViewById(R.id.tv_detail_harga);
        type = findViewById(R.id.tv_detil_role);

        Intent intent = getIntent();


        String intent_img = intent.getStringExtra("img");
        String intent_name = intent.getStringExtra("name");
        String intent_price = intent.getStringExtra("price");
        String intent_exp = intent.getStringExtra("explain");
        String intent_type = intent.getStringExtra("type");

        Glide.with(getApplicationContext()).load(intent_img).into(img);
        //Toast.makeText(this, "Error e cuk "+intent_name,Toast.LENGTH_LONG);
        name.setText(intent_name);
        explain.setText(intent_exp);
        price.setText(intent_price);
        type.setText(intent_type);
    }

}
