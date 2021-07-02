package com.example.eva3_9_handler_post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mostrar;
    Thread thread;
    Handler handler = new Handler();


    //TRABAJO PESADO EN SEGUNDO PLANO
    Runnable background = new Runnable() {
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                    handler.post(foreground);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                    break;
                }
            }
        }
    };

    //TRABAJO CON LA UI
    Runnable foreground = new Runnable() {
        @Override
        public void run() {
            mostrar.append("Hola mundo \n" );
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mostrar = findViewById(R.id.txtMostrar);
        thread = new Thread(background);
        thread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }
}