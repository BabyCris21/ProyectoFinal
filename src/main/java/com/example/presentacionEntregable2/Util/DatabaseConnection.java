package com.example.presentacionEntregable2.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static String url = "jdbc:sqlserver://localhost:1434;encrypt=true;trustServerCertificate=true;databaseName=proyecto_dwi;";
    private static String username = "Administrador";
    private static String password = "Admin12345";

    private static Connection connection;

    private DatabaseConnection() {
    }

    public static Connection getInstancia() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;
    }

    public static void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
