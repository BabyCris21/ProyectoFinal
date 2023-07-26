package com.example.presentacionEntregable2.Repositorios.Interfaces;

import java.util.List;

public interface IRepositorio<T> {
    public List<T> Listar();
    public T ObtenerPorId(int id);
    public void Crear(T objeto);
    public T Eliminar(T objeto);
    public void Actualizar(T objeto);
}
