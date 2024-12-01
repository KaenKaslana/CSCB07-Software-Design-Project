package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CarbonFootprintActivity extends AppCompatActivity {

    private DatabaseReference databaseRef;
    private FusedLocationProviderClient fusedLocationClient;
    private String userCountry = "Canada";
    private Map<String, Double> emissionsMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carbon_footprint);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String userId = auth.getCurrentUser().getUid();
        databaseRef = FirebaseDatabase.getInstance().getReference("Users").child(userId);
        emissionsMap = new HashMap<>();
        populateEmissionsMap();
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            calculateAndStoreCarbonFootprint();
        }
    }

    private void calculateAndStoreCarbonFootprint() {
        databaseRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful() && task.getResult() != null) {
                DataSnapshot snapshot = task.getResult();
                final double[] totalEmission = {0.0};
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
                String occupants = getAnswer(snapshot, "Houseq2");
                String homeSize = getAnswer(snapshot, "Houseq3");
                String homeHeatingType = getAnswer(snapshot, "Houseq4");
                String electricityBill = getAnswer(snapshot, "Houseq5");
                String waterHeatType = getAnswer(snapshot, "Houseq6");
                String renewable = getAnswer(snapshot, "Houseq7");
                String clothing = getAnswer(snapshot, "Consq1");
                String secondHand = getAnswer(snapshot, "Consq2");
                String electronics = getAnswer(snapshot, "Consq3");
                String recycling = getAnswer(snapshot, "Consq4");
                CarbonFootprintCalculator calculator = new CarbonFootprintCalculator();
                double transportEmission = calculator.calculateTransportation(airTravelShort, airTravelLong, carType, distance, publicTransport, timeSpent);
                double foodEmission = calculator.calculateFood(dietType, beefFreq, porkFreq, chickenFreq, fishFreq, waste);
                double housingEmission = calculator.calculateHousing(homeType, occupants, homeSize, homeHeatingType, electricityBill, waterHeatType, renewable);
                double consumptionEmission = calculator.calculateConsumption(clothing, secondHand, electronics, recycling);
                totalEmission[0] = transportEmission + foodEmission + housingEmission + consumptionEmission;
                databaseRef.child("CarbonFootprint").setValue(totalEmission[0])
                        .addOnSuccessListener(aVoid -> Toast.makeText(this, "Carbon footprint calculated and stored!", Toast.LENGTH_LONG).show())
                        .addOnFailureListener(e -> Toast.makeText(this, "Failed to store carbon footprint.", Toast.LENGTH_SHORT).show());
                TextView totalFootprintText = findViewById(R.id.totalFootprintText);
                TextView breakdownText = findViewById(R.id.breakdownText);
                TextView comparisonText = findViewById(R.id.comparisonText);
                totalFootprintText.setText(String.format(Locale.getDefault(), "Total Emissions: %.2f tons CO2e", totalEmission[0] / 1000));
                breakdownText.setText(String.format(Locale.getDefault(),
                        "Breakdown:\nTransportation: %.2f tons CO2e\nFood: %.2f tons CO2e\nHousing: %.2f tons CO2e\nConsumption: %.2f tons CO2e",
                        transportEmission / 1000, foodEmission / 1000, housingEmission / 1000, consumptionEmission / 1000));
                getUserCountry(totalEmission[0]);
            } else {
                Toast.makeText(this, "Failed to retrieve user data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getUserCountry(double total) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, location -> {
                    if (location != null) {
                        userCountry = getCountryFromLocation(location);
                        updateComparisonUI(userCountry, total);
                    } else {
                        Toast.makeText(this, "Unable to get location.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private String getCountryFromLocation(Location location) {
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses;
        try {
            addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
            if (addresses != null && !addresses.isEmpty()) {
                return addresses.get(0).getCountryName();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Unknown";
    }

    private void updateComparisonUI(String country, double total) {
        TextView comparisonText = findViewById(R.id.comparisonText);

        if ("Unknown".equals(country)) {
            comparisonText.setText("Unable to determine your country for comparison.");
        } else {
            double nationalAverage = emissionsMap.getOrDefault(country, -1.0);
            if (nationalAverage == -1.0) {
                comparisonText.setText(String.format("Data unavailable for %s. Unable to compare your footprint.", country));
            } else {
                double totalEmission = total;
                double percentageBelow = ((nationalAverage - totalEmission / 1000) / nationalAverage) * 100;
                comparisonText.setText(String.format(Locale.getDefault(),
                        "Your footprint is %.2f%% %s the national average for %s.\nYour footprint %s global targets for climate change!",
                        Math.abs(percentageBelow),
                        (percentageBelow > 0 ? "below" : "above"),
                        country,
                        (percentageBelow > 0 ? "meets" : "does not meet")));
            }
        }
    }


    private void populateEmissionsMap() {
        emissionsMap.put("Afghanistan", 0.29536375);
        emissionsMap.put("Africa", 0.99422127);
        emissionsMap.put("Albania", 1.7432004);
        emissionsMap.put("Algeria", 3.9272263);
        emissionsMap.put("Andorra", 4.6171236);
        emissionsMap.put("Angola", 0.45155162);
        emissionsMap.put("Anguilla", 8.752724);
        emissionsMap.put("Antigua and Barbuda", 6.4218745);
        emissionsMap.put("Argentina", 4.2378173);
        emissionsMap.put("Armenia", 2.3045583);
        emissionsMap.put("Aruba", 8.133404);
        emissionsMap.put("Asia", 4.611434);
        emissionsMap.put("Asia (excl. China and India)", 4.017375);
        emissionsMap.put("Australia", 14.985412);
        emissionsMap.put("Austria", 6.8781943);
        emissionsMap.put("Azerbaijan", 3.6746833);
        emissionsMap.put("Bahamas", 5.1708703);
        emissionsMap.put("Bahrain", 25.672274);
        emissionsMap.put("Bangladesh", 0.5964455);
        emissionsMap.put("Barbados", 4.3772573);
        emissionsMap.put("Belarus", 6.1669006);
        emissionsMap.put("Belgium", 7.6875386);
        emissionsMap.put("Belize", 1.7894346);
        emissionsMap.put("Benin", 0.631487);
        emissionsMap.put("Bermuda", 6.9370627);
        emissionsMap.put("Bhutan", 1.3489918);
        emissionsMap.put("Bolivia", 1.7583066);
        emissionsMap.put("Bonaire Sint Eustatius and Saba", 4.083284);
        emissionsMap.put("Bosnia and Herzegovina", 6.1034565);
        emissionsMap.put("Botswana", 2.838951);
        emissionsMap.put("Brazil", 2.2454574);
        emissionsMap.put("British Virgin Islands", 5.0039577);
        emissionsMap.put("Brunei", 23.950201);
        emissionsMap.put("Bulgaria", 6.8044534);
        emissionsMap.put("Burkina Faso", 0.26295447);
        emissionsMap.put("Burundi", 0.06194545);
        emissionsMap.put("Cambodia", 1.1900775);
        emissionsMap.put("Cameroon", 0.34292704);
        emissionsMap.put("Canada", 14.249212);
        emissionsMap.put("Cape Verde", 0.9588915);
        emissionsMap.put("Central African Republic", 0.040548485);
        emissionsMap.put("Chad", 0.13367727);
        emissionsMap.put("Chile", 4.3041654);
        emissionsMap.put("China", 7.992761);
        emissionsMap.put("Colombia", 1.9223082);
        emissionsMap.put("Comoros", 0.49327007);
        emissionsMap.put("Congo", 1.2447897);
        emissionsMap.put("Cook Islands", 3.9950094);
        emissionsMap.put("Costa Rica", 1.5226681);
        emissionsMap.put("Cote d'Ivoire", 0.41668788);
        emissionsMap.put("Croatia", 4.348515);
        emissionsMap.put("Cuba", 1.8659163);
        emissionsMap.put("Curacao", 9.189007);
        emissionsMap.put("Cyprus", 5.616782);
        emissionsMap.put("Czechia", 9.3357525);
        emissionsMap.put("Democratic Republic of Congo", 0.036375992);
        emissionsMap.put("Denmark", 4.940161);
        emissionsMap.put("Djibouti", 0.40418932);
        emissionsMap.put("Dominica", 2.1058853);
        emissionsMap.put("Dominican Republic", 2.1051137);
        emissionsMap.put("East Timor", 0.49869007);
        emissionsMap.put("Ecuador", 2.3117273);
        emissionsMap.put("Egypt", 2.333106);
        emissionsMap.put("El Salvador", 1.2174718);
        emissionsMap.put("Equatorial Guinea", 3.0307202);
        emissionsMap.put("Eritrea", 0.18914719);
        emissionsMap.put("Estonia", 7.77628);
        emissionsMap.put("Eswatini", 1.0527312);
        emissionsMap.put("Ethiopia", 0.15458965);
        emissionsMap.put("Europe", 6.8578663);
        emissionsMap.put("Europe (excl. EU-27)", 7.886797);
        emissionsMap.put("Europe (excl. EU-28)", 8.817789);
        emissionsMap.put("European Union (27)", 6.1743994);
        emissionsMap.put("European Union (28)", 5.983708);
        emissionsMap.put("Faroe Islands", 14.084624);
        emissionsMap.put("Fiji", 1.1550449);
        emissionsMap.put("Finland", 6.5267396);
        emissionsMap.put("France", 4.603891);
        emissionsMap.put("French Polynesia", 2.8509297);
        emissionsMap.put("Gabon", 2.3882635);
        emissionsMap.put("Gambia", 0.2847278);
        emissionsMap.put("Georgia", 2.962545);
        emissionsMap.put("Germany", 7.9837584);
        emissionsMap.put("Ghana", 0.6215505);
        emissionsMap.put("Greece", 5.7451057);
        emissionsMap.put("Greenland", 10.473997);
        emissionsMap.put("Grenada", 2.7133646);
        emissionsMap.put("Guatemala", 1.0756185);
        emissionsMap.put("Guinea", 0.35742033);
        emissionsMap.put("Guinea-Bissau", 0.15518051);
        emissionsMap.put("Guyana", 4.3736935);
        emissionsMap.put("Haiti", 0.21119381);
        emissionsMap.put("High-income countries", 10.132565);
        emissionsMap.put("Honduras", 1.0696708);
        emissionsMap.put("Hong Kong", 4.081913);
        emissionsMap.put("Hungary", 4.449911);
        emissionsMap.put("Iceland", 9.499798);
        emissionsMap.put("India", 1.9966822);
        emissionsMap.put("Indonesia", 2.6456614);
        emissionsMap.put("Iran", 7.7993317);
        emissionsMap.put("Iraq", 4.024638);
        emissionsMap.put("Ireland", 7.7211185);
        emissionsMap.put("Israel", 6.208912);
        emissionsMap.put("Italy", 5.726825);
        emissionsMap.put("Jamaica", 2.2945588);
        emissionsMap.put("Japan", 8.501681);
        emissionsMap.put("Jordan", 2.0301995);
        emissionsMap.put("Kazakhstan", 13.979704);
        emissionsMap.put("Kenya", 0.45998666);
        emissionsMap.put("Kiribati", 0.5184742);
        emissionsMap.put("Kosovo", 4.830646);
        emissionsMap.put("Kuwait", 25.578102);
        emissionsMap.put("Kyrgyzstan", 1.4251612);
        emissionsMap.put("Laos", 3.0803475);
        emissionsMap.put("Latvia", 3.561689);
        emissionsMap.put("Lebanon", 4.3543963);
        emissionsMap.put("Lesotho", 1.3594668);
        emissionsMap.put("Liberia", 0.1653753);
        emissionsMap.put("Libya", 9.242238);
        emissionsMap.put("Liechtenstein", 3.8097827);
        emissionsMap.put("Lithuania", 4.606163);
        emissionsMap.put("Low-income countries", 0.28005043);
        emissionsMap.put("Lower-middle-income countries", 1.777996);
        emissionsMap.put("Luxembourg", 11.618432);
        emissionsMap.put("Macao", 1.5127679);
        emissionsMap.put("Madagascar", 0.14871116);
        emissionsMap.put("Malawi", 0.10262384);
        emissionsMap.put("Malaysia", 8.576508);
        emissionsMap.put("Maldives", 3.2475724);
        emissionsMap.put("Mali", 0.31153768);
        emissionsMap.put("Malta", 3.1035979);
        emissionsMap.put("Marshall Islands", 3.6353714);
        emissionsMap.put("Mauritania", 0.957337);
        emissionsMap.put("Mauritius", 3.2697906);
        emissionsMap.put("Mexico", 4.0153365);
        emissionsMap.put("Micronesia (country)", 1.3243006);
        emissionsMap.put("Moldova", 1.6565942);
        emissionsMap.put("Mongolia", 11.150772);
        emissionsMap.put("Montenegro", 3.6558185);
        emissionsMap.put("Montserrat", 4.8447766);
        emissionsMap.put("Morocco", 1.8263615);
        emissionsMap.put("Mozambique", 0.24274588);
        emissionsMap.put("Myanmar", 0.6445672);
        emissionsMap.put("Namibia", 1.5399038);
        emissionsMap.put("Nauru", 4.1700416);
        emissionsMap.put("Nepal", 0.5074035);
        emissionsMap.put("Netherlands", 7.1372175);
        emissionsMap.put("New Caledonia", 17.641167);
        emissionsMap.put("New Zealand", 6.212154);
        emissionsMap.put("Nicaragua", 0.79879653);
        emissionsMap.put("Niger", 0.116688);
        emissionsMap.put("Nigeria", 0.5891771);
        emissionsMap.put("Niue", 3.8729508);
        emissionsMap.put("North America", 10.5346775);
        emissionsMap.put("North America (excl. USA)", 4.741475);
        emissionsMap.put("North Korea", 1.9513915);
        emissionsMap.put("North Macedonia", 3.6245701);
        emissionsMap.put("Norway", 7.5093055);
        emissionsMap.put("Oceania", 9.85179);
        emissionsMap.put("Oman", 15.730261);
        emissionsMap.put("Pakistan", 0.84893465);
        emissionsMap.put("Palau", 12.123921);
        emissionsMap.put("Palestine", 0.6660658);
        emissionsMap.put("Panama", 2.699258);
        emissionsMap.put("Papua New Guinea", 0.77131313);
        emissionsMap.put("Paraguay", 1.3299496);
        emissionsMap.put("Peru", 1.7891879);
        emissionsMap.put("Philippines", 1.3014648);
        emissionsMap.put("Poland", 8.106886);
        emissionsMap.put("Portugal", 4.050785);
        emissionsMap.put("Qatar", 37.601273);
        emissionsMap.put("Romania", 3.739777);
        emissionsMap.put("Russia", 11.416899);
        emissionsMap.put("Rwanda", 0.112346195);
        emissionsMap.put("Saint Helena", 3.2986484);
        emissionsMap.put("Saint Kitts and Nevis", 4.708081);
        emissionsMap.put("Saint Lucia", 2.6149206);
        emissionsMap.put("Saint Pierre and Miquelon", 10.293288);
        emissionsMap.put("Saint Vincent and the Grenadines", 2.2964725);
        emissionsMap.put("Samoa", 1.1218625);
        emissionsMap.put("Sao Tome and Principe", 0.5816142);
        emissionsMap.put("Saudi Arabia", 18.197495);
        emissionsMap.put("Senegal", 0.6738352);
        emissionsMap.put("Serbia", 6.024712);
        emissionsMap.put("Seychelles", 6.1495123);
        emissionsMap.put("Sierra Leone", 0.13124847);
        emissionsMap.put("Singapore", 8.911513);
        emissionsMap.put("Sint Maarten (Dutch part)", 14.352394);
        emissionsMap.put("Slovakia", 6.051555);
        emissionsMap.put("Slovenia", 5.9979916);
        emissionsMap.put("Solomon Islands", 0.41232163);
        emissionsMap.put("Somalia", 0.03676208);
        emissionsMap.put("South Africa", 6.7461643);
        emissionsMap.put("South America", 2.4865332);
        emissionsMap.put("South Korea", 11.598764);
        emissionsMap.put("South Sudan", 0.1680176);
        emissionsMap.put("Spain", 5.1644425);
        emissionsMap.put("Sri Lanka", 0.7936504);
        emissionsMap.put("Sudan", 0.4696261);
        emissionsMap.put("Suriname", 5.8029985);
        emissionsMap.put("Sweden", 3.6069093);
        emissionsMap.put("Switzerland", 4.0478554);
        emissionsMap.put("Syria", 1.2490375);
        emissionsMap.put("Taiwan", 11.630868);
        emissionsMap.put("Tajikistan", 1.0064901);
        emissionsMap.put("Tanzania", 0.23771806);
        emissionsMap.put("Thailand", 3.7762568);
        emissionsMap.put("Togo", 0.2910665);
        emissionsMap.put("Tonga", 1.7686282);
        emissionsMap.put("Trinidad and Tobago", 22.423758);
        emissionsMap.put("Tunisia", 2.879285);
        emissionsMap.put("Turkey", 5.1052055);
        emissionsMap.put("Turkmenistan", 11.03418);
        emissionsMap.put("Turks and Caicos Islands", 7.636793);
        emissionsMap.put("Tuvalu", 1.0004411);
        emissionsMap.put("Uganda", 0.12744623);
        emissionsMap.put("Ukraine", 3.5578535);
        emissionsMap.put("United Arab Emirates", 25.833244);
        emissionsMap.put("United Kingdom", 4.7201805);
        emissionsMap.put("United States", 14.949616);
        emissionsMap.put("Upper-middle-income countries", 6.2268133);
        emissionsMap.put("Uruguay", 2.3060381);
        emissionsMap.put("Uzbekistan", 3.4830604);
        emissionsMap.put("Vanuatu", 0.6363055);
        emissionsMap.put("Venezuela", 2.7168686);
        emissionsMap.put("Vietnam", 3.4995174);
        emissionsMap.put("Wallis and Futuna", 2.2819076);
        emissionsMap.put("World", 4.658219);
        emissionsMap.put("Yemen", 0.33701748);
        emissionsMap.put("Zambia", 0.44570068);
        emissionsMap.put("Zimbabwe", 0.542628);
    }


    private String getAnswer(DataSnapshot snapshot, String key) {
        String value = snapshot.child(key).getValue(String.class);
        return value != null ? value : "No answer";
    }
}
