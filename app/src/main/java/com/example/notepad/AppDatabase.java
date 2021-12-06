package com.example.notepad;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notepad.models.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();

    public static AppDatabase instance;


    private static AppDatabase create(Context context) {

        return Room.databaseBuilder(context, AppDatabase.class, "database-name").build();

    }

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    public AppDatabase getDatabase() {
        return instance;
    }
}
