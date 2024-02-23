package com.mycompany.saebu.logica.clases;

public class CuotaMensual {
    int mes;
    int anio;
    Alumno alumno;
    Disciplina disciplina;
    Inscripcion inscripcion;
    PagoDeCuota pdc;
    int pnum;

    public CuotaMensual(int mes, int anio, Alumno alumno, Disciplina disciplina, Inscripcion inscripcion, int pnum) {
        this.mes = mes;
        this.anio = anio;
        this.alumno = alumno;
        this.disciplina = disciplina;
        this.inscripcion = inscripcion;
        this.pdc = null;
        this.pnum = pnum;
    }
    
    public CuotaMensual(int mes, int anio, Alumno alumno, Disciplina disciplina, Inscripcion inscripcion) {
        this.mes = mes;
        this.anio = anio;
        this.alumno = alumno;
        this.disciplina = disciplina;
        this.inscripcion = inscripcion;
        this.pdc = null;
    }
    
    public CuotaMensual(int mes, int anio, Inscripcion inscripcion,PagoDeCuota pago, int pnum) {
        this.mes = mes;
        this.anio = anio;
        this.alumno = null;
        this.disciplina = null;
        this.inscripcion = inscripcion;
        this.pdc = pago;
        this.pnum = pnum;
    }
    
    public CuotaMensual(int mes, int anio, Inscripcion inscripcion) {
        this.mes = mes;
        this.anio = anio;
        this.inscripcion = inscripcion;
        this.pdc = null;
    }
    
    public CuotaMensual(int mes, int anio) {
        this.mes = mes;
        this.anio = anio;
        this.pdc = null;
    }
    
 
    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public PagoDeCuota getPdc() {
        return pdc;
    }

    public void setPdc(PagoDeCuota pdc) {
        this.pdc = pdc;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }
    
    
    
    /*public void anularPagoCuota(){
        this.pdc = null;
    }*/

    @Override
    public String toString() {
        return "CuotaMensual{" + "mes=" + mes + ", anio=" + anio + ", alumno=" + alumno + ", disciplina=" + disciplina + ", inscripcion=" + inscripcion + ", pdc=" + pdc + '}';
    }
}
