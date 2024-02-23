package com.mycompany.saebu.logica.managers;
import com.mycompany.saebu.persistencia.DisciplinaDAO;
import java.sql.SQLException;
import java.util.List;
import com.mycompany.saebu.logica.clases.Disciplina;

public class ManagerDisciplina {
    public int agregarDisciplina(Disciplina d) throws SQLException, ClassNotFoundException{
        DisciplinaDAO disciplinaDao = new DisciplinaDAO();
        return disciplinaDao.create(d);
    }
    
    public Disciplina consultarDisciplina(int id_d) throws SQLException, ClassNotFoundException {
        DisciplinaDAO disciplinaDao = new DisciplinaDAO();
        return disciplinaDao.read(id_d);
    }

    public List<Disciplina> consultarDisciplina(String nom) throws SQLException, ClassNotFoundException {
        DisciplinaDAO disciplinaDao = new DisciplinaDAO();
        return disciplinaDao.read(nom);
    }

    public List<Disciplina> consultarDisciplina() throws SQLException, ClassNotFoundException {
        DisciplinaDAO disciplinaDao = new DisciplinaDAO();
        return disciplinaDao.read();
    }
}
