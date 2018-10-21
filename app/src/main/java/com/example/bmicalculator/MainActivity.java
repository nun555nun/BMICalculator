package com.example.bmicalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bmicalculator.model.Body;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//สร้าง obj ทั้งหมด (Inflate)
        Button calculateButton = findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText heightEditText = findViewById(R.id.height_edit_text);
                EditText weightEditText = findViewById(R.id.weight_edit_text);
                if (heightEditText.getText().toString().equals("") || weightEditText.getText().toString().equals("")) {
                    String msg = "";
                    if (heightEditText.getText().toString().equals("")) {
                        msg += "-ส่วนสูง ";
                    }
                    if (weightEditText.getText().toString().equals("")) {
                        msg += "-น้ำหนัก ";
                    }
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("กรุณากรอก")
                            .setMessage(msg)
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(MainActivity.this, MainActivity.class);
                                    startActivity(i);
                                }
                            })
                            .show();
                } else {
                    int h = Integer.parseInt(heightEditText.getText().toString());
                    int w = Integer.parseInt(weightEditText.getText().toString());

                    Body body = new Body(h, w);
                    float bmi = body.calculateBMI();
                    String msg = "ฆ่า บีเอ็มไอ เท่ากับ " + String.format(Locale.US, "%2f", bmi);
                    String msg2 = "น้ำหนักของคุณอยู่ในเกณ์ " + body.getResultText();
                    Toast t = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG);
                    t.show();
                /*AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Result");
                dialog.setMessage(msg);
                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //โค้ดที่ให้ทำเมือ่ userกดปุ่ม ในdialog
                    }
                });
                dialog.setNegativeButton("no",null);
                dialog.setCancelable(false);//กดตรงอื่นนอกจากปุ่มในdialogไม่ได้
                dialog.show();*/

                    //method chaining
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Result")
                            .setMessage(msg)
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent(MainActivity.this, MainActivity.class);
                                    startActivity(i);
                                }
                            })
                            .show();
                    //การเขียนแบบfluem (Readability)
                    //Glide.with(context).load(URL).into(imageview); โหลดภาพจาก Link
                }
            }
        });
    }

}
