package com.tema.catatanharian;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    private ArrayList<Note> noteList;

    public NoteAdapter(ArrayList<Note> noteList) {
        this.noteList = noteList;
    }

    public void setNoteList(ArrayList<Note> noteList) {
        this.noteList = noteList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
//    Fungsi onCreateViewHolder
//    Membuat instance NoteViewHolder dan mengembalikannya.
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
//    Fungsi onBindViewHolder
//    Menghubungkan data catatan ke tampilan item_note.xml dalam NoteViewHolder.
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = noteList.get(position);
        holder.bind(note);
    }

    @Override
//    Fungis getItemCount
//    Mengembalikan jumlah item/catatan dalam daftar (noteList).
    public int getItemCount() {
        return noteList.size();
    }

    //    Menghubungkan tampilan item_note.xml dengan data catatan.
    //    Digunakan untuk mengoptimalkan kinerja RecyclerView dengan menghindari pemanggilan findViewById() berulang kali.
    public class NoteViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView contentTextView;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            contentTextView = itemView.findViewById(R.id.contentTextView);
        }

        public void bind(Note note) {
            titleTextView.setText(note.getTitle());
            contentTextView.setText(note.getContent());
        }
    }
}
