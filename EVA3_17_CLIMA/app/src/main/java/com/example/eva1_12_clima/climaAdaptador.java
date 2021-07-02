package com.example.eva1_12_clima;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class climaAdaptador extends ArrayAdapter<clima> {
    private Context context;
    private int layout;
    //private clima[] Ciudades;
    private List<clima> Ciudades;



    public climaAdaptador(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.Ciudades = objects;

    }

    //

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //FILA NO EXISTE
        if(convertView == null){ //PRIMERA VEZ QUE SE MUESTRA LA LISTA, NO EXISTE
            convertView = ((Activity) context).getLayoutInflater().inflate(layout, parent, false);
        }/*else{//FILA EXISTE Y HAY QUE LLENAR


        }*/
        ImageView imgClima;
        TextView txtCd, txtTemp, txtDesc;
        imgClima = convertView.findViewById(R.id.imgClima);
        txtCd = convertView.findViewById(R.id.txtCd);
        txtTemp = convertView.findViewById(R.id.txtTemp);
        txtDesc = convertView.findViewById(R.id.txtDesc);

        //Llenar los widget con datos (arreglo ciudades)
        clima climaCiudad = Ciudades.get(position);
        imgClima.setImageResource(climaCiudad.getImagen());
        txtCd.setText(climaCiudad.getCiudad());
        txtTemp.setText(climaCiudad.getTemp()+" ° C");
        txtDesc.setText(climaCiudad.getDesc());
       /* imgClima.setImageResource(Ciudades[position].getImagen());
        txtCd.setText(Ciudades[position].getCiudad());
        txtTemp.setText(Ciudades[position].getTemp()+" °C");
        txtDesc.setText(Ciudades[position].getDesc());*/



        return convertView;
    }
}
