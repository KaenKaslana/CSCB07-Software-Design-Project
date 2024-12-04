package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

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
        VideoView videoView = findViewById(R.id.natureVideo);

// Create a URI for the natureWalk.mp4 file
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.naturevideo);

// Set the video URI
        videoView.setVideoURI(uri);

// Set an OnPreparedListener to mute the video
        videoView.setOnPreparedListener(mp -> {
            mp.setVolume(0f, 0f); // Mute the video
        });

// Set the video to loop by restarting it on completion
        videoView.setOnCompletionListener(mp -> videoView.start());

// Start the video playback
        videoView.start();



        FirebaseAuth.getInstance().signOut();

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
    }
}