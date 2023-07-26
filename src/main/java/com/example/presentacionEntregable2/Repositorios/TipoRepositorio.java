package com.example.presentacionEntregable2.Repositorios;

import com.example.presentacionEntregable2.Entidades.Tipo;
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

public class TipoRepositorio implements IRepositorio<Tipo> {
    private Connection db;

    public TipoRepositorio() {
        try {
            this.db = DatabaseConnection.getInstancia();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Tipo> Listar() {
        String statement = "SELECT id, nombre, activo FROM tipo;";
        List<Tipo> tipos = new ArrayList<>();
        try {
            PreparedStatement ps = db.prepareStatement(statement);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int activo = rs.getInt("activo");
                tipos.add(new Tipo(id, nombre, activo));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(TipoRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
        return tipos;
    }

    @Override
    public Tipo ObtenerPorId(int id) {
        Tipo tipo = null;
        String procedure = "SELECT id, nombre, activo FROM tipo WHERE id = ?;";
        try {
            PreparedStatement ps = db.prepareStatement(procedure);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int tipoId = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int activo = rs.getInt("activo");
                tipo = new Tipo(tipoId, nombre, activo);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            Logger.getLogger(TipoRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
        return tipo;
    }

    @Override
    public void Crear(Tipo objeto) {
        String procedure = "INSERT INTO tipo (nombre, activo) VALUES (?, ?);";
        try {
            PreparedStatement cs = db.prepareStatement(procedure);
            cs.setString(1, objeto.getNombre());
            cs.setInt(2, objeto.getActivo());
            cs.execute();
            cs.close();
        } catch (SQLException e) {
            Logger.getLogger(TipoRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
    }

    @Override
    public Tipo Eliminar(Tipo objeto) {
        String procedure = "DELETE FROM tipo WHERE id = ?;";
        try {
            PreparedStatement cs = db.prepareStatement(procedure);
            cs.setInt(1, objeto.getId());
            cs.execute();
            cs.close();
        } catch (SQLException e) {
            Logger.getLogger(TipoRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
        return objeto;
    }

    @Override
    public void Actualizar(Tipo objeto) {
        String procedure = "UPDATE tipo SET nombre = ?, activo = ? WHERE id = ?;";
        try {
            PreparedStatement cs = db.prepareStatement(procedure);
            cs.setString(1, objeto.getNombre());
            cs.setInt(2, objeto.getActivo());
            cs.setInt(3, objeto.getId());
            cs.execute();
            cs.close();
        } catch (SQLException e) {
            Logger.getLogger(TipoRepositorio.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            DatabaseConnection.cerrarConexion();
        }
    }
}
