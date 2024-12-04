package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class foodq1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_foodq1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        FirebaseAuth database = FirebaseAuth.getInstance();
        String userId = database.getCurrentUser().getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Users").child(userId);

        Button never, occa, freq, always;

        never = findViewById(R.id.opt1);

        occa = findViewById(R.id.opt2);

        freq = findViewById(R.id.opt3);

        always = findViewById(R.id.opt4);

        never.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Foodq1").setValue("Vegetarian");
                ref.child("Meatq1").setValue("No answer");
                ref.child("Meatq2").setValue("No answer");
                ref.child("Meatq3").setValue("No answer");
                ref.child("Meatq4").setValue("No answer");
                Intent i = new Intent(foodq1.this, wasteq.class);
                startActivity(i);
            }
        });

        occa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Foodq1").setValue("Vegan");
                ref.child("Meatq1").setValue("No answer");
                ref.child("Meatq2").setValue("No answer");
                ref.child("Meatq3").setValue("No answer");
                ref.child("Meatq4").setValue("No answer");
                Intent i = new Intent(foodq1.this, wasteq.class);
                startActivity(i);
            }
        });

        freq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Foodq1").setValue("Pescatarian");
                ref.child("Meatq1").setValue("No answer");
                ref.child("Meatq2").setValue("No answer");
                ref.child("Meatq3").setValue("No answer");
                ref.child("Meatq4").setValue("No answer");
                Intent i = new Intent(foodq1.this, wasteq.class);
                startActivity(i);
            }
        });

        always.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Foodq1").setValue("Meat-based");
                Intent i = new Intent(foodq1.this, meatq1.class);
                startActivity(i);
            }
        });


    }
}