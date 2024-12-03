package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
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
import java.util.Map;

public class EcoGauge extends AppCompatActivity {

    private static final String TAG = "EcoGauge";

    private TextView tvTotalEmissions, tvSelectedPeriod, tvGlobalComparison;
    private LineChart lineChartTrend;
    private PieChart pieChartEmissions;
    private Spinner periodSpinner;

    // Firebase references
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    // Emissions data
    private List<Float> dailyEmissions = new ArrayList<>();
    private float transportationEmission, foodConsumptionEmission, shoppingEmission;
    private float total_emission;
    private Map<String, Float> dailyEmissionsByDate = new HashMap<>();
    private Map<String, Float> globalAverages = new HashMap<>();

    private void initializeGlobalAverages() {
        globalAverages.clear();
        globalAverages.put("United States", 15.52f);
        globalAverages.put("Canada", 14.2f);
        globalAverages.put("United Kingdom", 5.6f);
        globalAverages.put("India", 1.91f);
        globalAverages.put("China", 7.1f);
        globalAverages.put("World", 4.658219f); // Global average
        // Add other countries as needed
    }

    private void compareToGlobalOrNationalAverage(String country, float userEmission) {
        Float countryAverage = globalAverages.get(country) * 30;
        Float globalAverage = globalAverages.get("World") * 30;

        if (countryAverage == null && globalAverage == null) {
            tvGlobalComparison.setText("Could not compare to global or national averages.");
            return;
        }

        if (countryAverage == null) {
            countryAverage = globalAverage; // Default to global if no national average
        }

        float percentageOfCountry = (userEmission / countryAverage) * 100;
        float percentageOfGlobal = (userEmission / globalAverage) * 100;

        tvGlobalComparison.setText(String.format(
                "Your emissions are %.2f%% of the average for %s.\n" +
                        "Globally, they are %.2f%% of the world average.",
                percentageOfCountry, country != null ? country : "the World", percentageOfGlobal
        ));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eco_gauge);

        // Initialize Firebase
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

        if (currentUser != null) {
            String userId = currentUser.getUid();
            databaseReference = FirebaseDatabase.getInstance().getReference("users").child(userId).child("daily_inputs");
        } else {
            Log.e(TAG, "No user logged in");
            return;
        }

        // Commented out user ID retrieval for testing purposes
        //String sampleUserId = "6m87EapehFbeQjLCqfxQ3MOSSFp2"; // Replace this with your test user ID
        //databaseReference = FirebaseDatabase.getInstance().getReference("users").child(sampleUserId).child("daily_inputs");

        // Initialize views
        tvTotalEmissions = findViewById(R.id.tv_total_emissions);
        tvSelectedPeriod = findViewById(R.id.tv_selected_period);
        tvGlobalComparison = findViewById(R.id.tv_global_comparison);
        lineChartTrend = findViewById(R.id.line_chart_trend);
        pieChartEmissions = findViewById(R.id.pie_chart_emissions);
        periodSpinner = findViewById(R.id.period_spinner);

        // Set up the global averages
        initializeGlobalAverages();

        // Set up the spinner for period selection
        setupPeriodSpinner();

