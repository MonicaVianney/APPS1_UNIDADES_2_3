package com.example.eva3_2_multitarea_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //THREAD -> CLASE > PARA CREAR HILOS
        //RUNNABLE -> INTERFAZ

        Thread miHilo = new Thread(){
            //AQUI VAN LAS TAREAS EN SEGUNDO PLANO
            @Override
            public void run() {
                super.run();
                for(int i = 0; i < 10; i++){
                    try {
                        Thread.sleep(100);/* DETIENE LA EJECUCIÓN DEL HILO ACTUAL */
                        Log.wtf("HILO PRINCIPAL", "i = "+(i+1));
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();

                    }
                }
            }
        };
        miHilo.start();
        MiHilote miHilote = new MiHilote();
        miHilote.start();
    }
}

class MiHilote extends Thread{
    @Override
    public void run() {
        super.run();
        for(int x = 0; x < 10; x++){
            try {
                Thread.sleep(100);/* DETIENE LA EJECUCIÓN DEL HILO ACTUAL */
                Log.wtf("HILO MiHilote", "x = "+(x+1));
            }
            catch (InterruptedException e){
                e.printStackTrace();

            }
        }
    }
}