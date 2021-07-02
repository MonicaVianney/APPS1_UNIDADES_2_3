package com.example.eva3_8_load_image;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceActivity;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
ImageView imgVwLoad;

Bitmap bitmap;
Handler handler=new Handler(){
    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);//aqui cambiaremos la imagen
        imgVwLoad.setImageBitmap(bitmap);
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwLoad=findViewById(R.id.imgVwLoad);
        //Meterla dentro de un hilo de ejecucion
        Thread thread= new Thread(){
            @Override
            public void run() {
                super.run();
                //se hace la conexion
                bitmap= descargarImagen( "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Kheops-Pyramid.jpg/1024px-Kheops-Pyramid.jpg");
                Message msg=handler.obtainMessage();
                handler.sendMessage(msg);

            }
        };
       thread.start();
    }

    private Bitmap descargarImagen(String url){
        try {
            InputStream inputStream= (InputStream) new URL(url).getContent();
            Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
            return  bitmap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}