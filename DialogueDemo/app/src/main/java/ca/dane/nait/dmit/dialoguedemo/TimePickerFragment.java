package ca.dane.nait.dmit.dialoguedemo;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import java.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by dchristenson5 on 5/26/2017.
 */

public class TimePickerFragment extends DialogFragment {
    TimePickerDialog.OnTimeSetListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar timeCalendar = Calendar.getInstance();
        int currentHour = timeCalendar.get(Calendar.HOUR);
        int currentMinute = timeCalendar.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),listener, currentHour, currentMinute, false);
    }
}
