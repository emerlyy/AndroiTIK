package com.example.tik;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class SecondActivity extends AppCompatActivity {
    int period,width,amplitude;
    CheckBox checkBox1,checkBox2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        period = getIntent().getIntExtra("period", 0);
        width = getIntent().getIntExtra("width", 0);
        amplitude = getIntent().getIntExtra("amplitude", 0);
        checkBox1 = findViewById(R.id.checkBox);
        checkBox1.setText(Double.toString(calcA0(period, width, amplitude)));
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox2.setText(Double.toString(calcAn(period, width, amplitude, 1)));
    }
    public void startNewActivity2(View v){
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }

    public double calcA0(int T,int t,int h){
        return (double)h*t/T;
    }

    public double calcAn(int T,int t,int h,int k) {
        double w = 2 * Math.PI / T;
        double result = 2 * h * t * Math.sin(k * w * t / 2) / (T * k * w * t / 2);
        return Double.parseDouble(String.format("%.2f", result));
    }

}