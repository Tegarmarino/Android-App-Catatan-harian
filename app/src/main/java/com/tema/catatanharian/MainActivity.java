package com.tema.catatanharian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NoteAdapter noteAdapter;

//    Penggunaan Arraylist sebagai strutur data
    private ArrayList<Note> noteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        noteAdapter = new NoteAdapter(noteList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(noteAdapter);

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddNoteDialog();
            }
        });

        Button deleteAllButton = findViewById(R.id.deleteAllButton);
        deleteAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAllNotes();
            }
        });
    }


//    Menampilkan dialog untuk menambahkan catatan baru.
//    Dialog menggunakan AlertDialog untuk memungkinkan pengguna memasukkan judul dan konten catatan baru.
    private void showAddNoteDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Tambah Catatan");

        View view = LayoutInflater.from(this).inflate(R.layout.dialog_add_note, null);
        final EditText titleEditText = view.findViewById(R.id.titleEditText);
        final EditText contentEditText = view.findViewById(R.id.contentEditText);

        builder.setView(view);
        builder.setPositiveButton("Tambah", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String title = titleEditText.getText().toString();
                String content = contentEditText.getText().toString();

                Note note = new Note(title, content);
                noteList.add(note);
                noteAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Batal", null);

        builder.create().show();
    }


//    Menghapus semua catatan dari daftar (noteList) dan memberi tahu adapter untuk memperbarui tampilan.
    private void deleteAllNotes() {
        noteList.clear();
        noteAdapter.notifyDataSetChanged();
    }
}
