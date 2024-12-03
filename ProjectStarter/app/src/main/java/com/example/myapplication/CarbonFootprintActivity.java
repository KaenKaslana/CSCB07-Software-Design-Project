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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class CarbonFootprintActivity extends AppCompatActivity {

    private DatabaseReference databaseRef;
    private Map<String, Double> emissionsMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carbon_footprint);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String userId = auth.getCurrentUser().getUid();
        Button butt = findViewById(R.id.goToMain);
        databaseRef = FirebaseDatabase.getInstance().getReference("Users").child(userId);
        emissionsMap = new HashMap<>();
        populateEmissionsMap();
        calculateAndStoreCarbonFootprint();
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(CarbonFootprintActivity.this, EmissionDisplayActivity.class);
                startActivity(i);
            }
        });
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
                String userCountry = snapshot.child("Country").getValue(String.class);
                if (userCountry != null) {
                    updateComparisonUI(userCountry, totalEmission[0]);
                }
                else {
                    comparisonText.setText("Country information not available.");
                }
            }
            else {
                Toast.makeText(this, "Failed to retrieve user data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateComparisonUI(String country, double total) {
        TextView comparisonText = findViewById(R.id.comparisonText);

        double nationalAverage = emissionsMap.getOrDefault(country, -1.0);
        if (nationalAverage == -1.0) {
            comparisonText.setText(String.format("Data unavailable for %s. Unable to compare your footprint.", country));
        } else {
            double percentageBelow = ((nationalAverage - total / 1000) / nationalAverage) * 100;
            comparisonText.setText(String.format(Locale.getDefault(),
                    "Your footprint is %.2f%% %s the national average for %s.\nYour footprint %s global targets for climate change!",
                    Math.abs(percentageBelow),
                    (percentageBelow > 0 ? "below" : "above"),
                    country,
                    (percentageBelow > 0 ? "meets" : "does not meet")));
        }
    }

    private void populateEmissionsMap() {
        emissionsMap.put("afghanistan", 0.29536375);
        emissionsMap.put("africa", 0.99422127);
        emissionsMap.put("albania", 1.7432004);
        emissionsMap.put("algeria", 3.9272263);
        emissionsMap.put("andorra", 4.6171236);
        emissionsMap.put("angola", 0.45155162);
        emissionsMap.put("anguilla", 8.752724);
        emissionsMap.put("antigua and barbuda", 6.4218745);
        emissionsMap.put("argentina", 4.2378173);
        emissionsMap.put("armenia", 2.3045583);
        emissionsMap.put("aruba", 8.133404);
        emissionsMap.put("asia", 4.611434);
        emissionsMap.put("asia (excl. china and india)", 4.017375);
        emissionsMap.put("australia", 14.985412);
        emissionsMap.put("austria", 6.8781943);
        emissionsMap.put("azerbaijan", 3.6746833);
        emissionsMap.put("bahamas", 5.1708703);
        emissionsMap.put("bahrain", 25.672274);
        emissionsMap.put("bangladesh", 0.5964455);
        emissionsMap.put("barbados", 4.3772573);
        emissionsMap.put("belarus", 6.1669006);
        emissionsMap.put("belgium", 7.6875386);
        emissionsMap.put("belize", 1.7894346);
        emissionsMap.put("benin", 0.631487);
        emissionsMap.put("bermuda", 6.9370627);
        emissionsMap.put("bhutan", 1.3489918);
        emissionsMap.put("bolivia", 1.7583066);
        emissionsMap.put("bonaire sint eustatius and saba", 4.083284);
        emissionsMap.put("bosnia and herzegovina", 6.1034565);
        emissionsMap.put("botswana", 2.838951);
        emissionsMap.put("brazil", 2.2454574);
        emissionsMap.put("british virgin islands", 5.0039577);
        emissionsMap.put("brunei", 23.950201);
        emissionsMap.put("bulgaria", 6.8044534);
        emissionsMap.put("burkina faso", 0.26295447);
        emissionsMap.put("burundi", 0.06194545);
        emissionsMap.put("cambodia", 1.1900775);
        emissionsMap.put("cameroon", 0.34292704);
        emissionsMap.put("canada", 14.249212);
        emissionsMap.put("cape verde", 0.9588915);
        emissionsMap.put("central african republic", 0.040548485);
        emissionsMap.put("chad", 0.13367727);
        emissionsMap.put("chile", 4.3041654);
        emissionsMap.put("china", 7.992761);
        emissionsMap.put("colombia", 1.9223082);
        emissionsMap.put("comoros", 0.49327007);
        emissionsMap.put("congo", 1.2447897);
        emissionsMap.put("cook islands", 3.9950094);
        emissionsMap.put("costa rica", 1.5226681);
        emissionsMap.put("cote d'ivoire", 0.41668788);
        emissionsMap.put("croatia", 4.348515);
        emissionsMap.put("cuba", 1.8659163);
        emissionsMap.put("curacao", 9.189007);
        emissionsMap.put("cyprus", 5.616782);
        emissionsMap.put("czechia", 9.3357525);
        emissionsMap.put("democratic republic of congo", 0.036375992);
        emissionsMap.put("denmark", 4.940161);
        emissionsMap.put("djibouti", 0.40418932);
        emissionsMap.put("dominica", 2.1058853);
        emissionsMap.put("dominican republic", 2.1051137);
        emissionsMap.put("east timor", 0.49869007);
        emissionsMap.put("ecuador", 2.3117273);
        emissionsMap.put("egypt", 2.333106);
        emissionsMap.put("el salvador", 1.2174718);
        emissionsMap.put("equatorial guinea", 3.0307202);
        emissionsMap.put("eritrea", 0.18914719);
        emissionsMap.put("estonia", 7.77628);
        emissionsMap.put("eswatini", 1.0527312);
        emissionsMap.put("ethiopia", 0.15458965);
        emissionsMap.put("europe", 6.8578663);
        emissionsMap.put("europe (excl. eu-27)", 7.886797);
        emissionsMap.put("europe (excl. eu-28)", 8.817789);
        emissionsMap.put("european union (27)", 6.1743994);
        emissionsMap.put("european union (28)", 5.983708);
        emissionsMap.put("faroe islands", 14.084624);
        emissionsMap.put("fiji", 1.1550449);
        emissionsMap.put("finland", 6.5267396);
        emissionsMap.put("france", 4.603891);
        emissionsMap.put("french polynesia", 2.8509297);
        emissionsMap.put("gabon", 2.3882635);
        emissionsMap.put("gambia", 0.2847278);
        emissionsMap.put("georgia", 2.962545);
        emissionsMap.put("germany", 7.9837584);
        emissionsMap.put("ghana", 0.6215505);
        emissionsMap.put("greece", 5.7451057);
        emissionsMap.put("greenland", 10.473997);
        emissionsMap.put("grenada", 2.7133646);
        emissionsMap.put("guatemala", 1.0756185);
        emissionsMap.put("guinea", 0.35742033);
        emissionsMap.put("guinea-bissau", 0.15518051);
        emissionsMap.put("guyana", 4.3736935);
        emissionsMap.put("haiti", 0.21119381);
        emissionsMap.put("high-income countries", 10.132565);
        emissionsMap.put("honduras", 1.0696708);
        emissionsMap.put("hong kong", 4.081913);
        emissionsMap.put("hungary", 4.449911);
        emissionsMap.put("iceland", 9.499798);
        emissionsMap.put("india", 1.9966822);
        emissionsMap.put("indonesia", 2.6456614);
        emissionsMap.put("iran", 7.7993317);
        emissionsMap.put("iraq", 4.024638);
        emissionsMap.put("ireland", 7.7211185);
        emissionsMap.put("israel", 6.208912);
        emissionsMap.put("italy", 5.726825);
        emissionsMap.put("jamaica", 2.2945588);
        emissionsMap.put("japan", 8.501681);
        emissionsMap.put("jordan", 2.0301995);
        emissionsMap.put("kazakhstan", 13.979704);
        emissionsMap.put("kenya", 0.45998666);
        emissionsMap.put("kiribati", 0.5184742);
        emissionsMap.put("kosovo", 4.830646);
        emissionsMap.put("kuwait", 25.578102);
        emissionsMap.put("kyrgyzstan", 1.4251612);
        emissionsMap.put("laos", 3.0803475);
        emissionsMap.put("latvia", 3.561689);
        emissionsMap.put("lebanon", 4.3543963);
        emissionsMap.put("lesotho", 1.3594668);
        emissionsMap.put("liberia", 0.1653753);
        emissionsMap.put("libya", 9.242238);
        emissionsMap.put("liechtenstein", 3.8097827);
        emissionsMap.put("lithuania", 4.606163);
        emissionsMap.put("low-income countries", 0.28005043);
        emissionsMap.put("lower-middle-income countries", 1.777996);
        emissionsMap.put("luxembourg", 11.618432);
        emissionsMap.put("macao", 1.5127679);
        emissionsMap.put("madagascar", 0.14871116);
        emissionsMap.put("malawi", 0.10262384);
        emissionsMap.put("malaysia", 8.576508);
        emissionsMap.put("maldives", 3.2475724);
        emissionsMap.put("mali", 0.31153768);
        emissionsMap.put("malta", 3.1035979);
        emissionsMap.put("marshall islands", 3.6353714);
        emissionsMap.put("mauritania", 0.957337);
        emissionsMap.put("mauritius", 3.2697906);
        emissionsMap.put("mexico", 4.0153365);
        emissionsMap.put("micronesia (country)", 1.3243006);
        emissionsMap.put("moldova", 1.6565942);
        emissionsMap.put("mongolia", 11.150772);
        emissionsMap.put("montenegro", 3.6558185);
        emissionsMap.put("montserrat", 4.8447766);
        emissionsMap.put("morocco", 1.8263615);
        emissionsMap.put("mozambique", 0.24274588);
        emissionsMap.put("myanmar", 0.6445672);
        emissionsMap.put("namibia", 1.5399038);
        emissionsMap.put("nauru", 4.1700416);
        emissionsMap.put("nepal", 0.5074035);
        emissionsMap.put("netherlands", 7.1372175);
        emissionsMap.put("new caledonia", 17.641167);
        emissionsMap.put("new zealand", 6.212154);
        emissionsMap.put("nicaragua", 0.79879653);
        emissionsMap.put("niger", 0.116688);
        emissionsMap.put("nigeria", 0.5891771);
        emissionsMap.put("niue", 3.8729508);
        emissionsMap.put("north america", 10.5346775);
        emissionsMap.put("north america (excl. usa)", 4.741475);
        emissionsMap.put("north korea", 1.9513915);
        emissionsMap.put("north macedonia", 3.6245701);
        emissionsMap.put("norway", 7.5093055);
        emissionsMap.put("oceania", 9.85179);
        emissionsMap.put("oman", 15.730261);
        emissionsMap.put("pakistan", 0.84893465);
        emissionsMap.put("palau", 12.123921);
        emissionsMap.put("palestine", 0.6660658);
        emissionsMap.put("panama", 2.699258);
        emissionsMap.put("papua new guinea", 0.77131313);
        emissionsMap.put("paraguay", 1.3299496);
        emissionsMap.put("peru", 1.7891879);
        emissionsMap.put("philippines", 1.3014648);
        emissionsMap.put("poland", 8.106886);
        emissionsMap.put("portugal", 4.050785);
        emissionsMap.put("qatar", 37.601273);
        emissionsMap.put("romania", 3.739777);
        emissionsMap.put("russia", 11.416899);
        emissionsMap.put("rwanda", 0.112346195);
        emissionsMap.put("saint helena", 3.2986484);
        emissionsMap.put("saint kitts and nevis", 4.708081);
        emissionsMap.put("saint lucia", 2.6149206);
        emissionsMap.put("saint pierre and miquelon", 10.293288);
        emissionsMap.put("saint vincent and the grenadines", 2.2964725);
        emissionsMap.put("samoa", 1.1218625);
        emissionsMap.put("sao tome and principe", 0.5816142);
        emissionsMap.put("saudi arabia", 18.197495);
        emissionsMap.put("senegal", 0.6738352);
        emissionsMap.put("serbia", 6.024712);
        emissionsMap.put("seychelles", 6.1495123);
        emissionsMap.put("sierra leone", 0.13124847);
        emissionsMap.put("singapore", 8.911513);
        emissionsMap.put("sint maarten (dutch part)", 14.352394);
        emissionsMap.put("slovakia", 6.051555);
        emissionsMap.put("slovenia", 5.9979916);
        emissionsMap.put("solomon islands", 0.41232163);
        emissionsMap.put("somalia", 0.03676208);
        emissionsMap.put("south africa", 6.7461643);
        emissionsMap.put("south america", 2.4865332);
        emissionsMap.put("south korea", 11.598764);
        emissionsMap.put("south sudan", 0.1680176);
        emissionsMap.put("spain", 5.1644425);
        emissionsMap.put("sri lanka", 0.7936504);
        emissionsMap.put("sudan", 0.4696261);
        emissionsMap.put("suriname", 5.8029985);
        emissionsMap.put("sweden", 3.6069093);
        emissionsMap.put("switzerland", 4.0478554);
        emissionsMap.put("syria", 1.2490375);
        emissionsMap.put("taiwan", 11.630868);
        emissionsMap.put("tajikistan", 1.0064901);
        emissionsMap.put("tanzania", 0.23771806);
        emissionsMap.put("thailand", 3.7762568);
        emissionsMap.put("togo", 0.2910665);
        emissionsMap.put("tonga", 1.7686282);
        emissionsMap.put("trinidad and tobago", 22.423758);
        emissionsMap.put("tunisia", 2.879285);
        emissionsMap.put("turkey", 5.1052055);
        emissionsMap.put("turkmenistan", 11.03418);
        emissionsMap.put("turks and caicos islands", 7.636793);
        emissionsMap.put("tuvalu", 1.0004411);
        emissionsMap.put("uganda", 0.12744623);
        emissionsMap.put("ukraine", 3.5578535);
        emissionsMap.put("united arab emirates", 25.833244);
        emissionsMap.put("united kingdom", 4.7201805);
        emissionsMap.put("united states", 14.949616);
        emissionsMap.put("upper-middle-income countries", 6.2268133);
        emissionsMap.put("uruguay", 2.3060381);
        emissionsMap.put("uzbekistan", 3.4830604);
        emissionsMap.put("vanuatu", 0.6363055);
        emissionsMap.put("venezuela", 2.7168686);
        emissionsMap.put("vietnam", 3.4995174);
        emissionsMap.put("wallis and futuna", 2.2819076);
        emissionsMap.put("world", 4.658219);
        emissionsMap.put("yemen", 0.33701748);
        emissionsMap.put("zambia", 0.44570068);
        emissionsMap.put("zimbabwe", 0.542628);
    }

    private String getAnswer(DataSnapshot snapshot, String key) {
        String value = snapshot.child(key).getValue(String.class);
        return value != null ? value : "No answer";
    }
}
