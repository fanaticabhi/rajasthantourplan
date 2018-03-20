package com.example.abhi.rajasthantourplan;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.Calendar;


public class tourdates extends AppCompatActivity {

    Button b1;
    MaterialCalendarView mcv;
    TextView t1, t2;
    Calendar cal;
    int count = 0;

    static String startdate,enddate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourdates);

        b1=(Button)findViewById(R.id.button);
        mcv = (MaterialCalendarView) findViewById(R.id.calendarView);
        t1 = (TextView) findViewById(R.id.startdate);
        t2 = (TextView) findViewById(R.id.enddate);
      //  calenderstate();
        cal = Calendar.getInstance();
        mcv.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(tourdates.this,transport_new.class);
                startActivity(i);
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mcv.setVisibility(View.VISIBLE);
                count = 0;

            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mcv.setVisibility(View.VISIBLE);
                count = 1;

            }
        });

        mcv.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {

                if (count == 0) {
                    t1.setText("" + (mcv.getSelectedDate().toString()).substring(12, 21));
                    calendergone();
                    startdate=t1.getText().toString();


                } else {
                    t2.setText("" + (mcv.getSelectedDate().toString()).substring(12, 21));
                    calendergone();
                    startdate=t1.getText().toString();
                }
            }
        });
    }

    public void calendergone() {
        mcv.setVisibility(View.GONE);
    }

    private void calenderstate() {

        mcv.state().edit()
                .setFirstDayOfWeek(Calendar.MONDAY)
                .setMaximumDate(CalendarDay.from(2019, 1+1, 1))
                .setCalendarDisplayMode(CalendarMode.MONTHS);

        if (count == 0) {
            mcv.state().edit().setMinimumDate(CalendarDay.from((Integer.parseInt(mcv.getSelectedDate().toString().substring(12, 14))),
                    Integer.parseInt(mcv.getSelectedDate().toString().substring(17, 19)), Integer.parseInt(mcv.getSelectedDate().toString().substring(12, 15))));
        }
        if (count == 1) {
            mcv.state().edit().setMinimumDate(CalendarDay.from(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH)));
        }
        mcv.state().edit().commit();
    }
}


