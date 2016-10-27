package com.example.ujiantengahsemester;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by kyky on 24/10/2016.
 */

public class AdapterData extends BaseAdapter {
    private static ArrayList<RincianData> lisData;
    private LayoutInflater layout;
    private Context context;
    //Kontruktor
    public  AdapterData(Context context,
                              ArrayList<RincianData>results){

        lisData = results;
        layout = LayoutInflater.from(context);
        this.context = context;

    }
    public int getCount(){
        return lisData.size();
    }
    public Object getItem(int position){
        return lisData.get(position);
    }
    public long getItemId(int position){
        return position;
    }
    public View getView(final int position, View cV, ViewGroup parent) {
        final ViewData vd;
        if (cV == null) {
            cV = layout.inflate(R.layout.detail, null);
            vd = new ViewData();
            vd.imageViewMakanan = (ImageView) cV.findViewById(R.id.imageViewMakanan);
            vd.textViewMakanan = (TextView) cV.findViewById(R.id.textViewMakanan);
            vd.textViewHarga = (TextView) cV.findViewById(R.id.textViewHarga);
            vd.checkBox = (CheckBox)cV.findViewById(R.id.cek);
            vd.checkBox.setOnCheckedChangeListener((MainActivity)context);
            cV.setTag(vd);
        }
        else {
            vd = (ViewData) cV.getTag();
        }

        vd.imageViewMakanan.setImageResource(
                MainActivity.ID_MAKANAN[lisData.get(position)
                        .perolehIdGambar() - 1]);
        vd.textViewHarga.setText(lisData.get(position).perolehHarga());
        vd.textViewMakanan.setText(lisData.get(position).perolehMakanan());
        vd.checkBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                boolean isChecked = vd.checkBox.isChecked();
                vd.textViewHarga.setText(lisData.get(position).perolehHarga());
//                String[] hargaa = new String[lisData.size()];

                SharedPreferences pref = context.getApplicationContext().getSharedPreferences("PREFS",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                String message = vd.textViewHarga.getText().toString();

                if(isChecked==true){
                    switch(position) {
                        case 0:
                            editor.putString("HargaMakanan1", message);
                            editor.commit();
                            break;
                        case 1:
                            editor.putString("HargaMakanan2", message);
                            editor.commit();
                            break;
                        case 2:
                            editor.putString("HargaMakanan3", message);
                            editor.commit();
                        case 3:
                            editor.putString("HargaMakanan4", message);
                            editor.commit();
                        case 4:
                            editor.putString("HargaMakanan5", message);
                            editor.commit();
                        default:
                    }
                    Toast.makeText(context,"Nomor"+position+"Dipilih", Toast.LENGTH_SHORT).show();
                }
                else {
                    switch(position) {
                        case 0:
                            editor.remove("HargaMakanan1");
                            editor.commit();
                            break;
                        case 1:
                            editor.remove("HargaMakanan2");
                            editor.commit();
                            break;
                        case 2:
                            editor.remove("HargaMakanan3");
                            editor.commit();
                        case 3:
                            editor.remove("HargaMakanan4");
                            editor.commit();
                        case 4:
                            editor.remove("HargaMakanan5");
                            editor.commit();
                        default:
                    }
                    Toast.makeText(context, "Nomor"+position+"Dihapus", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return cV;
    }



    static class ViewData{
        ImageView imageViewMakanan;
        TextView textViewMakanan;
        TextView textViewHarga;
        CheckBox checkBox;
        Button btnpesan;
    }
}
