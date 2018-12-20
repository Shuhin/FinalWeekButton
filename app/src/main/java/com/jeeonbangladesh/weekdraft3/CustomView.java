package com.jeeonbangladesh.weekdraft3;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import org.threeten.bp.DayOfWeek;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CustomView extends LinearLayout{
    private ImageView previousButton;
    private TextView getCurrentDate;
    private GridView getCalendarGridView;
    private static final String TAG = CustomView.class.getSimpleName();
    private Context context;
    private TextView currentDate;
    private DatabaseQuery mQuery;
    private GridAdapter mAdapter;
    private GridView calendarGridView;
    private MaterialCalendarView materialCalendarView;
    private Calendar cal =Calendar.getInstance(Locale.ENGLISH);
    private SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);

    public CustomView(Context context) {
        super(context);
    }
    public CustomView(Context context,AttributeSet attributeSet){
        super(context,attributeSet);
        this.context=context;
        setUpCalendarAdapter();
        initializeUILayout();
        //setPreviouButtonClickEvent();
    }
//    private void setPreviouButtonClickEvent(){
//        previousButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setContentView(R.layout.activity_main);
//
//            }
//    }
    private void initializeUILayout(){
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.single_cell_layout,this);
        previousButton =(ImageView)view.findViewById(R.id.activity_main);
    }
  private void setUpCalendarAdapter(){
        List<Date>dayValueInCells = new ArrayList<Date>();
        mQuery = new DatabaseQuery(context);
       List<EventObjects> mEvents = mQuery.getAllFutureEvents();
         mAdapter = new GridAdapter(context, dayValueInCells , materialCalendarView, mEvents);
         calendarGridView.setAdapter(mAdapter);
    }
}
