package com.mycompany.saebu.persistencia;

import com.mycompany.saebu.logica.clases.*;
import java.sql.*;
import java.util.*;

public class AlumnoDAO implements IAlumnoDAO {

    private static final String SQL_SELECT = "SELECT * FROM Alumnos";
    private static final String SQL_SELECTBYID = "SELECT * FROM Alumnos WHERE id_a = ?";
    private static final String SQL_INSERT = "INSERT INTO Alumnos(anombreyape,atipodoc,"
            + "anrodoc,adomicilio,abarrio,alocalidad,"
            + "aprovincia,atel,afecNac,asexo,aobservaciones,atipo,aseguro"
            + ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Alumnos SET anombreyape = ?, adomicilio = ?,"
            + "abarrio = ?, alocalidad = ?, aprovincia = ?, atel = ?,"
            + "afecNac = ?, aobservaciones = ?, atipo = ?, aseguro = ?,"
            + " WHERE id_a = ?";
    private static final String SQL_DELETE = "DELETE FROM Alumnos WHERE id_a = ?";
    private static final String SQL_SELECTID = "SELECT max(id_a) as id FROM Alumnos";

    @Override
    public int create(Alumno alumno) throws SQLException, ClassNotFoundException {
        int id = -1;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, alumno.getNomyApe());
            stmt.setString(2, alumno.getTipoDoc());
            stmt.setInt(3, alumno.getNroDoc());
            stmt.setString(4, alumno.getDomicilio());
            stmt.setString(5, alumno.getBarrio());
            stmt.setString(6, alumno.getLocalidad());
            stmt.setString(7, alumno.getProvincia());
            stmt.setString(8, alumno.getTel());
            stmt.setDate(9, alumno.getFecNac());
            stmt.setString(10, alumno.getSexo());
            stmt.setString(11, alumno.getObservaciones());
            stmt.setString(12, String.valueOf(alumno.getTipoAlumno()));
            stmt.setString(13, String.valueOf(alumno.getTipoSeguro()));
            stmt.executeUpdate();

