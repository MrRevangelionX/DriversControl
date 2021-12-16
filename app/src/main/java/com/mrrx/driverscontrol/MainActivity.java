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
import android.text.format.DateUtils;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.DateSelector;

import java.sql.Driver;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    int driversRemain, totalDrivers;

    Boolean flagbtn1, flagbtn2, flagbtn3, flagbtn4, flagbtn5, flagbtn6, flagbtn7, flagbtn8, flagbtn9, flagbtn10, flagbtn11, flagbtn12, flagbtn13, flagbtn14
            , flagbtn15, flagbtn16, flagbtn17, flagbtn18, flagbtn19, flagbtn20, flagbtn21, flagbtn22, flagbtn23, flagbtn24, flagbtn25;

    TextView tvRemaining;

    String titulo, ubicacion, descripcion, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titulo="Driver Manager Appointment";
        ubicacion="";
        descripcion="Se ha solicitado un vehiculo a esta hora";

        flagbtn1 = false;
        flagbtn2 = false;
        flagbtn3 = false;
        flagbtn4 = false;
        flagbtn5 = false;
        flagbtn6 = false;
        flagbtn7 = false;
        flagbtn8 = false;
        flagbtn9 = false;
        flagbtn10 = false;
        flagbtn11 = false;
        flagbtn12 = false;
        flagbtn13 = false;
        flagbtn14 = false;
        flagbtn15 = false;
        flagbtn16 = false;
        flagbtn17 = false;
        flagbtn18 = false;
        flagbtn19 = false;
        flagbtn20 = false;
        flagbtn21 = false;
        flagbtn22 = false;
        flagbtn23 = false;
        flagbtn24 = false;
        flagbtn25 = false;



        setTotalDrivers();

        TextView tvRemaining = findViewById(R.id.registro);
        tvRemaining.setText("Cantidad de Drivers Disponible: " + totalDrivers);

        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn1 == true){
                    if(flagbtn1 == false) {
                        driversRemain--;
                        flagbtn1 = true;
                        addEvent();
                        btn1.setText("RESERVADO");
                        btn1.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn1 = false;
                        btn1.setText("08:00 a. m.");
                        btn1.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 30);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn1.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn2 == true){
                    if(flagbtn2 == false) {
                        driversRemain--;
                        flagbtn2 = true;
                        addEvent();
                        btn2.setText("RESERVADO");
                        btn2.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn2 = false;
                        btn2.setText("08:30 a. m.");
                        btn2.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn2.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn3 == true){
                    if(flagbtn3 == false) {
                        driversRemain--;
                        flagbtn3 = true;
                        addEvent();
                        btn3.setText("RESERVADO");
                        btn3.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn3 = false;
                        btn3.setText("09:00 a. m.");
                        btn3.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn3.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn4 == true){
                    if(flagbtn4 == false) {
                        driversRemain--;
                        flagbtn4 = true;
                        addEvent();
                        btn4.setText("RESERVADO");
                        btn4.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn4 = false;
                        btn4.setText("09:30 a. m.");
                        btn4.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn4.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn5 == true){
                    if(flagbtn5 == false) {
                        driversRemain--;
                        flagbtn5 = true;
                        addEvent();
                        btn5.setText("RESERVADO");
                        btn5.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn5 = false;
                        btn5.setText("10:00 a. m.");
                        btn5.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn5.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn6 == true){
                    if(flagbtn6 == false) {
                        driversRemain--;
                        flagbtn6 = true;
                        addEvent();
                        btn6.setText("RESERVADO");
                        btn6.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn6 = false;
                        btn6.setText("10:30 a. m.");
                        btn6.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn6.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn7 == true){
                    if(flagbtn7 == false) {
                        driversRemain--;
                        flagbtn7 = true;
                        addEvent();
                        btn7.setText("RESERVADO");
                        btn7.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn7 = false;
                        btn7.setText("11:00 a. m.");
                        btn7.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn7.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn8 == true){
                    if(flagbtn8 == false) {
                        driversRemain--;
                        flagbtn8 = true;
                        addEvent();
                        btn8.setText("RESERVADO");
                        btn8.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn8 = false;
                        btn8.setText("11:30 a. m.");
                        btn8.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn8.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn9 = (Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn9 == true){
                    if(flagbtn9 == false) {
                        driversRemain--;
                        flagbtn9 = true;
                        addEvent();
                        btn9.setText("RESERVADO");
                        btn9.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn9 = false;
                        btn9.setText("12:00 p. m.");
                        btn9.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn9.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn10 = (Button) findViewById(R.id.btn10);
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn10 == true){
                    if(flagbtn10 == false) {
                        driversRemain--;
                        flagbtn10 = true;
                        addEvent();
                        btn10.setText("RESERVADO");
                        btn10.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn10 = false;
                        btn10.setText("12:30 p. m.");
                        btn10.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn10.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn11 = (Button) findViewById(R.id.btn11);
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn11 == true){
                    if(flagbtn11 == false) {
                        driversRemain--;
                        flagbtn11 = true;
                        addEvent();
                        btn11.setText("RESERVADO");
                        btn11.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn11 = false;
                        btn11.setText("01:00 p. m.");
                        btn11.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn11.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn12 = (Button) findViewById(R.id.btn12);
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn12 == true){
                    if(flagbtn12 == false) {
                        driversRemain--;
                        flagbtn12 = true;
                        addEvent();
                        btn12.setText("RESERVADO");
                        btn12.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn12 = false;
                        btn12.setText("01:30 p. m.");
                        btn12.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn12.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn13 = (Button) findViewById(R.id.btn13);
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn13 == true){
                    if(flagbtn13 == false) {
                        driversRemain--;
                        flagbtn13 = true;
                        addEvent();
                        btn13.setText("RESERVADO");
                        btn13.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn13 = false;
                        btn13.setText("02:00 p. m.");
                        btn13.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn13.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn14 = (Button) findViewById(R.id.btn14);
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn14 == true){
                    if(flagbtn14 == false) {
                        driversRemain--;
                        flagbtn14 = true;
                        addEvent();
                        btn14.setText("RESERVADO");
                        btn14.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn14 = false;
                        btn14.setText("02:30 p. m.");
                        btn14.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn14.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn15 = (Button) findViewById(R.id.btn15);
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn15 == true){
                    if(flagbtn15 == false) {
                        driversRemain--;
                        flagbtn15 = true;
                        addEvent();
                        btn15.setText("RESERVADO");
                        btn15.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn15 = false;
                        btn15.setText("03:00 p. m.");
                        btn15.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn15.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn16 = (Button) findViewById(R.id.btn16);
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn16 == true){
                    if(flagbtn16 == false) {
                        driversRemain--;
                        flagbtn16 = true;
                        addEvent();
                        btn16.setText("RESERVADO");
                        btn16.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn16 = false;
                        btn16.setText("03:30 p. m.");
                        btn16.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn16.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn17 = (Button) findViewById(R.id.btn17);
        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn17 == true){
                    if(flagbtn17 == false) {
                        driversRemain--;
                        flagbtn17 = true;
                        addEvent();
                        btn17.setText("RESERVADO");
                        btn17.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn17 = false;
                        btn17.setText("04:00 p. m.");
                        btn17.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn17.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn18 = (Button) findViewById(R.id.btn18);
        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn18 == true){
                    if(flagbtn18 == false) {
                        driversRemain--;
                        flagbtn18 = true;
                        addEvent();
                        btn18.setText("RESERVADO");
                        btn18.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn18 = false;
                        btn18.setText("04:30 p. m.");
                        btn18.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn18.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn19 = (Button) findViewById(R.id.btn19);
        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn19 == true){
                    if(flagbtn19 == false) {
                        driversRemain--;
                        flagbtn19 = true;
                        addEvent();
                        btn19.setText("RESERVADO");
                        btn19.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn19 = false;
                        btn19.setText("05:00 p. m.");
                        btn19.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn19.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn20 = (Button) findViewById(R.id.btn20);
        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn20 == true){
                    if(flagbtn20 == false) {
                        driversRemain--;
                        flagbtn20 = true;
                        addEvent();
                        btn20.setText("RESERVADO");
                        btn20.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn20 = false;
                        btn20.setText("05:30 p. m.");
                        btn20.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn20.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn21 = (Button) findViewById(R.id.btn21);
        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn21 == true){
                    if(flagbtn21 == false) {
                        driversRemain--;
                        flagbtn21 = true;
                        addEvent();
                        btn21.setText("RESERVADO");
                        btn21.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn21 = false;
                        btn21.setText("06:00 p. m.");
                        btn21.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn21.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn22 = (Button) findViewById(R.id.btn22);
        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn22 == true){
                    if(flagbtn22 == false) {
                        driversRemain--;
                        flagbtn22 = true;
                        addEvent();
                        btn22.setText("RESERVADO");
                        btn22.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn22 = false;
                        btn22.setText("06:30 p. m.");
                        btn22.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn22.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn23 = (Button) findViewById(R.id.btn23);
        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn23 == true){
                    if(flagbtn23 == false) {
                        driversRemain--;
                        flagbtn23 = true;
                        addEvent();
                        btn23.setText("RESERVADO");
                        btn23.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn23 = false;
                        btn23.setText("07:00 p. m.");
                        btn23.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn23.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn24 = (Button) findViewById(R.id.btn24);
        btn24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn24 == true){
                    if(flagbtn24 == false) {
                        driversRemain--;
                        flagbtn24 = true;
                        addEvent();
                        btn24.setText("RESERVADO");
                        btn24.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn24 = false;
                        btn24.setText("07:30 p. m.");
                        btn24.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn24.getText().toString()));
                intent.putExtra(Intent.EXTRA_EMAIL,"revangelionx@gmail.com");

                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                    Toast.makeText(MainActivity.this,"Evento creado correctamente!", LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"No se pudo crear el evento", LENGTH_SHORT).show();
                }
            }
        });

        Button btn25 = (Button) findViewById(R.id.btn25);
        btn25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(driversRemain > 0 || flagbtn25 == true){
                    if(flagbtn25 == false) {
                        driversRemain--;
                        flagbtn25 = true;
                        addEvent();
                        btn25.setText("RESERVADO");
                        btn25.setBackgroundColor(Color.parseColor("#FF0000"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }else{
                        if(driversRemain<totalDrivers){
                            driversRemain++;
                        }
                        flagbtn25 = false;
                        btn25.setText("08:00 p. m.");
                        btn25.setBackgroundColor(Color.parseColor("#00FF00"));
                        tvRemaining.setText("Cantidad de Drivers Disponible: " + driversRemain);
                    }
                }else{
                    Toast.makeText(MainActivity.this,"No hay drivers disponibles", LENGTH_SHORT).show();
                }
            }
            private void addEvent() {
                Calendar calendar;
                SimpleDateFormat dateFormat;

                calendar = Calendar.getInstance();
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                date = dateFormat.format(calendar.getTime());

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE,titulo);
                intent.putExtra(CalendarContract.Events.HAS_ALARM,true);
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION,ubicacion);
                intent.putExtra(CalendarContract.Events.DESCRIPTION,descripcion);
                intent.putExtra(CalendarContract.Events.DURATION, 1800);
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn25.getText().toString()));
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

    public void setTotalDrivers() {
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

    public long getMiliseconds(String date, String time){

        try{
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm a");
            Date date1 = sdf.parse(date+" "+time);
            //Log.d("Fecha Mostrada:------",date1.toString());
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);
            Calendar beginCal = Calendar.getInstance();

            beginCal.set(cal1.get(Calendar.YEAR),cal1.get(Calendar.MONTH), cal1.get(Calendar.DAY_OF_MONTH), cal1.get(Calendar.HOUR_OF_DAY), cal1.get(Calendar.MINUTE));
            return beginCal.getTimeInMillis();
        }
        catch (Exception e) {
            return new Date().getTime();
        }
    }
}