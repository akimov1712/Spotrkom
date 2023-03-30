package com.example.spotrkom.screens.activities.autorization;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.spotrkom.R;

public class LoginActivity extends AppCompatActivity {

    private TextView tvCreateAccount;
    private EditText etEmail;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvCreateAccount = findViewById(R.id.tvCreateAccount);
        tvCreateAccount.setPaintFlags(tvCreateAccount.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
    }

    public void onClickBack(View view) {
        finish();
    }

    public void onClickCreateAccount(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    public void onClickLogin(View view) {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if (!email.isEmpty() && !password.isEmpty()) {

        } else {

        }
    }
}