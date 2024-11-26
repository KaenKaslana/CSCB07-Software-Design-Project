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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class q1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseAuth database = FirebaseAuth.getInstance();
        String userId = database.getCurrentUser().getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Users").child(userId);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_q1);
        Button yes = findViewById(R.id.q1y);
        Button no = findViewById(R.id.q1n);
       yes.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ref.child("Q1").setValue("Yes");
               Intent intent = new Intent(q1.this, carq1.class);
               startActivity(intent);
           }
       });

       no.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ref.child("Q1").setValue("No");
               ref.child("Carq1").setValue("No answer");
               ref.child("Carq2").setValue("No answer");
               Intent intent = new Intent(q1.this, publictransportq1.class);
               startActivity(intent);
           }
       });
    }
}