package com.example.eva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Intent intent;
    TextView txtDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intent = getIntent();
        String sNom = intent.getStringExtra("NOMBRE");
        Double dSal = intent.getDoubleExtra("SALARIO", 0.0);
        boolean bInfo = intent.getBooleanExtra("INFO", false);
        int Estado = intent.getIntExtra("ESTADO_CIVIL", 0);
        //TextView txtDatos;
        txtDatos = findViewById(R.id.txtDatos);
        txtDatos.append("Nombre: \n" );
        txtDatos.append(sNom + "\n");
        txtDatos.append("Salario: \n" );
        txtDatos.append(dSal + "\n");
        txtDatos.append("Información: \n" );
        if(bInfo)
            txtDatos.append("Con informacion \n");
        else
            txtDatos.append("Sin informacion \n");

        RadioButton rdTemp = findViewById(Estado);
        txtDatos.append("Estado civil: \n");
        txtDatos.append(rdTemp.getText() + "\n");

    }
    public void onClickRegresar(View view){
        finish();

    }
}