package com.example.eva2_6_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    final static int CODIGO_SECUN = 1000;
    final static int CODIGO_CONTACTOS = 2000;
    final static int CODIGO_IMAGENES = 3000;

    Button btnSecundaria;
    Intent intent, intentCont, intentImg;

   /* Uri[] uriProvider = {
            Uri.parse("content://media/external/audio/media"),
            Uri.parse("content://media/external/images/media"),
            ContactsContract.Contacts.CONTENT_URI,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
            MediaStore.Video.Media.EXTERNAL_CONTENT_URI,

    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, Secundaria.class);
        intentCont = new Intent(Intent.ACTION_PICK, android.provider.ContactsContract.Contacts.CONTENT_URI);
        intentImg = new Intent(Intent.ACTION_PICK, Uri.parse("content://media/external/images/media"));

    }

    @Override
    protected void onStart() {
        super.onStart();
        btnSecundaria = findViewById(R.id.btnSecundaria);
        btnSecundaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("DATOS", "Información enviada desde principal!!");
                startActivityForResult(intent,CODIGO_SECUN);

            }
        });
    }
     public void onClickBoton2(View view){
        if(view.getId() == R.id.boton2)
            startActivityForResult(intentCont, CODIGO_CONTACTOS);
        else {
            startActivityForResult(intentImg, CODIGO_IMAGENES);
        }

     }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //AQUI PROCESAMOS LA RESPUESTA DE LA ACTIVIDAD
        //1. IDENTIFICAR LA ACTIVIDAD QUE DEVOLVIÓ EL RESULTADO
        //IDENTIFICAR SI SE DEVOLVIÓ UN VALOR O NO
        //LEER LOS DATOS (INTENT)
        switch (requestCode){
            case CODIGO_SECUN:
                if (resultCode == Activity.RESULT_OK){ //SI ME DEVOLVIÓ UN VALOR
                    //LEER LOS DATOS
                    Toast.makeText(this, data.getStringExtra("VALOR"), Toast.LENGTH_LONG).show();
                }

                break;
                /*case CODIGO_SECUN un case para cada actividad que devuelve un valor*/
            case CODIGO_CONTACTOS:
                if(resultCode == Activity.RESULT_OK){
                    String returnedData = data.getDataString();
                    Toast.makeText(this, returnedData, Toast.LENGTH_LONG).show();
                }
                break;
            case CODIGO_IMAGENES:
                if(resultCode == Activity.RESULT_OK){
                    String returnedData = data.getDataString();
                    Toast.makeText(this, returnedData, Toast.LENGTH_LONG).show();
                }
                break;

            default:
        }
    }
}