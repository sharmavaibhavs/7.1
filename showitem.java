package com.example.sit305_7_1p;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class showitem extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);

        Button mainScreen = findViewById(R.id.mainScreen);


        Fragment fragment = RecyclerListFragment.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.FragmentContainer, fragment, "ShowAlertFragment");
        transaction.commit();

    }

    public void MainScreen(View view) {
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }
}

