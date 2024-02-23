package com.mycompany.saebu.logica.managers;

import com.mycompany.saebu.logica.clases.Equipo;
import com.mycompany.saebu.persistencia.EquipoDAO;
import java.sql.SQLException;

public class ManagerEquipo {
    
    public Equipo consultarEquipo(int id_e) throws SQLException, ClassNotFoundException {
        EquipoDAO equipo = new EquipoDAO();
        return equipo.read(id_e);
    }
}
