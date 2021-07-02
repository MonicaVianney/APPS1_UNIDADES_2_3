package com.example.eva2_1_intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String TEL = "tel:555";

    Intent intel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickDial(View v){
        //AQUÍ MARCAMOS PERO NO LLAMAMOS
        intel = new Intent(Intent.ACTION_DIAL, Uri.parse(TEL));
        startActivity(intel);


    }
    public void onClickCall(View v){
        //AQUÍ LLAMAMOS DIRECTAMENTE
        intel = new Intent(Intent.ACTION_CALL, Uri.parse(TEL));
        startActivity(intel);

    }

    public void onClickCont(View v){
        String sData = "content://contacts/people/";
        intel = new Intent(Intent.ACTION_VIEW, Uri.parse(sData));
        startActivity(intel);
    }

    public void onClickInter(View v){
        String myUriString = "https://www.youtube.com/watch?v=_1lXdLus2WI";
        intel = new Intent(Intent.ACTION_VIEW, Uri.parse(myUriString));
        startActivity(intel);
    }

}