package com.example.eva2_6_activity_result;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Secundaria extends AppCompatActivity {

    //Button boton2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        //intent = new Intent();
        intent = getIntent();
        Toast.makeText(this, intent.getStringExtra("DATOS"), Toast.LENGTH_LONG).show();

    }

    public void OnClick(View view){
        intent.putExtra("VALOR","HOLA MUNDO CRUEL");
        setResult(Activity.RESULT_OK, intent);
        finish();

    }

    /*@Override
    protected void onStart() {
        super.onStart();
        boton2 = findViewById(R.id.btn2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }*/
    public void OnClickCancel (View view){
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}