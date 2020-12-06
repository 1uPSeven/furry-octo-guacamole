package com.sweetspot.gnfo;
import java.io.Serializable;



public class lugares implements Serializable {

    private String nomLugar;
    private String descLugar;
    private String code;
    private String lugar;
    private String latitud;
    private String longitud;

    public lugares(){}
    public lugares(String code, String descLugar, String lugar, String nomLugar, String latitud, String longitud) {

        this.code = code;
        this.descLugar = descLugar;

        this.lugar = lugar;
        this.nomLugar = nomLugar;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNomLugar() {
        return nomLugar;
    }

    public String getDescLugar() {
        return descLugar;
    }

    public String getCode() {
        return code;
    }


    public String getLugar() {
        return lugar;
    }

    public String getLatitud(){ return latitud;}

    public String getLongitud(){ return longitud;}

    public void setNomLugar(String nomLugar) {
        this.nomLugar = nomLugar;
    }

    public void setDescLugar(String descLugar) {
        this.descLugar = descLugar;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}