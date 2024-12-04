package com.example.myapplication;

import java.util.Objects;

public class EmissionKey {
    private final String houseType;       // Detached, Semi-Detached, Townhouse, Condo/Apartment, Other
    private final String occupants;      // 1, 2, 3-4, 5 or more
    private final String homeSize;       // Under 1000 sq. ft., 1000-2000 sq. ft., Over 2000 sq. ft.
    private final String homeHeatType;   // Natural Gas, Electricity, Oil, Propane, Wood, Other
    private final String electricityBill; // Under $50, $50-$100, $100-$150, $150-$200, Over $200

    public EmissionKey(String houseType, String occupants, String homeSize, String homeHeatType, String electricityBill) {
        this.houseType = houseType;
        this.occupants = occupants;
        this.homeSize = homeSize;
        this.homeHeatType = homeHeatType;
        this.electricityBill = electricityBill;
    }

    public String getHouseType() {
        return houseType;
    }

    public String getOccupants() {
        return occupants;
    }

    public String getHomeSize() {
        return homeSize;
    }

    public String getHomeHeatType() {
        return homeHeatType;
    }

    public String getElectricityBill() {
        return electricityBill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmissionKey that = (EmissionKey) o;
        return Objects.equals(houseType, that.houseType) &&
                Objects.equals(occupants, that.occupants) &&
                Objects.equals(homeSize, that.homeSize) &&
                Objects.equals(homeHeatType, that.homeHeatType) &&
                Objects.equals(electricityBill, that.electricityBill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseType, occupants, homeSize, homeHeatType, electricityBill);
    }

    @Override
    public String toString() {
        return "EmissionKey{" +
                "houseType='" + houseType + '\'' +
                ", occupants='" + occupants + '\'' +
                ", homeSize='" + homeSize + '\'' +
                ", homeHeatType='" + homeHeatType + '\'' +
                ", electricityBill='" + electricityBill + '\'' +
                '}';
    }
}
