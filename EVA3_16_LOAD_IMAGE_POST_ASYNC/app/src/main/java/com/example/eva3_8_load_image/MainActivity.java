package com.example.eva3_8_load_image;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);
        clase c = new clase();

        c.execute();
    }


    private Bitmap descargas(){
        try {
            InputStream i = (InputStream)new URL("https://www.purina-latam.com/sites/g/files/auxxlc391/files/styles/social_share_large/public/purina-10-datos-curiosos-sobre-los-gatos.png?itok=88pMyzkl").getContent();
            Bitmap bit = BitmapFactory.decodeStream(i);
            return bit;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    class clase extends AsyncTask<Integer,String,Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            img.setImageBitmap(bitmap);

        }

        @Override
        protected Void doInBackground(Integer... integers) {
            bitmap = descargas();
            publishProgress("");

            return null;
        }
    }
}