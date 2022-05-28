package com.example.sit305_7_1p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ItemDescription extends AppCompatActivity {

    //these are the variables for the ui elements
    TextView name, phone ,date, location, desc ;
    Button saveButton;
    RadioButton lost, found;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);

        DbModel db = new DbModel(this);

        name = findViewById(R.id.Name);
        phone = findViewById(R.id.phone);
        desc = findViewById(R.id.desc);
        date = findViewById(R.id.date);
        location = findViewById(R.id.location);
        lost = findViewById(R.id.LostRadio);
        found = findViewById(R.id.FoundRadio);
        saveButton = findViewById(R.id.button4);

        Intent intent = new Intent(this, MainActivity.class);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Type = "";
                String Name = name.getText().toString();
                int Phone = 0;
                String Description = desc.getText().toString();
                String Date = date.getText().toString();
                String Location = location.getText().toString();
                DataModel dataCollected;
                boolean dataFound = true;

                if (lost.isChecked() == true){
                    Type = "Lost";
                }else if (found.isChecked() == true){
                    Type = "Found";
                }else{
                    dataFound = false;
                }
                if (!phone.getText().toString().equals("")){
                    Phone = Integer.parseInt(phone.getText().toString());
                }else{
                    dataFound = false;
                }
                if (name.getText().toString().equals("")||desc.getText().toString().equals("")
                        ||date.getText().toString().equals("")||location.getText().toString().equals("")){
                    dataFound = false;
                }

                if (dataFound == true){

                    dataCollected = new DataModel(Type,Name,Phone,Description,Date,Location);
                    db.InsertAlert(dataCollected);

                    startActivity(intent);
                    Toast.makeText(ItemDescription.this, "Item information stored successful !", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Please fill all fields.", Toast.LENGTH_SHORT).show();
                }



            }
        });

    }
}