package com.farid.vsgasharedpref;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editAja;
    Button add,tampil,hapus;
    TextView textaja;
    public static final String Name= "namaKey";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editAja = findViewById(R.id.editsp);
        add = findViewById(R.id.add);
        tampil = findViewById(R.id.tampil);
        hapus = findViewById(R.id.hapus);
        textaja = findViewById(R.id.textaja);

        sharedpreferences = getSharedPreferences("MyPREFERENCES", MODE_PRIVATE);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = editAja.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Name, n);
                editor.apply();
            }
        });
        tampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = sharedpreferences.getString(Name, "");
                textaja.setText(a);
            }
        });
        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editAja.setText("");
                textaja.setText("");
                editor.apply();
            }
        });


    }

}
