package vn.edu.ntu.tuongnghi.ulti;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;

import java.util.Calendar;

import vn.edu.ntu.tuongnghi.observerpatterndemo.MainActivity;

public class MyTimeDialog {
    Context context;
    MainActivity onTimeChangedListener;
    Calendar calendar;

    public MyTimeDialog(Context context, MainActivity onTimeChangedListener,
                        Calendar calendar) {
        this.context = context;
        this.onTimeChangedListener = onTimeChangedListener;
        this.calendar = calendar;
    }

    public void showTimeDialog() {
        TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(hourOfDay, minute);
                if(onTimeChangedListener != null)
                    onTimeChangedListener.timeUpdate(calendar);
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(context, listener,
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }

    public static interface OnTimeChangedListener {
        public void timeUpdate(Calendar newTime);
    }
}
