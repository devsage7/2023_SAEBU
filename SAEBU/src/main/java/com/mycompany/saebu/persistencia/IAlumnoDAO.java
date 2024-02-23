package com.mycompany.saebu.persistencia;

import com.mycompany.saebu.logica.clases.*;
import java.sql.SQLException;
import java.util.List;

public interface IAlumnoDAO {

    public int create(Alumno alumno) throws SQLException, ClassNotFoundException;

    public List<Alumno> read() throws SQLException, ClassNotFoundException;

    public boolean update(Alumno alumno) throws SQLException, ClassNotFoundException;

    public boolean delete(int id_a) throws SQLException, ClassNotFoundException;
}
