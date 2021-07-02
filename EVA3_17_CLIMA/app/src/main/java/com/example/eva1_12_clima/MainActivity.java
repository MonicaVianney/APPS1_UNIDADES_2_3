package com.example.eva1_12_clima;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    /*clima[] aClimacd = {
            new clima (R.drawable.cloudy, "Chihuahua",28, "Despejado con viento"),
            new clima (R.drawable.rainy, "Cuauhtémoc",28, "Lluvioso"),
            new clima (R.drawable.snow, "Madera",28, "Nevado"),
            new clima (R.drawable.sunny, "Parral",28, "Soleado asqueroso"),
            new clima (R.drawable.thunderstorm, "Batopilas",28, "Tormenta"),
            new clima (R.drawable.tornado, "Urique",28, "ASUMAQUINA"),
            new clima (R.drawable.light_rain, "Guachochi",28, "Bonito"),
            new clima (R.drawable.atmospher, "Meoqui",28, "No c"),
            new clima (R.drawable.cloudy, "Ciudad Juárez",28, "Nubes chulas"),
            new clima (R.drawable.cloudy, "Villa Ahumada",28, "Despejado con viento"),
            new clima (R.drawable.cloudy, "Creel",28, "Despejado con viento"),
            new clima (R.drawable.cloudy, "Jiménez",28, "Despejado con viento"),
            new clima (R.drawable.cloudy, "Camargo",28, "Despejado con viento"),
            new clima (R.drawable.cloudy, "Ojinaga",28, "Despejado con viento"),
            new clima (R.drawable.cloudy, "Casas Grandes",28, "A veces")
    };*/

    List<clima> lstCiudades = new ArrayList<>();

    ListView listClima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        listClima = findViewById(R.id.listClima);
        //listClima.setAdapter(new climaAdaptador(this, R.layout.mi_lista_clima,aClimacd));
        conexionClima cc = new conexionClima();
        cc.execute("http://api.openweathermap.org/data/2.5/find?lat=28.6&lon=-106&cnt=30&units=metric&appid=9d9383277424eff840278c89d55f243c");
    }
                                            //URL NADA  JSON(STRING)
    class conexionClima extends AsyncTask<String, Void, String>{

        //AQUI VAMOS A HACER LA CONEXION (TRABAJO EN SEGUNDO PLANO)
        @Override
        protected String doInBackground(String... strings) {
            String sUrl = strings[0];
            String sResu = null;
            //HttpURLConnection
            try {
                URL url = new URL(sUrl);
                //aqui se realiza la conexion
                HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
                //aqui verificamos si la conexion fue exitosa
                if (httpCon.getResponseCode() == HttpURLConnection.HTTP_OK){
                    //AQUI ES COMO LEER UN ARCHIVO DE TEXTO
                    InputStreamReader isReader = new InputStreamReader(httpCon.getInputStream());
                    BufferedReader bufferDatos = new BufferedReader(isReader);
                    sResu = bufferDatos.readLine();

                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sResu;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Log.wtf("CONEXION", s);
            if(!(s.equals("") || s == null)){ //verificamos que tengamos una respuesta
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    //RECUPERAR EL ARREGLO DE CIUDADES
                    JSONArray jsonArrayCiudades = jsonObject.getJSONArray("list");
                    for (int i = 0; i < jsonArrayCiudades.length(); i++){
                        JSONObject jsonCiudad = jsonArrayCiudades.getJSONObject(i); //RECUPERAR UNA CIUDAD PARTICULAR
                        //LEER CIUDAD POR CIUDAD
                        clima climaCiudad = new clima();
                        climaCiudad.setCiudad(jsonCiudad.getString("name"));
                        JSONObject jsonmain = jsonCiudad.getJSONObject("main");
                        climaCiudad.setTemp(jsonmain.getDouble("temp"));
                        JSONArray jsaWeather = jsonCiudad.getJSONArray("weather");
                        //TOMAMOS EL PRIMER ELEMENTO
                        JSONObject climaActual = jsaWeather.getJSONObject(0);
                        climaCiudad.setDesc(climaActual.getString("description"));
                        int id = climaActual.getInt("id");
                        if(id <300){
                            climaCiudad.setImagen(R.drawable.thunderstorm);
                        } else if(id < 400){//lluvia ligera
                            climaCiudad.setImagen(R.drawable.light_rain);
                        }else if(id < 600){//lluvioso
                            climaCiudad.setImagen(R.drawable.rainy);
                        }else if (id < 700){//nieve
                            climaCiudad.setImagen(R.drawable.snow);
                        }else if (id < 801){//cielo despejado
                            climaCiudad.setImagen(R.drawable.sunny);
                        }else if(id < 900){
                            climaCiudad.setImagen(R.drawable.cloudy);
                        }else {
                            climaCiudad.setImagen(R.drawable.tornado);
                        }
                        lstCiudades.add(climaCiudad);
                    }
                    listClima.setAdapter(new climaAdaptador(MainActivity.this, R.layout.mi_lista_clima,lstCiudades));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}