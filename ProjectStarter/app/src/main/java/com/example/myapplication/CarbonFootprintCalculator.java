package com.example.myapplication;

import java.util.Objects;

public class CarbonFootprintCalculator {

    private HousingEmissionsCalculator emissionsCalculator = new HousingEmissionsCalculator();

    public double calculateTransportation(String airTravelShort, String airTravelLong, String carType, String distance, String publicTransport, String timeSpent) {
        double emission = 0.0;

        // Air travel
        if ("1-2".equals(airTravelShort)) {
            emission += 225;
        } else if ("3-5".equals(airTravelShort)) {
            emission += 600;
        } else if ("6-10".equals(airTravelShort)) {
            emission += 1200;
        } else if ("More than 10".equals(airTravelShort)) {
            emission += 1800;
        }

        if ("1-2".equals(airTravelLong)) {
            emission += 825;
        } else if ("3-5".equals(airTravelLong)) {
            emission += 2200;
        } else if ("6-10".equals(airTravelLong)) {
            emission += 4400;
        } else if ("More than 10".equals(airTravelLong)) {
            emission += 6600;
        }

        // Car use
        double distanceValue = 0.0;
        if ("0-5k".equals(distance)) {
            distanceValue = 5000;
        } else if ("5k-10k".equals(distance)) {
            distanceValue = 10000;
        } else if ("10k-15k".equals(distance)) {
            distanceValue = 15000;
        } else if ("15k-20k".equals(distance)) {
            distanceValue = 20000;
        } else if ("20k-25k".equals(distance)) {
            distanceValue = 25000;
        } else if ("More than 25k".equals(distance)) {
            distanceValue = 35000;
        }

        if ("Gasoline".equals(carType)) {
            emission += distanceValue * 0.24;
        } else if ("Diesel".equals(carType)) {
            emission += distanceValue * 0.27;
        } else if ("Hybrid".equals(carType)) {
            emission += distanceValue * 0.16;
        } else if ("Electric".equals(carType)) {
            emission += distanceValue * 0.05;
        }

        // Public transport
        emission += calculatePublicTransport(publicTransport, timeSpent);

        return emission;
    }

    private double calculatePublicTransport(String frequency, String timeSpent) {
        double emission = 0.0;
        if ("Never".equals(frequency)) {
            return emission;
        }

        double baseEmission = 0.0;
        if ("Under 1 hour".equals(timeSpent)) {
            baseEmission = 246;
        } else if ("1-3 hours".equals(timeSpent)) {
            baseEmission = 819;
        } else if ("3-5 hours".equals(timeSpent)) {
            baseEmission = 1638;
        } else if ("5-10 hours".equals(timeSpent)) {
            baseEmission = 3071;
        } else if ("More than 10 hours".equals(timeSpent)) {
            baseEmission = 4095;
        }

        if ("Frequently".equals(frequency) || "Always".equals(frequency)) {
            baseEmission *= 2.3;
        }
        emission += baseEmission;
        return emission;
    }

    public double calculateFood(String dietType, String beefFreq, String porkFreq, String chickenFreq, String fishFreq, String waste) {
        double emission = 0.0;

        if ("Vegetarian".equals(dietType)) {
            emission += 1000;
        } else if ("Vegan".equals(dietType)) {
            emission += 500;
        } else if ("Pescatarian".equals(dietType)) {
            emission += 1500;
        } else if ("Meat-based".equals(dietType)) {
            emission += getMeatConsumptionEmission(beefFreq, 2500, 1900, 1300, 0);
            emission += getMeatConsumptionEmission(porkFreq, 1450, 860, 450, 0);
            emission += getMeatConsumptionEmission(chickenFreq, 950, 600, 200, 0);
            emission += getMeatConsumptionEmission(fishFreq, 800, 500, 150, 0);
        }

        // Food waste
        if ("Frequently".equals(waste)) {
            emission += 140.4;
        } else if ("Occasionally".equals(waste)) {
            emission += 70.2;
        } else if ("Rarely".equals(waste)) {
            emission += 23.4;
        }

        return emission;
    }

    private double getMeatConsumptionEmission(String frequency, double daily, double frequently, double occasionally, double never) {
        if ("Daily".equals(frequency)) {
            return daily;
        } else if ("Frequently".equals(frequency)) {
            return frequently;
        } else if ("Occasion ally".equals(frequency)) {
            return occasionally;
        } else if ("Never".equals(frequency)) {
            return never;
        }
        return 0.0;
    }

    public double calculateHousing(String homeType, String occupants, String homeSize, String homeHeatingType, String electricityBill, String waterHeatType, String renewable) {
        double housingEmission = 0.0;

        // Normalize "Other" homeType to "Townhouse"
        if ("Other".equals(homeType)) {
            homeType = "Townhouse";
        }

        HousingEmissionsCalculator emissionsCalculator = new HousingEmissionsCalculator();
        emissionsCalculator.populateEmissionsData();
        double baseEmission = emissionsCalculator.calculateEmissions(homeType, occupants, homeSize, homeHeatingType, electricityBill);

        housingEmission += baseEmission;

        // Additional emissions for water heating source being different from home heating source
        if (!Objects.equals(homeHeatingType, waterHeatType)) {
            housingEmission += 233.0;
        }

        // Reductions for renewable energy usage
        if ("Primarily".equalsIgnoreCase(renewable)) {
            housingEmission -= 6000.0;
        } else if ("Partially".equalsIgnoreCase(renewable)) {
            housingEmission -= 4000.0;
        }
        return Math.max(0, housingEmission);
    }

    public double calculateConsumption(String clothing, String secondHand, String electronics, String recycling) {
        double emission = 0.0;

        // Clothing frequency emissions
        if ("Monthly".equals(clothing)) {
            emission += 360;
        } else if ("Quarterly".equals(clothing)) {
            emission += 90;
        } else if ("Annually".equals(clothing)) {
            emission += 50;
        } else if ("Rarely".equals(clothing)) {
            emission += 20;
        }

        // Second-hand or eco-friendly product usage reductions
        if ("Yes, regularly".equals(secondHand)) {
            emission *= 0.5; // 50% reduction
        } else if ("Yes, occasionally".equals(secondHand)) {
            emission *= 0.7; // 30% reduction
        }

        // Electronics purchase emissions
        if ("1".equals(electronics)) {
            emission += 300;
        } else if ("2".equals(electronics)) {
            emission += 600;
        } else if ("3".equals(electronics)) {
            emission += 900;
        } else if ("4 or more".equals(electronics)) {
            emission += 1200;
        }

        // Recycling frequency reductions
        if ("Occasionally".equals(recycling)) {
            emission -= 30;
        } else if ("Frequently".equals(recycling)) {
            emission -= 50;
        } else if ("Always".equals(recycling)) {
            emission -= 50;
        }

        return Math.max(emission, 0.0); // Ensure non-negative emissions
    }

}