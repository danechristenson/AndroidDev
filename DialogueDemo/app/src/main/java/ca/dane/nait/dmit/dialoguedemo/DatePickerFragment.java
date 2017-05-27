package ca.dane.nait.dmit.dialoguedemo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import java.util.Calendar;
import android.os.Bundle;

/**
 * Created by dchristenson5 on 5/26/2017.
 */

public class DatePickerFragment extends DialogFragment {

    DatePickerDialog.OnDateSetListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar currentCalendar = Calendar.getInstance();
        int currentYear = currentCalendar.get(Calendar.YEAR);
        int currentMonth = currentCalendar.get(Calendar.MONTH);
        int currentDay = currentCalendar.get(Calendar.DAY_OF_MONTH);

        //create a new instance of data picker dialog and return it
        return new DatePickerDialog(getActivity(), listener, currentYear, currentMonth, currentDay);
    }
}
