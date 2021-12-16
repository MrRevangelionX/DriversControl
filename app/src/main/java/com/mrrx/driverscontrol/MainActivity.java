package com.mrrx.driverscontrol;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.usage.UsageEvents;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.InputType;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Driver;
import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int driversRemain, totalDrivers;

    Boolean btnFlag1, btnFlag2, btnFlag3, btnFlag4, btnFlag5, btnFlag6, btnFlag7, btnFlag8, btnFlag9, btnFlag10, btnFlag11, btnFlag12, btnFlag13, btnFlag14
            , btnFlag15, btnFlag16, btnFlag17, btnFlag18, btnFlag19, btnFlag20, btnFlag21, btnFlag22, btnFlag23, btnFlag24, btnFlag25;

    TextView tvRemaining;

    String titulo, ubicacion, descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        setTotalDrivers();

        long epoch = System.currentTimeMillis()/1000;
        Log.v("Segs",Long.toString(epoch));

        TextView tvRemaining = findViewById(R.id.registro);
        tvRemaining.setText("Cantidad de Drivers Disponible: " + totalDrivers);

        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || btnFlag1 == true){
                    if(btnFlag1 == false) {
                        driversRemain--;
                        btnFlag1 = true;
                        addEvent();
                        btn1.setText("RESERVADO");
                        btn1.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        btnFlag1 = false;
                        btn1.setText("08:00 AM");
                        btn1.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,"Driver Manager Appointment");
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,"HOME");
                intent.putExtra(CalendarContract.Events.DESCRIPTION,"A request has been set at this time");
                intent.putExtra(CalendarContract.Events.ALL_DAY,false);
                intent.putExtra(CalendarContract.Events.DTSTART, btn1.getText().toString());
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setTotalDrivers() {
        final EditText inputText = new EditText(this);
        inputText.setInputType(InputType.TYPE_CLASS_NUMBER);
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Drivers Manager")
                .setMessage("Set number of Available Drivers for Today:")
                .setView(inputText)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        totalDrivers = Integer.parseInt(inputText.getText().toString());
                        driversRemain = totalDrivers;
                    }
                })
                .show();
    }
}