package com.sweetspot.gnfo;
import java.io.Serializable;



public class lugares implements Serializable {

    private String nomLugar;
    private String descLugar;
    private String code;
    private String lugar;

    public lugares(){}
    public lugares(String code, String descLugar, String lugar, String nomLugar) {

        this.code = code;
        this.descLugar = descLugar;

        this.lugar = lugar;
        this.nomLugar = nomLugar;
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
}