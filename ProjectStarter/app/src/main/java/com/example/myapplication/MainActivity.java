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

/*The page user sees when first time downloading and entering the app
Branch off of this project and integrate your parts into it
Team Sign_UP: Focus on the function for the button sign up
Team Log_in: Focus on the function for the button log in
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = findViewById(R.id.loginButton);
        Button signup = findViewById(R.id.signupButton);
        Button ecoTracker = findViewById(R.id.buttonEcoTracker);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to execute when the button is clicked
                //Replace SecondActivity.class with the java file for Log_in class
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to execute when the button is clicked
                //Replace ThirdActivity.class with the java file for Log_in class
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        ecoTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to execute when the Eco Tracker button is clicked
                Intent intent = new Intent(MainActivity.this, EmissionDisplayActivity.class);
                startActivity(intent);
            }
        });
    }
}