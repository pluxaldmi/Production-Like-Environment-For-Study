package ru.mirea.dmitievaaa.lesson3.sharer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShareActivity extends AppCompatActivity {

    private TextView textViewDeveloperBook;
    private TextView textViewDeveloperQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        textViewDeveloperBook = findViewById(R.id.textViewDeveloperBook);
        textViewDeveloperQuote = findViewById(R.id.textViewDeveloperQuote);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String book_name = extras.getString(MainActivity.BOOK_NAME_KEY);
            String quotes_name = extras.getString(MainActivity.QUOTES_KEY);

            textViewDeveloperBook.setText("Моя любимая книга: " + book_name);
            textViewDeveloperQuote.setText("Цитата: " + quotes_name);
        }

        Button buttonSendData = findViewById(R.id.buttonSendData);
        buttonSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendUserData();
            }
        });
    }

    private void sendUserData() {
        TextView editTextUserBook = findViewById(R.id.editTextUserBook);
        TextView editTextUserQuote = findViewById(R.id.editTextUserQuote);

        String userBook = editTextUserBook.getText().toString().trim();
        String userQuote = editTextUserQuote.getText().toString().trim();

        String resultMessage = "Название Вашей любимой книги: " + userBook +
                "\nЦитата: " + userQuote;

        Intent data = new Intent();
        data.putExtra(MainActivity.USER_MESSAGE, resultMessage);

        setResult(RESULT_OK, data);
        finish();
    }
}