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

public class houseq7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_houseq7);
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


        never.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Houseq7").setValue("Primarily");
                Intent i = new Intent(houseq7.this, consumptionq1.class);
                startActivity(i);
            }
        });

        occa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Houseq7").setValue("Partially");
                Intent i = new Intent(houseq7.this, consumptionq1.class);
                startActivity(i);
            }
        });

        freq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Houseq7").setValue("No");
                Intent i = new Intent(houseq7.this, consumptionq1.class);
                startActivity(i);
            }
        });
    }
}