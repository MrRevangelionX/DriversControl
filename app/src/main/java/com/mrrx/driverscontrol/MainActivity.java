package com.mrrx.driverscontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int driversRemain;
    Boolean btnFlag1, btnFlag2, btnFlag3, btnFlag4, btnFlag5, btnFlag6, btnFlag7, btnFlag8, btnFlag9, btnFlag10, btnFlag11, btnFlag12, btnFlag13, btnFlag14
            , btnFlag15, btnFlag16, btnFlag17, btnFlag18, btnFlag19, btnFlag20, btnFlag21, btnFlag22, btnFlag23, btnFlag24, btnFlag25;
    TextView tvRemaining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvRemaining = findViewById(R.id.registro);
        driversRemain = 8;
        btnFlag1 = false;
        btnFlag2 = false;
        btnFlag3 = false;
        btnFlag4 = false;
        btnFlag5 = false;
        btnFlag6 = false;
        btnFlag7 = false;
        btnFlag8 = false;
        btnFlag9 = false;
        btnFlag10 = false;
        btnFlag11 = false;
        btnFlag12 = false;
        btnFlag13 = false;
        btnFlag14 = false;
        btnFlag15 = false;
        btnFlag16 = false;
        btnFlag17 = false;
        btnFlag18 = false;
        btnFlag19 = false;
        btnFlag20 = false;
        btnFlag21 = false;
        btnFlag22 = false;
        btnFlag23 = false;
        btnFlag24 = false;
        btnFlag25 = false;

        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain < 8 || driversRemain > 1){
                    //Escriba el codigo aqui
                }else{
                    Toast.makeText(MainActivity.this,"Hello Motherfuckers!", Toast.LENGTH_SHORT);
                }
            }
        });

    }
}