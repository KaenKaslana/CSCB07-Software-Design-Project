package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class EcoTrackerActivity extends AppCompatActivity {

    // Define state variables
    private int currentMajorCase = -1; // -1 means uninitialized
    private int currentMinorCase = -1;
    private int currentSubCase = -1;

    private Spinner spinnerMainActivityType, spinnerActivityType, spinnerPublicTransportType, spinnerFlightType, spinnerMealType, spinnerProductType, spinnerBillType, spinnerElectronicType, spinnerOtherPurchaseType;
    private EditText etDistanceOrDuration, etNumberOfFlights, etNumberOfServings, etNumberOfProducts, etBillAmount;
    private LinearLayout layoutTransportation, layoutFoodConsumption, layoutShoppingConsumption;
    private Button btnStoreInput, btnCalculateEmission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eco_tracker);

        // Initialize UI components
        initUIComponents();

        // Set up main activity type spinner
        setupSpinner(spinnerMainActivityType, R.array.main_activity_types);

        spinnerMainActivityType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentMajorCase = position; // Track the major case (0, 1, or 2)
                handleMainActivitySelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        btnStoreInput.setOnClickListener(v -> storeUserInput());
        btnCalculateEmission.setOnClickListener(v -> calculateEmission());
    }

    private void initUIComponents() {
        spinnerMainActivityType = findViewById(R.id.spinnerMainActivityType);
        spinnerActivityType = findViewById(R.id.spinnerActivityType);
        spinnerPublicTransportType = findViewById(R.id.spinnerPublicTransportType);
        spinnerFlightType = findViewById(R.id.spinnerFlightType);
        spinnerMealType = findViewById(R.id.spinnerMealType);
        spinnerProductType = findViewById(R.id.spinnerProductType);
        spinnerBillType = findViewById(R.id.spinnerBillType);
        spinnerElectronicType = findViewById(R.id.spinnerElectronicType);
        spinnerOtherPurchaseType = findViewById(R.id.spinnerOtherPurchaseType);

        etDistanceOrDuration = findViewById(R.id.etDistanceOrDuration);
        etNumberOfFlights = findViewById(R.id.etNumberOfFlights);
        etNumberOfServings = findViewById(R.id.etNumberOfServings);
        etNumberOfProducts = findViewById(R.id.etNumberOfProducts);
        etBillAmount = findViewById(R.id.etBillAmount);

        layoutTransportation = findViewById(R.id.layoutTransportation);
        layoutFoodConsumption = findViewById(R.id.layoutFoodConsumption);
        layoutShoppingConsumption = findViewById(R.id.layoutShoppingConsumption);

        btnStoreInput = findViewById(R.id.btnStoreInput);
        btnCalculateEmission = findViewById(R.id.btnCalculateEmission);
    }

    private void setupSpinner(Spinner spinner, int arrayResourceId) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                arrayResourceId, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private void handleMainActivitySelection(int position) {
        // Hide all sections initially
        layoutTransportation.setVisibility(View.GONE);
        layoutFoodConsumption.setVisibility(View.GONE);
        layoutShoppingConsumption.setVisibility(View.GONE);

        resetAllFields();

        switch (position) {
            case 0: // Transportation Activities
                layoutTransportation.setVisibility(View.VISIBLE);
                setupSpinner(spinnerActivityType, R.array.transportation_activity_types);
                spinnerActivityType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        currentMinorCase = position; // Track the specific transportation activity
                        updateTransportationUI(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // Do nothing
                    }
                });
                break;
            case 1: // Food Consumption Activities
                currentMinorCase = -1; // No sub-cases for food consumption, so set to -1
                layoutFoodConsumption.setVisibility(View.VISIBLE);
                setupSpinner(spinnerMealType, R.array.meal_types);
                etNumberOfServings.setVisibility(View.VISIBLE);
                break;
            case 2: // Shopping and Consumption Activities
                layoutShoppingConsumption.setVisibility(View.VISIBLE);
                setupSpinner(spinnerProductType, R.array.product_types);
                spinnerProductType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        currentMinorCase = position; // Track the specific shopping activity
                        updateShoppingConsumptionUI(position);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // Do nothing
                    }
                });
                break;
        }
    }

    private void updateTransportationUI(int position) {
        // Hide all transportation fields initially
        resetTransportationFields();

        switch (position) {
            case 0: // Drive Personal Vehicle
                etDistanceOrDuration.setHint("Enter Distance Driven (km)");
                etDistanceOrDuration.setVisibility(View.VISIBLE);
                break;
            case 1: // Take Public Transportation
                setupSpinner(spinnerPublicTransportType, R.array.public_transport_types);
                spinnerPublicTransportType.setVisibility(View.VISIBLE);
                etDistanceOrDuration.setHint("Enter Time Spent on Public Transport (hours)");
                etDistanceOrDuration.setVisibility(View.VISIBLE);
                spinnerPublicTransportType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        currentSubCase = position; // Track the type of public transportation
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // Do nothing
                    }
                });
                break;
            case 2: // Cycling or Walking
                etDistanceOrDuration.setHint("Enter Distance Walked or Cycled (km)");
                etDistanceOrDuration.setVisibility(View.VISIBLE);
                break;
            case 3: // Flight (Short-Haul or Long-Haul)
                setupSpinner(spinnerFlightType, R.array.flight_types_detailed);
                spinnerFlightType.setVisibility(View.VISIBLE);
                etNumberOfFlights.setVisibility(View.VISIBLE);
                spinnerFlightType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        currentSubCase = position; // Track the type of flight (short-haul or long-haul)
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // Do nothing
                    }
                });
                break;
        }
    }
    private void updateShoppingConsumptionUI(int position) {
        // Hide all shopping fields initially
        resetShoppingFields();

        switch (position) {
            case 0: // Buy New Clothes
                etNumberOfProducts.setHint("Enter Number of Clothing Items");
                etNumberOfProducts.setVisibility(View.VISIBLE);
                break;
            case 1: // Buy Electronics
                setupSpinner(spinnerElectronicType, R.array.electronic_device_types);
                spinnerElectronicType.setVisibility(View.VISIBLE);
                etNumberOfProducts.setHint("Enter Number of Devices");
                etNumberOfProducts.setVisibility(View.VISIBLE);
                spinnerElectronicType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        currentSubCase = position; // Track the type of electronic device
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // Do nothing
                    }
                });
                break;
            case 2: // Other Purchases
                setupSpinner(spinnerOtherPurchaseType, R.array.other_purchase_types);
                spinnerOtherPurchaseType.setVisibility(View.VISIBLE);
                etNumberOfProducts.setHint("Enter Quantity");
                etNumberOfProducts.setVisibility(View.VISIBLE);
                spinnerOtherPurchaseType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        currentSubCase = position; // Track the type of other purchase
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // Do nothing
                    }
                });
                break;
            case 3: // Energy Bills
                setupSpinner(spinnerBillType, R.array.bill_types);
                spinnerBillType.setVisibility(View.VISIBLE);
                etBillAmount.setVisibility(View.VISIBLE);
                spinnerBillType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        currentSubCase = position; // Track the type of bill
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // Do nothing
                    }
                });
                break;
        }
    }

    private void resetAllFields() {
        resetTransportationFields();
        resetFoodConsumptionFields();
        resetShoppingFields();
    }

    private void resetTransportationFields() {
        etDistanceOrDuration.setVisibility(View.GONE);
        spinnerPublicTransportType.setVisibility(View.GONE);
        spinnerFlightType.setVisibility(View.GONE);
        etNumberOfFlights.setVisibility(View.GONE);
    }

    private void resetFoodConsumptionFields() {
        etNumberOfServings.setVisibility(View.GONE);
    }

    private void resetShoppingFields() {
        etNumberOfProducts.setVisibility(View.GONE);
        spinnerBillType.setVisibility(View.GONE);
        spinnerElectronicType.setVisibility(View.GONE);
        spinnerOtherPurchaseType.setVisibility(View.GONE);
        etBillAmount.setVisibility(View.GONE);
    }

    private void storeUserInput() {
        // Use currentMajorCase, currentMinorCase, and currentSubCase to determine the case
        if (currentMajorCase == 0) { // Transportation
            switch (currentMinorCase) {
                case 0: // Drive Personal Vehicle
                    // Store data related to driving
                    break;
                case 1: // Public Transportation
                    switch (currentSubCase) {
                        case 0: // Bus
                            // Store data related to bus usage
                            break;
                        case 1: // Train
                            // Store data related to train usage
                            break;
                        case 2: // Subway
                            // Store data related to subway usage
                            break;
                    }
                    break;
                case 2: // Cycling or Walking
                    // Store data related to cycling or walking
                    break;
                case 3: // Flight
                    switch (currentSubCase) {
                        case 0: // Short-Haul Flight
                            // Store data related to short-haul flights
                            break;
                        case 1: // Long-Haul Flight
                            // Store data related to long-haul flights
                            break;
                    }
                    break;
            }
        } else if (currentMajorCase == 1) { // Food Consumption
            // Store data related to food consumption
        } else if (currentMajorCase == 2) { // Shopping and Consumption
            switch (currentMinorCase) {
                case 0: // Buy New Clothes
                    // Store data related to buying clothes
                    break;
                case 1: // Buy Electronics
                    switch (currentSubCase) {
                        case 0: // Smartphone
                            // Store data related to buying a smartphone
                            break;
                        case 1: // Laptop
                            // Store data related to buying a laptop
                            break;
                        case 2: // TV
                            // Store data related to buying a TV
                            break;
                    }
                    break;
                case 2: // Other Purchases
                    switch (currentSubCase) {
                        case 0: // Furniture
                            // Store data related to buying furniture
                            break;
                        case 1: // Appliances
                            // Store data related to buying appliances
                            break;
                    }
                    break;
                case 3: // Energy Bills
                    switch (currentSubCase) {
                        case 0: // Electricity
                            // Store data related to electricity bill
                            break;
                        case 1: // Gas
                            // Store data related to gas bill
                            break;
                        case 2: // Water
                            // Store data related to water bill
                            break;
                    }
                    break;
            }
        }
    }

    private void calculateEmission() {
        // Use currentMajorCase, currentMinorCase, and currentSubCase to determine which emission calculation to use
    }
}
