package com.example.amrihanif.amri_1202150075_studycase4;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListMahasiswa extends AppCompatActivity {
    private String[] list = {
            "Amri",
            "Hanif",
            "Dina",
            "Dino",
            "Dito"
    };
    ListView listNama;
    Button mulai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        listNama = (ListView)findViewById(R.id.list);
        mulai = (Button)findViewById(R.id.btn);

        //Untuk meng get data dari array
        listNama.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>()));

        mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Memanggil method yang dibuat
                new taskNama().execute();
            }
        });
    }


    class taskNama extends AsyncTask<Void, String, String> {
        ArrayAdapter<String> adapter;
        int count;
        ProgressDialog pg;
        @Override
        protected void onPreExecute() {
            //membuat proggress dialog dan sekaligus menampilkan data
            adapter = (ArrayAdapter<String>)listNama.getAdapter();
            pg = new ProgressDialog(ListMahasiswa.this);
            pg.setTitle("ambil data");
            pg.setProgressStyle(pg.STYLE_HORIZONTAL);
            pg.setMax(10);
            pg.setProgress(0);
            pg.show();
            count = 0;
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
            pg.hide();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
            count++;
            pg.setProgress(count);
        }

        @Override
        protected String doInBackground(Void... voids) {
            //menampilkan data array
            for (String listmhsw : list) {
                publishProgress(listmhsw);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "sudah muncul semua";
        }
    }
}