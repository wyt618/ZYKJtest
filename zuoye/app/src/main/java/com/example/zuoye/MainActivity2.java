package com.example.zuoye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String data = intent.getStringExtra("name");
        Log.i("MainActivity2",data);
        Toast.makeText(MainActivity2.this,data,Toast.LENGTH_SHORT).show();
    }
}