package com.example.cashier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class StrukActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_struk);

        EditText editQuantity = findViewById(R.id.editQuantityStruk);
        EditText editNama = findViewById(R.id.editNamaStruk);
        EditText editHarga = findViewById(R.id.editHargaStruk);
        EditText editTotal = findViewById(R.id.editTotalStruk);
        EditText editBayar = findViewById(R.id.editBayarStruk);
        EditText editKembali = findViewById(R.id.editKembaliStruk);
        Button quit = findViewById(R.id.btnQuitStruk);

        Intent receiveData = getIntent();
        Bundle bundle = receiveData.getExtras();

        String quantityStr = bundle.getString("JUMLAH");
        String namaStr = bundle.getString("NAMA");
        String hargaStr = bundle.getString("HARGA");
        String totalStr = bundle.getString("TOTAL");
        String bayarStr = bundle.getString("BAYAR");

        if (bundle != null) {
            editQuantity.setText(quantityStr);
            editNama.setText(namaStr);
            editHarga.setText(hargaStr);
            editTotal.setText(totalStr);
            editBayar.setText(bayarStr);

            double totalDbl = Double.parseDouble(editTotal.getText().toString());
            double bayarDbl = Double.parseDouble(editBayar.getText().toString());
            double hasil = bayarDbl - totalDbl;
            String hasilStr = String.valueOf(hasil);

            editKembali.setText(hasilStr);
        }

        quit.setOnClickListener(view -> {
            Intent back = new Intent(this, MainActivity.class);
            back.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            back.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            back.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(back);
        });

    }
}