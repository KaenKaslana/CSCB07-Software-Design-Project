package com.example.myapplication;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    Presenter presenter;

    EditText password;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        password = (EditText) findViewById(R.id.loginPassword);
        email = (EditText) findViewById(R.id.loginEmail);
        presenter = new Presenter(this, new Model());
        Button login, forget, back;
        login = findViewById(R.id.loginButton);
        forget = findViewById(R.id.ForgotPasswordButton);
        back =findViewById(R.id.closeButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.handleLogIn();
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.resetPass();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.back();
            }
        });

    }


    public String getEmail(){
        return email.getText().toString();
    }

    public String getPassword(){
        return password.getText().toString();
    }

    public void startNew(){
        Intent i = new Intent(LoginActivity.this, intro.class);
        startActivity(i);
    }

    public void forgerPassword(){
        Intent i = new Intent(LoginActivity.this, ForgetPassword.class);
        startActivity(i);
    }

    public void back(){
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void displayMessage(String message){
        EditText text = findViewById(R.id.error);
        text.setText(message);
    }


}