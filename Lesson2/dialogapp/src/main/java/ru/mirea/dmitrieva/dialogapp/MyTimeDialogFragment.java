package ru.mirea.dmitrieva.dialogapp;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;

public class MyTimeDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), (view, hourOfDay, minute1) -> {
            String time = hourOfDay + ":" + String.format("%02d", minute1);
            Toast.makeText(getActivity(), "Выбрано время: " + time, Toast.LENGTH_LONG).show();
        }, hour, minute, true);
    }
}