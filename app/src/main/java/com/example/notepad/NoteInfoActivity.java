package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.notepad.models.Note;

public class NoteInfoActivity extends AppCompatActivity implements View.OnClickListener {
    EditText title, description, urlArea;
    ImageView image;
    SwitchCompat isFav;
    Button showImage, save;
    TextView cancel;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_info);
        Intent intent = getIntent();
        index = intent.getIntExtra("noteindex", 0);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        image = findViewById(R.id.image);
        isFav = findViewById(R.id.add_to_fav);
        showImage = findViewById(R.id.show_img);
        save = findViewById(R.id.save);
        cancel = findViewById(R.id.cancel);
        isFav.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.add_to_fav) {
            if (isFav.isChecked()) {

            }
        }
    }
}