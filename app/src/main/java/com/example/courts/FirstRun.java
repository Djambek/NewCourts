package com.example.courts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import io.paperdb.Paper;


public class FirstRun extends AppCompatActivity {
    String[] citys = {"Москва"};

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        final String[] selected_item = new String[1];
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_settings);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, citys);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                selected_item[0] = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
        spinner.setAdapter(adapter);
        Paper.book().write("city", selected_item[0]);

        Button b = findViewById(R.id.button);
        b.setOnClickListener((View.OnClickListener) this);

    }
    public void onClick(View view) {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
        finish();
    }
}