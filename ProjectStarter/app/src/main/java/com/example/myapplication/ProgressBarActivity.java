package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ProgressBarActivity extends AppCompatActivity {

    private LinearLayout habitsProgressContainer; // Container for dynamic UI components

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar); // Ensure the XML layout has a container for habits

        habitsProgressContainer = findViewById(R.id.habitsProgressContainer); // Replace with your container ID

        // Fetch user data from Firebase
        String userId = "4ZQqEUzd28aWjrhrU5PrJTXid7Z2"; // Replace with dynamic user ID in production
        DatabaseReference habitsRef = FirebaseDatabase.getInstance().getReference("Users").child(userId).child("Habits");

        fetchAndDisplayHabits(habitsRef);
        resetProgressForNewMonth(habitsRef);
    }

    private void fetchAndDisplayHabits(DatabaseReference habitsRef) {
        habitsRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    for (DataSnapshot habitSnapshot : snapshot.getChildren()) {
                        String habitName = habitSnapshot.getKey();
                        DataSnapshot progressSnapshot = habitSnapshot.child("Count");
                        DataSnapshot lastUpdatedSnapshot = habitSnapshot.child("LastUpdated");

                        int progress = progressSnapshot.exists() ? progressSnapshot.getValue(Integer.class) : 0;
                        String lastUpdated = lastUpdatedSnapshot.exists() ? lastUpdatedSnapshot.getValue(String.class) : null;

                        // Dynamically add UI components for each habit
                        addHabitProgressUI(habitName, progress, lastUpdated, habitsRef);
                    }
                } else {
                    Toast.makeText(ProgressBarActivity.this, "No habits found for this user!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ProgressBarActivity.this, "Error fetching data: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addHabitProgressUI(String habitName, int progress, String lastUpdated, DatabaseReference habitsRef) {
        // Create TextView for the habit name
        TextView habitNameTextView = new TextView(this);
        habitNameTextView.setText(habitName);
        habitNameTextView.setTextSize(18);
        habitNameTextView.setPadding(0, 16, 0, 8);

        // Create ProgressBar for the habit progress
        ProgressBar habitProgressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
        habitProgressBar.setMax(7); // Assuming weekly goals (e.g., 7 days)
        habitProgressBar.setProgress(progress);
        habitProgressBar.setPadding(0, 0, 0, 16);

        // Create a Button to increment progress
        Button incrementButton = new Button(this);
        incrementButton.setText("Mark as Complete");
        incrementButton.setOnClickListener(v -> {
            // Get today's date
            String today = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

            // Check if the habit was already updated today
            if (today.equals(lastUpdated)) {
                Toast.makeText(ProgressBarActivity.this, "You have already completed this habit today!", Toast.LENGTH_SHORT).show();
            } else {
                int newProgress = progress + 1;
                habitProgressBar.setProgress(newProgress);

                // Update progress and LastUpdated in Firebase
                habitsRef.child(habitName).child("Count").setValue(newProgress);
                habitsRef.child(habitName).child("LastUpdated").setValue(today)
                        .addOnSuccessListener(aVoid -> Toast.makeText(ProgressBarActivity.this, "Progress updated!", Toast.LENGTH_SHORT).show())
                        .addOnFailureListener(e -> Toast.makeText(ProgressBarActivity.this, "Failed to update: " + e.getMessage(), Toast.LENGTH_SHORT).show());
            }
        });

        // Add components to the container
        habitsProgressContainer.addView(habitNameTextView);
        habitsProgressContainer.addView(habitProgressBar);
        habitsProgressContainer.addView(incrementButton);
    }

    private void resetProgressForNewMonth(DatabaseReference habitsRef) {
        // Get today's date
        String today = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        // Check if today is the 1st day of the month
        if (today.endsWith("-01")) {
            habitsRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        for (DataSnapshot habitSnapshot : snapshot.getChildren()) {
                            String habitName = habitSnapshot.getKey();

                            // Reset the progress to 0
                            if (habitName != null) {
                                habitsRef.child(habitName).child("Count").setValue(0)
                                        .addOnSuccessListener(aVoid -> {
                                            // Optional: Notify the user
                                            Toast.makeText(ProgressBarActivity.this, "Progress reset for " + habitName, Toast.LENGTH_SHORT).show();
                                        })
                                        .addOnFailureListener(e -> {
                                            // Handle errors
                                            Toast.makeText(ProgressBarActivity.this, "Failed to reset progress: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                        });
                            }
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(ProgressBarActivity.this, "Error resetting progress: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
