package com.example.notepad.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notepad.R;
import com.example.notepad.listeners.NotesOnClickListener;
import com.example.notepad.models.Note;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private ArrayList<Note> notes;
    private NotesOnClickListener notesOnClickListener;
    private Context mContext;

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    public NotesAdapter(ArrayList<Note> notes, NotesOnClickListener notesOnClickListener, Context mContext) {
        this.notes = notes;
        this.notesOnClickListener = notesOnClickListener;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(notes.get(position).getTitle());
        holder.date.setText(notes.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, date;
        ConstraintLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            parent = itemView.findViewById(R.id.parent);
            parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Note note = notes.get(getAdapterPosition());
                    notesOnClickListener.noteOnClickListener(note);
                }
            });
        }
    }
}
