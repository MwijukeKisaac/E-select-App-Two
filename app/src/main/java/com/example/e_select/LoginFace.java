package com.example.e_select;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginFace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_face);
    }

    public void GotoFP(View view) {
        Intent intent = new Intent(LoginFace.this, ForgotPassword.class);
        startActivity(intent);
    }

    public void GoToCreate(View view) {
        Intent intent = new Intent(LoginFace.this, CreateAccount.class);
        startActivity(intent);
    }

    public void GoToHome(View view) {
        Intent intent = new Intent(LoginFace.this, HomePage.class);
        startActivity(intent);
        finish();
    }
}