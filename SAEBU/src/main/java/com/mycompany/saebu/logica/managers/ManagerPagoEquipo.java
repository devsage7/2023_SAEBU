package com.mycompany.saebu.logica.managers;

import com.mycompany.saebu.logica.clases.GenerarPDF;
import com.mycompany.saebu.logica.clases.PagoEquipo;
import com.mycompany.saebu.persistencia.PagoEquipoDAO;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.util.List;

public class ManagerPagoEquipo {

    public List<PagoEquipo> consultarEquiposPagos() throws SQLException, ClassNotFoundException {
        List<PagoEquipo> pagos = consultarPagosEquipo();
        ManagerEquipo mEquipo = new ManagerEquipo();
        ManagerDisciplina mDisc = new ManagerDisciplina();
        ManagerOperador mOperador = new ManagerOperador();
        for (int i = 0; pagos.size() > i; i++) {
            pagos.get(i).setEquipo(mEquipo.consultarEquipo(pagos.get(i).getEquipo().getCod()));
            pagos.get(i).setDisciplina(mDisc.consultarDisciplina(pagos.get(i).getDisciplina().getId_d()));
            pagos.get(i).setOperador(mOperador.consultarOperador(pagos.get(i).getOperador().getId_o()).get(0));
        }
        return pagos;
    }

    public List<PagoEquipo> consultarPagosEquipo() throws SQLException, ClassNotFoundException {
        PagoEquipoDAO pago = new PagoEquipoDAO();
        return pago.read();
    }

    public void generarPDF(String nombreequipo, String disciplina, int num_pago, String nombre, float importe, Time horaActual, String tipo, String linea) {
        GenerarPDF pdf = new GenerarPDF();
        pdf.setNombre(nombreequipo);
        pdf.setNombredisciplina(disciplina);
        pdf.setNumero(num_pago);
        pdf.setNombreoperador(nombre);
        pdf.setImporte(importe);
        pdf.setHora(DateFormat.getDateTimeInstance().format(horaActual));
        pdf.setLinea(linea);
        pdf.setTipo("Tipo: Pago");
        pdf.setLinea2("Número de recibo: " + num_pago);
        pdf.setLinea3("");
        pdf.setNomarchivo(tipo);
        pdf.generarPDF();
    }
}
