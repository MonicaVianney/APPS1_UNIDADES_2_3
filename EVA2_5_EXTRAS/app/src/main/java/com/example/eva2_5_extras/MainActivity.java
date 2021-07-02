package com.example.eva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText nombre, salario;
    CheckBox info;
    //RadioButton soltero, casado, divorciado, sinInfo;
    RadioGroup estadoCivil;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, MainActivity2.class);
    }
    public void onClickEnviar(View view){
        intent.putExtra("NOMBRE", nombre.getText().toString());
        Double dSalario = 0.0;
        dSalario = Double.parseDouble(salario.getText().toString());
        intent.putExtra("SALARIO", dSalario);
        intent.putExtra("INFO", info.isChecked());
        intent.putExtra("ESTADO_CIVIL", estadoCivil.getCheckedRadioButtonId());

        startActivity(intent);


    }

    @Override
    protected void onStart() {
        super.onStart();
        nombre = findViewById(R.id.editNombre);
        salario = findViewById(R.id.editSalario);
        info = findViewById(R.id.checkInfo);
        /*soltero = findViewById(R.id.rdSoltero);
        casado = findViewById(R.id.rdCasado);
        divorciado = findViewById(R.id.rdDivorciado);
        sinInfo = findViewById(R.id.rdSinInfo);*/
        estadoCivil = findViewById(R.id.radioEstadoCivil);

    }
}