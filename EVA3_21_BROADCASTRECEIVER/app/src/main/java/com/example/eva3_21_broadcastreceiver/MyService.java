package com.example.eva3_21_broadcastreceiver;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import java.io.BufferedReader;

public class MyService extends Service {

    Thread hilo;
    Intent datos;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        hilo = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    try {
                        Thread.sleep(1000);
                        //Log.wtf("SERVICIO", "MENSAJE");

                        //ENVIAR MENSAJES
                        datos = new Intent("MI_MENSAJE");
                        datos.putExtra("MENSAJE", "onStart");


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        hilo.start();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        datos = new Intent("MI_MENSAJE");
        datos.putExtra("MENSAJE", "onCreate");
        sendBroadcast(datos);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        datos = new Intent("MI_MENSAJE");
        datos.putExtra("MENSAJE", "onDestroy");
        hilo.interrupt();
    }
}