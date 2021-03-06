package com.example.indotrainticket;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.indotrainticket.R;
import com.example.indotrainticket.adapter.AlertDialogManager;
import com.example.indotrainticket.session.SessionManager;

public class MainActivity extends AppCompatActivity {
//Deklarasi semua komponen yang di gunakan pada halaman menu
    AlertDialogManager alert = new AlertDialogManager();
    SessionManager session;
    Button btnLogout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //membuat session untuk mengecek login
        session = new SessionManager(getApplicationContext());
        session.checkLogin();

        btnLogout = findViewById(R.id.out);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            //membuat fungsi on click untuk tombol logut
            @Override
            public void onClick(View arg0) {
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        //jika tombol di klik akan memunculkan opsi untuk logout
                        .setTitle("Anda yakin ingin keluar ?")
                        //jika di tekan Ya maka akan menuju ke halaman login
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                session.logoutUser();
                            }
                        })
                        //jika di tekan tidak terjadi aksi, halaman akan tetap di menu utama
                        .setNegativeButton("Tidak", null)
                        .create();
                dialog.show();
            }
        });
    }
    //methode untuk menuju ke halaman profil
    public void profileMenu(View v) {
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);
    }
    //methode untuk menuju ke halaman history booking
    public void historyMenu(View v) {
        Intent i = new Intent(this, HistoryActivity.class);
        startActivity(i);
    }
    //methode untuk menuju ke halaman boking tiket kereta
    public void bookKereta(View v) {
        Intent i = new Intent(this, BookKeretaActivity.class);
        startActivity(i);
    }
}