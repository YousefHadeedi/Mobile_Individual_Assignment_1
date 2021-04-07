package com.example.assignment_1_1171655;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spn_days;
    private Spinner spn_months;
    private Spinner spn_gender;

    private EditText edt_name;
    private EditText edt_email;
    private EditText edt_phone;
    private EditText edt_year;
    private EditText edt_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        
        initiateDaysSpinner();
        initiateMonthsSpinner();
        initiateGendersSpinner();
    }

    private void setupViews() {
        spn_days = findViewById(R.id.spn_days);
        spn_months = findViewById(R.id.spn_months);
        spn_gender = findViewById(R.id.spn_gender);

        edt_name = findViewById(R.id.edt_name);
        edt_email = findViewById(R.id.edt_email);
        edt_phone = findViewById(R.id.edt_phone);
        edt_year = findViewById(R.id.edt_year);
        edt_pass = findViewById(R.id.edt_pass);
    }

    private void initiateGendersSpinner() {
        ArrayList<String> gender = new ArrayList<>();
        gender.add("Male");
        gender.add("Female");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gender);

        spn_gender.setAdapter(adapter);
    }

    private void initiateMonthsSpinner() {
        ArrayList<String> months = new ArrayList<>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, months);

        spn_months.setAdapter(adapter);
    }

    private void initiateDaysSpinner() {
        ArrayList<String> days = new ArrayList<>();

        for (int i = 1; i <= 31; i++) {
            days.add(i + "");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, days);

        spn_days.setAdapter(adapter);
    }

    public void btn_save_onClick(View view) {
        Intent intent = new Intent(this, Activity_2.class);

        ArrayList<String> data = new ArrayList<>();

        data.add(edt_name.getText().toString());

        data.add(edt_email.getText().toString());

        data.add(edt_phone.getText().toString());

        data.add(spn_days.getSelectedItem().toString());

        data.add(spn_months.getSelectedItem().toString());

        data.add(edt_year.getText().toString());

        data.add(spn_gender.getSelectedItem().toString());

        data.add(edt_pass.getText().toString());


        intent.putStringArrayListExtra("user_data", data);

        startActivity(intent);
    }
}