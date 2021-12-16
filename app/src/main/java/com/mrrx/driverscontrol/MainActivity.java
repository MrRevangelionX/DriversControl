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
                        btn1.setText("08:00 AM");
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
                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, getMiliseconds(date, btn1.getText().toString()));
                intent.putExtra(CalendarContract.Events.DURATION, "1800");
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