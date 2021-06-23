package com.example.zuoye;

import androidx.appcompat.app.AppCompatActivity;

import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.zuoye.databinding.MyBinding;

public class MainActivity extends AppCompatActivity {
    private MyBinding binding ;
    private LayoutInfo layoutInfo = new LayoutInfo();
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        dbHelper = new MyDatabaseHelper(this,"Layout.db",null,1);
        dbHelper.getWritableDatabase();
        layoutInfo.setBtn1_name("提交");
        layoutInfo.setText1_name("姓名");
        layoutInfo.setText2_name("这是Activity1");
        layoutInfo.setText3_name("无");
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



        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i= 0;i<10;i++){
                    try {
                        Thread.sleep(1000);
                        layoutInfo.setText1_name("姓名"+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

    }
}