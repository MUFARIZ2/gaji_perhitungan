package com.example.gaji_perhitungan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gaji_perhitungan.R;

public class MainActivity extends AppCompatActivity {
    private EditText inNama;
    private TextView hasilNama, hasilStatus, hasilGolongan;
    private TextView hasilGaji;
    private CheckBox menikah;

    private CheckBox lajang;
    private RadioGroup grupGol;
    private RadioButton golA;
    private RadioButton golB;
    private Button btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        btnHitung = findViewById(R.id.btnHitung);
        inNama = findViewById(R.id.inNama);
        menikah = findViewById(R.id.cbMenikah);
        lajang = findViewById(R.id.cbLajang);
        grupGol = findViewById(R.id.grupGol);
        golA = findViewById(R.id.radioA);
        golB = findViewById(R.id.radioB);
        hasilNama = findViewById(R.id.hasilNama);
        hasilStatus= findViewById(R.id.hasilStatus);
        hasilGolongan = findViewById(R.id.hasilGolongan);
        hasilGaji = findViewById(R.id.hasilGaji);

        String status = "";


        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung();
            }
        });
    }
    private void hitung(){
        String nama = inNama.getText().toString();
        if(nama.isEmpty()){
            Toast.makeText(this, "Masukan Nama", Toast.LENGTH_SHORT).show();
            return;
        }

//    memilih golongan
        int gaji;
        String golongan;
        if(golA.isChecked()){
            gaji = 10000000;
            golongan = "Golongan A";
        }else if(golB.isChecked()){
            gaji = 7000000;
            golongan = "Golongan B";
        }else{
            Toast.makeText(this, "Pilih Golongan", Toast.LENGTH_SHORT).show();
            return;
        }

        //status
        String status;
        if(menikah.isChecked()){
            status = "Menikah";
        }else if(lajang.isChecked()){
            status = "lajang";
        }else {
            Toast.makeText(this, "Pilih Status", Toast.LENGTH_SHORT).show();
            return;
        }

        //set text
        inNama.setText("");
        hasilNama.setText("Nama : " + nama);
        hasilStatus.setText("Status : " + status);
        hasilGolongan.setText("Golongan : " + golongan);
        hasilGaji.setText("Golongan : " + gaji);

    }

}