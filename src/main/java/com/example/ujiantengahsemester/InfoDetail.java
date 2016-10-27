package com.example.ujiantengahsemester;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InfoDetail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_detail);
        ImageView imageViewGambarBendera = (ImageView) findViewById(
        		R.id.imageViewGambarMakanan);
        TextView textViewNamaMakanan = (TextView) findViewById(
        		R.id.textViewNamaMakanan);
        TextView textViewHarga = (TextView) findViewById(
        		R.id.textViewHargaMakanan);
        TextView textViewDeskripsi = (TextView)findViewById(R.id.tvdeskripsi);


        // Peroleh data
        Bundle data = getIntent().getExtras();
     	String makanan = data.getString("Makanan");
     	String harga = data.getString("Harga");
     	String deskripsi = data.getString("Deskripsi");
     	int idBendera = data.getInt("Gambar");
        boolean cek = data.getBoolean("check");
     	if(cek = true){
            Toast.makeText(this, "Benar"+harga, Toast.LENGTH_SHORT).show();
        }

     	imageViewGambarBendera.setImageResource(
     			MainActivity.ID_MAKANAN[idBendera - 1]);
     	textViewNamaMakanan.setText(makanan);

     	String keterangan = deskripsi;
     	textViewHarga.setText(harga);
        textViewDeskripsi.setText(deskripsi);
     	
        Button tombolTutup = (Button) findViewById(R.id.kembali);
        tombolTutup.setOnClickListener(new View.OnClickListener() {
			
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
	}
}
