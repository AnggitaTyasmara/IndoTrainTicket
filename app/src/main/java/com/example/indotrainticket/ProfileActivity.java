package com.example.indotrainticket;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.indotrainticket.R;
import com.example.indotrainticket.database.DatabaseHelper;
import com.example.indotrainticket.session.SessionManager;

import java.util.HashMap;

public class ProfileActivity extends AppCompatActivity {
//deklarasi semua komponen yang diperlukan pada activity profile
    protected Cursor cursor;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    SessionManager session;
    String name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //memanggil database haelper
        dbHelper = new DatabaseHelper(this);
        //membuat session
        session = new SessionManager(getApplicationContext());
        //mengambil detail data user
        HashMap<String, String> user = session.getUserDetails();
        email = user.get(SessionManager.KEY_EMAIL);

        db = dbHelper.getReadableDatabase();
        //detail data yang diambil adalah email dari TB_USER
        cursor = db.rawQuery("SELECT * FROM TB_USER WHERE username = '" + email + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            name = cursor.getString(2);
        }

        TextView lblName = findViewById(R.id.lblName);
        TextView lblEmail = findViewById(R.id.lblEmail);

        lblName.setText(name);
        lblEmail.setText(email);

        setupToolbar();

    }
    //membuat setup dan memberi judul pada header/panel
    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.tbProfile);
        toolbar.setTitle("Identitas Pemesan");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //untuk menampilkan tombol tindakan back pada panel
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}