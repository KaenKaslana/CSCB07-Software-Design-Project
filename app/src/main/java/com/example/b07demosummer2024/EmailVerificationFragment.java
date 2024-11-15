package com.example.b07demosummer2024;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class EmailVerificationFragment extends Fragment {

    private EditText editTextVerificationCode;
    private Button buttonVerify;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_email_verification, container, false);

        // Initialize UI elements
        editTextVerificationCode = view.findViewById(R.id.editTextVerificationCode);
        buttonVerify = view.findViewById(R.id.buttonVerify);

        // Set up the Verify button click listener
        buttonVerify.setOnClickListener(v -> {
            String code = editTextVerificationCode.getText().toString().trim();
            if (code.isEmpty()) {
                Toast.makeText(getActivity(), "Please enter the verification code", Toast.LENGTH_SHORT).show();
            } else {
                // Here you would validate the verification code
                // For now, just display a success message
                Toast.makeText(getActivity(), "Verification successful!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
