package com.mycompany.saebu.logica.clases;

import java.util.*;

public class Operador {
    String nomyApe;
    int nroDoc;
    List<PagoEquipo> pagosEquipos;
    List<PagoDeCuota> pagosDeCuotas;
    List<Inscripcion> inscripciones;
    int id_o;

    public int getId_o() {
        return id_o;
    }

    public void setId_o(int id_o) {
        this.id_o = id_o;
    }

    
    public Operador(int id_o,String nomyApe, int nroDoc) {
        this.id_o= id_o;
        this.nomyApe = nomyApe;
        this.nroDoc = nroDoc;
        this.pagosEquipos = new ArrayList<PagoEquipo>();
        this.pagosDeCuotas = new ArrayList<PagoDeCuota>();
        this.inscripciones = new ArrayList<Inscripcion>();
    }
    
    public Operador(int id_o) {
        this.id_o= id_o;
        this.pagosEquipos = new ArrayList<PagoEquipo>();
        this.pagosDeCuotas = new ArrayList<PagoDeCuota>();
        this.inscripciones = new ArrayList<Inscripcion>();
    }
    
    public void agregarPagoEquipo(PagoEquipo pe){
        this.pagosEquipos.add(pe);
        pe.setOperador(this);
    }
    
    public void agregarPagoDeCuota(PagoDeCuota pdc){
        this.pagosDeCuotas.add(pdc);
        pdc.setOperador(this);
    }
    
    public void agregarInscripcion(Inscripcion i){
        this.inscripciones.add(i);
        i.setOperador(this);
    }

    public String getNomyApe() {
        return nomyApe;
    }

    public void setNomyApe(String nomyApe) {
        this.nomyApe = nomyApe;
    }

    public int getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(int nroDoc) {
        this.nroDoc = nroDoc;
    }

    public List<PagoEquipo> getPagosEquipos() {
        return pagosEquipos;
    }

    public List<PagoDeCuota> getPagosDeCuotas() {
        return pagosDeCuotas;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    @Override
    public String toString() {
        return "Operador{" + "nomyApe=" + nomyApe + ", nroDoc=" + nroDoc + ", pagosEquipos=" + pagosEquipos + ", pagosDeCuotas=" + pagosDeCuotas + ", inscripciones=" + inscripciones + '}';
    }
}
