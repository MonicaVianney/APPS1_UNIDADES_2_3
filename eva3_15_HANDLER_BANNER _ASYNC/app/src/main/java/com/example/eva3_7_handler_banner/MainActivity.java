package com.example.eva3_7_handler_banner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {


    ImageView view;
    SeekBar barrita;
    int[] imgs;
    int speed;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speed = 250;
        barrita = findViewById(R.id.seek);
        barrita.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                speed = 250 + progress*8;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        view= findViewById(R.id.banner);


        imgs = new int[]{
            R.drawable.f1,
            R.drawable.f2,
            R.drawable.f3
        };
        clase c = new clase();
        c.execute();
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
            view.setImageResource(imgs[contador]);
            if (contador < 2)
                contador++;
            else
                contador = 0;
            //img.setImageBitmap(decscargar(values[0]));

        }

        @Override
        protected Void doInBackground(Integer... integers) {
            publishProgress("");
            while (true){
                try {
                    Thread.sleep(speed);
                    onProgressUpdate("");


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}