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

public class consumptionq3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_consumptionq3);
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
                ref.child("Consq3").setValue("None");
                Intent i = new Intent(consumptionq3.this, consumptionq4.class);
                startActivity(i);
            }
        });

        occa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Consq3").setValue("1");
                Intent i = new Intent(consumptionq3.this, consumptionq4.class);
                startActivity(i);
            }
        });

        freq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Consq3").setValue("2");
                Intent i = new Intent(consumptionq3.this, consumptionq4.class);
                startActivity(i);
            }
        });

        always.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Consq3").setValue("3 or more");
                Intent i = new Intent(consumptionq3.this, consumptionq4.class);
                startActivity(i);
            }
        });
    }
}