package com.example.eva3_7_handler_banner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imgVw;
    Thread tBanner;
    int iCont=0;
    //A TRAVES DE UN HANDLER MESSAGE INTERACTUAR CON LA INTERFAZ GRAFICA (UI)
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //INTERACTUAR CON LA UI
            Toast.makeText(getApplicationContext(),"FUNCIONA",Toast.LENGTH_SHORT).show();
            int image;
            if (iCont ==0){
                image = R.drawable.f1;
                iCont++;
            }else if(iCont==1){
                image = R.drawable.f2;
                iCont++;
            }else {
                image = R.drawable.f3;
                iCont=0;
            }
            imgVw.setImageResource(image);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVw = findViewById(R.id.imgVw);
        tBanner = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    try {
                        Thread.sleep(1000);
                        //SOLICITAR UN MENSAJE
                        Message message = handler.obtainMessage();
                        //ENVIAR EL MENSAJE
                        handler.sendMessage(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        tBanner.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tBanner.interrupt();
    }
}