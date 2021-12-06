package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username, password;
    Button login;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.log_in_btn);
        error = findViewById(R.id.error_txt);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.log_in_btn) {
            String usernameText = username.getText().toString();
            String passwordText = password.getText().toString();
            if (usernameText.equals(Constants.username) && passwordText.equals(Constants.password)) {
                Toast.makeText(this, "Successful log in", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra("username", usernameText);
                intent.putExtra("password", passwordText);
                this.startActivity(intent);
                finish();
            } else {
                error.setVisibility(View.VISIBLE);
            }
        }
    }
}