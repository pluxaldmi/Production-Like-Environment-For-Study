package ru.mirea.dmitievaaa.lesson3.intentapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textViewResult = findViewById(R.id.textViewResult);

        String time = getIntent().getStringExtra("current_time");
        if (time == null) {
            time = "время не передано";
        }

        int yourNumber = 9;

        int square = yourNumber * yourNumber;

        String resultText = "КВАДРАТ ЗНАЧЕНИЯ МОЕГО НОМЕРА ПО СПИСКУ В ГРУППЕ СОСТАВЛЯЕТ "
                + square
                + ", а текущее время "
                + time;

        textViewResult.setText(resultText);
    }
}