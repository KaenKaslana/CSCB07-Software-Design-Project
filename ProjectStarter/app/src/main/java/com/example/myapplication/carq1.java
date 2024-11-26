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

public class carq1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_carq1);
        Button gas, diesel, hybrid, electric, dunno;
        gas = findViewById(R.id.ptq12);
        diesel = findViewById(R.id.ptq15);
        hybrid = findViewById(R.id.ptq110);
        electric = findViewById(R.id.ptq1more);
        dunno = findViewById(R.id.atq1no);
        FirebaseAuth database = FirebaseAuth.getInstance();
        String userId = database.getCurrentUser().getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Users").child(userId);

        gas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Carq1").setValue("Gasoline");
                Intent intent = new Intent(carq1.this, carq2.class);
                startActivity(intent);
            }
        });
        diesel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Carq1").setValue("Diesel");
                Intent intent = new Intent(carq1.this, carq2.class);
                startActivity(intent);
            }
        });
        hybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Carq1").setValue("Hybrid");
                Intent intent = new Intent(carq1.this, carq2.class);
                startActivity(intent);
            }
        });

        electric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Carq1").setValue("Electric");
                Intent intent = new Intent(carq1.this, carq2.class);
                startActivity(intent);
            }
        });

        dunno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Carq1").setValue("No answer");
                Intent intent = new Intent(carq1.this, carq2.class);
                startActivity(intent);
            }
        });

    }
}