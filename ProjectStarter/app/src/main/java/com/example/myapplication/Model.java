package com.example.myapplication;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.CompletableFuture;


public class Model {
    public FirebaseAuth mAuth;
    static int  indicator;


    Model () {
        mAuth = FirebaseAuth.getInstance();
        indicator = -1;
    }

    public interface LoginCallback {
        void onLoginResult(int indicator);
    }

    public void login (String email, String password, Presenter presenter) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    if (user != null && user.isEmailVerified()) {
                        //Login success
                        Log.d(TAG, "signInWithEmail:success");
                        indicator = 1;
                        presenter.handleResult(indicator);
                    } else if (user != null) {
                        mAuth.signOut();
                        indicator = 0;
                        presenter.handleResult(indicator);
                    } else {
                        Log.e(TAG, "signInWithEmail:failure", task.getException());
                        indicator = -1;
                        presenter.handleResult(indicator);
                    }
                }
            }
        });
    }

    public int theInt(int i){
        return i;
    }
}
