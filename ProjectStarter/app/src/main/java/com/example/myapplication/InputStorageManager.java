package com.example.myapplication;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.widget.Toast;

public class InputStorageManager {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    public InputStorageManager() {
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public boolean storeUserInput(String activityType, String subActivityType, double value) {
        // Check if the user is logged in
        if (mAuth.getCurrentUser() == null) {
            // User is not logged in
            return false;
        }

        // Check if the value is greater than zero
        if (value <= 0) {
            // Invalid value, ignore storing
            return false;
        }

        // Get user ID and current date
        String userId = mAuth.getCurrentUser().getUid();
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        // Construct reference to user's daily inputs for the current date
        DatabaseReference userDayRef = mDatabase.child("users").child(userId).child("daily_inputs").child(currentDate);

        // Update the data in Firebase based on activity type and sub-activity type
        userDayRef.child(activityType).child(subActivityType).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                double currentValue = 0;
                if (task.getResult().exists()) {
                    currentValue = task.getResult().getValue(Double.class);
                }
                double updatedValue = currentValue + value;
                userDayRef.child(activityType).child(subActivityType).setValue(updatedValue);
            }
        });

        return true; // Indicate the input was processed
    }

    public void deleteUserInput(Context context, String activityType, String subActivityType, double value) {
        if (mAuth.getCurrentUser() == null) {
            // User is not logged in
            Toast.makeText(context, "User is not logged in", Toast.LENGTH_SHORT).show();
            return;
        }

        if (value <= 0) {
            // Invalid value, ignore deletion
            Toast.makeText(context, "Invalid value for deletion. Please enter a positive value.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Get user ID and current date
        String userId = mAuth.getCurrentUser().getUid();
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        // Construct reference to user's daily inputs for the current date
        DatabaseReference userDayRef = mDatabase.child("users").child(userId).child("daily_inputs").child(currentDate).child(activityType).child(subActivityType);

        // Update the data in Firebase based on activity type and sub-activity type
        userDayRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful() && task.getResult().exists()) {
                Double currentValue = task.getResult().getValue(Double.class);
                if (currentValue != null && value <= currentValue) {
                    double updatedValue = currentValue - value;

                    if (updatedValue == 0) {
                        userDayRef.removeValue();
                    } else {
                        userDayRef.setValue(updatedValue);
                    }
                    Toast.makeText(context, "Input successfully deleted.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Invalid deletion: The value to delete is greater than what's stored.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(context, "No data found to delete.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}