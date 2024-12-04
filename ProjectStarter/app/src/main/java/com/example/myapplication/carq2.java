package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class carq2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_carq2);
        Button k5, k10, k15, k20, k25, more;
        k5 = findViewById(R.id.atq1no);
        k10 = findViewById(R.id.ptq12);
        k15 = findViewById(R.id.ptq15);
        k20 = findViewById(R.id.ptq110);
        k25 = findViewById(R.id.ptq1more);
        more = findViewById(R.id.carq2more);
        FirebaseAuth database = FirebaseAuth.getInstance();
        String userId = database.getCurrentUser().getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Users").child(userId);
        k5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Carq2").setValue("0-5k");
                Intent intent = new Intent(carq2.this, publictransportq1.class);
                startActivity(intent);
            }
        });

        k10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Carq2").setValue("5k-10k");
                Intent intent = new Intent(carq2.this, publictransportq1.class);
                startActivity(intent);
            }
        });

        k15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Carq2").setValue("10k-15k");
                Intent intent = new Intent(carq2.this, publictransportq1.class);
                startActivity(intent);
            }
        });

        k20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Carq2").setValue("15k-20k");
                Intent intent = new Intent(carq2.this, publictransportq1.class);
                startActivity(intent);
            }
        });

        k25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Carq2").setValue("20k-25k");
                Intent intent = new Intent(carq2.this, publictransportq1.class);
                startActivity(intent);
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Carq2").setValue("More than 25k");
                Intent intent = new Intent(carq2.this, publictransportq1.class);
                startActivity(intent);
            }
        });


    }
}