            stmt = conn.prepareStatement(SQL_SELECTID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Error: Clase AlumnoDaoImple, método create");
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase AlumnoDaoImple, método create");
                ex.printStackTrace(System.out);
            }
        }
        return id;
    }

    @Override
    public List<Alumno> read() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Alumno a = null;
        List<Alumno> listaAlumno = new ArrayList<Alumno>();
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int cod = rs.getInt(1);
                String nombre = rs.getString(2);
                String tipoDoc = rs.getString(3);
                int nroDoc = rs.getInt(4);
                String dom = rs.getString(5);
                String barrio = rs.getString(6);
                String localidad = rs.getString(7);
                String prov = rs.getString(8);
                String tel = rs.getString(9);
                java.sql.Date fecNac = rs.getDate(10);
                String sexo = rs.getString(11);
                String obs = rs.getString(12);
                TipoAlumno tipo = TipoAlumno.valueOf(rs.getString(13));
                TipoSeguro seguro = TipoSeguro.valueOf(rs.getString(14));
                a = new Alumno(cod, tipo, seguro, nombre, tipoDoc, nroDoc,
                        dom, barrio, localidad, prov, tel, fecNac, sexo, obs);
                listaAlumno.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase AlumnoDaoImple, método read");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase AlumnoDaoImple, método read");
                ex.printStackTrace(System.out);
            }
        }
        return listaAlumno;
    }

    public Alumno readid(int id) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Alumno a = null;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_SELECTBYID);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int cod = rs.getInt(1);
                String nombre = rs.getString(2);
                String tipoDoc = rs.getString(3);
                int nroDoc = rs.getInt(4);
                String dom = rs.getString(5);
                String barrio = rs.getString(6);
                String localidad = rs.getString(7);
                String prov = rs.getString(8);
                String tel = rs.getString(9);
                java.sql.Date fecNac = rs.getDate(10);
                String sexo = rs.getString(11);
                String obs = rs.getString(12);
                TipoAlumno tipo = TipoAlumno.valueOf(rs.getString(13));
                TipoSeguro seguro = TipoSeguro.valueOf(rs.getString(14));
                a = new Alumno(cod, tipo, seguro, nombre, tipoDoc, nroDoc,
                        dom, barrio, localidad, prov, tel, fecNac, sexo, obs);
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase AlumnoDaoImple, método read");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase AlumnoDaoImple, método read");
                ex.printStackTrace(System.out);
            }
        }
        return a;
    }

    public List<Alumno> read(int doc) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Alumno a = null;
        List<Alumno> listaAlumno = new ArrayList<Alumno>();
        String consql = "";
        consql = "SELECT * FROM Alumnos WHERE anrodoc LIKE'"
                + doc + "%'";
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(consql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int cod = rs.getInt(1);
                String nombre = rs.getString(2);
                String tipoDoc = rs.getString(3);
                int nroDoc = rs.getInt(4);
                String dom = rs.getString(5);
                String barrio = rs.getString(6);
                String localidad = rs.getString(7);
                String prov = rs.getString(8);
                String tel = rs.getString(9);
                java.sql.Date fecNac = rs.getDate(10);
                String sexo = rs.getString(11);
                String obs = rs.getString(12);
                TipoAlumno tipo = TipoAlumno.valueOf(rs.getString(13));
                TipoSeguro seguro = TipoSeguro.valueOf(rs.getString(14));
                a = new Alumno(cod, tipo, seguro, nombre, tipoDoc, nroDoc,
                        dom, barrio, localidad, prov, tel, fecNac, sexo, obs);
                listaAlumno.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase AlumnoDaoImple, método read");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase AlumnoDaoImple, método read");
                ex.printStackTrace(System.out);
            }
        }
        return listaAlumno;
    }

    public List<Alumno> read(String nom) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Alumno a = null;
        List<Alumno> listaAlumno = new ArrayList<Alumno>();
        String consql = "";
        consql = "SELECT * FROM Alumnos WHERE anombreyape LIKE'%"
                + nom + "%'";
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(consql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int cod = rs.getInt(1);
                String nombre = rs.getString(2);
                String tipoDoc = rs.getString(3);
                int nroDoc = rs.getInt(4);
                String dom = rs.getString(5);
                String barrio = rs.getString(6);
                String localidad = rs.getString(7);
                String prov = rs.getString(8);
                String tel = rs.getString(9);
                java.sql.Date fecNac = rs.getDate(10);
                String sexo = rs.getString(11);
                String obs = rs.getString(12);
                TipoAlumno tipo = TipoAlumno.valueOf(rs.getString(13));
                TipoSeguro seguro = TipoSeguro.valueOf(rs.getString(14));
                a = new Alumno(cod, tipo, seguro, nombre, tipoDoc, nroDoc,
                        dom, barrio, localidad, prov, tel, fecNac, sexo, obs);
                listaAlumno.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase AlumnoDaoImple, método read");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase AlumnoDaoImple, método read");
                ex.printStackTrace(System.out);
            }
        }
        return listaAlumno;
    }

    @Override
    public boolean update(Alumno alumno) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean modificar = false;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, alumno.getNomyApe());
            stmt.setString(2, alumno.getDomicilio());
            stmt.setString(3, alumno.getBarrio());
            stmt.setString(4, alumno.getLocalidad());
            stmt.setString(5, alumno.getProvincia());
            stmt.setString(6, alumno.getTel());
            stmt.setDate(7, alumno.getFecNac());
            stmt.setString(8, alumno.getObservaciones());
            stmt.setString(9, String.valueOf(alumno.getTipoAlumno()));
            stmt.setString(10, String.valueOf(alumno.getTipoSeguro()));
            stmt.setLong(11, alumno.getId_a());

            stmt.executeUpdate();
            modificar = true;
        } catch (SQLException ex) {
            System.out.println("Error: Clase AlumnoDaoImple, método update");
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase AlumnoDaoImple, método update");
                ex.printStackTrace(System.out);
            }
        }
        return modificar;
    }

    @Override
    public boolean delete(int id_a) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean eliminado = false;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id_a);

            stmt.executeUpdate();
            eliminado = true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error: Clase AlumnoDaoImple, método delete");
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                System.out.println("Error: Clase AlumnoDaoImple, método delete");
            }
        }
        return eliminado;
    }
}
