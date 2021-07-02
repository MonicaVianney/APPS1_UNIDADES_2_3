package com.example.eva3_14_asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mostrar = findViewById(R.id.txtMostrar);
        MiClaseAsincrona miClaseAsincrona = new MiClaseAsincrona();
        miClaseAsincrona.execute(10,500);
        //15 --> BANNER ASYNTASKS
        //16 --> LOAD_IMAGE_ASYNTASKS
    }

    class MiClaseAsincrona extends AsyncTask <Integer,String,Void>{

        @Override
        protected void onPreExecute() { //SI PUEDEN INTERACTUAR CON LA UI
            super.onPreExecute();
            mostrar.append("INICIANDO LA TAREA ASINCRONA!!! \n");
        }

        @Override
        protected void onPostExecute(Void s) {
            super.onPostExecute(s);
            mostrar.append("FIN DE LA TAREA ASINCRONA \n");
        }

        @Override
        protected void onProgressUpdate(String... values) { //SI PUEDEN INTERACTUAR CON LA UI
            super.onProgressUpdate(values);
            mostrar.append(values[0]);
        }

        @Override //NO SE PUEDE INTERACTUAR CON LA UI
        protected Void doInBackground(Integer... integers) { //EQUIVALENTE AL METODO RUN() EN UN THREAD
            int limite = integers[0], time = integers[1];
            for (int i = 0; i < limite; i++){
                try {
                    Thread.sleep(time);
                    publishProgress("i = "+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}