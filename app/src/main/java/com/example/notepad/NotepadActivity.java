package com.example.notepad;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.notepad.models.Note;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.InputStream;


public class NotepadActivity extends AppCompatActivity implements View.OnClickListener {
    Button add;
    TextView textView;
    int numberOfNotes = 0;
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);
        Intent intent = getIntent();
        Note note = (Note) intent.getSerializableExtra("note");
        Log.d("TAG", "onCreateView: " + (note != null ? note.getTitle() : "null"));


        bottomNavigation = findViewById(R.id.navigation_bar);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavigation, navController);
//        add = findViewById(R.id.button);
//        textView = findViewById(R.id.text);
//        add.setOnClickListener(this);
//        textView.setText(textView.getText().toString() + " " + numberOfNotes);
//        if (savedInstanceState != null) {
//            byteArray = savedInstanceState.getByteArray("bytes");
//            Log.d("TAG", "onCreate: " + byteArray == null ? "null" : ("not null" + "and with length" + byteArray.length));
//
//            Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//            imageView.setImageBitmap(bmp);
//        }


    }


    @Override
    public void onClick(View view) {
//        if (view.getId() == R.id.button) {
//            Intent intent = new Intent(this, NotepadTextActivity.class);
//            startActivityForResult(intent, 1);
//
//        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            numberOfNotes++;
            textView.setText("number of notes " + numberOfNotes);
        }
    }


//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
////        byteArray = savedInstanceState.getByteArray("bytes");
////        Log.d("TAG", "onCreate: " + byteArray == null ? "null" : ("not null" + "and with length" + byteArray.length));
////
////        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
////        imageView.setImageBitmap(bmp);
//    }
//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState, outPersistentState);
////        Log.d("TAG", "onSaveInstanceState: " + byteArray == null ? "null" : "not null");
////        outState.putByteArray("bytes", byteArray);
//
//    }
}