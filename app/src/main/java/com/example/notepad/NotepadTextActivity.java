package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.PrecomputedTextCompat;
import androidx.room.Room;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.CursorJoiner;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.notepad.fragments.HomeFragment;
import com.example.notepad.models.Note;

import java.util.Date;

import javax.xml.transform.Result;

public class NotepadTextActivity extends AppCompatActivity implements View.OnClickListener, CheckBox.OnCheckedChangeListener {
    Button save, download;
    EditText title, description, urlArea;
    CheckBox checkBox;
    ImageView imageView;
    static byte[] byteArray;
    AppDatabase db;
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            byteArray = intent.getByteArrayExtra("bytes");
            Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            imageView.setImageBitmap(bmp);


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad_text);
        save = findViewById(R.id.save);
        title = findViewById(R.id.title);
        urlArea = findViewById(R.id.url_area);
        checkBox = findViewById(R.id.checkbox);
        download = findViewById(R.id.downlaod);
        checkBox.setOnCheckedChangeListener(this);
        download.setOnClickListener(this);
        save.setOnClickListener(this);
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").fallbackToDestructiveMigration().allowMainThreadQueries().build();

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.save) {
            if (!title.getText().toString().equals("")) {
                Intent intent = new Intent(this, NotepadActivity.class);
                Note note = new Note();
                note.setTitle(title.getText().toString());
                note.setDate("22/5/2020");
                note.setFav(false);
                addToDatabase(note);
                startActivity(intent);
                finish();
            }
        } else if (view.getId() == R.id.downlaod) {
            Intent intent = new Intent(NotepadTextActivity.this, MyIntentService.class);
            intent.putExtra("url", urlArea.getText().toString());
            startService(intent);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.notepad");
        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (b) {
            urlArea.setVisibility(View.VISIBLE);
            download.setVisibility(View.VISIBLE);
        } else {
            urlArea.setVisibility(View.GONE);
            download.setVisibility(View.GONE);
        }
    }

    public void addToDatabase(Note note) {
        class AddNote extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                AppDatabase.getInstance(getApplicationContext()).getDatabase()
                        .noteDao()
                        .insert(note);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

            }
        }
        AddNote addNote = new AddNote();
        addNote.execute();
    }
}