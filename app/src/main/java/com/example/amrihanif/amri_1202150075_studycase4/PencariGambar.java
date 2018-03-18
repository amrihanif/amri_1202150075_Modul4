package com.example.amrihanif.amri_1202150075_studycase4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import java.io.InputStream;
import java.net.URL;

public class PencariGambar extends AppCompatActivity {
    Button Cari;
    EditText Link;
    ImageView Gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencari_gambar);

        Cari = (Button)findViewById(R.id.cari);
        Gambar = (ImageView)findViewById(R.id.image);
        Link = (EditText)findViewById(R.id.url);

        Cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //memanggil method yang sudah dibuat
                new tampilGambar().execute();
            }
        });
    }

    class tampilGambar extends AsyncTask<Void, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(Void... voids) {
            //mengubah url menjadi string
            String URL = Link.getText().toString();

            Bitmap bmp = null;
            try {
                //mendecode url tadi agar bisa dicari
                bmp = BitmapFactory.decodeStream((InputStream)new URL(URL).getContent());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bmp;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            //menampilkan gambar yang sudah dicari
            Gambar.setImageBitmap(bitmap);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }
}
