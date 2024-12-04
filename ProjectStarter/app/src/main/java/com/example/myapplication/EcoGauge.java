package com.example.myapplication;

import android.content.res.AssetManager;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    private String userCountry;

    // Firebase references
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    // Emissions data
    private List<Float> dailyEmissions = new ArrayList<>();
    private List<Float> dailyEmissionsTransportation = new ArrayList<>();
    private List<Float> dailyEmissionsFood = new ArrayList<>();
    private List<Float> dailyEmissionsShopping = new ArrayList<>();
    private Map<String, Float> dailyEmissionsByDate = new HashMap<>();
    private Map<String, Float> dailyEmissionsTransportationByDate = new HashMap<>();
    private Map<String, Float> dailyEmissionsFoodByDate = new HashMap<>();
    private Map<String, Float> dailyEmissionsShoppingByDate = new HashMap<>();
    private Map<String, Float> globalAverages = new HashMap<>();
    private float total_emission;

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

    private void fetchDataFromFirebase() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Log.d(TAG, "Data fetched: " + snapshot.getValue());
                if (snapshot.exists()) {
                    userCountry = "Canada";
                    dailyEmissions.clear();
                    dailyEmissionsByDate.clear();
                    total_emission = 0;
                    float transportationEmission, foodConsumptionEmission, shoppingEmission;

                    for (DataSnapshot dateSnapshot : snapshot.getChildren()) {
                        Float totalDailyEmission = dateSnapshot.child("Total_Daily_Emission").getValue(Float.class);
                        Float transportation = dateSnapshot.child("Transportation_Emission").getValue(Float.class);
                        Float food = dateSnapshot.child("Food_Emission").getValue(Float.class);
                        Float shopping = dateSnapshot.child("Consumption_Shopping_Emission").getValue(Float.class);

                        // Handle null values gracefully
                        transportationEmission = transportation != null ? transportation : 0;
                        foodConsumptionEmission = food != null ? food : 0;
                        shoppingEmission = shopping != null ? shopping : 0;

                        String date = dateSnapshot.getKey();
                        if (totalDailyEmission != null) {
                            total_emission += totalDailyEmission;

                            dailyEmissions.add(totalDailyEmission);
                            dailyEmissionsTransportation.add(transportationEmission);
                            dailyEmissionsFood.add(foodConsumptionEmission);
                            dailyEmissionsShopping.add(shoppingEmission);

                            dailyEmissionsByDate.put(date, totalDailyEmission);
                            dailyEmissionsTransportationByDate.put(date, transportationEmission);
                            dailyEmissionsFoodByDate.put(date, foodConsumptionEmission);
                            dailyEmissionsShoppingByDate.put(date, shoppingEmission);
                        }

                    }

                    updateChart("Daily");
                    compareToGlobalOrNationalAverage(total_emission / Math.max(dailyEmissions.size(), 1));
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

        // Update the total emissions display
        setupTotalEmissions(period);

        // Update Pie Chart
        setupPieChart(period);

        // Update Line Chart
        setupLineChart(period);
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

    private void setupLineChart(String period) {
        List<Entry> entries = new ArrayList<>();
        List<String> xAxisLabels = new ArrayList<>();

        if (period.equals("Daily")) {
            for (int i = 0; i < dailyEmissions.size(); i++) {
                entries.add(new Entry(i + 1, dailyEmissions.get(i))); // Day index starts from 1
                xAxisLabels.add("Day " + (i + 1));
            }
        } else if (period.equals("Weekly")) {
            int weekNumber = 1;
            float weeklySum = 0;
            for (int i = 0; i < dailyEmissions.size(); i++) {
                weeklySum += dailyEmissions.get(i);
                if ((i + 1) % 7 == 0 || i == dailyEmissions.size() - 1) {
                    entries.add(new Entry(weekNumber, weeklySum));
                    xAxisLabels.add("Week " + weekNumber);
                    weekNumber++;
                    weeklySum = 0;
                }
            }
        } else if (period.equals("Monthly")) {
            Map<String, Float> monthlyEmissions = new HashMap<>();
            for (Map.Entry<String, Float> entry : dailyEmissionsByDate.entrySet()) {
                String date = entry.getKey(); // Format YYYY-MM-DD
                String month = date.substring(0, 7); // Extract YYYY-MM for the month
                monthlyEmissions.put(month, monthlyEmissions.getOrDefault(month, 0f) + entry.getValue());
            }

            int monthIndex = 1;
            for (Map.Entry<String, Float> entry : monthlyEmissions.entrySet()) {
                entries.add(new Entry(monthIndex, entry.getValue()));
                xAxisLabels.add(entry.getKey()); // Use YYYY-MM as label
                monthIndex++;
            }
        }

        // Update Line Chart
        LineDataSet dataSet = new LineDataSet(entries, "Carbon Footprint (kg CO2)");
        dataSet.setLineWidth(2f);
        LineData lineData = new LineData(dataSet);
        lineChartTrend.setData(lineData);

        // Customize the X-Axis
        XAxis xAxis = lineChartTrend.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisLabels)); // Use custom labels
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        // Disable default description
        lineChartTrend.getDescription().setEnabled(false);

        lineChartTrend.invalidate(); // Refresh the chart
    }



    private void setupTotalEmissions(String period){
        float totalEmissions = 0, cnt = 0;
        switch(period) {
            case "Daily":
                for (int i = Math.max(0, dailyEmissions.size() - 1); i < dailyEmissions.size(); ++i){
                    totalEmissions += dailyEmissions.get(i);
                }
                tvTotalEmissions.setText("Total Emissions: " + (int)(totalEmissions + 0.5f) + " kg CO2 today.");
                break;
            case "Weekly":
                cnt = 0;
                for (int i = Math.max(0, dailyEmissions.size() - 7); i < dailyEmissions.size(); ++i){
                    totalEmissions += dailyEmissions.get(i);
                    ++cnt;
                }

                totalEmissions *= 7f / cnt; // fill in the empty days with weekly average
                tvTotalEmissions.setText("Total Emissions: " + (int)(totalEmissions + 0.5f) + " kg CO2 this week.");
                break;
            case "Monthly":
                cnt = 0;
                for (int i = Math.max(0, dailyEmissions.size() - 30); i < dailyEmissions.size(); ++i){
                    totalEmissions += dailyEmissions.get(i);
                    ++cnt;
                }

                totalEmissions *= 30f / cnt; // fill in the empty days with monthly average
                tvTotalEmissions.setText("Total Emissions: " + (int)(totalEmissions + 0.5f) + " kg CO2 this month.");
                break;
        }
    }

    private void setupPieChart(String period) {
        List<PieEntry> pieEntries = new ArrayList<>();
        float transportationEmission = 0, foodConsumptionEmission = 0, shoppingEmission = 0;

        if (period.equals("Daily")) {
            for (int i = Math.max(0, dailyEmissions.size() - 1); i < dailyEmissions.size(); ++i){
                transportationEmission += dailyEmissionsTransportation.get(i);
                foodConsumptionEmission += dailyEmissionsFood.get(i);
                shoppingEmission += dailyEmissionsShopping.get(i);
            }
        } else if (period.equals("Weekly")) {
            for (int i = Math.max(0, dailyEmissions.size() - 7); i < dailyEmissions.size(); ++i){
                transportationEmission += dailyEmissionsTransportation.get(i);
                foodConsumptionEmission += dailyEmissionsFood.get(i);
                shoppingEmission += dailyEmissionsShopping.get(i);
            }
        } else if (period.equals("Monthly")) {
            for (int i = Math.max(0, dailyEmissions.size() - 30); i < dailyEmissions.size(); ++i){
                transportationEmission += dailyEmissionsTransportation.get(i);
                foodConsumptionEmission += dailyEmissionsFood.get(i);
                shoppingEmission += dailyEmissionsShopping.get(i);
            }
        }

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

    private void initializeGlobalAverages() {
        globalAverages.clear();
        // Load data from Global_Averages.txt file in assets
        try {
            globalAverages.putAll(loadGlobalAveragesFromAssets());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Utility method to load data from assets
    private HashMap<String, Float> loadGlobalAveragesFromAssets() throws IOException {
        HashMap<String, Float> countryEmissions = new HashMap<>();
        AssetManager assetManager = getAssets();
        String fileName = "Global_Averages.txt";

        try (InputStream is = assetManager.open(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    String country = parts[0].trim();
                    float emissions = Float.parseFloat(parts[1].trim());
                    countryEmissions.put(country, emissions);
                }
            }
        }
        return countryEmissions;
    }

    private void compareToGlobalOrNationalAverage(float userEmission) {
        Float countryAverage = globalAverages.get(userCountry) * 1000f / 365f;
        Float globalAverage = globalAverages.get("World") * 1000f / 365f;


        if (countryAverage == null && globalAverage == null) {
            tvGlobalComparison.setText("Could not compare to global or national averages.");
            return;
        }

        if (countryAverage == null) {
            countryAverage = globalAverage; // Default to global if no national average
        }

        float percentageOfCountry = (userEmission / (countryAverage * 1000 / 365)) * 100;
        float percentageOfGlobal = (userEmission / (globalAverage * 1000 / 365)) * 100;

        tvGlobalComparison.setText(String.format(
                "Your emissions are %.2f%% of the average for %s.\n" +
                        "Globally, they are %.2f%% of the world average.",
                percentageOfCountry, userCountry != null ? userCountry : "the World", percentageOfGlobal
        ));
    }
}
