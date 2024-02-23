package com.mycompany.saebu.persistencia;

import com.mycompany.saebu.logica.clases.CuotaMensual;
import java.sql.SQLException;
import java.util.List;

public interface ICuotaMensualDAO {

    public boolean create(CuotaMensual cuota) throws SQLException, ClassNotFoundException;

    public List<CuotaMensual> read() throws SQLException, ClassNotFoundException;

    public boolean update(CuotaMensual cuota) throws SQLException, ClassNotFoundException;

    public boolean delete(int mes, int anio, int icod) throws SQLException, ClassNotFoundException;
}
