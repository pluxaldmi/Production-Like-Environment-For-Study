package ru.mirea.dmitievaaa.lesson3.simplefragmentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    private Fragment firstFragment;
    private Fragment secondFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        fragmentManager = getSupportFragmentManager();

        if (getResources().getConfiguration().orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer1, firstFragment)
                    .commit();

            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer2, secondFragment)
                    .commit();
        } else {
            Button btnFirst = findViewById(R.id.btnFirstFragment);
            Button btnSecond = findViewById(R.id.btnSecondFragment);

            btnFirst.setOnClickListener(v ->
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainer, firstFragment)
                            .commit()
            );

            btnSecond.setOnClickListener(v ->
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragmentContainer, secondFragment)
                            .commit()
            );

            if (savedInstanceState == null) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, firstFragment)
                        .commit();
            }
        }
    }
}