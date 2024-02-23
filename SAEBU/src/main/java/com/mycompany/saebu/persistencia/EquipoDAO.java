package com.mycompany.saebu.persistencia;

import com.mycompany.saebu.logica.clases.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EquipoDAO implements IEquipoDAO{
    private static final String SQL_SELECT = "SELECT * FROM Equipos WHERE id_e = ?";
    
    @Override
    public Equipo read (int id_e) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Equipo equipo = null;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, id_e);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_equipo = rs.getInt("id_e");
                String nombre = rs.getString("enombre");
                int eintegrantes = rs.getInt("eintegrantes");
                
                equipo = new Equipo(id_equipo,nombre,eintegrantes);
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase InscripcionDaoImple, método read");
            e.printStackTrace();
        }
        finally{
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase InscripcionDaoImple, método read");
                ex.printStackTrace(System.out);
            }
        }
        return equipo;
    }

    @Override
    public int create(Equipo disciplina) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Equipo disciplina) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int dcod) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
