package com.example.eva1_12_clima;

public class clima {
    private int imagen;
    private String ciudad;
    private double temp;
    private String desc;

    public clima() {
        this.imagen = R.drawable.sunny;
        this.ciudad = "Guadalupe Victoria";
        this.temp = 27.3;
        this.desc = "Rojo atardecer con crepusculos arrebolados";
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public clima(int imagen, String ciudad, double temp, String desc) {
        this.imagen = imagen;
        this.ciudad = ciudad;
        this.temp = temp;
        this.desc = desc;
    }
}

