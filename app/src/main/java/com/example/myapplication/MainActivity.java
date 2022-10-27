package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvNama;
    private TextView tvTempatLahir;
    private TextView tvTanggalLahir;
    private EditText etNama;
    private EditText etTanggalLahir;
    private EditText etTempatLahir;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.et_nama);
        etTanggalLahir = findViewById(R.id.et_tanggalLahir);
        etTempatLahir = findViewById(R.id.et_tempatLahir);
        btnSubmit = findViewById(R.id.btn_submit);

        tvNama = findViewById(R.id.textView);
        tvTempatLahir = findViewById(R.id.textView4);
        tvTanggalLahir = findViewById(R.id.textView7);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_submit){
            String inputNama = etNama.getText().toString();
            String inputTempatLahir = etTempatLahir.getText().toString();
            String inputTanggalLahir = etTanggalLahir.getText().toString();

            boolean isEmptyFields = false;
            if (inputNama.isEmpty()){
                isEmptyFields = true;
                etNama.setError("Field ini tidak boleh kosong");
            }
            if (inputTempatLahir.isEmpty()){
                isEmptyFields = true;
                etTempatLahir.setError("Field ini tidak boleh kosong");
            }
            if (inputTanggalLahir.isEmpty()){
                isEmptyFields = true;
                etTanggalLahir.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields){
                openActivity2();
            }
        }
    }

    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("nama", etNama.getText().toString());
        intent.putExtra("tempatLahir", etTempatLahir.getText().toString());
        intent.putExtra("tanggalLahir", etTanggalLahir.getText().toString());
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Exit App");
        alertDialog.setMessage("Yakin ingin keluar aplikasi?");
        alertDialog.setPositiveButton("Nggih", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        alertDialog.setNegativeButton("Mboten", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
}