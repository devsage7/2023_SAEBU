package com.mycompany.saebu.logica.clases;

import java.util.*;

public class Disciplina {
    String nombre;
    float importe;
    float importeCuota;
    List<Profesor> profesores;
    List<PagoEquipo> pagosEquipos;
    List<Inscripcion> inscripciones;
    List<CuotaMensual> cuotasMensuales;
    int id_d;

    public Disciplina(int id_d){
        this.id_d = id_d;
        this.nombre = "";
        this.importe = -1;
        this.importeCuota = -1;
        this.cuotasMensuales = new ArrayList<CuotaMensual>();
        this.inscripciones = new ArrayList<Inscripcion>();
        this.profesores = new ArrayList<Profesor>();
        this.pagosEquipos = new ArrayList<PagoEquipo>();
    }
    
    public Disciplina(int id_d, String nombre){
        this.id_d = id_d;
        this.nombre = nombre;
    }
    
    public int getId_d() {
        return id_d;
    }

    public void setId_d(int id_d) {
        this.id_d = id_d;
    }
    
    public Disciplina(int id_d, String nombre, float importe, float importeCuota) {
        this.id_d= id_d;
        this.nombre = nombre;
        this.importe = importe;
        this.importeCuota = importeCuota;
        this.cuotasMensuales = new ArrayList<CuotaMensual>();
        this.inscripciones = new ArrayList<Inscripcion>();
        this.profesores = new ArrayList<Profesor>();
        this.pagosEquipos = new ArrayList<PagoEquipo>();
    }
    
    public Disciplina(String nombre, float importe, float importeCuota) {
        this.nombre = nombre;
        this.importe = importe;
        this.importeCuota = importeCuota;
        this.cuotasMensuales = new ArrayList<CuotaMensual>();
        this.inscripciones = new ArrayList<Inscripcion>();
        this.profesores = new ArrayList<Profesor>();
        this.pagosEquipos = new ArrayList<PagoEquipo>();
    }

    public void agregarProfesor(Profesor p){
        this.profesores.add(p);
        p.agregarDisciplina(this);
    }
    
    public void eliminarProfesor(Profesor p){
        this.profesores.remove(p);
        p.eliminarDisciplina(this);
    }
    
    public void agregarPagoEquipo(PagoEquipo pe){
        this.pagosEquipos.add(pe);
        pe.setDisciplina(this);
    }
    
    public void agregarInscripcion(Inscripcion i){
        this.inscripciones.add(i);
        i.setDisciplina(this);
    }
    
    public void agregarCuotaMensual(CuotaMensual c){
        this.cuotasMensuales.add(c);
        c.setDisciplina(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public float getImporteCuota() {
        return importeCuota;
    }

    public void setImporteCuota(float importeCuota) {
        this.importeCuota = importeCuota;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public List<PagoEquipo> getPagosEquipos() {
        return pagosEquipos;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public List<CuotaMensual> getCuotasMensuales() {
        return cuotasMensuales;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "nombre=" + nombre + ", importe=" + importe + ", importeCuota=" + importeCuota + ", profesores=" + profesores + ", pagosEquipos=" + pagosEquipos + ", inscripciones=" + inscripciones + ", cuotasMensuales=" + cuotasMensuales + ", id_d=" + id_d + '}';
    }
}
