package com.example.myapplication;

import static java.lang.String.format;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarActivityUI extends AppCompatActivity {
    CalendarView calendarView;
    Calendar calendar;
    DatabaseReference databaseReference;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_ui);

        calendarView = findViewById(R.id.calendarViewName);
        calendar = Calendar.getInstance();

        // Initialize Firebase
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        currentUser = FirebaseAuth.getInstance().getCurrentUser();

        // Set default date

        String dateDisplay = getIntent().getStringExtra("sendDate");
        // Get today's date
        String[] dateArray = dateDisplay.split("-");
        int todayDay = Integer.parseInt(dateArray[2]);
        int todayMonth = Integer.parseInt(dateArray[1]);
        int todayYear = Integer.parseInt(dateArray[0]);

// Use the date components
        setDate(todayDay, todayMonth, todayYear); // Call your setDate method


        // Listen for date changes
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int day) {
                // Format the selected date
                String formattedDate = year + "-" + (month + 1) + "-" + day;

                // Save the date to Firebase for the current user
                if (currentUser != null) {
                    String userId = currentUser.getUid(); // Get the user's unique ID
                    databaseReference.child(userId).child("selectedDate").setValue(formattedDate)
                            .addOnSuccessListener(aVoid -> {
                                Toast.makeText(CalendarActivityUI.this, "Date updated: " + formattedDate, Toast.LENGTH_SHORT).show();

                                // Navigate to EmissionDisplayActivity
                                Intent intent = new Intent(CalendarActivityUI.this, EmissionDisplayActivity.class);
                                intent.putExtra("currentDate", formattedDate); // Pass the selected date
                                startActivity(intent);
                            })
                            .addOnFailureListener(e -> Toast.makeText(CalendarActivityUI.this, "Failed to update date", Toast.LENGTH_SHORT).show());
                } else {
                    Toast.makeText(CalendarActivityUI.this, "User not logged in", Toast.LENGTH_SHORT).show();
                    //testing delete after merging
                    Intent intent = new Intent(CalendarActivityUI.this, EmissionDisplayActivity.class);
                    intent.putExtra("currentDate", formattedDate); // Pass the selected date
                    startActivity(intent);

                }
            }
        });
    }


    public void getDate() {
        long date = calendarView.getDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        calendar.setTimeInMillis(date);
        String selectedDate = simpleDateFormat.format(calendar.getTime());
        Toast.makeText(this, selectedDate, Toast.LENGTH_SHORT).show();
    }

    public void setDate(int day, int month, int year) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        long milli = calendar.getTimeInMillis();
        calendarView.setDate(milli);
    }
}
