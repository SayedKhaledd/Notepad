package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        skip = findViewById(R.id.skip);
        skip.setOnClickListener(this);
        Intent in = getIntent();
        String username = in.getStringExtra("username");
        Toast.makeText(this, username, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.skip) {
            Toast.makeText(this, "Skipped!!!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, NotepadActivity.class);
            this.startActivity(intent);
            finish();
        }
    }
}