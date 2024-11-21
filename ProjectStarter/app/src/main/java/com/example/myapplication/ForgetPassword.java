
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {
    Button send;
    EditText email;
    FirebaseAuth auth;

    String mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);
        send = findViewById(R.id.Send);
        email = findViewById(R.id.EmailAddress);
        auth = FirebaseAuth.getInstance();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail = email.getText().toString().trim();
                if (!TextUtils.isEmpty(mail)) {
                    ResetPassword();
                } else {
                    email.setError("Email cannot be empty!");
                }
            }
        });
    }

    private void ResetPassword(){
        auth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(ForgetPassword.this, "Reset password link has been send to your email!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ForgetPassword.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ForgetPassword.this, "Oops, wrong email, try again please", Toast.LENGTH_SHORT).show();
                    }
                });
        }
    }


