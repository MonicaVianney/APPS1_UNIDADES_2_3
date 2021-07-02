package com.example.eva3_1_m;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //linux ---> proceso ---> tiene un hilo de ejecución
        //hilo de ejecucion es una secuencia de instrucciones que un programa va a ejecutar
        //un proceso puede tener multiples hilos
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
}