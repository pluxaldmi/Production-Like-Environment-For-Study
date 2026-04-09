package ru.mirea.dmitievaaa.lesson3.sharer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewUserBook;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    static final String BOOK_NAME_KEY = "book_name";
    static final String QUOTES_KEY = "quotes_name";
    static final String USER_MESSAGE = "MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewUserBook = findViewById(R.id.textViewBook);
        Button buttonOpenShare = findViewById(R.id.buttonOpenShare);

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent data = result.getData();
                            if (data != null) {
                                String userBook = data.getStringExtra(USER_MESSAGE);
                                textViewUserBook.setText(userBook);
                            }
                        }
                    }
                });

        buttonOpenShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInfoAboutBook(v);
            }
        });
    }

    public void getInfoAboutBook(View view) {
        Intent intent = new Intent(MainActivity.this, ShareActivity.class);

        intent.putExtra(BOOK_NAME_KEY, "Мастер и Маргарита");
        intent.putExtra(QUOTES_KEY, "Никогда не просите ни о чём у тех, кто сильнее вас");

        activityResultLauncher.launch(intent);
    }
}