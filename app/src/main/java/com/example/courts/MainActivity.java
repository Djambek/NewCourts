package com.example.courts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Paper.init(this);
        String city = Paper.book().read("city") != null ? Paper.book().read("city"):"";
        if (!city.equals("")){
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, FirstRun.class);
            startActivity(intent);
        }
        finish();
    }
}