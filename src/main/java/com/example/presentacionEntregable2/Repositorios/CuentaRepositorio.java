package com.example.presentacionEntregable2.Repositorios;

import com.example.presentacionEntregable2.Entidades.Cuenta;
import com.example.presentacionEntregable2.Repositorios.Interfaces.IRepositorio;
import com.example.presentacionEntregable2.Util.DatabaseConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
@Repository
public class CuentaRepositorio implements IRepositorio<Cuenta> {

    private Connection db;
    public CuentaRepositorio(){}

    public void AbrirConexion(){
        try {
            this.db = DatabaseConnection.getInstancia();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Cuenta> Listar() {
        String statement = "SELECT id, idusuario, nombre, activo, descripcion, fechaCreacion FROM usuario_cuenta where activo=1;";
        List<Cuenta> cuentas = new ArrayList<>();
        try {
            AbrirConexion();
            PreparedStatement ps = db.prepareStatement(statement);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idusuario = rs.getInt("idusuario");
                int activo = rs.getInt("activo");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String date = rs.getString("fechaCreacion");
                cuentas.add(new Cuenta(id, idusuario, nombre, descripcion, activo, date));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
        return cuentas;
    }

    @Override
    public Cuenta ObtenerPorId(int id) {
        Cuenta cuentas = null;
        String procedure = "SELECT id, idusuario, nombre, activo, descripcion, fechacreacion FROM usuario_cuenta WHERE id = ? and activo=1;";
        try {
            AbrirConexion();
            PreparedStatement ps = db.prepareStatement(procedure);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int idcue = rs.getInt("id");
                int idusuario = rs.getInt("idusuario");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int activo = rs.getInt("activo");
                String fechaCreacion = rs.getString("fechaCreacion");
                cuentas = new Cuenta(idcue, idusuario, nombre,descripcion,activo, fechaCreacion);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
        return cuentas;
    }


    @Override
    public void Crear(Cuenta objeto) {
        String procedure = "INSERT INTO usuario_cuenta (nombre) VALUES (?);";
        try{
            AbrirConexion();
            PreparedStatement cs = db.prepareStatement(procedure);
            cs.setString(1, objeto.getNombre());
            cs.execute();
            cs.close();
        }
        catch (SQLException e) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
    }

    @Override
    public Cuenta Eliminar(Cuenta objeto) {
        String procedure = "DELETE FROM usuario_cuenta_categoria WHERE id = ?;";

        try {
            PreparedStatement cs = db.prepareStatement(procedure);
            cs.setInt(1, objeto.getId());
            cs.executeUpdate();
            cs.close();
        } catch (SQLException e) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }

        return objeto;
    }


    @Override
    public void Actualizar(Cuenta objeto) {
        String procedure = "UPDATE usuario_cuenta_categoria SET nombre = ? WHERE id = ?;";
        try {
            PreparedStatement cs = db.prepareStatement(procedure);
            cs.setString(1, objeto.getNombre());
            cs.setInt(2, objeto.getId());
            cs.executeUpdate();
            cs.close();
        } catch (SQLException e) {
            Logger.getLogger(CategoriaRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
    }
}