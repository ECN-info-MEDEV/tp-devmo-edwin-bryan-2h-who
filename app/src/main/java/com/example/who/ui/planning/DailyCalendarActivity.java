package com.example.who.ui.planning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.who.R;

import java.util.ArrayList;

public class DailyCalendarActivity extends AppCompatActivity {

    private TextView monthDayText;
    private TextView dayOfWeekTV;
    private ListView houtListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_calendar);
        initWidgets();
    }

    private void initWidgets() {
        monthDayText = findViewById(R.id.monthDayText);
        dayOfWeekTV = findViewById(R.id.dayOfWeekTV);
        houtListView = findViewById(R.id.hourListView);
    }

    @Override
    protected void onResume(){
        super.onResume();
        setDayView();
    }

    private void setDayView() {
    }


}