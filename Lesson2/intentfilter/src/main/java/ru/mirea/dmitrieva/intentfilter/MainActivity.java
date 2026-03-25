package ru.mirea.dmitrieva.intentfilter;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOpenSite = findViewById(R.id.btnOpenSite);
        Button btnShare = findViewById(R.id.btnShare);

        btnOpenSite.setOnClickListener(v -> {
            Uri address = Uri.parse("https://www.mirea.ru/");
            Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, address);
            startActivity(openLinkIntent);
        });

        btnShare.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "МИРЭА");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Дмитриева Алиса - студентка РТУ МИРЭА");

            startActivity(Intent.createChooser(shareIntent, "Поделиться ФИО"));
        });
    }
}