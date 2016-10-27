package com.example.ujiantengahsemester;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by kyky on 27/10/2016.
 */

public class pesanActivity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pesan_layout);

        SharedPreferences pref = getSharedPreferences("PREFS",1);
        SharedPreferences.Editor editor = pref.edit();

        String harga1 = pref.getString("HargaMakanan1",null);
        String harga2 = pref.getString("HargaMakanan2",null);
        String harga3 = pref.getString("HargaMakanan3",null);
        String harga4 = pref.getString("HargaMakanan4",null);
        String harga5 = pref.getString("HargaMakanan5",null);


        TextView tv1 =(TextView)findViewById(R.id.tvharga1);
        TextView tv2 =(TextView)findViewById(R.id.tvharga2);
        TextView tv3 =(TextView)findViewById(R.id.tvharga3);
        TextView tv4 =(TextView)findViewById(R.id.tvharga4);
        TextView tv5 =(TextView)findViewById(R.id.tvharga5);

        tv1.setText(harga1);
        tv2.setText(harga2);
        tv3.setText(harga3);
        tv4.setText(harga4);
        tv5.setText(harga5);

        if(harga1!=null){
            tv1.setVisibility(View.VISIBLE);
        }
        if(harga2!=null){
            tv2.setVisibility(View.VISIBLE);
        }
        if(harga3!=null){
            tv3.setVisibility(View.VISIBLE);
        }
        if(harga4!=null){
            tv4.setVisibility(View.VISIBLE);
        }
        if(harga5!=null){
            tv5.setVisibility(View.VISIBLE);
        }

        editor.commit();
    }
}
