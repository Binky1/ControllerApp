package com.example.finalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import android.util.Patterns;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText email = findViewById(R.id.EmailSignUp);
        EditText password = findViewById(R.id.PasswordSignUp);
        EditText confirmPassword = findViewById(R.id.ConfirmPasswordSignUp);
        Button SignUpButton = findViewById(R.id.SignUpButton);

        SignUpButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Code to be executed when the button is clicked
                if(checkInput(email, password, confirmPassword)){
                    email.setBackgroundColor(4);
                }
                else{
                    password.setBackgroundResource(Color.RED);
                }
            }
        });
    }
    private boolean checkInput(EditText email, EditText password, EditText confirmPassword){
        if (!isValidEmail(email.getText().toString())){
            return false;
        }
        else if(!(password.getText().toString().equals(confirmPassword.getText().toString()) && password.getText().toString().length() < 50)){
            return false;
        }
        return true;
    }

    private boolean isValidEmail(CharSequence email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}