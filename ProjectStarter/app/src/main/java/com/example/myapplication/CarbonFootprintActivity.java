package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CarbonFootprintActivity extends AppCompatActivity {

    private Button calculateButton;
    private DatabaseReference databaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carbon_footprint);

        // Initialize Firebase
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String userId = auth.getCurrentUser().getUid();
        databaseRef = FirebaseDatabase.getInstance().getReference("Users").child(userId);

        // Initialize the button
        calculateButton = findViewById(R.id.calculateButton);

        // Set up the click listener for the button
        calculateButton.setOnClickListener(v -> calculateAndStoreCarbonFootprint());
    }

    private void calculateAndStoreCarbonFootprint() {
        // Retrieve data from the Firebase database
        databaseRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful() && task.getResult() != null) {
                DataSnapshot snapshot = task.getResult();

                // Mutable holder for total emission
                final double[] totalEmission = {0.0};

                // Retrieve user answers
                String airTravelShort = getAnswer(snapshot, "Atq1");
                String airTravelLong = getAnswer(snapshot, "Atq2");
                String carType = getAnswer(snapshot, "Carq1");
                String distance = getAnswer(snapshot, "Carq2");
                String publicTransport = getAnswer(snapshot, "Ptq1");
                String timeSpent = getAnswer(snapshot, "Ptq2");
                String dietType = getAnswer(snapshot, "Foodq1");
                String beefFreq = getAnswer(snapshot, "Meatq1");
                String porkFreq = getAnswer(snapshot, "Meatq2");
                String chickenFreq = getAnswer(snapshot, "Meatq3");
                String fishFreq = getAnswer(snapshot, "Meatq4");
                String waste = getAnswer(snapshot, "Wasteq");
                String homeType = getAnswer(snapshot, "Houseq1");
                int occupants = Integer.parseInt(getAnswer(snapshot, "Houseq2"));
                String homeSize = getAnswer(snapshot, "Houseq3");
                String heatingType = getAnswer(snapshot, "Houseq4");
                String electricityBill = getAnswer(snapshot, "Houseq5");
                String clothing = getAnswer(snapshot, "Consq1");
                String secondHand = getAnswer(snapshot, "Consq2");
                String electronics = getAnswer(snapshot, "Consq3");
                String recycling = getAnswer(snapshot, "Consq4");

                // Calculate the total carbon footprint
                totalEmission[0] += calculateTransportation(airTravelShort, airTravelLong, carType, distance, publicTransport,timeSpent);
                totalEmission[0] += calculateFood(dietType, beefFreq, porkFreq, chickenFreq, fishFreq, waste);
                double housingEmission = calculateHousing(homeType, homeSize, electricityBill, heatingType, occupants);
                totalEmission[0] += calculateConsumption(clothing, secondHand, electronics, recycling);

                // Store the calculated footprint in Firebase
                databaseRef.child("CarbonFootprint").setValue(totalEmission[0])
                        .addOnSuccessListener(aVoid -> {
                            Toast.makeText(this, "Carbon footprint calculated and stored: " + totalEmission[0] + " kg CO2e", Toast.LENGTH_LONG).show();
                        })
                        .addOnFailureListener(e -> {
                            Toast.makeText(this, "Failed to store carbon footprint.", Toast.LENGTH_SHORT).show();
                        });
            } else {
                Toast.makeText(this, "Failed to retrieve user data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getAnswer(DataSnapshot snapshot, String key) {
        String value = snapshot.child(key).getValue(String.class);
        return value != null ? value : "No answer";
    }

    private double calculateTransportation(String airTravelShort, String airTravelLong, String carType, String distance, String publicTransport, String timeSpent) {
        double emission = 0.0;

        // Air travel
        if ("1-2".equals(airTravelShort)) {
            emission += 225;
        }
        else if ("3-5".equals(airTravelShort)) {
            emission += 600;
        }
        else if ("6-10".equals(airTravelShort)) {
            emission += 1200;
        }
        else if ("More than 10".equals(airTravelShort)) {
            emission += 1800;
        }

        if ("1-2".equals(airTravelLong)) {
            emission += 825;
        }
        else if ("3-5".equals(airTravelLong)) {
            emission += 2200;
        }
        else if ("6-10".equals(airTravelLong)) {
            emission += 4400;
        }
        else if ("More than 10".equals(airTravelLong)) {
            emission += 6600;
        }

        // Car use
        double distanceValue = 0.0;
        if ("0-5k".equals(distance)) {
            distanceValue = 5000;
        }
        else if ("5k-10k".equals(distance)) {
            distanceValue = 10000;
        }
        else if ("10k-15k".equals(distance)) {
            distanceValue = 15000;
        }
        else if ("15k-20k".equals(distance)) {
            distanceValue = 20000;
        }
        else if ("20k-25k".equals(distance)) {
            distanceValue = 25000;
        }
        else if ("More than 25k".equals(distance)) {
            distanceValue = 35000;
        }

        if ("Gasoline".equals(carType)) {
            emission += distanceValue * 0.24;
        }
        else if ("Diesel".equals(carType)) {
            emission += distanceValue * 0.27;
        }
        else if ("Hybrid".equals(carType)) {
            emission += distanceValue * 0.16;
        }
        else if ("Electric".equals(carType)) {
            emission += distanceValue * 0.05;
        }

        // Public transport
        emission += calculatePublicTransport(publicTransport, timeSpent);

        return emission;
    }

    private double calculatePublicTransport(String frequency, String timeSpent) {
        double emission = 0.0;

        if ("Never".equals(frequency)) {
            emission = 0;
        }
        else if ("Occasionally".equals(frequency)) {
            if ("Under 1 hour".equals(timeSpent)) emission = 246;
            else if ("1-3 hours".equals(timeSpent)) emission = 819;
            else if ("3-5 hours".equals(timeSpent)) emission = 1638;
            else if ("5-10 hours".equals(timeSpent)) emission = 3071;
            else if ("More than 10 hours".equals(timeSpent)) emission = 4095;
        }
        else if ("Frequently".equals(frequency)) {
            if ("Under 1 hour".equals(timeSpent)) emission = 573;
            else if ("1-3 hours".equals(timeSpent)) emission = 1911;
            else if ("3-5 hours".equals(timeSpent)) emission = 3822;
            else if ("5-10 hours".equals(timeSpent)) emission = 7166;
            else if ("More than 10 hours".equals(timeSpent)) emission = 9555;
        }
        else if ("Always".equals(frequency)) {
            if ("Under 1 hour".equals(timeSpent)) emission = 573;
            else if ("1-3 hours".equals(timeSpent)) emission = 1911;
            else if ("3-5 hours".equals(timeSpent)) emission = 3822;
            else if ("5-10 hours".equals(timeSpent)) emission = 7166;
            else if ("More than 10 hours".equals(timeSpent)) emission = 9555;
        }

        return emission;
    }

    private double calculateFood(String dietType, String beefFreq, String porkFreq, String chickenFreq, String fishFreq, String waste) {
        double emission = 0.0;

        if ("Vegetarian".equals(dietType)) emission += 1000;
        else if ("Vegan".equals(dietType)) emission += 500;
        else if ("Pescatarian".equals(dietType)) emission += 1500;
        else if ("Meat-based".equals(dietType)) {
            // Beef consumption
            if ("Daily".equals(beefFreq)) emission += 2500;
            else if ("Frequently".equals(beefFreq)) emission += 1900;
            else if ("Occasionally".equals(beefFreq)) emission += 1300;
            else if ("Never".equals(beefFreq)) emission += 0;

            // Pork consumption
            if ("Daily".equals(porkFreq)) emission += 1450;
            else if ("Frequently".equals(porkFreq)) emission += 860;
            else if ("Occasionally".equals(porkFreq)) emission += 450;
            else if ("Never".equals(porkFreq)) emission += 0;

            // Chicken consumption
            if ("Daily".equals(chickenFreq)) emission += 950;
            else if ("Frequently".equals(chickenFreq)) emission += 600;
            else if ("Occasionally".equals(chickenFreq)) emission += 200;
            else if ("Never".equals(chickenFreq)) emission += 0;

            // Fish consumption
            if ("Daily".equals(fishFreq)) emission += 800;
            else if ("Frequently".equals(fishFreq)) emission += 500;
            else if ("Occasionally".equals(fishFreq)) emission += 150;
            else if ("Never".equals(fishFreq)) emission += 0;
        }

        // Food waste
        if ("Frequently".equals(waste)) emission += 140.4;
        else if ("Occasionally".equals(waste)) emission += 70.2;
        else if ("Rarely".equals(waste)) emission += 23.4;
        else if ("Never".equals(waste)) emission += 0;

        return emission;
    }

    private double calculateHousing(String homeType, String homeSize, String electricityBill, String heatingType, int occupants) {
        double emission = 0.0;

        if ("Detached house".equals(homeType)) {
            emission = getDetachedEmissions(homeSize, electricityBill, heatingType, occupants);
        } else if ("Semi-detached house".equals(homeType)) {
            emission = getSemiDetachedEmissions(homeSize, electricityBill, heatingType, occupants);
        } else if ("Townhouse".equals(homeType)) {
            emission = getTownhouseEmissions(homeSize, electricityBill, heatingType, occupants);
        } else if ("Condo/Apartment".equals(homeType)) {
            emission = getApartmentEmissions(homeSize, electricityBill, heatingType, occupants);
        }

        return emission;
    }


    private double getDetachedEmissions(String homeSize, String electricityBill, String heatingType, int occupants) {
        if ("Under 1000 sq. ft.".equals(homeSize)) {
            return getDetachedUnder1000Emissions(electricityBill, heatingType, occupants);
        } else if ("1000-2000 sq. ft.".equals(homeSize)) {
            return getDetached1000To2000Emissions(electricityBill, heatingType, occupants);
        } else if ("Over 2000 sq. ft.".equals(homeSize)) {
            return getDetachedOver2000Emissions(electricityBill, heatingType, occupants);
        }
        return 0.0;
    }

    private double getDetachedUnder1000Emissions(String electricityBill, String heatingType, int occupants) {
        if ("Under $50".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 200, 216, 243, 272);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 300, 380, 500, 550);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 2400, 2500, 2600, 2700);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 2100, 2500, 2500);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 2000, 2100, 2300);
        } else if ("$50-$100".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 2800, 2900, 3250, 3800);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 450, 520, 580, 675);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5000, 5200, 5400, 5600);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 3700, 3900, 4000, 4200);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3200, 3500, 3800, 4000);
        } else if ("$100-$150".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 3500, 3600, 4000, 4500);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 600, 700, 800, 900);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5400, 5500, 5700, 5900);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 4000, 4300, 4600, 5000);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3800, 4100, 4400, 4700);
        } else if ("$150-$200".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 4000, 4200, 4600, 5000);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 800, 900, 1000, 1100);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5800, 6000, 6200, 6400);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5100, 5400);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 4200, 4500, 4800, 5100);
        } else if ("Over $200".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5200, 5600);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 1000, 1200, 1400, 1600);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 6000, 6200, 6400, 6600);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 5000, 5300, 5600, 5900);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5100, 5400);
        }

        return 0.0;
    }


    private double getDetached1000To2000Emissions(String electricityBill, String heatingType, int occupants) {
        if ("Under $50".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 200, 216, 243, 272);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 300, 380, 500, 550);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 2400, 2500, 2600, 2700);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 2100, 2500, 2500);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 2000, 2100, 2300);
        } else if ("$50-$100".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 2800, 2900, 3250, 3800);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 450, 520, 580, 675);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5000, 5200, 5400, 5600);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 3700, 3900, 4000, 4200);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3200, 3500, 3800, 4000);
        } else if ("$100-$150".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 3500, 3600, 4000, 4500);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 600, 700, 800, 900);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5400, 5500, 5700, 5900);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 4000, 4300, 4600, 5000);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3800, 4100, 4400, 4700);
        } else if ("$150-$200".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 4000, 4200, 4600, 5000);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 800, 900, 1000, 1100);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5800, 6000, 6200, 6400);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5100, 5400);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 4200, 4500, 4800, 5100);
        } else if ("Over $200".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5200, 5600);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 1000, 1200, 1400, 1600);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 6000, 6200, 6400, 6600);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 5000, 5300, 5600, 5900);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5100, 5400);
        }
        return 0.0;
    }

    private double getDetachedOver2000Emissions(String electricityBill, String heatingType, int occupants) {
        if ("Under $50".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 200, 216, 243, 272);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 300, 380, 500, 550);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 2400, 2500, 2600, 2700);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 2100, 2500, 2500);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 2000, 2100, 2300);
        } else if ("$50-$100".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 2800, 2900, 3250, 3800);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 450, 520, 580, 675);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5000, 5200, 5400, 5600);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 3700, 3900, 4000, 4200);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3200, 3500, 3800, 4000);
        } else if ("$100-$150".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 3500, 3600, 4000, 4500);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 600, 700, 800, 900);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5400, 5500, 5700, 5900);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 4000, 4300, 4600, 5000);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3800, 4100, 4400, 4700);
        } else if ("$150-$200".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 4000, 4200, 4600, 5000);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 800, 900, 1000, 1100);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5800, 6000, 6200, 6400);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5100, 5400);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 4200, 4500, 4800, 5100);
        } else if ("Over $200".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5200, 5600);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 1000, 1200, 1400, 1600);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 6000, 6200, 6400, 6600);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 5000, 5300, 5600, 5900);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5100, 5400);
        }
        return 0.0;
    }

    private double getSemiDetachedEmissions(String homeSize, String electricityBill, String heatingType, int occupants) {
        if ("Under 1000 sq. ft.".equals(homeSize)) {
            return getSemiDetachedUnder1000Emissions(electricityBill, heatingType, occupants);
        } else if ("1000-2000 sq. ft.".equals(homeSize)) {
            return getSemiDetached1000To2000Emissions(electricityBill, heatingType, occupants);
        } else if ("Over 2000 sq. ft.".equals(homeSize)) {
            return getSemiDetachedOver2000Emissions(electricityBill, heatingType, occupants);
        }
        return 0.0;
    }

    private double getSemiDetachedUnder1000Emissions(String electricityBill, String heatingType, int occupants) {
        if ("Under $50".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 200, 216, 243, 272);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 300, 380, 500, 550);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 2400, 2500, 2600, 2700);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 2100, 2500, 2500);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 2000, 2100, 2300);
        } else if ("$50-$100".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 2800, 2900, 3250, 3800);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 450, 520, 580, 675);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5000, 5200, 5400, 5600);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 3700, 3900, 4000, 4200);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3200, 3500, 3800, 4000);
        } else if ("$100-$150".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 3500, 3600, 4000, 4500);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 600, 700, 800, 900);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5400, 5500, 5700, 5900);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 4000, 4300, 4600, 5000);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3800, 4100, 4400, 4700);
        } else if ("$150-$200".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 4000, 4200, 4600, 5000);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 800, 900, 1000, 1100);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5800, 6000, 6200, 6400);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5100, 5400);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 4200, 4500, 4800, 5100);
        } else if ("Over $200".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5200, 5600);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 1000, 1200, 1400, 1600);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 6000, 6200, 6400, 6600);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 5000, 5300, 5600, 5900);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5100, 5400);
        }
        return 0.0;
    }

    private double getSemiDetached1000To2000Emissions(String electricityBill, String heatingType, int occupants) {
        if ("Under $50".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 200, 216, 243, 272);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 300, 380, 500, 550);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 2400, 2500, 2600, 2700);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 2100, 2500, 2500);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 2000, 2100, 2300);
        } else if ("$50-$100".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 2800, 2900, 3250, 3800);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 450, 520, 580, 675);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5000, 5200, 5400, 5600);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 3700, 3900, 4000, 4200);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3200, 3500, 3800, 4000);
        } else if ("$100-$150".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 3500, 3600, 4000, 4500);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 600, 700, 800, 900);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5400, 5500, 5700, 5900);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 4000, 4300, 4600, 5000);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3800, 4100, 4400, 4700);
        } else if ("$150-$200".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 4000, 4200, 4600, 5000);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 800, 900, 1000, 1100);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5800, 6000, 6200, 6400);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5100, 5400);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 4200, 4500, 4800, 5100);
        } else if ("Over $200".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5200, 5600);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 1000, 1200, 1400, 1600);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 6000, 6200, 6400, 6600);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 5000, 5300, 5600, 5900);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5100, 5400);
        }
        return 0.0;
    }

    private double getSemiDetachedOver2000Emissions(String electricityBill, String heatingType, int occupants) {
        if ("Under $50".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 200, 216, 243, 272);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 300, 380, 500, 550);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 2400, 2500, 2600, 2700);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 2100, 2500, 2500);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 2000, 2100, 2300);
        } else if ("$50-$100".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 2800, 2900, 3250, 3800);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 450, 520, 580, 675);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5000, 5200, 5400, 5600);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 3700, 3900, 4000, 4200);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3200, 3500, 3800, 4000);
        } else if ("$100-$150".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 3500, 3600, 4000, 4500);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 600, 700, 800, 900);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5400, 5500, 5700, 5900);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 4000, 4300, 4600, 5000);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3800, 4100, 4400, 4700);
        } else if ("$150-$200".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 4000, 4200, 4600, 5000);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 800, 900, 1000, 1100);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5800, 6000, 6200, 6400);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5100, 5400);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 4200, 4500, 4800, 5100);
        } else if ("Over $200".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5200, 5600);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 1000, 1200, 1400, 1600);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 6000, 6200, 6400, 6600);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 5000, 5300, 5600, 5900);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5100, 5400);
        }
        return 0.0;
    }


    private double getTownhouseEmissions(String homeSize, String electricityBill, String heatingType, int occupants) {
        if ("Under 1000 sq. ft.".equals(homeSize)) {
            return getTownhouseUnder1000Emissions(electricityBill, heatingType, occupants);
        } else if ("1000-2000 sq. ft.".equals(homeSize)) {
            return getTownhouse1000To2000Emissions(electricityBill, heatingType, occupants);
        } else if ("Over 2000 sq. ft.".equals(homeSize)) {
            return getTownhouseOver2000Emissions(electricityBill, heatingType, occupants);
        }
        return 0.0;
    }

    private double getTownhouseUnder1000Emissions(String electricityBill, String heatingType, int occupants) {
        if ("Under $50".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 1971, 2160, 2500, 2800);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 300, 400, 500, 600);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 2400, 2600, 2800, 3000);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 1800, 2000, 2200);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 2000, 2100, 2300);
        } else if ("$50-$100".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 2800, 3000, 3200, 3400);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 450, 520, 580, 675);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5000, 5200, 5400, 5600);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 3700, 3900, 4000, 4200);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3200, 3500, 3800, 4000);
        } else if ("$100-$150".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 3500, 3600, 4000, 4500);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 600, 700, 800, 900);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5400, 5500, 5700, 5900);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 4000, 4300, 4600, 5000);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3800, 4100, 4400, 4700);
        } else if ("$150-$200".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 4000, 4200, 4600, 5000);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 800, 900, 1000, 1100);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5800, 6000, 6200, 6400);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5100, 5400);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 4200, 4500, 4800, 5100);
        } else if ("Over $200".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5200, 5600);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 1000, 1200, 1400, 1600);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 6000, 6200, 6400, 6600);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 5000, 5300, 5600, 5900);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5100, 5400);
        }
        return 0.0;
    }

    private double getTownhouse1000To2000Emissions(String electricityBill, String heatingType, int occupants) {
        if ("Under $50".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 1971, 2160, 2500, 2800);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 300, 400, 500, 600);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 2400, 2600, 2800, 3000);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 1800, 2000, 2200);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 2000, 2100, 2300);
        } else if ("$50-$100".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 2800, 3000, 3200, 3400);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 450, 520, 580, 675);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5000, 5200, 5400, 5600);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 3700, 3900, 4000, 4200);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3200, 3500, 3800, 4000);
        } else if ("$100-$150".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 3500, 3600, 4000, 4500);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 600, 700, 800, 900);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5400, 5500, 5700, 5900);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 4000, 4300, 4600, 5000);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3800, 4100, 4400, 4700);
        } else if ("$150-$200".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 4000, 4200, 4600, 5000);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 800, 900, 1000, 1100);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5800, 6000, 6200, 6400);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5100, 5400);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 4200, 4500, 4800, 5100);
        } else if ("Over $200".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5200, 5600);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 1000, 1200, 1400, 1600);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 6000, 6200, 6400, 6600);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 5000, 5300, 5600, 5900);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5100, 5400);
        }
        return 0.0;
    }

    private double getTownhouseOver2000Emissions(String electricityBill, String heatingType, int occupants) {
        if ("Under $50".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 1971, 2160, 2500, 2800);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 300, 400, 500, 600);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 2400, 2600, 2800, 3000);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 1800, 2000, 2200);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 2000, 2100, 2300);
        } else if ("$50-$100".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 2800, 3000, 3200, 3400);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 450, 520, 580, 675);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5000, 5200, 5400, 5600);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 3700, 3900, 4000, 4200);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3200, 3500, 3800, 4000);
        } else if ("$100-$150".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 3500, 3600, 4000, 4500);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 600, 700, 800, 900);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5400, 5500, 5700, 5900);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 4000, 4300, 4600, 5000);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3800, 4100, 4400, 4700);
        } else if ("$150-$200".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 4000, 4200, 4600, 5000);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 800, 900, 1000, 1100);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 5800, 6000, 6200, 6400);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5100, 5400);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 4200, 4500, 4800, 5100);
        } else if ("Over $200".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5200, 5600);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 1000, 1200, 1400, 1600);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 6000, 6200, 6400, 6600);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 5000, 5300, 5600, 5900);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 4500, 4800, 5100, 5400);
        }
        return 0.0;
    }

    private double getApartmentEmissions(String homeSize, String electricityBill, String heatingType, int occupants) {
        if ("Under 1000 sq. ft.".equals(homeSize)) {
            return getApartmentUnder1000Emissions(electricityBill, heatingType, occupants);
        } else if ("1000-2000 sq. ft.".equals(homeSize)) {
            return getApartment1000To2000Emissions(electricityBill, heatingType, occupants);
        } else if ("Over 2000 sq. ft.".equals(homeSize)) {
            return getApartmentOver2000Emissions(electricityBill, heatingType, occupants);
        }
        return 0.0;
    }

    private double getApartmentUnder1000Emissions(String electricityBill, String heatingType, int occupants) {
        if ("Under $50".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 1680, 1800, 2000, 2400);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 200, 300, 400, 500);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 1320, 1550, 1800, 2000);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 1600, 1800, 2000, 2100);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 1800, 2000, 2300, 2500);
        } else if ("$50-$100".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 2240, 2430, 2719, 2997);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 500, 700, 900, 1200);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 2100, 2400, 2600, 2800);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 1800, 2100, 2300, 2500);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 2500, 2700, 2900, 3200);
        }
        // Add more electricity bill ranges here
        return 0.0;
    }

    private double getApartment1000To2000Emissions(String electricityBill, String heatingType, int occupants) {
        if ("Under $50".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 2060, 2260, 2520, 2800);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 300, 400, 500, 600);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 1700, 2000, 2300);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 1500, 1900, 2200, 2500);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 1800, 2000, 2400, 2700);
        } else if ("$50-$100".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 2580, 2780, 3110, 3320);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 550, 750, 900, 1100);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 2400, 2800, 3100, 3400);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 1900, 2100, 2400, 2700);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 2700, 3000, 3300, 3600);
        }
        // Add more electricity bill ranges here
        return 0.0;
    }

    private double getApartmentOver2000Emissions(String electricityBill, String heatingType, int occupants) {
        if ("Under $50".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 2440, 2727, 3100, 3300);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 400, 500, 600, 700);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 1800, 2000, 2400, 2800);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 2000, 2400, 2600, 3000);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 2400, 2700, 3000, 3400);
        } else if ("$50-$100".equals(electricityBill)) {
            if ("Natural gas".equals(heatingType)) return getEmissionByOccupants(occupants, 2700, 3000, 3300, 3600);
            if ("Electricity".equals(heatingType)) return getEmissionByOccupants(occupants, 600, 800, 1000, 1200);
            if ("Oil".equals(heatingType)) return getEmissionByOccupants(occupants, 2400, 2700, 3000, 3400);
            if ("Propane".equals(heatingType)) return getEmissionByOccupants(occupants, 2100, 2500, 2800, 3200);
            if ("Wood".equals(heatingType)) return getEmissionByOccupants(occupants, 3000, 3300, 3600, 3900);
        }
        // Add more electricity bill ranges here
        return 0.0;
    }








    private double getEmissionByOccupants(int occupants, double oneOccupant, double twoOccupants, double threeToFourOccupants, double fiveOrMoreOccupants) {
        if (occupants == 1) return oneOccupant;
        else if (occupants == 2) return twoOccupants;
        else if (occupants <= 4) return threeToFourOccupants;
        else return fiveOrMoreOccupants;
    }



    private double calculateConsumption(String clothing, String secondHand, String electronics, String recycling) {
        double emission = 0.0;

        if ("Monthly".equals(clothing)) emission += 360;
        else if ("Annually".equals(clothing)) emission += 50;
        if ("Regularly".equals(secondHand)) emission -= 200;
        if ("1".equals(electronics)) emission += 300;
        if ("Occasionally".equals(recycling)) emission += 50;

        return emission;
    }
}
