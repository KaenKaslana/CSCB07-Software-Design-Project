package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.List;

public class intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseAuth database = FirebaseAuth.getInstance();
        String userId = database.getCurrentUser().getUid();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Users").child(userId);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intro);
        Button next = findViewById(R.id.next);
        EditText input = findViewById(R.id.Input);
        List<String> countryList = Search.readFileFromAssets(this, "Countries.txt");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String count = input.getText().toString().trim().toLowerCase();
            if(countryList.contains(count)){
                ref.child("Country").setValue(count);
                Intent i = new Intent(intro.this, q1.class);
                startActivity(i);
            }else{
                Toast.makeText(intro.this, "Invalid input, try again please", Toast.LENGTH_SHORT).show();
            }
            }
        });


    }
}