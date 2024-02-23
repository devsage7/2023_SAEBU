package com.mycompany.saebu.persistencia;

import com.mycompany.saebu.logica.clases.Disciplina;
import java.sql.Connection;
import java.sql.*;
import java.util.*;

public class DisciplinaDAO implements IDisciplinaDAO {

    private static final String SQL_SELECT = "SELECT * FROM Disciplinas WHERE id_d = ?";
    private static final String SQL_SELECTALL = "SELECT * FROM Disciplinas";
    private static final String SQL_SELECTNOM = "SELECT * FROM Disciplinas WHERE dnombre = ?";
    private static final String SQL_INSERT = "INSERT INTO Disciplinas(dnombre,dimporte,dimportecuota) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Disciplinas SET dnombre = ?, dimporte = ?, dimportecuota = ? WHERE id_d = ?";
    private static final String SQL_DELETE = "DELETE FROM Disciplinas WHERE id_d = ?";
    private static final String SQL_SELECTID = "SELECT max(id_d) as id FROM Disciplinas";

    @Override
    public int create(Disciplina disciplina) throws SQLException, ClassNotFoundException {
        int id = -1;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, disciplina.getNombre());
            stmt.setFloat(2, disciplina.getImporte());
            stmt.setFloat(3, disciplina.getImporteCuota());
            stmt.executeUpdate();

            stmt = conn.prepareStatement(SQL_SELECTID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }

        } catch (SQLException ex) {
            System.out.println("Error: Clase DisciplinaDaoImple, método create");
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase DisciplinaDaoImple, método create");
                ex.printStackTrace(System.out);
            }
        }
        return id;
    }

    public List<Disciplina> read(String nombre) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Disciplina disciplina = null;
        List<Disciplina> listaDisciplinas = new ArrayList<>();
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_SELECTNOM);
            stmt.setString(1, nombre);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_d = rs.getInt("id_d");
                String nom = rs.getString("dnombre");
                float importe = rs.getFloat("dimporte");
                float importecuo = rs.getFloat("dimportecuota");
                disciplina = new Disciplina(id_d, nom, importe, importecuo);
                listaDisciplinas.add(disciplina);
            }
        } catch (SQLException ex) {
            System.out.println("Error: Clase DisciplinaDaoImple, método read");
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase DisciplinaDaoImple, método read");
                ex.printStackTrace(System.out);
            }
        }
        return listaDisciplinas;
    }

    public List<Disciplina> read() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Disciplina disciplina = null;
        List<Disciplina> listaDisciplinas = new ArrayList<>();
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_SELECTALL);

            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_d = rs.getInt("id_d");
                String nom = rs.getString("dnombre");
                float importe = rs.getFloat("dimporte");
                float importecuo = rs.getFloat("dimportecuota");
                disciplina = new Disciplina(id_d, nom, importe, importecuo);
                listaDisciplinas.add(disciplina);
            }
        } catch (SQLException ex) {
            System.out.println("Error: Clase DisciplinaDaoImple, método read");
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase DisciplinaDaoImple, método read");
                ex.printStackTrace(System.out);
            }
        }
        return listaDisciplinas;
    }

    @Override
    public Disciplina read(int id_d) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Disciplina disciplina = null;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, id_d);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_d");
                String nom = rs.getString("dnombre");
                float importe = rs.getFloat("dimporte");
                float importecuo = rs.getFloat("dimportecuota");
                disciplina = new Disciplina(id, nom, importe, importecuo);
            }
        } catch (SQLException ex) {
            System.out.println("Error: Clase DisciplinaDaoImple, método read");
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase DisciplinaDaoImple, método read");
                ex.printStackTrace(System.out);
            }
        }
        return disciplina;
    }

    @Override
    public boolean update(Disciplina disciplina) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean modificar = false;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, disciplina.getNombre());
            stmt.setFloat(2, disciplina.getImporte());
            stmt.setFloat(3, disciplina.getImporteCuota());
            stmt.setInt(4, disciplina.getId_d());
            stmt.executeUpdate();
            modificar = true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                System.out.println("Error: Clase DisciplinaDaoImple, método update");
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase DisciplinaDaoImple, método update");
                ex.printStackTrace(System.out);
            }
        }
        return modificar;
    }

    @Override
    public boolean delete(int dcod) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean eliminar = false;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, dcod);
            stmt.executeUpdate();
            eliminar = true;
        } catch (SQLException ex) {
            System.out.println("Error: Clase DisciplinaDaoImple, método delete");
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase DisciplinaDaoImple, método delete");
                ex.printStackTrace(System.out);
            }
        }
        return eliminar;
    }
}
