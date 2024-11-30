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

public class airtravelq1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_airtravelq1);
        Button none, one, five, ten, more;
        none = findViewById(R.id.atq1no);
        one = findViewById(R.id.ptq12);
        five = findViewById(R.id.ptq15);
        ten = findViewById(R.id.ptq110);
        more = findViewById(R.id.ptq1more);

        FirebaseAuth database = FirebaseAuth.getInstance();
        String userId = database.getCurrentUser().getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Users").child(userId);

        none.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Atq1").setValue("None");
                Intent i = new Intent(airtravelq1.this, airtravelq2.class);
                startActivity(i);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Atq1").setValue("1-2");
                Intent i = new Intent(airtravelq1.this, airtravelq2.class);
                startActivity(i);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Atq1").setValue("3-5");
                Intent i = new Intent(airtravelq1.this, airtravelq2.class);
                startActivity(i);
            }
        });

        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Atq1").setValue("6-10");
                Intent i = new Intent(airtravelq1.this, airtravelq2.class);
                startActivity(i);
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref.child("Atq1").setValue("More than 10");
                Intent i = new Intent(airtravelq1.this, airtravelq2.class);
                startActivity(i);
            }
        });
    }
}