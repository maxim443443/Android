package com.example.helloworld;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int x = 0;

    int randomColor() { // задать цвет рандомно
        Random r = new Random();
        int red = r.nextInt(256);
        int green = r.nextInt(256);
        int blue = r.nextInt(256);
        return Color.rgb(red, green, blue);
    }

    String androidTime(){ // таймер до начала пар

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //формат времени

        Date dateNow = new Date(); // актуальное время
        String timeThis = format1.format(dateNow);

        Date dateS = null; // время начала пар


        try {
            dateS = format1.parse("2022-04-09 13:30:00"); // присвоение формата времени
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            dateNow = format1.parse(timeThis);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long delt = dateS.getTime() - dateNow.getTime(); // сравнение

        String result = String.format("До начала пар %dд %dч %dмин %dc",
                delt / 86400000,
                (delt % 86400000) / 3600000,
                (delt % 3600000) / 60000,
                (delt % 60000) /1000
                );

        return result;
    }


    public void fun(View view) {

        Button b = (Button)view;
        b.setText(""+x+"");
        x+=20;
        b.setMinimumWidth(0);
        b.setWidth(100+x);
        b.setBackgroundColor(randomColor());


        /////////////////////////////////////////
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(randomColor()));
        actionBar.setTitle(androidTime());

        //Toast.makeText(this, "Hello from button", Toast.LENGTH_SHORT).show();
    }
}