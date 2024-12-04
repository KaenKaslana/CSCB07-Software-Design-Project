package com.example.myapplication;

import java.util.HashMap;
import java.util.Map;

public class HousingEmissionsCalculator {

    public final Map<EmissionKey, Double> emissionsMap;

    public HousingEmissionsCalculator() {
        emissionsMap = new HashMap<>();
        populateEmissionsData();
    }

    public void populateEmissionsData() {
        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3000.0);

        // Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 250.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 380.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 450.0);

        // Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2650.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3700.0);

        // Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2870.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3470.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4370.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 5270.0);

        // Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2170.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2370.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2670.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2970.0);


        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2440.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2640.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2940.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3240.0);

        // Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 550.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 600.0);

        // Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6000.0);

        // Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5200.0);

        // Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2340.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2540.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2840.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3140.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2610.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2810.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3110.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3410.0);

        // Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1450.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1800.0);

        // Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6250.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6950.0);

        // Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6200.0);

        // Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2510.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2710.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3010.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3310.0);


        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2780.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2980.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3280.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3580.0);

        // Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 1700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 1900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2050.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2200.0);

        // Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 7200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 7400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 7700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 8000.0);

        // Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 7200.0);

        // Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2680.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2880.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3180.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3480.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3900.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3000.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 8200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 8400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 8700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 9000.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 8200.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3800.0);


        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3380.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3860.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 380.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 600.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 5350.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3770.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4470.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 5670.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 6570.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3670.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4170.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4870.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 5670.0);


        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6700.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 1050.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 1200.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5440.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6100.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3940.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4640.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5740.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6740.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3840.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4340.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5040.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5840.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 7000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 7300.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1450.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1800.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 7000.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 7100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 7230.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 7440.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 7550.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4010.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4510.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5210.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6010.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 7100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 7300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 7600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 7900.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 1800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2250.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2400.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 7200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 7400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 7700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 8000.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4280.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4980.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5985.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 7080.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4180.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4680.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5380.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6180.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 8300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 8500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 8800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 9100.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3100.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 8700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 9000.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 8200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 8400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 8200.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5750.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6500.0);


        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2880.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3230.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 320.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 450.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 520.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 675.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 5400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 6200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 7000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 8900.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 5570.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 6170.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 6970.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 7970.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4170.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4670.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 5270.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 6170.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3800.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 1500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 1800.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 10500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 11000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 12500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 14000.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5740.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6340.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 7240.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 8140.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4340.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4840.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5640.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6340.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4000.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2700.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 14000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 15500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 16250.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 17500.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6410.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 7300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 8230.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4510.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5010.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5710.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6510.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4400.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3600.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 17500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 18100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 20000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 21000.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5852.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6410.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 7300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 8300.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4680.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5180.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5980.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6680.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4400.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2700.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 21000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 22000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 23500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 25000.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6840.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7890.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 8710.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6250.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7000.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2160.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2349.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2732.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3199.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 410.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 580.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2592.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2680.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2750.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2450.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2600.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2450.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3000.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3200.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 410.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 560.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 600.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3600.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3400.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3800.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3400.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1210.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1450.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1620.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1820.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3800.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3600.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4000.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3600.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 1700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 1900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2200.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4000.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3800.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4200.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3800.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3600.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4200.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4000.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4400.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2443.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2727.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3151.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3578.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 410.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 550.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 605.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3499.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3599.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3700.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4900.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2500.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 7500.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 1050.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 1200.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6000.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 7300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 8000.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4000.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 7800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 8500.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1550.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1800.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 7300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 8500.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 7000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 8000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 9100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 10000.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4850.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5500.0);


        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 8800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 10000.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 1800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2250.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2400.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 8000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 8800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 9200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 10500.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 9000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 10200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 11000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 12000.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 7100.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 9800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 11000.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3200.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 10550.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 10900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 11200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 12000.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 12000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 13200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 14100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 15000.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7220.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 8000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 8600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 9100.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2821.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3010.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3261.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3578.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 560.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 890.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1000.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3820.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4307.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4400.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4370.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4870.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 5670.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 6370.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3970.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4470.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 5270.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 5970.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 7500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 8800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 10800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 12500.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 1200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 1400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 1650.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 1800.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 7200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 8500.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4540.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5040.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5840.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6540.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4140.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4640.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5340.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6140.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 10000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 12000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 14000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 15000.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2400.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 8500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 9200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 10200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 11000.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4710.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5210.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6010.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6710.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4310.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4810.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5610.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6310.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 12500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 14200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 16000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 17500.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2820.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3000.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 11000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 12000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 13500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 14000.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4880.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5380.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6180.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6880.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4480.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4980.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5780.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6480.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 15000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 16800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 18200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 19000.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4500.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 14000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 14800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 15500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 16000.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7200.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6150.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_SEMI_DETACHED,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6800.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1971.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2160.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2800.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 410.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 550.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2523.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2720.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1850.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2500.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2250.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2600.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2910.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3200.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 550.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 580.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 600.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3250.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3500.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3800.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3400.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3210.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3800.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1250.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1320.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1420.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3750.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4050.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5000.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3520.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3800.0);


        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 8000.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 1600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 1750.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 1900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2000.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5100.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5800.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3330.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3720.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4000.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 8000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 9500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 10200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 12000.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3000.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5600.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7800.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_UNDER_1000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4300.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2443.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2750.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3111.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3580.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 380.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 590.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2590.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2620.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2730.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2800.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3170.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3770.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4670.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 5570.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1560.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2200.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 7300.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 550.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 950.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 1100.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4320.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5500.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5940.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6140.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6340.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3800.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 8340.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1350.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1520.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1700.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6100.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6420.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6500.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4310.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5100.0);



        // Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 8500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 9000.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 1700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 1900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2150.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2400.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5350.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5720.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5900.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3680.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4280.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5180.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6080.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4220.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4400.0);



        // Over $200 for Townhouse (1000-2000 sq. ft.) with different heating types

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 9500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 10100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 11200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 14000.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2780.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3500.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5370.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6200.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7400.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4640.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5430.0);



        // Emissions for Townhouse (Over 2000 sq. ft.) with monthly electricity bill under $50

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2822.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3010.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3600.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 560.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 890.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1000.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2810.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3468.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3760.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3340.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3940.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4840.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 5740.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 4070.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 5000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 5600.0);



        // Emissions for Townhouse (Over 2000 sq. ft.) with monthly electricity bill $50-$100

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3840.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5100.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 1200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 1380.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 1600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 1750.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5320.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5800.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6330.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6440.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 6900.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3930.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4360.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5000.0);



        // Emissions for Townhouse (Over 2000 sq. ft.) with monthly electricity bill $100-$150

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 7000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 8000.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2300.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5690.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6250.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 6500.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3510.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4110.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5010.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5910.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4780.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5360.0);



        // Emissions for Townhouse (Over 2000 sq. ft.) with monthly electricity bill $150-$200

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 8000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 8300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 9000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 9500.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2650.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2800.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5440.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6000.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5380.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6200.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4640.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5400.0);



        // Emissions for Townhouse (Over 2000 sq. ft.) with monthly electricity bill Over $200

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 9500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 1010.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 10300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 11000.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4300.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5440.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6000.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5380.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6200.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4640.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_TOWNHOUSE,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5500.0);



        // Emissions for Condo/Apartment (1000 sq. ft.) with monthly electricity bill Under $50

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1680.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1870.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2170.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2440.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 250.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 380.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 450.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 0.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1320.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1550.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2000.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1850.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2100.0);



        // Emissions for Condo/Apartment (1000 sq. ft.) with monthly electricity bill $50-$100

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2240.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2430.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2719.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2997.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 550.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 580.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 600.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 0.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3200.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 1800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2400.0);



        // Emissions for Condo/Apartment (1000 sq. ft.) with monthly electricity bill $100-$150

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3500.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1300.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 0.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4300.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3500.0);



        // Emissions for Condo/Apartment (1000 sq. ft.) with monthly electricity bill $150-$200

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5000.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 1400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 1600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 1700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 1900.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 0.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5200.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3900.0);



        // Emissions for Condo/Apartment (1000 sq. ft.) with monthly electricity bill Over $200

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 8000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 10000.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 1900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2600.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 0.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7000.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4200.0);



        // Emissions for Condo/Apartment (1000-2000 sq. ft.) with a monthly electricity bill Under $50

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2060.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2260.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2540.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3010.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 620.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 0.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2300.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2700.0);



        // Emissions for Condo/Apartment (1000-2000 sq. ft.) with a monthly electricity bill $50-$100

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2880.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3110.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3320.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 550.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 670.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 780.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 900.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 0.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4200.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3300.0);



        // Emissions for Condo/Apartment (1000-2000 sq. ft.) with a monthly electricity bill $100-$150

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3900.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1250.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1450.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1750.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2100.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 0.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5400.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4000.0);



        // Emissions for Condo/Apartment (1000-2000 sq. ft.) with a monthly electricity bill $150-$200

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5900.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 1900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3000.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 0.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4550.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4950.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5350.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5650.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4100.0);


        // Emissions for Condo/Apartment (1000-2000 sq. ft.) with a monthly electricity bill Over $200

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5350.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7550.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 8200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 10500.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3100.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 0.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7400.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_1000_TO_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4700.0);



        // Emissions for Condo/Apartment (Over 2000 sq. ft.) with a monthly electricity bill Under $50

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2440.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2727.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3010.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3577.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 350.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 570.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 980.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 0.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 1800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2450.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2600.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 2900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_UNDER_50), 3300.0);



        // Emissions for Condo/Apartment (Over 2000 sq. ft.) with a monthly electricity bill $50-$100

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3600.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 610.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 690.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 820.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 980.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 0.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3650.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4050.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 4650.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 5150.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 2900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3300.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_50_TO_100), 3600.0);



        // Emissions for Condo/Apartment (Over 2000 sq. ft.) with a monthly electricity bill $100-$150

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3670.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3870.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4300.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 1700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 2350.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 0.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 5700.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 3700.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_100_TO_150), 4600.0);



        // Emissions for Condo/Apartment (Over 2000 sq. ft.) with a monthly electricity bill $150-$200

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4250.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5050.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6200.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2150.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2550.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 2850.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3150.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 0.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 5600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 6000.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3530.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 3730.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4200.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_150_TO_200), 4630.0);



        // Emissions for Condo/Apartment (Over 2000 sq. ft.) with a monthly electricity bill Over $200

// Natural Gas
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6000.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 8500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_NATURAL_GAS,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 11100.0);

// Electricity
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 2600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 3600.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_ELECTRICITY,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4000.0);

// Oil
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 0.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_OIL,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 0.0);

// Propane
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6500.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 6800.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_PROPANE,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 7800.0);

// Wood
        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_ONE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4100.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_TWO,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4400.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_THREE_TO_FOUR,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 4900.0);

        emissionsMap.put(new EmissionKey(EmissionConstants.HOUSE_TYPE_APARTMENT,
                EmissionConstants.OCCUPANTS_FIVE_OR_MORE,
                EmissionConstants.HOME_SIZE_OVER_2000,
                EmissionConstants.HEATING_TYPE_WOOD,
                EmissionConstants.ELECTRICITY_BILL_OVER_200), 5100.0);
    }



    public double calculateEmissions(String houseType, String occupants, String homeSize, String homeHeatType, String electricityBill) {
        EmissionKey key = new EmissionKey(houseType, occupants, homeSize, homeHeatType, electricityBill);
        Double emissionValue = emissionsMap.get(key);
        if (emissionValue == null) {
            return 0;
        }
        return emissionValue;
    }


}
