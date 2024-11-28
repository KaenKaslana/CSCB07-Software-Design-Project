package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.HashMap;

public class EmissionDisplayActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private TextView tvDate, tvDailyCO2Emission, tvTransportationCO2, tvFoodCO2, tvShoppingCO2;
    private Button btnDetailedActivityList, btnInputActivities;
    private String storedActivityDetails;
    private double totalDailyCO2Emission;
    private double transportationCO2, foodCO2, shoppingCO2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emission_display);

        // Initialize Firebase authentication and database reference
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Initialize UI components
        tvDate = findViewById(R.id.tvDate);
        tvDailyCO2Emission = findViewById(R.id.tvDailyCO2Emission);
        tvTransportationCO2 = findViewById(R.id.tvTransportationCO2);
        tvFoodCO2 = findViewById(R.id.tvFoodCO2);
        tvShoppingCO2 = findViewById(R.id.tvShoppingCO2);
        btnDetailedActivityList = findViewById(R.id.btnDetailedActivityList);
        btnInputActivities = findViewById(R.id.btnInputActivities);

        // Set up buttons to navigate to other activities
        setUpButtons();

        // Display daily CO2 emission and activities
        displayDailyEmission();
    }

    private void setUpButtons() {
        btnDetailedActivityList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmissionDisplayActivity.this, DetailedActivityListActivity.class);
                intent.putExtra("activityList", storedActivityDetails.toString()); // Pass the activity details string
                startActivity(intent);
            }
        });

        btnInputActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmissionDisplayActivity.this, EcoTrackerActivity.class);
                startActivity(intent);
            }
        });

    }

    private void displayDailyEmission() {
        if (mAuth.getCurrentUser() == null) {
            // User is not logged in
            Toast.makeText(this, "Please log in to view your emissions.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Get user ID and current date
        String userId = mAuth.getCurrentUser().getUid();
        String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        // Display the current date
        tvDate.setText(currentDate);

        // Construct reference to user's daily inputs for the current date
        DatabaseReference userDayRef = mDatabase.child("users").child(userId).child("daily_inputs").child(currentDate);

        userDayRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    double totalDailyCO2Emission = 0.0;
                    double transportationEmission = 0.0;
                    double foodEmission = 0.0;
                    double shoppingEmission = 0.0;

                    StringBuilder activityListBuilder = new StringBuilder();

                    for (DataSnapshot activitySnapshot : dataSnapshot.getChildren()) {
                        String activityType = activitySnapshot.getKey();

                        for (DataSnapshot subActivitySnapshot : activitySnapshot.getChildren()) {
                            String subActivityType = subActivitySnapshot.getKey();
                            Object valueObj = subActivitySnapshot.getValue();

                            // Check if the value is a nested HashMap
                            if (valueObj instanceof HashMap) {
                                // Transform HashMap into formatted sub-activity type
                                HashMap<?, ?> valueMap = (HashMap<?, ?>) valueObj;

                                for (Object keyObj : valueMap.keySet()) {
                                    String formattedSubActivityType = keyObj.toString();
                                    Object nestedValueObj = valueMap.get(keyObj);

                                    if (nestedValueObj instanceof Number) {
                                        double value = ((Number) nestedValueObj).doubleValue();
                                        double emission = calculateEmission(activityType, formattedSubActivityType, value);

                                        totalDailyCO2Emission += emission;

                                        // Append activity details to the list
                                        activityListBuilder.append(formatActivityName(activityType, formattedSubActivityType))
                                                .append(": ")
                                                .append(formatValueWithUnit(activityType, formattedSubActivityType, value))
                                                .append(" - ")
                                                .append(String.format(Locale.getDefault(), "%.2f", emission))
                                                .append(" kg CO2\n");

                                        // Sum emissions per category
                                        switch (activityType) {
                                            case "transportation":
                                                transportationEmission += emission;
                                                break;
                                            case "food_consumption":
                                                foodEmission += emission;
                                                break;
                                            case "shopping_consumption":
                                                shoppingEmission += emission;
                                                break;
                                        }
                                    }
                                }
                            } else if (valueObj instanceof Number) {
                                // If value is not nested, handle it directly
                                double value = ((Number) valueObj).doubleValue();
                                double emission = calculateEmission(activityType, subActivityType, value);

                                totalDailyCO2Emission += emission;

                                // Append activity details to the list
                                activityListBuilder.append(formatActivityName(activityType, subActivityType))
                                        .append(": ")
                                        .append(formatValueWithUnit(activityType, subActivityType, value))
                                        .append(" - ")
                                        .append(String.format(Locale.getDefault(), "%.2f", emission))
                                        .append(" kg CO2\n");

                                // Sum emissions per category
                                switch (activityType) {
                                    case "transportation":
                                        transportationEmission += emission;
                                        break;
                                    case "food_consumption":
                                        foodEmission += emission;
                                        break;
                                    case "shopping_consumption":
                                        shoppingEmission += emission;
                                        break;
                                }
                            }
                        }
                    }

                    // Display total daily CO2 emission
                    tvDailyCO2Emission.setText("Daily CO2 Emission: " + String.format(Locale.getDefault(), "%.2f", totalDailyCO2Emission) + " kg");

                    // Display emissions per category
                    tvTransportationCO2.setText("Transportation: " + String.format(Locale.getDefault(), "%.2f", transportationEmission) + " kg");
                    tvFoodCO2.setText("Food Consumption: " + String.format(Locale.getDefault(), "%.2f", foodEmission) + " kg");
                    tvShoppingCO2.setText("Consumption and Shopping: " + String.format(Locale.getDefault(), "%.2f", shoppingEmission) + " kg");

                    // Store the detailed activity list for use in the DetailedActivityListActivity
                    storedActivityDetails = activityListBuilder.toString();

                } else {
                    // No data for the current date
                    tvDailyCO2Emission.setText("Daily CO2 Emission: 0 kg");
                    tvTransportationCO2.setText("Transportation: 0 kg");
                    tvFoodCO2.setText("Food Consumption: 0 kg");
                    tvShoppingCO2.setText("Consumption and Shopping: 0 kg");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle database error
                Toast.makeText(EmissionDisplayActivity.this, "Failed to load data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void categorizeEmissions(String activityType, double emission) {
        switch (activityType) {
            case "transportation":
                transportationCO2 += emission;
                break;
            case "food_consumption":
                foodCO2 += emission;
                break;
            case "shopping_consumption":
                shoppingCO2 += emission;
                break;
            default:
                // Unknown activity type, do nothing
                break;
        }
    }

    // Reuse helper methods from the demo
    private String formatSubActivityTypeFromMap(String activityType, HashMap<?, ?> valueMap) {
        // This method helps transform the HashMap into a proper sub-activity key
        for (Object key : valueMap.keySet()) {
            if (key instanceof String) {
                return (String) key;
            }
        }
        return null;
    }

    private double getValueFromHashMap(HashMap<?, ?> valueMap) {
        // This method extracts the numeric value from the HashMap for emission calculation
        for (Object value : valueMap.values()) {
            if (value instanceof Number) {
                return ((Number) value).doubleValue();
            }
        }
        return 0.0;
    }

    private double calculateEmission(String activityType, String subActivityType, double value) {
        double emissionFactor = 0.0;

        switch (activityType) {
            case "transportation":
                switch (subActivityType) {
                    case "car":
                        emissionFactor = 0.24; // kg CO2 per km for gasoline car
                        break;
                    case "bus":
                        emissionFactor = 0.2; // kg CO2 per hour for bus
                        break;
                    case "train":
                        emissionFactor = 0.1; // kg CO2 per hour for train
                        break;
                    case "subway":
                        emissionFactor = 0.15; // kg CO2 per hour for subway
                        break;
                    case "cycling_walking":
                        return 0.0; // No emissions for cycling or walking
                    case "short_haul_flight":
                        if (value <= 2) {
                            return 225.0; // kg CO2 for 1-2 short-haul flights per year
                        } else if (value <= 5) {
                            return 600.0; // kg CO2 for 3-5 short-haul flights per year
                        } else if (value <= 10) {
                            return 1200.0; // kg CO2 for 6-10 short-haul flights per year
                        } else {
                            return 1800.0; // kg CO2 for more than 10 short-haul flights per year
                        }
                    case "long_haul_flight":
                        if (value <= 2) {
                            return 825.0; // kg CO2 for 1-2 long-haul flights per year
                        } else if (value <= 5) {
                            return 2200.0; // kg CO2 for 3-5 long-haul flights per year
                        } else if (value <= 10) {
                            return 4400.0; // kg CO2 for 6-10 long-haul flights per year
                        } else {
                            return 6600.0; // kg CO2 for more than 10 long-haul flights per year
                        }
                    default:
                        return 0.0;
                }
                break;

            case "food_consumption":
                switch (subActivityType) {
                    case "beef":
                        emissionFactor = 27.0; // kg CO2 per serving for beef
                        break;
                    case "pork":
                        emissionFactor = 12.1; // kg CO2 per serving for pork
                        break;
                    case "chicken":
                        emissionFactor = 6.9; // kg CO2 per serving for chicken
                        break;
                    case "fish":
                        emissionFactor = 5.5; // kg CO2 per serving for fish
                        break;
                    case "plant_based":
                        emissionFactor = 2.0; // kg CO2 per serving for plant-based
                        break;
                    default:
                        return 0.0;
                }
                break;

            case "shopping_consumption":
                switch (subActivityType) {
                    case "clothes":
                        emissionFactor = 9.0; // kg CO2 per item for clothes
                        break;
                    case "smartphone":
                        emissionFactor = 70.0; // kg CO2 per smartphone
                        break;
                    case "laptop":
                        emissionFactor = 200.0; // kg CO2 per laptop
                        break;
                    case "tv":
                        emissionFactor = 150.0; // kg CO2 per TV
                        break;
                    case "furniture":
                        emissionFactor = 50.0; // kg CO2 per furniture purchase
                        break;
                    case "appliances":
                        emissionFactor = 100.0; // kg CO2 per appliance purchase
                        break;
                    case "electricity":
                        emissionFactor = 0.233; // kg CO2 per kWh for electricity
                        return (value / 30) * emissionFactor; // Assuming monthly bill, divided by 30 for daily emission
                    case "gas":
                        emissionFactor = 2.05; // kg CO2 per therm for natural gas
                        return (value / 30) * emissionFactor; // Assuming monthly bill, divided by 30 for daily emission
                    case "water":
                        emissionFactor = 0.002; // kg CO2 per gallon for water
                        return (value / 30) * emissionFactor; // Assuming monthly bill, divided by 30 for daily emission
                    default:
                        return 0.0;
                }
                break;

            default:
                return 0.0;
        }

        return value * emissionFactor;
    }

    private String formatActivityName(String activityType, String subActivityType) {
        switch (activityType) {
            case "food_consumption":
                return "Food (" + subActivityType + ")";
            case "shopping_consumption":
                return "Shopping (" + subActivityType + ")";
            case "transportation":
                return "Transport (" + subActivityType + ")";
            default:
                return activityType + " (" + subActivityType + ")";
        }
    }

    private String formatValueWithUnit(String activityType, String subActivityType, double value) {
        String unit;

        switch (activityType) {
            case "food_consumption":
                unit = "serving";
                break;
            case "shopping_consumption":
                switch (subActivityType) {
                    case "smartphone":
                    case "laptop":
                    case "tv":
                        unit = "device";
                        break;
                    case "furniture":
                    case "appliances":
                        unit = "purchase";
                        break;
                    case "electricity":
                    case "gas":
                    case "water":
                        unit = "$";
                        break;
                    default:
                        unit = "item";
                        break;
                }
                break;
            case "transportation":
                if (subActivityType.contains("flight")) {
                    unit = "flight";
                } else if (subActivityType.equals("bus") ||
                        subActivityType.equals("train") ||
                        subActivityType.equals("subway")) {
                    unit = value == 1 ? "hour" : "hours";
                } else {
                    unit = "km";
                }
                break;
            default:
                unit = "unit";
        }

        // Use integer formatting if value is a whole number
        String formattedValue;
        if (value == Math.floor(value)) {
            formattedValue = String.format(Locale.getDefault(), "%.0f", value);
        } else {
            formattedValue = String.format(Locale.getDefault(), "%.1f", value);
        }

        // Add "s" for plural units when necessary
        if (value != 1 && !unit.equals("km") && !unit.equals("$")) {
            unit += "s";
        }

        return formattedValue + " " + unit;
    }
}