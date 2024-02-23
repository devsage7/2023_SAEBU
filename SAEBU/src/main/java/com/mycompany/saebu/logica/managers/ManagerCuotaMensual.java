package com.mycompany.saebu.logica.managers;

import com.mycompany.saebu.logica.clases.CuotaMensual;
import com.mycompany.saebu.persistencia.CuotaMensualDAO;
import com.mycompany.saebu.persistencia.PagoDeCuotaDAO;
import java.sql.SQLException;
import java.util.List;

public class ManagerCuotaMensual {
    
    public boolean registrarCuota(CuotaMensual cm) throws SQLException, ClassNotFoundException{
        CuotaMensualDAO cuota = new CuotaMensualDAO();
        return cuota.create(cm);
    }
    
    public List<CuotaMensual> consultarCuotas( int inscripcion ) throws SQLException, ClassNotFoundException {
        CuotaMensualDAO cuo = new CuotaMensualDAO();
        PagoDeCuotaDAO pag= new PagoDeCuotaDAO();
        List<CuotaMensual> cuotas= cuo.read(inscripcion);
        for(int i=0; i< cuotas.size();i++){
            if(cuotas.get(i).getPnum()!=-1){
                cuotas.get(i).setPdc(pag.read(cuotas.get(i).getPnum()));
           }
        }
        return cuotas;
    }
    
    public boolean ingresarPNUM(int mes,int anio,int nroInscripcion,int num_pago) throws SQLException, ClassNotFoundException{
        CuotaMensualDAO pago = new CuotaMensualDAO();
        return pago.update(mes,anio,nroInscripcion,num_pago);
    }
    
    public CuotaMensual traerCuotaDelPago(int pnum) throws SQLException, ClassNotFoundException{
        CuotaMensualDAO cuota = new CuotaMensualDAO();
        CuotaMensual cu = cuota.read_pnum(pnum);
        
        ManagerAlumno mAlu = new ManagerAlumno();
        cu.setAlumno( mAlu.consultarAlumnoid( cu.getAlumno().getId_a() ));
        
        ManagerDisciplina mDisc = new ManagerDisciplina();
        cu.setDisciplina( mDisc.consultarDisciplina( cu.getDisciplina().getId_d() ));
        
        return cu;
    }
    
}
