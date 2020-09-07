package com.example.passingdataactivitiesapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtName,txtAge;
    private Button btnSend;
    private TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtAge = findViewById(R.id.txtAge);
        btnSend = findViewById(R.id.btnSend);
        txtData = findViewById(R.id.txtData);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("un",txtName.getText().toString());
                intent.putExtra("uage",Integer.parseInt(txtAge.getText().toString()));
                startActivityForResult(intent,1001);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1001){
            if(resultCode==RESULT_OK){
                String msg = data.getStringExtra("msg");
                txtData.setText(msg);
            }
        }

    }
}