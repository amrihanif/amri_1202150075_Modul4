package com.example.amrihanif.amri_1202150075_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.LoginFilter;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button Lmahasiswa, Pgambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lmahasiswa = (Button)findViewById(R.id.listmahasiswa);
        Pgambar = (Button)findViewById(R.id.pencarigambar);

        Lmahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, ListMahasiswa.class);
                startActivity(a);
            }
        });

        Pgambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(MainActivity.this, PencariGambar.class);
                startActivity(b);
            }
        });
    }
}
