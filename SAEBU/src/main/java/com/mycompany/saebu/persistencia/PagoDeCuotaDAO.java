package com.mycompany.saebu.persistencia;

import com.mycompany.saebu.logica.clases.CuotaMensual;
import com.mycompany.saebu.logica.clases.Disciplina;
import com.mycompany.saebu.logica.clases.Inscripcion;
import com.mycompany.saebu.logica.clases.Operador;
import com.mycompany.saebu.logica.clases.PagoDeCuota;
import java.sql.*;
import java.util.*;

public class PagoDeCuotaDAO implements IPagoDeCuotaDAO {

    private static final String SQL_SELECT = "SELECT * FROM Pagos_cuota WHERE pnum = ?";
    private static final String SQL_INSERT = "INSERT INTO Pagos_cuota(pfecha,pimporte,phora,id_o,pmes,panio,icod) VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE Pagos_cuota SET pfecha = ?, pimporte = ?, phora = ? WHERE pnum = ?"; //duda del cod operador
    private static final String SQL_DELETE = "DELETE FROM Pagos_cuota WHERE pnum = ?";
    private static final String SQL_SELECT_INSCRIPCION = "SELECT * FROM Pagos_cuota WHERE icod = ?";
    private static final String SQL_SELECT_ALL = "SELECT * FROM Pagos_cuota";
    private static final String SQL_SELECTID = "SELECT max(pnum) as id FROM Pagos_cuota";


    @Override
    public int create(PagoDeCuota pago) throws SQLException, ClassNotFoundException {
        int pagonum = -1;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_INSERT);

            java.util.Date utilD = pago.getFecha();
            java.sql.Date sqlD = new java.sql.Date(utilD.getTime());    // Conversion de util.date a sql.date
            stmt.setDate(1, sqlD);
            stmt.setFloat(2, pago.getImporte());
            stmt.setTime(3, pago.getHora());
            stmt.setInt(4, pago.getOperador().getId_o());
            stmt.setInt(5, pago.getCuotaMensual().getMes());
            stmt.setInt(6, pago.getCuotaMensual().getAnio());
            stmt.setInt(7, pago.getCuotaMensual().getInscripcion().getNroInscripcion());

            stmt.executeUpdate();

            stmt = conn.prepareStatement(SQL_SELECTID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                pagonum = rs.getInt("id");
            }

        } catch (SQLException ex) {
            System.out.println("Error: Clase PagoDeCuotaDaoImple, método create");
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase PagoDeCuotaDaoImple, método create");
                ex.printStackTrace(System.out);
            }
        }
        return pagonum;
    }

    @Override
    public PagoDeCuota read(int nropago) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PagoDeCuota pago = null;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, nropago);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int pagonum = rs.getInt("pnum");
                float importep = rs.getFloat("pimporte");
                java.sql.Date fecpag = rs.getDate("pfecha");
                Time horapago = rs.getTime("phora");
                CuotaMensual cm = new CuotaMensual(rs.getInt("pmes"), rs.getInt("panio"));
                Operador o = new Operador(rs.getInt("id_o"));
                pago = new PagoDeCuota(pagonum, fecpag, horapago, importep, cm, o);
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase PagoDeCuotaDaoImple, método read");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase PagoDeCuotaDaoImple, método read");
                ex.printStackTrace(System.out);
            }
        }
        return pago;
    }

    public List<PagoDeCuota> read() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PagoDeCuota pagos = null;
        List<PagoDeCuota> listapagos = new ArrayList<PagoDeCuota>();
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int pagonum = rs.getInt("pnum");
                float importep = rs.getFloat("pimporte");
                java.sql.Date fecpag = rs.getDate("pfecha");
                Time horapago = rs.getTime("phora");
                CuotaMensual cm = new CuotaMensual(rs.getInt("pmes"), rs.getInt("panio"));
                Operador o = new Operador(rs.getInt("id_o"));
                pagos = new PagoDeCuota(pagonum, fecpag, horapago, importep, cm, o);
                listapagos.add(pagos);
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase PagoDeCuotaDaoImple, método read");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase PagoDeCuotaDaoImple, método read");
                ex.printStackTrace(System.out);
            }
        }
        return listapagos;
    } 

    @Override
    public boolean update(PagoDeCuota pago) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean modificar = false;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setDate(1, pago.getFecha());
            stmt.setFloat(2, pago.getImporte());
            stmt.setTime(3, pago.getHora());
            stmt.setInt(4, pago.getNroPago());

            stmt.executeUpdate();
            modificar = true;
        } catch (SQLException ex) {
            System.out.println("Error: Clase PagoDeCuotaDaoImple, método update");
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase PagoDeCuotaDaoImple, método update");
                ex.printStackTrace(System.out);
            }
        }
        return modificar;
    }

    @Override
    public boolean delete(int nropago) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean eliminado = false;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, nropago);

            stmt.executeUpdate();
            eliminado = true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error: Clase PagoDeCuotaDaoImple, método delete");
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                System.out.println("Error: Clase PagoDeCuotaDaoImple, método delete");
            }
        }
        return eliminado;
    }

    public List<PagoDeCuota> readPagos(int icod) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PagoDeCuota pagos = null;
        List<PagoDeCuota> listapagos = new ArrayList<PagoDeCuota>();
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_SELECT_INSCRIPCION);
            stmt.setInt(1, icod);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int pagonum = rs.getInt("pnum");
                float importep = rs.getFloat("pimporte");
                java.sql.Date fecpag = rs.getDate("pfecha");
                Time horapago = rs.getTime("phora"); //Probablemente no sea así xdxd
                CuotaMensual cm = new CuotaMensual(rs.getInt("pmes"), rs.getInt("panio"));
                Operador o = new Operador(rs.getInt("id_o"));
                pagos = new PagoDeCuota(pagonum, fecpag, horapago, importep, cm, o);
                listapagos.add(pagos);
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase PagoDeCuotaDaoImple, método read");
            e.printStackTrace();
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase PagoDeCuotaDaoImple, método read");
                ex.printStackTrace(System.out);
            }
        }
        return listapagos;
    }
}
