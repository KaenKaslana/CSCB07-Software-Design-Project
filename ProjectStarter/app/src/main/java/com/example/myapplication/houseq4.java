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

public class houseq4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_houseq4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

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
                ref.child("Houseq4").setValue("Natural gas");
                Intent intent = new Intent(houseq4.this, houseq5.class);
                startActivity(intent);
            }
        });

        k10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Houseq4").setValue("Electricity");
                Intent intent = new Intent(houseq4.this, houseq5.class);
                startActivity(intent);
            }
        });

        k15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Houseq4").setValue("Oil");
                Intent intent = new Intent(houseq4.this, houseq5.class);
                startActivity(intent);
            }
        });

        k20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Houseq4").setValue("Propane");
                Intent intent = new Intent(houseq4.this, houseq5.class);
                startActivity(intent);
            }
        });

        k25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Houseq4").setValue("Wood");
                Intent intent = new Intent(houseq4.this, houseq5.class);
                startActivity(intent);
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Houseq4").setValue("Other");
                Intent intent = new Intent(houseq4.this, houseq5.class);
                startActivity(intent);
            }
        });

    }
}