package com.mycompany.saebu.persistencia;

import com.mycompany.saebu.logica.clases.Disciplina;
import java.sql.SQLException;
import java.util.*;

public interface IDisciplinaDAO {

    public int create(Disciplina disciplina) throws SQLException, ClassNotFoundException;

    public Disciplina read(int id_d) throws SQLException, ClassNotFoundException;

    public boolean update(Disciplina disciplina) throws SQLException, ClassNotFoundException;

    public boolean delete(int dcod) throws SQLException, ClassNotFoundException;
}
