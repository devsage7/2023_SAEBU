package com.mycompany.saebu.persistencia;

import com.mycompany.saebu.logica.clases.Operador;
import java.sql.SQLException;
import java.util.List;

public interface IOperadorDAO {

    public boolean create(Operador operador) throws SQLException, ClassNotFoundException;

    public List<Operador> read(int dniconsul) throws SQLException, ClassNotFoundException;

    public boolean update(Operador operador) throws SQLException, ClassNotFoundException;

    public boolean delete(int dni) throws SQLException, ClassNotFoundException;
}
