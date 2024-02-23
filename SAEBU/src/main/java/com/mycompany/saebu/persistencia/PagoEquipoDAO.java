package com.mycompany.saebu.persistencia;

import com.mycompany.saebu.logica.clases.Disciplina;
import com.mycompany.saebu.logica.clases.Equipo;
import com.mycompany.saebu.logica.clases.Operador;
import com.mycompany.saebu.logica.clases.PagoEquipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagoEquipoDAO implements IPagoEquipoDAO {
    private static final String SQL_SELECT_ALL = "SELECT * FROM Pagos_equipo";
    
    public List<PagoEquipo> read () throws SQLException, ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PagoEquipo pagos = null;
        List<PagoEquipo> listapagos = new ArrayList<PagoEquipo>();
        try {
            conn = Conexion.getInstance();
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int pagonum = rs.getInt("panum");
                java.sql.Date fecpag = rs.getDate("pafecha");
                float importep = rs.getFloat("paimporte");
                String descripcion = rs.getString("padescripcion");
                Disciplina  di = new Disciplina( rs.getInt("id_d") );
                Equipo eq = new Equipo( rs.getInt("id_e") );
                Operador op = new Operador( rs.getInt("id_o") );          
                pagos= new PagoEquipo(pagonum,fecpag,importep,descripcion,di,eq,op);
                listapagos.add(pagos);
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase PagoEquipoDaoImple, método read");
            e.printStackTrace();
        }
        finally{
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
