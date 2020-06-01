package vn.edu.ntu.tuongnghi.observerpatterndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;

import java.util.Calendar;

import vn.edu.ntu.tuongnghi.ulti.MyDateDialog;
import vn.edu.ntu.tuongnghi.ulti.MyTimeDialog;

public class MainActivity extends AppCompatActivity
        implements MyDateDialog.OnMyDateChangedListener,MyTimeDialog.OnTimeChangedListener {

    EditText editDate, editTime;
    ImageView imvDate, imvTime;
    Calendar calendar = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();
        dateUpdate(calendar);
        timeUpdate(calendar);
        addEvents();
    }

    private void addView() {
        editDate = findViewById(R.id.editDate);
        editDate.setEnabled(false);
        imvDate = findViewById(R.id.imvDate);
        editTime = findViewById(R.id.editTime);
        editTime.setEnabled(false);
        imvTime = findViewById(R.id.imvTime);
    }

    private void addEvents() {
        imvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDateDialog dateDialog = new MyDateDialog(MainActivity.this,
                        MainActivity.this,
                        Calendar.getInstance());
                dateDialog.showDateDialog();
            }
        });
        imvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTimeDialog timeDialog = new MyTimeDialog(MainActivity.this,
                        MainActivity.this,
                        Calendar.getInstance());
                timeDialog.showTimeDialog();
            }
        });
    }

    @Override
    public void dateUpdate(Calendar newDate) {
        StringBuilder builder = new StringBuilder();
        builder.append(newDate.get(Calendar.DAY_OF_MONTH)).append("/").
                append(newDate.get(Calendar.MONTH) + 1).append("/").
                append(newDate.get(Calendar.YEAR));
        editDate.setText(builder);
    }

    @Override
    public void timeUpdate(Calendar newTime) {
        StringBuilder builder = new StringBuilder();
        builder.append(newTime.get(Calendar.HOUR_OF_DAY)).append(":").
                append(newTime.get(Calendar.MINUTE));
        editTime.setText(builder);
    }

}
