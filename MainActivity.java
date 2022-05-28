package com.example.sit305_7_1p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void newAdvert(View view) {
        Intent itemDesc= new Intent(this, ItemDescription.class);
        startActivity(itemDesc);
    }

    public void activity2(View view) {
        Intent activity2 = new Intent(this, showitem.class);
        startActivity(activity2);


    }
}