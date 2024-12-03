package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MenuActivity extends AppCompatActivity {

    private List<String> adoptedHabits = new ArrayList<>();
    private DatabaseReference databaseReference;
    private TextView suggestedHabitTextView;

    ExpandableListView expandableListView;
    List<String> categoryList;
    HashMap<String, List<String>> habitMap;
    ExpandableListAdapter expandableListAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("Search Habits...");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                expandableListAdapter.filter(newText);
                expandableListView.invalidate();
                return true;
            }
        });

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        FirebaseApp.initializeApp(this);
        setTheme(R.style.Theme_MyApplication_PageSpecific);

        // Get current user
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = auth.getCurrentUser();


        expandableListView = findViewById(R.id.expandableListView);
        suggestedHabitTextView = findViewById(R.id.suggestedHabitTextView);
        Button trackHabitsButton = findViewById(R.id.trackHabitsButton);

        prepareData();
        expandableListAdapter = new ExpandableListAdapter(this, categoryList, habitMap);
        expandableListView.setAdapter(expandableListAdapter);
        // Add OnChildClickListener to handle habit adoption
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            String habit = (String) expandableListAdapter.getChild(groupPosition, childPosition);
            if (habit != null) {
                if (!adoptedHabits.contains(habit)) {
                    adoptedHabits.add(habit);
                    String userId = currentUser.getUid();
                    fetchDataForUser(userId);
                    //String userId = "4ZQqEUzd28aWjrhrU5PrJTXid7Z2";
                    DatabaseReference habitsRef = FirebaseDatabase.getInstance()
                            .getReference("Users")
                            .child(userId)
                            .child("Habits");

                    habitsRef.child(habit).setValue(0);

                    Toast.makeText(MenuActivity.this, "You adopted the habit: " + habit, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MenuActivity.this, "You have already adopted the habit: " + habit, Toast.LENGTH_SHORT).show();
                }

                Log.d("AdoptedHabits", "Adopted habits: " + adoptedHabits);
            } else {
                Log.e("OnChildClickListener", "Habit is null for groupPosition: " + groupPosition + ", childPosition: " + childPosition);
            }

            return true;
        });

        databaseReference = FirebaseDatabase.getInstance().getReference();

        String userId = currentUser.getUid();
        fetchDataForUser(userId);


        trackHabitsButton.setOnClickListener(v -> {
            // Always pass the adoptedHabits list, even if empty
            Intent intent = new Intent(MenuActivity.this, EcoTrackerActivity.class);
            intent.putStringArrayListExtra("adoptedHabits", new ArrayList<>(adoptedHabits));
            startActivity(intent);
        });


    }

    private void fetchDataForUser(String userId) {
        DatabaseReference userReference = databaseReference.child("Users").child(userId);

        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    //transportation
                    String carType = dataSnapshot.child("Carq1").getValue(String.class);
                    String carTravel = dataSnapshot.child(("Carq2")).getValue(String.class);
                    //food
                    String foodPreference = dataSnapshot.child("Foodq1").getValue(String.class);
                    String beefFrequency = dataSnapshot.child("Meatq1").getValue(String.class);
                    String porkFrequency = dataSnapshot.child("Meatq2").getValue(String.class);
                    String fishFrequency = dataSnapshot.child("Meatq3").getValue(String.class);
                    String chickenFrequency = dataSnapshot.child("Meatq4").getValue(String.class);
                    String wasteFrequency = dataSnapshot.child("Wasteq").getValue(String.class);
                    //energy
                    String energyPreference = dataSnapshot.child("Houseq4").getValue(String.class);
                    String eletricBill = dataSnapshot.child("Houseq5").getValue(String.class);
                    String renewableEnergy = dataSnapshot.child("Houseq7").getValue(String.class);
                    //consumption
                    String useSecond = dataSnapshot.child("Consq2").getValue(String.class);
                    String recycleFrequency = dataSnapshot.child("Consq4").getValue(String.class);

                    // Get a list of suggested habits
                    List<String> suggestedHabits = suggestHabits(carType, foodPreference, recycleFrequency, carTravel, beefFrequency, fishFrequency, chickenFrequency, porkFrequency, wasteFrequency, energyPreference, eletricBill, renewableEnergy, useSecond);

                    // Display Suggested Habits
                    StringBuilder suggestions = new StringBuilder();
                    for (String habit : suggestedHabits) {
                        suggestions.append("- ").append(habit).append("\n");
                    }

                    suggestedHabitTextView.setText("Suggested Habits:\n" + suggestions.toString().trim());
                    suggestedHabitTextView.setVisibility(View.VISIBLE);

                    Log.d("FirebaseData", "Car Type: " + carType + ", Suggested Habits: " + suggestedHabits);
                } else {
                    Toast.makeText(MenuActivity.this, "User not found!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MenuActivity.this, "Database Error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private List<String> suggestHabits(String carType, String foodPreference, String recycleFrequency, String carTravel, String beefFrequency, String fishFrequency, String chickenFrequency, String porkFrequency, String wasteFrequency, String energyPreference, String eletricBill, String renewableEnergy, String useSecond) {
        List<String> suggestions = new ArrayList<>();
        suggestions.add("Choose local seasonal produce");
        //transportation
        if ("Gasoline".equalsIgnoreCase(carType)) {
            suggestions.add("Drive Electric vehicle");
        }
        if ("More than 25k".equalsIgnoreCase(carTravel)) {
            suggestions.add("Work from home");
        }
        //food
        if ("Meat-based".equalsIgnoreCase(foodPreference) && "Daily".equalsIgnoreCase(fishFrequency) && "Daily".equalsIgnoreCase(porkFrequency)&& "Daily".equalsIgnoreCase(beefFrequency) && "Daily".equalsIgnoreCase(chickenFrequency)) {
            suggestions.add("Eat more plant-based meals");
        }else if ("Meat-based".equalsIgnoreCase(foodPreference) && "Daily".equalsIgnoreCase(fishFrequency) && "Daily".equalsIgnoreCase(porkFrequency) && "Daily".equalsIgnoreCase(beefFrequency)) {
            suggestions.add("Eat more plant-based meals");
        }else if ("Meat-based".equalsIgnoreCase(foodPreference) && "Daily".equalsIgnoreCase(fishFrequency) && "Daily".equalsIgnoreCase(porkFrequency) && "Daily".equalsIgnoreCase(chickenFrequency)) {
            suggestions.add("Eat more plant-based meals");
        }else if ("Meat-based".equalsIgnoreCase(foodPreference) && "Daily".equalsIgnoreCase(chickenFrequency) && "Daily".equalsIgnoreCase(porkFrequency) && "Daily".equalsIgnoreCase(beefFrequency)) {
            suggestions.add("Eat more plant-based meals");
        }else if ("Vegetarian".equalsIgnoreCase(foodPreference) || "Frequently".equalsIgnoreCase(wasteFrequency) || "Occasionally".equalsIgnoreCase(wasteFrequency)) {
            suggestions.add("Grow your own vegetables");
        }
        //energy
        if ("Over $200".equalsIgnoreCase(eletricBill)) {
            suggestions.add("Choose energy-efficient appliances");
            suggestions.add("Switch off lights and appliances");
        }
        if ("No".equalsIgnoreCase(renewableEnergy)) {
            suggestions.add("Use solar panels");
        }

        //consumption
        if (!"Always".equalsIgnoreCase(recycleFrequency)) {
            suggestions.add("Recycle properly");
        }
        if ("No".equalsIgnoreCase(useSecond)){
            suggestions.add("Buy second-hand items");
        }

        return suggestions;
    }


    private void prepareData() {
        categoryList = new ArrayList<>();
        habitMap = new HashMap<>();

        // Add categories and habits
        categoryList.add("Transportation");
        categoryList.add("Energy");
        categoryList.add("Food");
        categoryList.add("Consumption");

        List<String> transportation = new ArrayList<>();
        transportation.add("Walk");
        transportation.add("Bike");
        transportation.add("Drive Electric vehicle");
        transportation.add("Work from home");

        List<String> energy = new ArrayList<>();
        energy.add("Switch off lights and appliances");
        energy.add("Choose energy-efficient appliances");
        energy.add("Set your thermostat a few degrees lower in winter");
        energy.add("Use solar panels");

        List<String> food = new ArrayList<>();
        food.add("Eat more plant-based meals");
        food.add("Choose local seasonal produce");
        food.add("Reduce food waste");
        food.add("Grow your own vegetables");

        List<String> consumption = new ArrayList<>();
        consumption.add("Recycle properly");
        consumption.add("Buy second-hand items");
        consumption.add("Use reusable containers");

        habitMap.put("Transportation", transportation);
        habitMap.put("Energy", energy);
        habitMap.put("Food", food);
        habitMap.put("Consumption", consumption);
    }
}
