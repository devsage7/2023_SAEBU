package com.mycompany.saebu.logica.managers;

import com.mycompany.saebu.logica.clases.GenerarPDF;
import com.mycompany.saebu.logica.clases.Operador;
import com.mycompany.saebu.logica.clases.PagoDeCuota;
import com.mycompany.saebu.persistencia.PagoDeCuotaDAO;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.util.List;

public class ManagerPagoDeCuota {
    
    public List<PagoDeCuota> consultarCuotasPagos() throws SQLException, ClassNotFoundException {
        List<PagoDeCuota> pagos = consultarPagosDeCuotas();
        ManagerCuotaMensual mCuota = new ManagerCuotaMensual();
        ManagerOperador mOperador = new ManagerOperador();
        for (int i = 0; pagos.size() > i; i++) {
            pagos.get(i).setCuotaMensual(mCuota.traerCuotaDelPago(pagos.get(i).getNroPago()));
            pagos.get(i).setOperador( mOperador.consultarOperador(pagos.get(i).getOperador().getId_o()).get(0));
        }
        return pagos;
    }
    
    
    public int ingresarPagoDeCuota(PagoDeCuota pago, int mes, int anio, int nroInscripcion) throws SQLException, ClassNotFoundException {
        PagoDeCuotaDAO pagoDeCuotaDAO = new PagoDeCuotaDAO();
        
        int num_pago = pagoDeCuotaDAO.create(pago);
        
        if (num_pago != -1) {
            ManagerCuotaMensual managerCuota = new ManagerCuotaMensual();
            if (managerCuota.ingresarPNUM(mes, anio, nroInscripcion, num_pago)) {
                return num_pago;
            }
        }
        return num_pago;
    }
    
    public List<PagoDeCuota> consultarPagosDeCuotas() throws SQLException, ClassNotFoundException {
        PagoDeCuotaDAO pago = new PagoDeCuotaDAO();
        return pago.read();
    }
    
    public void generarPDF(String nombreAlumno, String disciplina, int num_pago, String nombre, float importe, int mes, int anio, Time horaActual, String tipo, String linea) {
        GenerarPDF pdf = new GenerarPDF();
        pdf.setNombre(nombreAlumno);
        pdf.setNombredisciplina(disciplina);
        pdf.setNumero(num_pago);
        pdf.setNombreoperador(nombre);
        pdf.setImporte(importe);
        pdf.setHora(DateFormat.getDateTimeInstance().format(horaActual));
        pdf.setLinea(linea);
        pdf.setTipo("Tipo: Pago Mensualidad");
        pdf.setLinea2("Número de recibo: " + num_pago);
        pdf.setLinea3("Cuota perteneciente al mes " + mes + " de " + anio);
        pdf.setNomarchivo(tipo);
        pdf.generarPDF();
    }
}
