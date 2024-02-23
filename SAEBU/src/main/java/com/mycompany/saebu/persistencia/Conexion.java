package com.mycompany.saebu.persistencia;
import java.sql.*;

public class Conexion {
   private static final String JDBC_URL = "jdbc:mysql://localhost:3306/saebu";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";

    private static Connection connection= null;

    private Conexion() {
    }

    private static void createInstance() throws SQLException, ClassNotFoundException{
        try{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getInstance() throws SQLException, ClassNotFoundException {
        if (connection == null) {
            createInstance();
        }
        return connection;
    }

    public static void close() throws SQLException {
        if (connection != null) {
            connection.close();
            connection = null;
        }
    } 
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(Statement stmt) throws SQLException{
        stmt.close();
    }
    
    public static void close(PreparedStatement stmt) throws SQLException{
        stmt.close();
    }
}
