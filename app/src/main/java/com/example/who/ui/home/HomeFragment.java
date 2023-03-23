package com.example.who.ui.home;

import static com.example.who.ui.planning.CalendarUtils.selectedDate;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.who.R;
import com.example.who.ui.planning.CalendarUtils;
import com.example.who.ui.planning.Event;
import com.example.who.ui.planning.HourAdapter;
import com.example.who.ui.planning.HourEvent;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

public class HomeFragment extends Fragment {

    private TextView monthDayText;
    private TextView dayOfWeekTV;
    private ListView hourListView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        monthDayText = (TextView) getView().findViewById(R.id.monthDayText);
        dayOfWeekTV = (TextView) getView().findViewById(R.id.dayOfWeekTV);
        hourListView  = (ListView) getView().findViewById(R.id.hourView);
        // or  (ImageView) view.findViewById(R.id.foo);

        CalendarUtils.selectedDate = LocalDate.now();

        // Manage onClick buttons in a fragment
        setOnClickButton(view);

        setDayView();
    }

    private void setOnClickButton(View view){
        Button button = (Button) view.findViewById(R.id.nextDay);
        Button button2 = (Button) view.findViewById(R.id.previousDay);
        button.setOnClickListener(this::nextDayAction);
        button2.setOnClickListener(this::previousDayAction);
    }

    private void setCourses(){
        Event.eventsList.clear();
        LocalTime time = LocalTime.parse("10:00:00");
//        LocalDate date = LocalDate.parse("2023-03-24");
        LocalDate date = LocalDate.now();
        Event event1 = new Event("TD-DEVMO", date, time);
        Event event2 = new Event("DS-DEVMO", date, LocalTime.parse("11:00:00"));
        Event.eventsList.add(event1);
        Event.eventsList.add(event2);
    }

    private void setDayView()
    {
        monthDayText.setText(CalendarUtils.monthDayFromDate(selectedDate));
        String dayOfWeek = selectedDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
        dayOfWeekTV.setText(dayOfWeek);
        setCourses();
        setHourAdapter();
    }

    private void setHourAdapter()
    {
        HourAdapter hourAdapter = new HourAdapter(getContext(), hourEventList());
        hourListView.setAdapter(hourAdapter);
    }

    private ArrayList<HourEvent> hourEventList()
    {
        ArrayList<HourEvent> list = new ArrayList<>();

        // Fills the hourEventList
        // For every hour we have an EventList that is also filled
        for(int hour = 8; hour < 21; hour++)
        {
            LocalTime time = LocalTime.of(hour, 0);
            ArrayList<Event> events = Event.eventsForDateAndTime(selectedDate, time);
            HourEvent hourEvent = new HourEvent(time, events);
            list.add(hourEvent);
        }

        //  time | events(Event List)
        //  8:00 | Event1 Event2  ...
        //  9:00 | Event1 ...
        //  ...
        return list;
    }

    public void previousDayAction(View view)
    {
        selectedDate = selectedDate.minusDays(1);
        setDayView();
    }

    public void nextDayAction(View view)
    {
        selectedDate = selectedDate.plusDays(1);
        setDayView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}