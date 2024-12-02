package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;



public class EcoTrackerActivity extends AppCompatActivity {

    // Define state variables
    private int currentMajorCase = -1; // -1 means uninitialized
    private int currentMinorCase = -1;
    private int currentSubCase = -1;
    private InputStorageManager inputStorageManager;
    private Spinner spinnerMainActivityType, spinnerActivityType, spinnerPublicTransportType, spinnerFlightType, spinnerMealType, spinnerProductType, spinnerBillType, spinnerElectronicType, spinnerOtherPurchaseType;
    private EditText etDistanceOrDuration, etNumberOfFlights, etNumberOfServings, etNumberOfProducts, etBillAmount;
    private LinearLayout layoutTransportation, layoutFoodConsumption, layoutShoppingConsumption;
    private Button btnStoreInput, btnCalculateEmission, btnDeleteInput;


    private LinearLayout habitsProgressContainer;

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

        btnStoreInput.setOnClickListener(v -> handleStoreInput());
        btnCalculateEmission.setOnClickListener(v -> navigateToEmissionPage());
        btnDeleteInput.setOnClickListener(v -> handleDeleteInput());





        // Add Save Progress button listener
        Button btnSaveProgress = findViewById(R.id.btnSaveProgress);
        btnSaveProgress.setOnClickListener(v -> {
            // Navigate to ProgressBarActivity
            Intent intent = new Intent(EcoTrackerActivity.this, ProgressBarActivity.class);
            startActivity(intent);
        });




    }

    private void initUIComponents() {
        inputStorageManager = new InputStorageManager();

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
        btnDeleteInput = findViewById(R.id.btnDeleteInput);
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

    private void handleStoreInput() {
        // Use currentMajorCase, currentMinorCase, and currentSubCase to determine the case
        if (currentMajorCase == 0) { // Transportation
            switch (currentMinorCase) {
                case 0: // Drive Personal Vehicle
                    String distanceDrivenStr = etDistanceOrDuration.getText().toString();
                    if (!distanceDrivenStr.isEmpty()) {
                        try {
                            double distanceDriven = Double.parseDouble(distanceDrivenStr);
                            boolean isStored = inputStorageManager.storeUserInput("transportation", "car", distanceDriven);
                            showStoreInputResult(isStored);
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Invalid input for distance. Please enter a valid number.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Please enter the distance driven.", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 1: // Public Transportation
                    switch (currentSubCase) {
                        case 0: // Bus
                            handlePublicTransportInput("public_transport/bus");
                            break;
                        case 1: // Train
                            handlePublicTransportInput("public_transport/train");
                            break;
                        case 2: // Subway
                            handlePublicTransportInput("public_transport/subway");
                            break;
                    }
                    break;
                case 2: // Cycling or Walking
                    String cyclingDistanceStr = etDistanceOrDuration.getText().toString();
                    if (!cyclingDistanceStr.isEmpty()) {
                        try {
                            double cyclingDistance = Double.parseDouble(cyclingDistanceStr);
                            boolean isStored = inputStorageManager.storeUserInput("transportation", "cycling_walking", cyclingDistance);
                            showStoreInputResult(isStored);
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Invalid input for cycling/walking distance. Please enter a valid number.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Please enter the distance covered by cycling or walking.", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 3: // Flight
                    String numberOfFlightsStr = etNumberOfFlights.getText().toString();
                    if (!numberOfFlightsStr.isEmpty()) {
                        try {
                            int numberOfFlights = Integer.parseInt(numberOfFlightsStr);
                            String flightType = (currentSubCase == 0) ? "short_haul_flight" : "long_haul_flight";
                            boolean isStored = inputStorageManager.storeUserInput("transportation", flightType, numberOfFlights);
                            showStoreInputResult(isStored);
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Invalid input for number of flights. Please enter a valid integer.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Please enter the number of flights.", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        } else if (currentMajorCase == 1) { // Food Consumption
            String numberOfServingsStr = etNumberOfServings.getText().toString();
            if (!numberOfServingsStr.isEmpty()) {
                try {
                    int numberOfServings = Integer.parseInt(numberOfServingsStr);
                    int mealTypePosition = spinnerMealType.getSelectedItemPosition();
                    String mealType = getMealType(mealTypePosition);
                    boolean isStored = inputStorageManager.storeUserInput("food_consumption", mealType, numberOfServings);
                    showStoreInputResult(isStored);
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Invalid input for number of servings. Please enter a valid integer.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please enter the number of servings.", Toast.LENGTH_SHORT).show();
            }
        } else if (currentMajorCase == 2) { // Shopping and Consumption
            switch (currentMinorCase) {
                case 0: // Buy New Clothes
                    String numberOfClothesStr = etNumberOfProducts.getText().toString();
                    if (!numberOfClothesStr.isEmpty()) {
                        try {
                            int numberOfClothes = Integer.parseInt(numberOfClothesStr);
                            boolean isStored = inputStorageManager.storeUserInput("shopping_consumption", "clothes", numberOfClothes);
                            showStoreInputResult(isStored);
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Invalid input for number of clothing items. Please enter a valid integer.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Please enter the number of clothing items.", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 1: // Buy Electronics
                    int electronicsTypePosition = spinnerElectronicType.getSelectedItemPosition();
                    String electronicDeviceType = getElectronicDeviceType(electronicsTypePosition);
                    String numberOfDevicesStr = etNumberOfProducts.getText().toString();
                    if (!numberOfDevicesStr.isEmpty()) {
                        try {
                            int numberOfDevices = Integer.parseInt(numberOfDevicesStr);
                            boolean isStored = inputStorageManager.storeUserInput("shopping_consumption/electronics", electronicDeviceType, numberOfDevices);
                            showStoreInputResult(isStored);
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Invalid input for number of electronic devices. Please enter a valid integer.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Please enter the number of electronic devices.", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 2: // Other Purchases
                    int otherPurchasePosition = spinnerOtherPurchaseType.getSelectedItemPosition();
                    String otherPurchaseType = getOtherPurchaseType(otherPurchasePosition);
                    String quantityStr = etNumberOfProducts.getText().toString();
                    if (!quantityStr.isEmpty()) {
                        try {
                            int quantity = Integer.parseInt(quantityStr);
                            boolean isStored = inputStorageManager.storeUserInput("shopping_consumption/other_purchases", otherPurchaseType, quantity);
                            showStoreInputResult(isStored);
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Invalid input for quantity. Please enter a valid integer.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Please enter the quantity.", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 3: // Energy Bills
                    int billTypePosition = spinnerBillType.getSelectedItemPosition();
                    String billType = getBillType(billTypePosition);
                    String billAmountStr = etBillAmount.getText().toString();
                    if (!billAmountStr.isEmpty()) {
                        try {
                            double billAmount = Double.parseDouble(billAmountStr);
                            boolean isStored = inputStorageManager.storeUserInput("shopping_consumption/energy_bills", billType, billAmount);
                            showStoreInputResult(isStored);
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Invalid input for bill amount. Please enter a valid number.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Please enter the bill amount.", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    }

    private void showStoreInputResult(boolean isStored) {
        if (!isStored) {
            Toast.makeText(this, "Input failed to store.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Input successfully stored.", Toast.LENGTH_SHORT).show();
        }
    }

    private void handlePublicTransportInput(String transportType) {
        String durationStr = etDistanceOrDuration.getText().toString();
        if (!durationStr.isEmpty()) {
            try {
                double duration = Double.parseDouble(durationStr);
                boolean isStored = inputStorageManager.storeUserInput("transportation", transportType, duration);
                showStoreInputResult(isStored);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid input for duration. Please enter a valid number.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please enter the time spent on " + transportType + ".", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleDeleteInput() {
        if (currentMajorCase == 0) { // Transportation
            switch (currentMinorCase) {
                case 0: // Drive Personal Vehicle
                    String distanceDrivenStr = etDistanceOrDuration.getText().toString();
                    if (!distanceDrivenStr.isEmpty()) {
                        try {
                            double distanceDriven = Double.parseDouble(distanceDrivenStr);
                            inputStorageManager.deleteUserInput(this, "transportation", "car", distanceDriven);
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Invalid input for distance. Please enter a valid number.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Please enter the distance driven.", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 1: // Public Transportation
                    switch (currentSubCase) {
                        case 0: // Bus
                            handlePublicTransportDelete("public_transport/bus");
                            break;
                        case 1: // Train
                            handlePublicTransportDelete("public_transport/train");
                            break;
                        case 2: // Subway
                            handlePublicTransportDelete("public_transport/subway");
                            break;
                    }
                    break;
                case 2: // Cycling or Walking
                    String cyclingDistanceStr = etDistanceOrDuration.getText().toString();
                    if (!cyclingDistanceStr.isEmpty()) {
                        try {
                            double cyclingDistance = Double.parseDouble(cyclingDistanceStr);
                            inputStorageManager.deleteUserInput(this, "transportation", "cycling_walking", cyclingDistance);
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Invalid input for cycling/walking distance. Please enter a valid number.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Please enter the distance covered by cycling or walking.", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 3: // Flight
                    String numberOfFlightsStr = etNumberOfFlights.getText().toString();
                    if (!numberOfFlightsStr.isEmpty()) {
                        try {
                            int numberOfFlights = Integer.parseInt(numberOfFlightsStr);
                            String flightType = (currentSubCase == 0) ? "short_haul_flight" : "long_haul_flight";
                            inputStorageManager.deleteUserInput(this, "transportation", flightType, numberOfFlights);
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Invalid input for number of flights. Please enter a valid integer.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Please enter the number of flights.", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        } else if (currentMajorCase == 1) { // Food Consumption
            String numberOfServingsStr = etNumberOfServings.getText().toString();
            if (!numberOfServingsStr.isEmpty()) {
                try {
                    int numberOfServings = Integer.parseInt(numberOfServingsStr);
                    int mealTypePosition = spinnerMealType.getSelectedItemPosition();
                    String mealType = getMealType(mealTypePosition);
                    inputStorageManager.deleteUserInput(this, "food_consumption", mealType, numberOfServings);
                } catch (NumberFormatException e) {
                    Toast.makeText(this, "Invalid input for number of servings. Please enter a valid integer.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Please enter the number of servings.", Toast.LENGTH_SHORT).show();
            }
        } else if (currentMajorCase == 2) { // Shopping and Consumption
            switch (currentMinorCase) {
                case 0: // Buy New Clothes
                    String numberOfClothesStr = etNumberOfProducts.getText().toString();
                    if (!numberOfClothesStr.isEmpty()) {
                        try {
                            int numberOfClothes = Integer.parseInt(numberOfClothesStr);
                            inputStorageManager.deleteUserInput(this, "shopping_consumption", "clothes", numberOfClothes);
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Invalid input for number of clothing items. Please enter a valid integer.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Please enter the number of clothing items.", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 1: // Buy Electronics
                    int electronicsTypePosition = spinnerElectronicType.getSelectedItemPosition();
                    String electronicDeviceType = getElectronicDeviceType(electronicsTypePosition);
                    String numberOfDevicesStr = etNumberOfProducts.getText().toString();
                    if (!numberOfDevicesStr.isEmpty()) {
                        try {
                            int numberOfDevices = Integer.parseInt(numberOfDevicesStr);
                            inputStorageManager.deleteUserInput(this, "shopping_consumption/electronics", electronicDeviceType, numberOfDevices);
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Invalid input for number of electronic devices. Please enter a valid integer.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Please enter the number of electronic devices.", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 2: // Other Purchases
                    int otherPurchasePosition = spinnerOtherPurchaseType.getSelectedItemPosition();
                    String otherPurchaseType = getOtherPurchaseType(otherPurchasePosition);
                    String quantityStr = etNumberOfProducts.getText().toString();
                    if (!quantityStr.isEmpty()) {
                        try {
                            int quantity = Integer.parseInt(quantityStr);
                            inputStorageManager.deleteUserInput(this, "shopping_consumption/other_purchases", otherPurchaseType, quantity);
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Invalid input for quantity. Please enter a valid integer.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Please enter the quantity.", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 3: // Energy Bills
                    int billTypePosition = spinnerBillType.getSelectedItemPosition();
                    String billType = getBillType(billTypePosition);
                    String billAmountStr = etBillAmount.getText().toString();
                    if (!billAmountStr.isEmpty()) {
                        try {
                            double billAmount = Double.parseDouble(billAmountStr);
                            inputStorageManager.deleteUserInput(this, "shopping_consumption/energy_bills", billType, billAmount);
                        } catch (NumberFormatException e) {
                            Toast.makeText(this, "Invalid input for bill amount. Please enter a valid number.", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Please enter the bill amount.", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    }

    private void handlePublicTransportDelete(String transportType) {
        String durationStr = etDistanceOrDuration.getText().toString();
        if (!durationStr.isEmpty()) {
            try {
                double duration = Double.parseDouble(durationStr);
                inputStorageManager.deleteUserInput(this, "transportation", transportType, duration);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid input for duration. Please enter a valid number.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please enter the time spent on " + transportType + " to delete.", Toast.LENGTH_SHORT).show();
        }
    }

    private void navigateToEmissionPage() {
        Intent intent = new Intent(EcoTrackerActivity.this, EmissionDisplayActivity.class);
        startActivity(intent);
    }

    // Helper methods to determine sub-activity types
    private String getMealType(int position) {
        switch (position) {
            case 0:
                return "beef";
            case 1:
                return "pork";
            case 2:
                return "chicken";
            case 3:
                return "fish";
            case 4:
                return "plant_based";
            default:
                return "";
        }
    }

    private String getElectronicDeviceType(int position) {
        switch (position) {
            case 0:
                return "smartphone";
            case 1:
                return "laptop";
            case 2:
                return "tv";
            default:
                return "";
        }
    }

    private String getOtherPurchaseType(int position) {
        switch (position) {
            case 0:
                return "furniture";
            case 1:
                return "appliances";
            default:
                return "";
        }
    }

    private String getBillType(int position) {
        switch (position) {
            case 0:
                return "electricity";
            case 1:
                return "gas";
            case 2:
                return "water";
            default:
                return "";
        }
    }















}