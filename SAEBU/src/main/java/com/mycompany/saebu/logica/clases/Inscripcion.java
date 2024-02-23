package com.mycompany.saebu.logica.clases;

import java.util.*;

public class Inscripcion {
    int nroInscripcion;
    Date fecInsc;
    Date fecVenc;
    float importeUnico;
    TipoInscripcion tipoInscr;
    Alumno alumno;
    Disciplina disciplina;
    Operador operador;
    List<CuotaMensual> cuotasMensuales;
    int codigo;

    public void setCuotasMensuales(List<CuotaMensual> cuotasMensuales) {
        this.cuotasMensuales = cuotasMensuales;
    }

    public Inscripcion(int nroInscripcion, Date fecInsc, Date fecVenc, float importeUnico, TipoInscripcion tipoInscr, Alumno alumno, Disciplina disciplina, Operador operador) {
        this.nroInscripcion = nroInscripcion;
        this.fecInsc = fecInsc;
        this.fecVenc = fecVenc;
        this.importeUnico = importeUnico;
        this.tipoInscr = tipoInscr;
        this.alumno = alumno;
        this.disciplina = disciplina;
        this.operador = operador;
        this.cuotasMensuales = new ArrayList<CuotaMensual>();
    }
    
    public Inscripcion(Date fecInsc, Date fecVenc, float importeUnico, TipoInscripcion tipoInscr, Alumno alumno, Disciplina disciplina, Operador operador) {
        this.fecInsc = fecInsc;
        this.fecVenc = fecVenc;
        this.importeUnico = importeUnico;
        this.tipoInscr = tipoInscr;
        this.alumno = alumno;
        this.disciplina = disciplina;
        this.operador = operador;
        this.cuotasMensuales = new ArrayList<CuotaMensual>();
    }

    public Inscripcion(int nroInscripcion){
        this.nroInscripcion = nroInscripcion;
        this.fecInsc = null;
        this.fecVenc = null;
        this.importeUnico = -1;
        this.tipoInscr = null;
        this.alumno = null;
        this.disciplina = null;
        this.operador = null;
        this.cuotasMensuales = new ArrayList<CuotaMensual>();
    }

    public Inscripcion(){}
    
    public int getNroInscripcion() {
        return nroInscripcion;
    }
    
    public int getCodigo(){
        return codigo;
    }

    public void setNroInscripcion(int nroInscripcion) {
        this.nroInscripcion = nroInscripcion;
    }

    public Date getFecInsc() {
        return fecInsc;
    }

    public void setFecInsc(Date fecInsc) {
        this.fecInsc = fecInsc;
    }

    public Date getFecVenc() {
        return fecVenc;
    }

    public void setFecVenc(Date fecVenc) {
        this.fecVenc = fecVenc;
    }

    public float getImporteUnico() {
        return importeUnico;
    }

    public void setImporteUnico(float importeUnico) {
        this.importeUnico = importeUnico;
    }

    public TipoInscripcion getTipoInscr() {
        return tipoInscr;
    }

    public void setTipoInscr(TipoInscripcion tipoInscr) {
        this.tipoInscr = tipoInscr;
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

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public void agregarCuotaMensual(CuotaMensual c){
        this.cuotasMensuales.add(c);
        c.setInscripcion(this);
    }

    public List<CuotaMensual> getCuotasMensuales() {
        return cuotasMensuales;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "nroInscripcion=" + nroInscripcion + ", fecInsc=" + fecInsc + ", fecVenc=" + fecVenc + ", importeUnico=" + importeUnico + ", tipoInscr=" + tipoInscr + ", alumno=" + alumno + ", disciplina=" + disciplina + ", operador=" + operador + ", cuotasMensuales=" + cuotasMensuales + '}';
    }
}
