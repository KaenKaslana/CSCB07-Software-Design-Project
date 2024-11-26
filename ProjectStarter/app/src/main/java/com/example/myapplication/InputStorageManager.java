package com.example.myapplication;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.text.SimpleDateFormat;
import java.util.Date;

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
}