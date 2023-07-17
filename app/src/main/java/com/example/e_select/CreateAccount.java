package com.example.e_select;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    public void GoToHome(View view) {
        Intent intent = new Intent(CreateAccount.this, HomePage.class);
        startActivity(intent);
        finish();
    }
}