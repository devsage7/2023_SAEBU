package com.mycompany.saebu.logica.managers;

import com.mycompany.saebu.logica.clases.*;
import com.mycompany.saebu.persistencia.InscripcionDAO;
import static java.lang.String.valueOf;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ManagerInscripcion {
    public int registrarInscripcion(Date fecInscr, Date fecVenc, float importe, TipoInscripcion ti, Alumno a, Disciplina d, Operador o) throws SQLException, ClassNotFoundException {
        InscripcionDAO inscripcionDAO = new InscripcionDAO();
        Inscripcion i = new Inscripcion(fecInscr, fecVenc, importe, ti, a, d, o);
        int id = inscripcionDAO.create(i);
        i.setNroInscripcion(id);
        o.agregarInscripcion(i);
        a.agregarInscripcion(i);
        d.agregarInscripcion(i);
        
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(fecInscr);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(fecVenc);

        if (!(a.getTipoAlumno().name().equalsIgnoreCase("EXTRAUNIVERSITARIO"))
                && valueOf(ti).equals("RECREATIVO")) {
        } else {
            CuotaMensual cm;
            ManagerCuotaMensual mcm = new ManagerCuotaMensual();
            int mesesTotales = 0;
            while (!calendar1.after(calendar2)) {
                cm = new CuotaMensual((1 + calendar1.get(Calendar.MONTH)), calendar1.get(Calendar.YEAR), a, d, i);
                mcm.registrarCuota(cm);
                calendar1.add(Calendar.MONTH, 1);
                mesesTotales++;
            }
        }
        return id;
    }
    
    public List<Inscripcion> consultarInscripciones(int id_a) throws SQLException, ClassNotFoundException{
        InscripcionDAO inscripcionDAO = new InscripcionDAO();
        List <Inscripcion> insc=inscripcionDAO.readid_a(id_a);
        ManagerDisciplina di = new ManagerDisciplina();
        ManagerCuotaMensual cuo = new ManagerCuotaMensual();
        for (int i = 0; i < insc.size(); i++) {
            insc.get(i).setDisciplina(di.consultarDisciplina(insc.get(i).getDisciplina().getId_d()));
            insc.get(i).setCuotasMensuales(cuo.consultarCuotas(insc.get(i).getNroInscripcion()));
        }
        return insc;
    }
    
    public boolean consultarInscripciones(Alumno alumno, Disciplina d_selecc, String ti) throws SQLException, ClassNotFoundException{
        InscripcionDAO inscripcionDAO = new InscripcionDAO();
        List<Inscripcion> li = inscripcionDAO.readid_a(alumno.getId_a());
        Calendar calendar = Calendar.getInstance();
        for (Inscripcion inscr : li) {
            if (inscr.getAlumno().getId_a() == alumno.getId_a()
                    && inscr.getDisciplina().getId_d() == d_selecc.getId_d()
                    && (inscr.getFecVenc().after(calendar.getTime()))
                    && inscr.getTipoInscr() == TipoInscripcion.valueOf(valueOf(ti))) {
                return true;
            }
        }
        return false;
    }
    
    public float calcularImporte(Alumno a, String ti, Disciplina d){
        float importe = 0;
        if (!(a.getTipoAlumno().name().equalsIgnoreCase("EXTRAUNIVERSITARIO"))
                && valueOf(ti).equals("RECREATIVO")) {
                return importe;
            }
        importe = d.getImporte();
        return importe;
    }
    
    public String obtenerDatos(Alumno a, Disciplina d, String ti, int mesIni, int anioIni, int mesFin, int anioFin, float importe){
        return "Alumno: "+a.getNomyApe()+ 
                "\nNro. de Doc: "+a.getNroDoc()+
                "\nDisciplina: "+d.getNombre()+
                "\nTipo: "+ti+
                "\nDesde: "+mesIni+"/"+anioIni+
                "\nHasta: "+mesFin+"/"+anioFin+
                "\nA pagar: $"+importe;
    }

    public List<Inscripcion> consultarInscripciones() throws SQLException, ClassNotFoundException{
        InscripcionDAO inscripcionDAO = new InscripcionDAO();
        return inscripcionDAO.read();
    }
    
    public Inscripcion consultarInscripcion(int icod) throws SQLException, ClassNotFoundException{
        InscripcionDAO inscripcionDAO = new InscripcionDAO();
        return inscripcionDAO.read(icod);
    }
    
    
    public List<Inscripcion> consultarInscripcionAlumno(int id_a) throws SQLException, ClassNotFoundException{
        InscripcionDAO inscripcionDAO = new InscripcionDAO();
        
        return inscripcionDAO.readid_a(id_a);
    }
    
    public void generarPDF(Alumno a, int id_i, Disciplina d, TipoInscripcion ti, Date fecInscr, Date fecVenc, float importe, Operador o) {
        Time horaActual = new Time(System.currentTimeMillis());
        GenerarPDF pdf = new GenerarPDF();
        pdf.setNombre(a.getNomyApe());
        pdf.setNumero(id_i);
        pdf.setNombredisciplina(d.getNombre());
        pdf.setLinea("DEPORTES                                                                                                                   ORIGINAL");
        pdf.setTipo("Tipo: Inscripción - " + ti);
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        pdf.setHora(DateFormat.getDateTimeInstance().format(horaActual));
        pdf.setLinea2("Número de inscripción: " + id_i);
        pdf.setImporte(importe);
        pdf.setLinea3("Período: " + formateador.format(fecInscr) + " hasta " + formateador.format(fecVenc));
        pdf.setNombreoperador(o.getNomyApe());
        pdf.setNomarchivo("Inscripcion");
        pdf.generarPDF();
    }
}
