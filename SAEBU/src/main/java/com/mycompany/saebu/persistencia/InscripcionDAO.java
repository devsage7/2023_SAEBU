package com.mycompany.saebu.persistencia;

import com.mycompany.saebu.logica.clases.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InscripcionDAO implements IInscripcionDAO {

    private static final String SQL_SELECT = "SELECT * FROM Inscripciones WHERE icod = ?";
    private static final String SQL_SELECT_ALUMNO = "SELECT * FROM Inscripciones WHERE id_a = ?";
    private static final String SQL_SELECTALL = "SELECT * FROM Inscripciones";
    private static final String SQL_INSERT = "INSERT INTO Inscripciones(icod,ifecins,ifecven,iimporteuni,iinscripcion,id_o, id_a, id_d) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Inscripciones SET ifecins = ?,ifecven = ?, iimporteuni=?, iinscripcion=? WHERE  icod = ?";
    private static final String SQL_DELETE = "DELETE FROM Inscripciones WHERE icod = ?";
    private static final String SQL_SELECTID = "SELECT max(icod) as id FROM Inscripciones";

    @Override
    public int create(Inscripcion insc) throws SQLException, ClassNotFoundException {
        int id = -1;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setInt(1, insc.getNroInscripcion());
            java.util.Date utilD = insc.getFecInsc();
            java.sql.Date sqlD = new java.sql.Date(utilD.getTime());    // Conversion de util.date a sql.date
            stmt.setDate(2, sqlD);
            java.util.Date utilD2 = insc.getFecVenc();
            java.sql.Date sqlD2 = new java.sql.Date(utilD2.getTime());    // Conversion de util.date a sql.date
            stmt.setDate(3, sqlD2);
            stmt.setFloat(4, insc.getImporteUnico());
            stmt.setString(5, String.valueOf(insc.getTipoInscr()));
            stmt.setInt(6, insc.getOperador().getId_o());
            stmt.setInt(7, insc.getAlumno().getId_a());
            stmt.setInt(8, insc.getDisciplina().getId_d());
            stmt.executeUpdate();

            stmt = conn.prepareStatement(SQL_SELECTID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Error: Clase InscripcionDaoImple, método create");
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase InscripcionDaoImple, método create");
                ex.printStackTrace(System.out);
            }
        }
        return id;
    }

    @Override
    public Inscripcion read(int icod) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Inscripcion i = null;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, icod);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int numero = rs.getInt("icod");
                java.sql.Date fecinsc = rs.getDate("ifecins");
                java.sql.Date fecven = rs.getDate("ifecven");
                float importe = rs.getFloat("iimporteuni");
                TipoInscripcion tipo = TipoInscripcion.valueOf(rs.getString("iinscripcion"));
                Alumno a = new Alumno(rs.getInt("id_a"));
                Operador o = new Operador(rs.getInt("id_o"));
                Disciplina d = new Disciplina(rs.getInt("id_d"));
                i = new Inscripcion(numero, fecinsc, fecven, importe, tipo, a, d, o);
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase InscripcionDaoImple, método read");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase InscripcionDaoImple, método read");
                ex.printStackTrace(System.out);
            }
        }
        return i;
    }

    public List<Inscripcion> readid_a(int acod) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Inscripcion i = null;
        List<Inscripcion> listainscripciones = new ArrayList<Inscripcion>();
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_SELECT_ALUMNO);
            stmt.setInt(1, acod);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int numero = rs.getInt("icod");
                java.sql.Date fecinsc = rs.getDate("ifecins");
                java.sql.Date fecven = rs.getDate("ifecven");
                float importe = rs.getFloat("iimporteuni");
                TipoInscripcion tipo = TipoInscripcion.valueOf(rs.getString("iinscripcion"));
                Alumno a = new Alumno(rs.getInt("id_a"));
                Operador o = new Operador(rs.getInt("id_o"));
                Disciplina d = new Disciplina(rs.getInt("id_d"));
                i = new Inscripcion(numero, fecinsc, fecven, importe, tipo, a, d, o);
                listainscripciones.add(i);
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase InscripcionDaoImple, método read");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase InscripcionDaoImple, método read");
                ex.printStackTrace(System.out);
            }
        }
        return listainscripciones;
    }

    public List<Inscripcion> read() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Inscripcion i = null;
        List<Inscripcion> listainscripciones = new ArrayList<Inscripcion>();
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_SELECTALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int numero = rs.getInt("icod");
                java.sql.Date fecinsc = rs.getDate("ifecins");
                java.sql.Date fecven = rs.getDate("ifecven");
                float importe = rs.getFloat("iimporteuni");
                TipoInscripcion tipo = TipoInscripcion.valueOf(rs.getString("iinscripcion"));
                Alumno a = new Alumno(rs.getInt("id_a"));
                Operador o = new Operador(rs.getInt("id_o"));
                Disciplina d = new Disciplina(rs.getInt("id_d"));
                i = new Inscripcion(numero, fecinsc, fecven, importe, tipo, a, d, o);
                listainscripciones.add(i);
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase InscripcionDaoImple, método read");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase InscripcionDaoImple, método read");
                ex.printStackTrace(System.out);
            }
        }
        return listainscripciones;
    }

    @Override
    public boolean update(Inscripcion insc) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean modificar = false;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_UPDATE);

            java.util.Date utilD = insc.getFecInsc();
            java.sql.Date sqlD = new java.sql.Date(utilD.getTime());    // Conversion de util.date a sql.date
            stmt.setDate(1, sqlD);
            java.util.Date utilD2 = insc.getFecVenc();
            java.sql.Date sqlD2 = new java.sql.Date(utilD2.getTime());    // Conversion de util.date a sql.date
            stmt.setDate(2, sqlD2);
            stmt.setFloat(3, insc.getImporteUnico());
            stmt.setString(4, String.valueOf(insc.getTipoInscr()));
            stmt.executeUpdate();
            modificar = true;
        } catch (SQLException ex) {
            System.out.println("Error: Clase InscripcionDaoImple, método update");
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase InscripcionDaoImple, método update");
                ex.printStackTrace(System.out);
            }
        }
        return modificar;
    }

    @Override
    public boolean delete(int icod) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean eliminado = false;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, icod);

            stmt.executeUpdate();
            eliminado = true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error: Clase InscripcionDaoImple, método delete");
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                System.out.println("Error: Clase InscripcionDaoImple, método delete");
            }
        }
        return eliminado;
    }
}