        // Fetch data from Firebase and update charts
        fetchDataFromFirebase();
    }

    private void setupPeriodSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.emission_periods, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        periodSpinner.setAdapter(adapter);

        periodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String period = parent.getItemAtPosition(position).toString();
                updateChart(period);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                updateChart("Daily");
            }
        });
    }

    private void fetchDataFromFirebase() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Log.d(TAG, "Data fetched: " + snapshot.getValue());
                if (snapshot.exists()) {
                    dailyEmissions.clear();
                    dailyEmissionsByDate.clear();
                    transportationEmission = 0;
                    foodConsumptionEmission = 0;
                    shoppingEmission = 0;
                    total_emission = 0;

                    for (DataSnapshot dateSnapshot : snapshot.getChildren()) {
                        Float totalDailyEmission = dateSnapshot.child("Total_Daily_Emission").getValue(Float.class);
                        Float transportation = dateSnapshot.child("Transportation_Emission").getValue(Float.class);
                        Float food = dateSnapshot.child("Food_Emission").getValue(Float.class);
                        Float shopping = dateSnapshot.child("Consumption_Shopping_Emission").getValue(Float.class);

                        // Handle null values gracefully
                        dailyEmissions.add(totalDailyEmission != null ? totalDailyEmission.floatValue() : 0);
                        transportationEmission += transportation != null ? transportation : 0;
                        foodConsumptionEmission += food != null ? food : 0;
                        shoppingEmission += shopping != null ? shopping : 0;

                        String date = dateSnapshot.getKey();
                        if (totalDailyEmission != null) {
                            dailyEmissions.add(totalDailyEmission);
                            dailyEmissionsByDate.put(date, totalDailyEmission);
                            total_emission += totalDailyEmission; // Accumulate for yearly total
                        }

                        //energyUseEmission = shoppingEmission * 0.6f;
                        //shoppingEmission = shoppingEmission * 0.4f;

                    }

                    tvTotalEmissions.setText("Total Emissions: " + (int) (total_emission+0.5) + " kg CO2 this month");
                    updateChart("Daily");
                    setupPieChart();
                    //compareToGlobalOrNationalAverage("Canada", 12.5f);
                    compareToGlobalOrNationalAverage("Canada", total_emission);
                } else {
                    Log.e(TAG, "No data found in Firebase!");
                }
            }


            @Override
            public void onCancelled(DatabaseError error) {
                Log.e(TAG, "Failed to fetch data from Firebase: " + error.getMessage());
            }
        });
    }

    private void updateChart(String period) {
        tvSelectedPeriod.setText("Viewing emissions: " + period);

        List<Entry> entries = new ArrayList<>();
        List<String> xAxisLabels = new ArrayList<>(); // To store custom labels for X-Axis

        if (period.equals("Daily")) {
            // Populate daily data
            for (int i = 1; i <= dailyEmissions.size(); i++) {
                entries.add(new Entry(i, dailyEmissions.get(i - 1)));
                xAxisLabels.add("Day " + i); // Add labels for each day
            }
            setupPieChart();
        } else if (period.equals("Weekly")) {
            // Group emissions into weeks (assuming 7 days per week)
            float weeklySum = 0;
            int weekNumber = 1;
            for (int i = 0; i < dailyEmissions.size(); i++) {
                weeklySum += dailyEmissions.get(i);
                if ((i + 1) % 7 == 0 || i == dailyEmissions.size() - 1) {
                    entries.add(new Entry(weekNumber, weeklySum));
                    xAxisLabels.add("Week " + weekNumber); // Add labels for each week
                    weekNumber++;
                    weeklySum = 0;
                }
            }
            setupPieChart();
        } else if (period.equals("Monthly")) {
            // Calculate monthly emissions based on each month's data
            Map<String, Float> monthlyEmissions = new HashMap<>();
            for (Map.Entry<String, Float> entry : dailyEmissionsByDate.entrySet()) {
                String date = entry.getKey();
                float emission = entry.getValue();

                // Extract the month (e.g., "2024-11" from "2024-11-24")
                String month = date.substring(0, 7);
                monthlyEmissions.put(month, monthlyEmissions.getOrDefault(month, 0f) + emission);
            }

            int monthIndex = 1;
            for (Map.Entry<String, Float> entry : monthlyEmissions.entrySet()) {
                entries.add(new Entry(monthIndex, entry.getValue()));
                xAxisLabels.add(entry.getKey()); // Add month as label (e.g., "2024-11")
                monthIndex++;
            }
            setupPieChart();
        } else if (period.equals("Yearly")) {
            // For simplicity, aggregate all emissions into one yearly total
            float yearlyTotal = 0;
            for (float dailyEmission : dailyEmissions) {
                yearlyTotal += dailyEmission;
            }
            entries.add(new Entry(1, yearlyTotal));
            xAxisLabels.add("Year"); // Add a single label for the year
            setupPieChart();
        }

        // Update Line Chart
        LineDataSet dataSet = new LineDataSet(entries, "Carbon Footprint (kg CO2)");
        LineData lineData = new LineData(dataSet);
        lineChartTrend.setData(lineData);

        // Customize the X-Axis
        XAxis xAxis = lineChartTrend.getXAxis();
        xAxis.setGranularity(1f); // Ensure labels appear at regular intervals
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisLabels)); // Use custom labels
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // Move labels to the bottom

        // Disable default description
        lineChartTrend.getDescription().setEnabled(false);

        lineChartTrend.invalidate(); // Refresh the chart
    }


    private void setupPieChart() {
        /*
        Due to time constraints I couldn't update the pie chart for weekly and monthly yearly data
        since we don't have enough of data yet. This is a feature for future updates.
         */
        List<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(transportationEmission, "Transportation"));
        pieEntries.add(new PieEntry(foodConsumptionEmission, "Food Consumption"));
        pieEntries.add(new PieEntry(shoppingEmission, "Shopping"));

        PieDataSet pieDataSet = new PieDataSet(pieEntries, "");
        pieDataSet.setColors(new int[]{R.color.blue, R.color.red, R.color.green, R.color.yellow}, this);
        pieDataSet.setDrawValues(false);

        pieChartEmissions.setDrawEntryLabels(false);
        PieData pieData = new PieData(pieDataSet);
        pieChartEmissions.setData(pieData);
        pieChartEmissions.getDescription().setEnabled(false);
        pieChartEmissions.invalidate();
    }
}
