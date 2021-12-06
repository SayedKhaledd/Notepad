package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.notepad.models.Note;

public class NoteInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_info);
        Intent intent = getIntent();
        Note note = (Note) intent.getSerializableExtra("note");
        Log.d("TAG", "onCreateView: " + (note != null ? note.getTitle() : "null"));

    }
}