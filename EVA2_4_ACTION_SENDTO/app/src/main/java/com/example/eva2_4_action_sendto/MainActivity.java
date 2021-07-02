package com.example.eva2_4_action_sendto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText txtTel, txtMsj;
    Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTel = findViewById(R.id.editTelefono);
        txtMsj = findViewById(R.id.editMensaje);
        enviar = findViewById(R.id.btnEnviar);
        enviar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String sTel, sMensa;
        sTel = "smsto:" + txtTel.getText().toString();
        sMensa = txtMsj.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(sTel));
        intent.putExtra("sms_body", sMensa);
        startActivity(intent);

    }
}