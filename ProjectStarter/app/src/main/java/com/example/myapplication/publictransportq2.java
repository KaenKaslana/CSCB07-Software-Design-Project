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

public class publictransportq2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_publictransportq2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FirebaseAuth database = FirebaseAuth.getInstance();
        String userId = database.getCurrentUser().getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Users").child(userId);

        Button never, occa, freq, always, hardly;

        never = findViewById(R.id.opt1);

        occa = findViewById(R.id.opt2);

        freq = findViewById(R.id.opt3);

        always = findViewById(R.id.opt4);

        hardly = findViewById(R.id.opt0);

        hardly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Ptq2").setValue("Under 1h");
                Intent i = new Intent(publictransportq2.this, airtravelq1.class);
                startActivity(i);
            }
        });

        never.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Ptq2").setValue("1-3h");
                Intent i = new Intent(publictransportq2.this, airtravelq1.class);
                startActivity(i);
            }
        });

        occa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Ptq2").setValue("3-5h");
                Intent i = new Intent(publictransportq2.this, airtravelq1.class);
                startActivity(i);
            }
        });

        freq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Ptq2").setValue("5-10h");
                Intent i = new Intent(publictransportq2.this, airtravelq1.class);
                startActivity(i);
            }
        });

        always.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Ptq2").setValue("More than 10h");
                Intent i = new Intent(publictransportq2.this, airtravelq1.class);
                startActivity(i);
            }
        });


    }
}