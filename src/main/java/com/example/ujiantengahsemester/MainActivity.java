package com.example.ujiantengahsemester;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, CompoundButton.OnCheckedChangeListener {
    static final public Integer[] ID_MAKANAN = {
            R.drawable.mieayam,
            R.drawable.nasgor,
            R.drawable.sate,
            R.drawable.otak,
            R.drawable.ayampenyet
    };

    ArrayList<RincianData> hasil;

    ListView listViewData;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Cek User apakah sudah login


        final ArrayList<RincianData> listData = perolehData();

        listViewData = (ListView) findViewById(R.id.listViewData);


        final AdapterData adapter = new AdapterData(this, listData);

        listViewData.setAdapter(adapter);
        listViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object terpilih = listViewData.getItemAtPosition(position);
                RincianData rincian = (RincianData) terpilih;
                CheckBox cek = (CheckBox) findViewById(R.id.cek);

                // Bentuk Intent untuk menampilkan detail negara
                Intent intent = new Intent(MainActivity.this, InfoDetail.class);

                Bundle data = new Bundle();
                data.putString("Makanan", rincian.perolehMakanan());
                data.putString("Harga", rincian.perolehHarga());
                data.putString("Deskripsi", rincian.perolehDeksripsi());
                data.putInt("Gambar", rincian.perolehIdGambar());


                intent.putExtras(data);
                startActivityForResult(intent, 1);
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public ArrayList<RincianData> perolehData() {
        hasil = new ArrayList<RincianData>();

        RincianData data;

        data = new RincianData("Mie Ayam", "10.000", "Mie ayam adalah jajanan rakyat yang semakin banyak di jual di perkampungan. Walaupun demikian, mie ayam adalah jajanan sehat serta bergizi. Terkecuali enak, makanan ini mempunyai kandungan gizi yang terbilang komplit, dari mulai karbohidrat, protein, dan gizi yang didapat dari sayuran pelengkap mie ayam.", 1);
        hasil.add(data);

        data = new RincianData("Nasi Goreng", "15.000", "Nasi goreng adalah sebuah makanan berupa nasi yang digoreng dan diaduk dalam minyak goreng atau margarin, biasanya ditambah kecap manis, bawang merah, bawang putih, asam jawa, lada dan bumbu-bumbu lainnya, seperti telur, ayam, dan kerupuk.", 2);
        hasil.add(data);

        data = new RincianData("Sate", "20.000", "Sate adalah hidangan yang sangat populer di Indonesia; dengan berbagai suku bangsa dan tradisi seni memasak (lihat Masakan Indonesia) telah menghasilkan berbagai jenis sate.", 3);
        hasil.add(data);

        data = new RincianData("Otak-Otak", "5.000", "Otak-otak dibuat dari ikan yang diambil dagingnya, kemudian dihaluskan dan dibumbui. Selanjutnya, daging ikan tersebut dimasukkan lagi ke dalam kulit ikan yang kemudian direbus atau dipanggang dalam balutan daun pisang. Makanan ini dapat dimakan tersendiri atau dengan saus asam pedas.", 4);
        hasil.add(data);

        data = new RincianData("Ayam Penyet","8000","Ayam penyet adalah ayam goreng yang penyajiannya dengan cara ditekan-tekan menggunakan ulekan yang dilumuri dengan sambal khusus. Bukan sambal goreng ati ataupun sambal terasi tapi sambal khusus untuk ayam penyet",5);
        hasil.add(data);

        return (hasil);
    }
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, final boolean isChecked) {
        if(isChecked){
            Button btnList = (Button) findViewById(R.id.pesan);
            btnList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this,pesanActivity2.class);
                    startActivity(i);
                }
            });
        }
        else {
            Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
        }

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent i = new Intent(MainActivity.this,MainActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(MainActivity.this,BokingActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
