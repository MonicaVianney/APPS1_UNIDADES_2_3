package com.example.eva3_7_handler_banner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {


    ImageView view;
    Thread hilo;
    SeekBar bar;
    int[] imgs;
    int speed;
    int c = 0;
    Handler manej = new Handler();
    Runnable fore = new Runnable() {
        @Override
        public void run() {
            view.setImageResource(imgs[c]);
            if (c < 2)
                c++;
            else
                c = 0;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        speed = 250;
        bar = findViewById(R.id.seek);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){


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

        hilo = new Thread(){
            @Override
            public void run() {
                super.run();

                while (true){
                    try {
                        Thread.sleep(speed);
                        manej.post(fore);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        imgs = new int[]{
            R.drawable.f1,
            R.drawable.f2,
            R.drawable.f3
        };
        hilo.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        hilo.interrupt();
    }
}