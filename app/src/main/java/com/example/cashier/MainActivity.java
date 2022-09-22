package com.example.cashier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nama = findViewById(R.id.editNama);
        EditText harga = findViewById(R.id.editHargaStruk);
        EditText jumlah = findViewById(R.id.editJumlah);
        EditText total = findViewById(R.id.editTotal);
        EditText bayar = findViewById(R.id.editBayar);
        Button hitung = findViewById(R.id.btnHitung);
        Button clear = findViewById(R.id.btnClear);
        Button proses = findViewById(R.id.btnProses);
        Intent passData = new Intent(this, StrukActivity.class);

        hitung.setOnClickListener(view -> {
            if (harga.length() == 0 && jumlah.length() == 0)
                Toast.makeText(getApplication(), "Masukkan harga dan jumlah!", Toast.LENGTH_LONG).show();
            else if (harga.length() == 0)
                Toast.makeText(getApplication(), "Masukkan harga!", Toast.LENGTH_LONG).show();
            else if (jumlah.length() == 0)
                Toast.makeText(getApplication(), "Masukkan jumlah!", Toast.LENGTH_LONG).show();
            else {
                double hargaDbl = Double.parseDouble(harga.getText().toString());
                double jumlahDbl = Double.parseDouble(jumlah.getText().toString());
                double hasil = hargaDbl * jumlahDbl;

                total.setText(String.valueOf(hasil));
            }
        });

        proses.setOnClickListener(view -> {
            if (
                    nama.length() == 0
                    && harga.length() == 0
                    && jumlah.length() == 0
                    && total.length() == 0
                    && bayar.length() == 0
            ) Toast.makeText(getApplication(), "Isi Semua Field!", Toast.LENGTH_LONG).show();

            else {
                String namaStr = nama.getText().toString();
                String hargaStr = harga.getText().toString();
                String jumlahStr = jumlah.getText().toString();
                String totalStr = total.getText().toString();
                String bayarStr = bayar.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("NAMA", namaStr);
                bundle.putString("HARGA", hargaStr);
                bundle.putString("JUMLAH", jumlahStr);
                bundle.putString("TOTAL", totalStr);
                bundle.putString("BAYAR", bayarStr);
                passData.putExtras(bundle);
                startActivity(passData);
            }
        });

        clear.setOnClickListener(view -> {
            nama.getText().clear();
            harga.getText().clear();
            jumlah.getText().clear();
            total.getText().clear();
            bayar.getText().clear();
        });
    }

}