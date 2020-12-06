package com.sweetspot.gnfo;
import java.io.Serializable;




public class lugares implements Serializable{

    private String nombre;
    private String descripcion;
    private String codigo;
    private String latitud;
    private String longitud;
    private String lugar;

    public lugares(){
        
    }

    public lugares(String nombre, String descripcion, String codigo, String latitud, String longitud, String lugar){

        this.codigo=codigo;
        this.descripcion=descripcion;
        this.nombre=nombre;
        this.latitud=latitud;
        this.longitud=longitud;
        this.lugar=lugar;

    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public String getLugar() {
        return lugar;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}

