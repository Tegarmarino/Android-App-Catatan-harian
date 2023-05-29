package com.tema.catatanharian;

public class Note {
    private String title;
    private String content;

    public Note() {
    }

//    Constructor note
//    Menerima judul dan konten sebagai parameter dan menginisialisasi properti.
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

//    Getter dan setter
//    Memungkinkan akses ke properti private judul dan konten catatan.
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
