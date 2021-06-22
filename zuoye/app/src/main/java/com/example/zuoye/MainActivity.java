package com.example.zuoye;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.zuoye.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding ;
    private LayoutInfo layoutInfo = new LayoutInfo();
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this,"Layout.db",null,1);
        dbHelper.getWritableDatabase();
        layoutInfo.setBtn_name("提交");
        layoutInfo.setText1_name("姓名");
        layoutInfo.setText2_name("这是Activity1");
        binding.setLi(layoutInfo);
        binding.btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("name",binding.et1.getText().toString());
                startActivity(intent);
                finish();
            }
        });

    }
}