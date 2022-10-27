package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private TextView tvNama;
    private TextView tvTempatLahir;
    private TextView tvTanggalLahir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvNama = findViewById(R.id.textView);
        tvNama.setText(getIntent().getExtras().getString("nama"));
        tvTempatLahir = findViewById(R.id.textView4);
        tvTempatLahir.setText(getIntent().getExtras().getString("tempatLahir"));
        tvTanggalLahir = findViewById(R.id.textView7);
        tvTanggalLahir.setText(getIntent().getExtras().getString("tanggalLahir"));
    }

    @Override
    public void onBackPressed() {
        Intent iMain = new Intent(this, MainActivity.class);
        startActivity(iMain);
        finish();
    }
}