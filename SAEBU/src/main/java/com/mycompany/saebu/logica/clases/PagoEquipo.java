package com.mycompany.saebu.logica.clases;

import java.sql.Date;

public class PagoEquipo {
    int nroPago;
    Date fecha;
    float importe;
    String descripcion;
    Disciplina disciplina;
    Equipo equipo;
    Operador operador;

    public PagoEquipo(Date fecha, float importe, Disciplina disciplina, Equipo equipo, Operador operador) {
        this.nroPago = nroPago;
        this.fecha = fecha;
        this.importe = importe;
        this.disciplina = disciplina;
        this.equipo = equipo;
        this.operador = operador;
    }

    public PagoEquipo(int nroPago, Date fecha, float importe, String descripcion, Disciplina disciplina, Equipo equipo, Operador operador) {
        this.nroPago = nroPago;
        this.fecha = fecha;
        this.importe = importe;
        this.descripcion = descripcion;
        this.disciplina = disciplina;
        this.equipo = equipo;
        this.operador = operador;
    }

    public int getNroPago() {
        return nroPago;
    }

    public void setNroPago(int nroPago) {
        this.nroPago = nroPago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    @Override
    public String toString() {
        return "PagoEquipo{" + "nroPago=" + nroPago + ", fecha=" + fecha + ", importe=" + importe + ", descripcion=" + descripcion + ", disciplina=" + disciplina + ", equipo=" + equipo + ", operador=" + operador + '}';
    }
    
    
}
