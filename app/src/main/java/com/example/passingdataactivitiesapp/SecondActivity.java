package com.example.passingdataactivitiesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView txtName,txtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtName = findViewById(R.id.txtName);
        txtAge = findViewById(R.id.txtAge);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("un");
        int age = bundle.getInt("uage");

        txtName.setText("Welcome "+ name);
        if(age<18)
            txtAge.setText(age+" age is not Eligible");
        else
            txtAge.setText(age+" age is Eligible");

    }
}