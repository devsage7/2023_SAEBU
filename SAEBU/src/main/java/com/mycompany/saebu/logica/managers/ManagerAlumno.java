package com.mycompany.saebu.logica.managers;

import com.mycompany.saebu.logica.clases.Alumno;
import com.mycompany.saebu.persistencia.AlumnoDAO;
import java.sql.SQLException;
import java.util.List;


public class ManagerAlumno {
    public int registrarAlumno(Alumno alumno) throws SQLException, ClassNotFoundException{
        AlumnoDAO alumnoDao = new AlumnoDAO();
        return alumnoDao.create(alumno);
    }
    
    public Alumno consultarAlumnoid(int id) throws SQLException, ClassNotFoundException{
        AlumnoDAO alumnoDao = new AlumnoDAO();
        return alumnoDao.readid(id);
    }
    
    public List<Alumno> consultarAlumnos(int dni) throws SQLException, ClassNotFoundException{
        AlumnoDAO alumnoDao = new AlumnoDAO();
        return alumnoDao.read(dni);
    }
    
    public List<Alumno> consultarAlumnos(String nom) throws SQLException, ClassNotFoundException{
        AlumnoDAO alumnoDao = new AlumnoDAO();
        return alumnoDao.read(nom);
    }
    
    public List<Alumno> consultarAlumnos() throws SQLException, ClassNotFoundException{
        AlumnoDAO alumnoDao = new AlumnoDAO();
        return alumnoDao.read();
    }
    
    public boolean bajaAlumno(int id_a) throws SQLException, ClassNotFoundException{
        AlumnoDAO alumnoDao = new AlumnoDAO();
        return alumnoDao.delete(id_a);
    }
    
    public boolean modificarAlumno(Alumno alumno) throws SQLException, ClassNotFoundException{
        AlumnoDAO alumnoDao = new AlumnoDAO();
        return alumnoDao.update(alumno);
    }
}
