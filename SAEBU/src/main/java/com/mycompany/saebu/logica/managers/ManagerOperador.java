package com.mycompany.saebu.logica.managers;

import com.mycompany.saebu.logica.clases.Operador;
import com.mycompany.saebu.persistencia.OperadorDAO;
import java.sql.SQLException;
import java.util.List;

public class ManagerOperador {
    public boolean RegistrarOperador(Operador operador) throws SQLException, ClassNotFoundException{
        OperadorDAO opDao = new OperadorDAO();
        return opDao.create(operador);
    }
    
    public List<Operador> consultarOperador(int id_o) throws SQLException, ClassNotFoundException{
        OperadorDAO operadorDAO = new OperadorDAO();
        return operadorDAO.read(id_o);
    }
}
