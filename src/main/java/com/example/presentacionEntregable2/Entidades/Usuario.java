package com.example.presentacionEntregable2.Entidades;

public class Usuario {
    int Id;
    int Activo;
    String Correo;
    String Nombre;
    String Apellido;
    String telefono;
    String fechaCreacion;

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    String contrasena;
    public Usuario(){};
    public Usuario(int id, int activo, String correo, String nombre, String apellido, String telefono, String fechaCreacion) {
        this.Id = id;
        this.Activo = activo;
        Correo = correo;
        Nombre = nombre;
        Apellido = apellido;
        this.telefono = telefono;
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario(String correo, String nombre, String apellido, String telefono) {
        Correo = correo;
        Nombre = nombre;
        Apellido = apellido;
        this.telefono = telefono;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int getActivo() {
        return Activo;
    }

    public void setActivo(int activo) {
        this.Activo = activo;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}