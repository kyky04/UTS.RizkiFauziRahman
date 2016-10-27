package com.example.ujiantengahsemester;

/**
 * Created by kyky on 24/10/2016.
 */

public class RincianData {
    private String nama_makanan;
    private String harga;
    private String deskripsi;
    private int idGambar;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    private boolean checked = false ;


    //Konstruktor
    public RincianData(String nama_makanan,
                       String harga,
                       String deskripsi,
                       int idGambar) {
        this.nama_makanan = nama_makanan;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.idGambar = idGambar;
    }

    public String perolehMakanan() {
        return nama_makanan;
    }

    public String perolehHarga() {
        return harga;
    }

    public String perolehDeksripsi() {
        return deskripsi;
    }
    public int perolehIdGambar(){
        return idGambar;
    }

//    public boolean isSelected() {
//        return selected;
//    }
//
//    public void setSelected(boolean selected) {
//        this.selected = selected;
//    }
}







