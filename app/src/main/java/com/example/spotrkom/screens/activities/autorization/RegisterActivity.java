package com.example.spotrkom.screens.activities.autorization;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.spotrkom.R;

public class RegisterActivity extends AppCompatActivity {

    private TextView tvCreateAccount;
    private EditText etUserName;
    private EditText etEmail;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tvCreateAccount = findViewById(R.id.tvCreateAccount);
        tvCreateAccount.setPaintFlags(tvCreateAccount.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void onClickBack(View view) {
        finish();
    }

    public void onClickLogIn(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void onClickSignIn(View view) {
        String userName = etUserName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if (!userName.isEmpty() && !email.isEmpty() && !password.isEmpty()){

        } else {

        }
    }
}