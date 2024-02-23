package com.mycompany.saebu.persistencia;

import com.mycompany.saebu.logica.clases.PagoDeCuota;
import java.sql.SQLException;
import java.util.List;

public interface IPagoDeCuotaDAO {

    public int create(PagoDeCuota pago) throws SQLException, ClassNotFoundException;

    public PagoDeCuota read(int nropago) throws SQLException, ClassNotFoundException;

    public boolean update(PagoDeCuota pago) throws SQLException, ClassNotFoundException;

    public boolean delete(int nropago) throws SQLException, ClassNotFoundException;
}
