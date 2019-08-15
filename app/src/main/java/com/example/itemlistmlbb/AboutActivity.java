package com.example.itemlistmlbb;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
    private TextView mail, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("About Me");

        mail = findViewById(R.id.email);
        phone = findViewById(R.id.myphone);
        final String send_mail = (String) mail.getText();
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"+send_mail));
                startActivity(intent);
            }
        });
        final String call_me = (String) phone.getText();
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+call_me));
                startActivity(intent);
            }
        });
    }
//    private void setActionBarTitle(String title) {
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setTitle(title);
//        }
//    }
//    @Override
//    public Boolean onOpttionsItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case android.R.id.home:
//                NavUtils.navigateUpFromSameTask(this);
//                return true;
//                default:
//                    return super.onOptionsItemSelected(item);
//        }
//    }
}
