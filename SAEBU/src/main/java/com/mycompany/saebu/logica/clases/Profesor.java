package com.mycompany.saebu.logica.clases;

import java.sql.Date;
import java.util.*;


public class Profesor extends Persona{
    String art;
    Date fecIng;
    List<Disciplina> disciplinas;

    public Profesor(String art, Date fecIng, String nomyApe, String tipoDoc, int nroDoc, String domicilio, String localidad, String provincia, String tel, Date fecNac, String sexo) {
        super(nomyApe, tipoDoc, nroDoc, domicilio, localidad, provincia, tel, fecNac, sexo);
        this.art = art;
        this.fecIng = fecIng;
        this.disciplinas = new ArrayList<Disciplina>();
    }

    public Profesor(String art, Date fecIng, String nomyApe, String tipoDoc, int nroDoc, String domicilio, String barrio, String localidad, String provincia, String tel, Date fecNac, String sexo) {
        super(nomyApe, tipoDoc, nroDoc, domicilio, barrio, localidad, provincia, tel, fecNac, sexo);
        this.art = art;
        this.fecIng = fecIng;
        this.disciplinas = new ArrayList<Disciplina>();
    }

    public Profesor(String art, Date fecIng, String nomyApe, String apellido, String tipoDoc, int nroDoc, String domicilio, String localidad, String provincia, String tel, Date fecNac, String sexo, String observaciones) {
        super(nomyApe, apellido, tipoDoc, nroDoc, domicilio, localidad, provincia, tel, fecNac, sexo, observaciones);
        this.art = art;
        this.fecIng = fecIng;
        this.disciplinas = new ArrayList<Disciplina>();
    }

    public Profesor(String art, Date fecIng, String nomyApe, String tipoDoc, int nroDoc, String domicilio, String barrio, String localidad, String provincia, String tel, Date fecNac, String sexo, String observaciones) {
        super(nomyApe, tipoDoc, nroDoc, domicilio, barrio, localidad, provincia, tel, fecNac, sexo, observaciones);
        this.art = art;
        this.fecIng = fecIng;
        this.disciplinas = new ArrayList<Disciplina>();
    }

    public void agregarDisciplina(Disciplina d){
        this.disciplinas.add(d);
        d.agregarProfesor(this);
    }
    
    public void eliminarDisciplina(Disciplina d){
        this.disciplinas.remove(d);
        d.eliminarProfesor(this);
    }
    
    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public Date getFecIng() {
        return fecIng;
    }

    public void setFecIng(Date fecIng) {
        this.fecIng = fecIng;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    @Override
    public String toString() {
        return "Profesor{" + "art=" + art + ", fecIng=" + fecIng + ", disciplinas=" + disciplinas + '}';
    }
}
