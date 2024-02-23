package com.mycompany.saebu.persistencia;

import com.mycompany.saebu.logica.clases.Inscripcion;
import java.sql.SQLException;
import java.util.List;

public interface IInscripcionDAO {

    public int create(Inscripcion insc) throws SQLException, ClassNotFoundException;

    public Inscripcion read(int icod) throws SQLException, ClassNotFoundException;

    public boolean update(Inscripcion insc) throws SQLException, ClassNotFoundException;

    public boolean delete(int icod) throws SQLException, ClassNotFoundException;
}
