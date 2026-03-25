package ru.mirea.dmitrieva.dialogapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAlert = findViewById(R.id.btnShowDialog);
        Button btnTime = findViewById(R.id.btnTimePicker);
        Button btnDate = findViewById(R.id.btnDatePicker);
        Button btnProgress = findViewById(R.id.btnProgress);

        btnAlert.setOnClickListener(v -> showAlertDialog());
        btnTime.setOnClickListener(v -> showTimeDialog());
        btnDate.setOnClickListener(v -> showDateDialog());
        btnProgress.setOnClickListener(v -> showProgressDialog());
    }

    private void showAlertDialog() {
        MyDialogFragment dialog = new MyDialogFragment();
        dialog.show(getSupportFragmentManager(), "alert");
    }

    private void showTimeDialog() {
        MyTimeDialogFragment dialog = new MyTimeDialogFragment();
        dialog.show(getSupportFragmentManager(), "time");
    }

    private void showDateDialog() {
        MyDateDialogFragment dialog = new MyDateDialogFragment();
        dialog.show(getSupportFragmentManager(), "date");
    }

    private void showProgressDialog() {
        MyProgressDialogFragment dialog = new MyProgressDialogFragment();
        dialog.show(getSupportFragmentManager(), "progress");

        new android.os.Handler().postDelayed(() -> {
            if (dialog.getDialog() != null && dialog.getDialog().isShowing()) {
                dialog.dismiss();
                Toast.makeText(this, "Загрузка завершена!", Toast.LENGTH_SHORT).show();
            }
        }, 3000);
    }

    public void onOkClicked() {
        Toast.makeText(this, "Вы выбрали кнопку \"Иду дальше\"!", Toast.LENGTH_LONG).show();
    }

    public void onNeutralClicked() {
        Toast.makeText(this, "Вы выбрали кнопку \"На паузе\"!", Toast.LENGTH_LONG).show();
    }

    public void onCancelClicked() {
        Toast.makeText(this, "Вы выбрали кнопку \"Нет\"!", Toast.LENGTH_LONG).show();
    }
}