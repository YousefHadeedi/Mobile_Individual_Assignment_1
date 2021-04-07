package com.example.assignment_1_1171655;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_2 extends AppCompatActivity {

    private TextView txt_name;
    private TextView txt_email;
    private TextView txt_phone;
    private TextView txt_DOB;
    private TextView txt_gender;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        setupViews();

        displayInfo();

    }

    private void setupViews() {
        txt_name = findViewById(R.id.txt_name_view);
        txt_email = findViewById(R.id.txt_email_view);
        txt_phone = findViewById(R.id.txt_phone_view);
        txt_DOB = findViewById(R.id.txt_DOB_view);
        txt_gender = findViewById(R.id.txt_gender_view);
    }

    private void displayInfo() {
        Intent intent = getIntent();

        ArrayList<String> data = intent.getStringArrayListExtra("user_data");

        password = data.get(7);

        txt_name.setText(data.get(0));
        txt_email.setText(data.get(1));
        txt_phone.setText(data.get(2));
        txt_DOB.setText(data.get(3) + "/" + data.get(4) + "/" + data.get(5));
        txt_gender.setText(data.get(6));
    }


    public void btn_showPass_onClick(View view) {
        if (!password.isEmpty()) {
            Toast.makeText(this, password, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "There is no password!", Toast.LENGTH_SHORT).show();
        }
    }
}