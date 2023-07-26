package com.example.presentacionEntregable2.Repositorios;

import com.example.presentacionEntregable2.Entidades.Movimiento;
import com.example.presentacionEntregable2.Repositorios.Interfaces.IRepositorio;
import com.example.presentacionEntregable2.Util.DatabaseConnection;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MovimientoRepositorio implements IRepositorio<Movimiento> {

    private Connection db;
    public MovimientoRepositorio(){
        try {
            this.db = DatabaseConnection.getInstancia();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Movimiento> Listar() {
        String statement = "SELECT id, idusuariocuenta, idmovimientotipo, idmovimientocategoria, nombre, activo, fechaCreacion  FROM usuario_cuenta_movimiento;";
        List<Movimiento> movimientos = new ArrayList<>();
        try {
            PreparedStatement ps = db.prepareStatement(statement);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("id");
                int idusuariocuenta = rs.getInt("idusuariocuenta");
                int idmovimientotipo = rs.getInt("idmovimientotipo");
                int idmovimientocategoria = rs.getInt("idmovimientocategoria");
                String nombre = rs.getString("nombre");
                int activo = rs.getInt("activo");
                String fechaCreacion = rs.getString("fechaCreacion");
                movimientos.add(new Movimiento(id, idusuariocuenta, idmovimientotipo, idmovimientocategoria, nombre, activo,fechaCreacion));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(MovimientoRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
        return movimientos;
    }

    @Override
    public Movimiento ObtenerPorId(int id) {
        Movimiento movimiento = null;
        String procedure = "SELECT id, idusuariocuenta, idmovimientotipo, idmovimientocategoria, nombre, activo, fechaCreacion FROM usuario_cuenta_movimiento WHERE id = ?;";
        try {
            PreparedStatement ps = db.prepareStatement(procedure);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int idcat = rs.getInt("id");
                int idusuariocuenta = rs.getInt("idusuariocuenta");
                int idmovimientotipo = rs.getInt("idmovimientotipo");
                int idmovimientocategoria = rs.getInt("idmovimientocategoria");
                String nombre = rs.getString("nombre");
                int activo = rs.getInt("activo");
                String fechaCreacion = rs.getString("fechaCreacion");
                movimiento = new Movimiento(idcat, idusuariocuenta, idmovimientotipo, idmovimientocategoria, nombre, activo, fechaCreacion );
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(MovimientoRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
        return movimiento;
    }

    @Override
    public void Crear(Movimiento objeto) {
        String procedure = "INSERT INTO usuario_cuenta_movimiento (id, idusuariocuenta, idmovimientotipo, idmovimientocategoria, nombre, activo, fechaCreacion) VALUES (?,?,?,?,?,?,?);";
        try {
            PreparedStatement cs = db.prepareStatement(procedure);
            cs.setInt(1, objeto.getId());
            cs.setInt(2, objeto.getIdusuarioCuenta());
            cs.setInt(3, objeto.getIdmovimientoTipo());
            cs.setInt(4, objeto.getIdmovimientoCategoria());
            cs.setString(5, objeto.getNombre());
            cs.setInt(6, objeto.getActivo());
            cs.setString(7, objeto.getFechaCreacion());
            cs.execute();
            cs.close();
        } catch (SQLException e) {
            Logger.getLogger(MovimientoRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
    }

    @Override
    public Movimiento Eliminar(Movimiento objeto) {

        String procedure = "UPDATE FROM usuario_cuenta_movimiento Set activo = 0 WHERE id=?;";
        try {
            PreparedStatement cs = db.prepareStatement(procedure);
            cs.setInt(1, objeto.getId());
            cs.execute();
            cs.close();
        } catch (SQLException e) {
            Logger.getLogger(MovimientoRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
        return objeto;

    }

    @Override
    public void Actualizar(Movimiento objeto) {

        String procedure = "UPDATE usuario_cuenta_movimiento Set idusuariocuenta = ?, idmovimientotipo  = ?, idmovmimientocategoria = ?, nombre = ?, WHERE id = ?";
        try {
            PreparedStatement cs = db.prepareStatement(procedure);
            cs.setInt(2, objeto.getIdusuarioCuenta());
            cs.setInt(3, objeto.getIdmovimientoTipo());
            cs.setInt(4, objeto.getIdmovimientoCategoria());
            cs.setString(5, objeto.getNombre());
            cs.execute();
            cs.close();
        } catch (SQLException e) {
            Logger.getLogger(MovimientoRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }

    }
}
