package com.example.presentacionEntregable2.Entidades;

public class Movimiento {

    int id;
    int idusuarioCuenta;
    int idmovimientoTipo;
    int idmovimientoCategoria;
    String nombre;
    int activo;
    String fechaCreacion;

    public Movimiento(int id, int idusuarioCuenta, int idmovimientoTipo, int idmovimientoCategoria, String nombre, int activo, String fechaCreacion) {
        this.id = id;
        this.idusuarioCuenta = idusuarioCuenta;
        this.idmovimientoTipo = idmovimientoTipo;
        this.idmovimientoCategoria = idmovimientoCategoria;
        this.nombre = nombre;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
    }

    public Movimiento(int id, int idusuarioCuenta, int idmovimientoTipo, int idmovimientoCategoria, String nombre) {
        this.id = id;
        this.idusuarioCuenta = idusuarioCuenta;
        this.idmovimientoTipo = idmovimientoTipo;
        this.idmovimientoCategoria = idmovimientoCategoria;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdusuarioCuenta() {
        return idusuarioCuenta;
    }

    public void setIdusuarioCuenta(int idusuarioCuenta) {
        this.idusuarioCuenta = idusuarioCuenta;
    }

    public int getIdmovimientoTipo() {
        return idmovimientoTipo;
    }

    public void setIdmovimientoTipo(int idmovimientoTipo) {
        this.idmovimientoTipo = idmovimientoTipo;
    }

    public int getIdmovimientoCategoria() {
        return idmovimientoCategoria;
    }

    public void setIdmovimientoCategoria(int idmovimientoCategoria) {
        this.idmovimientoCategoria = idmovimientoCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
