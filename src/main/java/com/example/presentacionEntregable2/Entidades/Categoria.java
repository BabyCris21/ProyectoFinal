package com.example.presentacionEntregable2.Entidades;



public class Categoria {
    int id;
    int idUsuario;
    int activo;
    String nombre;
    String fechaRegistro;

    public Categoria(int id, int idUsuario, int activo, String nombre, String fechaRegistro) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.activo = activo;
        this.nombre = nombre;
        this.fechaRegistro = fechaRegistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}