package com.example.itemlistmlbb;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.itemlistmlbb.adapter.list_barang_adapter;
import com.example.itemlistmlbb.model.barang;
import com.example.itemlistmlbb.model.barang_data;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvBarang;
    private ArrayList<barang> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBarang = findViewById(R.id.rv_barang);
        rvBarang.setHasFixedSize(true);

        list.addAll(barang_data.getListData());
        showRecyclerList();

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Home");

        //setActionBarTitle("Home");
    }
    private void showRecyclerList(){
        rvBarang.setLayoutManager(new LinearLayoutManager(this));
        list_barang_adapter listItemAdapter = new list_barang_adapter(list);
        rvBarang.setAdapter(listItemAdapter);

        listItemAdapter.setOnItemClickCallback(new list_barang_adapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(barang data) {
                showSelectedBarang(data);
            }
        });
    }
    private void showSelectedBarang(barang brg) {
        Toast.makeText(this, "Kamu memilih " + brg.getName(), Toast.LENGTH_SHORT).show();
    }
    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.custom_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.about:
                Intent moveAbout = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(moveAbout);
                break;
        }
    }
}
