package com.mycompany.saebu.persistencia;

import com.mycompany.saebu.logica.clases.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuotaMensualDAO implements ICuotaMensualDAO {

    private static final String SQL_SELECT = "SELECT * FROM Cuotas";
    private static final String SQL_SELECT_NROINSCRIPCION = "SELECT * FROM Cuotas WHERE icod=? ORDER BY panio, pmes";
    private static final String SQL_SELECT_NROPAGO = "SELECT * FROM Cuotas WHERE pnum = ?";
    private static final String SQL_INSERT = "INSERT INTO Cuotas(pmes,panio,id_a,id_d,icod) VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Cuotas SET pmes = ?, panio = ?";
    private static final String SQL_UPDATE_PNUM = "UPDATE Cuotas SET pnum = ? WHERE pmes= ? AND panio = ? AND icod = ?";
    private static final String SQL_DELETE = "DELETE FROM Cuotas WHERE pmes= ? AND panio = ? AND icod = ?";

    @Override
    public boolean create(CuotaMensual cuota) throws SQLException, ClassNotFoundException {
        boolean registrar = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, cuota.getMes());
            stmt.setInt(2, cuota.getAnio());
            stmt.setInt(3, cuota.getAlumno().getId_a());
            stmt.setInt(4, cuota.getDisciplina().getId_d());
            stmt.setInt(5, cuota.getInscripcion().getNroInscripcion());
            stmt.executeUpdate();
            registrar = true;
        } catch (SQLException ex) {
            System.out.println("Error: Clase CuotaMensualDaoImple, método create");
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase CuotaMensualDaoImple, método create");
                ex.printStackTrace(System.out);
            }
        }
        return registrar;
    }

    @Override
    public List<CuotaMensual> read() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CuotaMensual c = null;
        List<CuotaMensual> listacuotas = new ArrayList<CuotaMensual>();
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int mes = rs.getInt("pmes");
                int anio = rs.getInt("panio");
                c = new CuotaMensual(mes, anio);
                listacuotas.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase CuotaMensualDaoImple, método read");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase CuotaMensualDaoImple, método read");
                ex.printStackTrace(System.out);
            }
        }
        return listacuotas;
    }

    public List<CuotaMensual> read(int nro) throws SQLException, ClassNotFoundException { //read(nroi)
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CuotaMensual c = null;
        List<CuotaMensual> listacuotas = new ArrayList<CuotaMensual>();
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_SELECT_NROINSCRIPCION);
            stmt.setInt(1, nro);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int mes = rs.getInt("pmes");
                int anio = rs.getInt("panio");
                Alumno a = new Alumno(rs.getInt("id_a"));
                Disciplina d = new Disciplina(rs.getInt("id_d"));
                Inscripcion i = new Inscripcion(rs.getInt("icod"));
                int pnum = rs.getInt("pnum");
                c = new CuotaMensual(mes, anio, a, d, i, pnum);
                listacuotas.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase CuotaMensualDaoImple, método read");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase CuotaMensualDaoImple, método read");
                ex.printStackTrace(System.out);
            }
        }
        return listacuotas;
    }

    public CuotaMensual read_pnum(int pnumIN) throws SQLException, ClassNotFoundException { //read(nroi)
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CuotaMensual c = null;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_SELECT_NROPAGO);
            stmt.setInt(1, pnumIN);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int mes = rs.getInt("pmes");
                int anio = rs.getInt("panio");
                Alumno a = new Alumno(rs.getInt("id_a"));
                Disciplina d = new Disciplina(rs.getInt("id_d"));
                Inscripcion i = new Inscripcion(rs.getInt("icod"));
                int pnum = rs.getInt("pnum");
                c = new CuotaMensual(mes, anio, a, d, i, pnum);
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase CuotaMensualDaoImple, método read");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase CuotaMensualDaoImple, método read");
                ex.printStackTrace(System.out);
            }
        }
        return c;
    }

    @Override
    public boolean update(CuotaMensual cuota) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean modificar = false;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setInt(1, cuota.getMes());
            stmt.setInt(2, cuota.getAnio());

            stmt.executeUpdate();
            modificar = true;
        } catch (SQLException ex) {
            System.out.println("Error: Clase CuotaMensualDaoImple, método update");
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase CuotaMensualDaoImple, método update");
                ex.printStackTrace(System.out);
            }
        }
        return modificar;
    }

    public boolean update(int mes, int anio, int icod, int pnum) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean modificar = false;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_UPDATE_PNUM);

            stmt.setInt(1, pnum);
            stmt.setInt(2, mes);
            stmt.setInt(3, anio);
            stmt.setInt(4, icod);

            stmt.executeUpdate();
            modificar = true;
        } catch (SQLException ex) {
            System.out.println("Error: Clase CuotaMensualDaoImple, método update");
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase CuotaMensualDaoImple, método update");
                ex.printStackTrace(System.out);
            }
        }
        return modificar;
    }

    public boolean delete(int mes, int anio, int icod) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean eliminado = false;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, mes);
            stmt.setInt(2, anio);
            stmt.setInt(3, icod);
            stmt.executeUpdate();
            eliminado = true;
        } catch (SQLException ex) {
            System.out.println("Error: Clase CuotaMensualDaoImple, método delete");
            ex.printStackTrace(System.out);

        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase CuotaMensualDaoImple, método delete");
                ex.printStackTrace(System.out);
            }
        }
        return eliminado;
    }
}
