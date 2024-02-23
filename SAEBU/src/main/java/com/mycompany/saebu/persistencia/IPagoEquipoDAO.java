package com.mycompany.saebu.persistencia;

import com.mycompany.saebu.logica.clases.PagoEquipo;
import java.sql.SQLException;

public interface IPagoEquipoDAO {

    public interface IPagoDeCuotaDAO {

        public int create(PagoEquipo pago) throws SQLException, ClassNotFoundException;

        public PagoEquipo read(int nropago) throws SQLException, ClassNotFoundException;

        public boolean update(PagoEquipo pago) throws SQLException, ClassNotFoundException;

        public boolean delete(int nropago) throws SQLException, ClassNotFoundException;
    }
}
