package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailedActivityListActivity extends AppCompatActivity {

    private TextView tvDetailedActivityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_activity_list);

        // Initialize UI component
        tvDetailedActivityList = findViewById(R.id.tvDetailedActivityList);
        Button closeButton = findViewById(R.id.closeButton);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(DetailedActivityListActivity.this, EmissionDisplayActivity.class);
                startActivity(in);
            }
        });

        // Get the activity list data from the intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("activityList")) {
            String activityList = intent.getStringExtra("activityList");
            tvDetailedActivityList.setText(activityList);
        } else {
            tvDetailedActivityList.setText("No activities recorded for today.");
        }
    }
}