package com.example.eva3_21_broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView visualizar;
    Intent iniciarServicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        visualizar = findViewById(R.id.txtVisualizar);
        iniciarServicio = new Intent(this, MyService.class);
        BroadcastReceiver broadcastReceiver = new miBroadcast();
        IntentFilter intentFilter = new IntentFilter("MI_MENSAJE");
        registerReceiver(broadcastReceiver, intentFilter);

    }

    public void iniciar(View view){
        startService(iniciarServicio);
    }

    public void detener(View view){
        stopService(iniciarServicio);

    }

    class miBroadcast extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            visualizar.append(intent.getStringExtra("MENSAJE") + "\n");
        }
    }

}
