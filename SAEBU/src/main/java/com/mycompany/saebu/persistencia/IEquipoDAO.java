package com.mycompany.saebu.persistencia;

import com.mycompany.saebu.logica.clases.Equipo;
import java.sql.SQLException;

public interface IEquipoDAO {

    public int create(Equipo disciplina) throws SQLException, ClassNotFoundException;

    public Equipo read(int id_e) throws SQLException, ClassNotFoundException;

    public boolean update(Equipo disciplina) throws SQLException, ClassNotFoundException;

    public boolean delete(int dcod) throws SQLException, ClassNotFoundException;
}
