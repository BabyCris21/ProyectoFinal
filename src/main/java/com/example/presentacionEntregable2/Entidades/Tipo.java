package com.example.presentacionEntregable2.Entidades;

public class Tipo {
    int Id;
    String Nombre;
    int activo;

    public Tipo(int id, String nombre, int activo) {
        this.Id = id;
        Nombre = nombre;
        this.activo = activo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
}
