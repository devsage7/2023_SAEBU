package com.mycompany.saebu.persistencia;

import com.mycompany.saebu.logica.clases.Operador;
import java.sql.*;
import java.util.*;

public class OperadorDAO implements IOperadorDAO {
    private static final String SQL_SELECT = "SELECT * FROM Operadores WHERE id_o = ?";
    private static final String SQL_INSERT = "INSERT INTO Operadores(onombreyape,onrodoc) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE Operadores SET onombreyape = ? WHERE onrodoc = ?";
    private static final String SQL_DELETE = "DELETE FROM Operadores WHERE onrodoc = ?";
    
    @Override
    public boolean create (Operador operador) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean registrar=false;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_INSERT);            
            stmt.setString(1, operador.getNomyApe());
            stmt.setInt(2, operador.getNroDoc());
            stmt.executeUpdate();
            registrar=true;
        }catch (SQLException ex) {
            System.out.println("Error: Clase OperadorDaoImple, método create");
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase OperadorDaoImple, método create");
                ex.printStackTrace(System.out);
            }
        }
        return registrar;
    }
    
    @Override
    public List<Operador> read (int dniconsul) throws SQLException, ClassNotFoundException{
        Connection conn=null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Operador operador = null;
        List<Operador> listaOperadores = new ArrayList<>();
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, dniconsul);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id_o= rs.getInt("id_o");
                String nom = rs.getString("onombreyape");
                int dni= rs.getInt("onrodoc");                      
                operador = new Operador(id_o,nom,dni);
                listaOperadores.add(operador);
            }
        } catch (SQLException ex) {
            System.out.println("Error: Clase OperadorDaoImple, método read");
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase OperadorDaoImple, método read");
                ex.printStackTrace(System.out);
            }
        }
        return listaOperadores;
    }
    
    @Override
    public boolean update (Operador operador)throws SQLException, ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean modificar=false;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, operador.getNomyApe());
            stmt.setInt(2, operador.getNroDoc());       
            stmt.executeUpdate();
            modificar=true;
        } catch (SQLException ex) {
            System.out.println("Error: Clase OperadorDaoImple, método update");
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase OperadorDaoImple, método update");
                ex.printStackTrace(System.out);
            }
        }
        return modificar;
    }
    
    @Override
   public boolean delete (int dni) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean eliminado=false;
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, dni);
            stmt.executeUpdate();
            eliminado=true;
        } catch (SQLException ex) {
            System.out.println("Error: Clase OperadorDaoImple, método delete");
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                Conexion.close(stmt);
                Conexion.close();
            } catch (SQLException ex) {
                System.out.println("Error: Clase OperadorDaoImple, método delete");
                ex.printStackTrace(System.out);
            }
        }
        return eliminado;
    }
}
