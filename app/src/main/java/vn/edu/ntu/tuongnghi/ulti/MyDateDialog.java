package vn.edu.ntu.tuongnghi.ulti;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

import java.util.Calendar;

public class MyDateDialog {
    Context context;
    OnMyDateChangedListener onMyDateChangedListener;
    Calendar calendar;

    public MyDateDialog(Context context, OnMyDateChangedListener onMyDateChangedListener, Calendar calendar) {
        this.context = context;
        this.onMyDateChangedListener = onMyDateChangedListener;
        this.calendar = calendar;
    }

    public void showDateDialog() {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                if(onMyDateChangedListener != null)
                    onMyDateChangedListener.dateUpdate(calendar);
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, listener,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    };
    public static interface OnMyDateChangedListener {
        public void dateUpdate(Calendar newDate);
    }
}
