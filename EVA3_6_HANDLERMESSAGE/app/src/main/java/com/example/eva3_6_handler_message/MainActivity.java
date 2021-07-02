package com.example.eva3_6_handler_message;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtMensaje;
    Thread thread;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //AQUI PODEMOS MODIFICAR LA INTERFAZ GRAFICA
            //tiene que ser un trabajo muy ligero
            //trabajo ligero --> una tarea intensa va a trabar la UI
            String cade = (String) msg.obj;
            int what = msg.what;
            txtMensaje.append("El hilo = "+what+" imprime "+cade+"\n");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMensaje = findViewById(R.id.txtMensaje);
        //txtMensaje.setText("HOLA MUNDO CRUEL");

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true){
                    try {
                        Thread.sleep(1000);
                        String cade = "i = " +i;
                        i++;
                       // txtMensaje.append(cade+"\n");
                        //SOLICITAMOS UN MENSAJE
                        //PONER INFO EN EL MENSAJE
                        Message message = handler.obtainMessage(1000, cade);
                        // Y DEVOLVERLO
                        handler.sendMessage(message);
                        Log.wtf("runnable",cade);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }

            }
        };
        thread = new Thread(runnable);
        thread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        thread.interrupt();

    }
}