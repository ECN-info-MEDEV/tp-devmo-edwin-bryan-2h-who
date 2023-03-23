package com.example.who.ui.home;

import static com.example.who.ui.planning.CalendarUtils.selectedDate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.who.R;
import com.example.who.databinding.FragmentHomeBinding;
import com.example.who.ui.planning.CalendarUtils;
import com.example.who.ui.planning.Event;
import com.example.who.ui.planning.HourAdapter;
import com.example.who.ui.planning.HourEvent;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TextView monthDayText;
    private TextView dayOfWeekTV;
    private ListView hourListView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        HomeViewModel homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);

        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        final TextView monthView = binding.monthDayText;
//        final TextView dayView = binding.dayOfWeekTV;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        Button button = (Button) view.findViewById(R.id.nextDay);
//        button.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                selectedDate = selectedDate.minusDays(1);
//                setDayView();
//            }
//        });
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        monthDayText = (TextView) getView().findViewById(R.id.monthDayText);
        dayOfWeekTV = (TextView) getView().findViewById(R.id.dayOfWeekTV);
        hourListView  = (ListView) getView().findViewById(R.id.hourView);
        // or  (ImageView) view.findViewById(R.id.foo);
        setDayView();
    }

    private void setDayView()
    {
//        monthDayText.setText(CalendarUtils.monthDayFromDate(selectedDate));
//        String dayOfWeek = selectedDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());
//        dayOfWeekTV.setText(dayOfWeek);
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

        for(int hour = 0; hour < 24; hour++)
        {
            LocalTime time = LocalTime.of(hour, 0);
            ArrayList<Event> events = Event.eventsForDateAndTime(selectedDate, time);
            HourEvent hourEvent = new HourEvent(time, events);
            list.add(hourEvent);
        }

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
        binding = null;
    }
}