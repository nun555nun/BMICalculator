package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Toast t2 = Toast.makeText(SplashActivity.this,"หวัดดีย์ เห็นโหล",Toast.LENGTH_SHORT);
        t2.show();
        Button startButton = findViewById(R.id.start);
        startButton.setText("เริ่มต้น");

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(SplashActivity.this,"Open!!!",Toast.LENGTH_SHORT);
                t.show();
                Intent i = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        Button exitButton = findViewById(R.id.exit);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //โค้ดที่ต้องการให้ทำเมื่อปุ่มถูกคลิก
                Toast t = Toast.makeText(SplashActivity.this,"ปิดละจ้า",Toast.LENGTH_SHORT);
                t.show();
                finish();//ปิดแอป
            }

        });
    }


}
