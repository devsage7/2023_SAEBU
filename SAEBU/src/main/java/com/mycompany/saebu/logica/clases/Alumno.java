package com.mycompany.saebu.logica.clases;

import java.sql.Date;
import java.util.*;

public class Alumno extends Persona {
    TipoAlumno tipoAlumno;
    TipoSeguro tipoSeguro;
    List<CuotaMensual> cuotasMensuales;
    List<Inscripcion> inscripciones;
    int id_a;
    
    public int getId_a() {
        return id_a;
    }

    public void setId_a(int id_a) {
        this.id_a = id_a;
    }
    
    public Alumno(int id){
        super();
        this.id_a=id;
        this.tipoAlumno = null;
        this.tipoSeguro = null;
        this.cuotasMensuales = new ArrayList<CuotaMensual>();
        this.inscripciones = new ArrayList<Inscripcion>();
    }
    
    public Alumno(int cod,TipoAlumno tipoAlumno, TipoSeguro tipoSeguro, String nomyApe, String tipoDoc, int nroDoc, String domicilio, String localidad, String provincia, String tel, Date fecNac, String sexo, Inscripcion i) {
        super(nomyApe, tipoDoc, nroDoc, domicilio, localidad, provincia, tel, fecNac, sexo);
        this.id_a=cod;
        this.tipoAlumno = tipoAlumno;
        this.tipoSeguro = tipoSeguro;
        this.cuotasMensuales = new ArrayList<CuotaMensual>();
        this.inscripciones = new ArrayList<Inscripcion>();
        this.inscripciones.add(i);
        i.setAlumno(this);
    }

    public Alumno(int cod,TipoAlumno tipoAlumno, TipoSeguro tipoSeguro, String nomyApe, String tipoDoc, int nroDoc, String domicilio, String barrio, String localidad, String provincia, String tel, Date fecNac, String sexo, Inscripcion i) {
        super(nomyApe, tipoDoc, nroDoc, domicilio, barrio, localidad, provincia, tel, fecNac, sexo);
        this.id_a=cod;        
        this.tipoAlumno = tipoAlumno;
        this.tipoSeguro = tipoSeguro;
        this.cuotasMensuales = new ArrayList<CuotaMensual>();
        this.inscripciones = new ArrayList<Inscripcion>();
        this.inscripciones.add(i);
        i.setAlumno(this);
    }

    public Alumno(int cod,TipoAlumno tipoAlumno, TipoSeguro tipoSeguro, String nomyApe, String apellido, String tipoDoc, int nroDoc, String domicilio, String localidad, String provincia, String tel, Date fecNac, String sexo, String observaciones, Inscripcion i) {
        super(nomyApe, apellido, tipoDoc, nroDoc, domicilio, localidad, provincia, tel, fecNac, sexo, observaciones);
        this.id_a=cod;
        this.tipoAlumno = tipoAlumno;
        this.tipoSeguro = tipoSeguro;
        this.cuotasMensuales = new ArrayList<CuotaMensual>();
        this.inscripciones = new ArrayList<Inscripcion>();
        this.inscripciones.add(i);
        i.setAlumno(this);
    }

    public Alumno(int cod,TipoAlumno tipoAlumno, TipoSeguro tipoSeguro, String nomyApe, String tipoDoc, int nroDoc, String domicilio, String barrio, String localidad, String provincia, String tel, Date fecNac, String sexo, String observaciones, Inscripcion i) {
        super(nomyApe, tipoDoc, nroDoc, domicilio, barrio, localidad, provincia, tel, fecNac, sexo, observaciones);
        this.id_a=cod;
        this.tipoAlumno = tipoAlumno;
        this.tipoSeguro = tipoSeguro;
        this.cuotasMensuales = new ArrayList<CuotaMensual>();
        this.inscripciones = new ArrayList<Inscripcion>();
        this.inscripciones.add(i);
        i.setAlumno(this);
    }
    
    public Alumno(int cod,TipoAlumno tipoAlumno, TipoSeguro tipoSeguro, String nomyApe, String tipoDoc, int nroDoc, String domicilio, String localidad, String provincia, String tel, Date fecNac, String sexo) {
        super(nomyApe, tipoDoc, nroDoc, domicilio, localidad, provincia, tel, fecNac, sexo);
        this.id_a=cod;
        this.tipoAlumno = tipoAlumno;
        this.tipoSeguro = tipoSeguro;
        this.cuotasMensuales = new ArrayList<CuotaMensual>();
        this.inscripciones = new ArrayList<Inscripcion>();
    }

    public Alumno(int cod,TipoAlumno tipoAlumno, TipoSeguro tipoSeguro, String nomyApe, String tipoDoc, int nroDoc, String domicilio, String barrio, String localidad, String provincia, String tel, Date fecNac, String sexo) {
        super(nomyApe, tipoDoc, nroDoc, domicilio, barrio, localidad, provincia, tel, fecNac, sexo);
        this.id_a=cod;
        this.tipoAlumno = tipoAlumno;
        this.tipoSeguro = tipoSeguro;
        this.cuotasMensuales = new ArrayList<CuotaMensual>();
        this.inscripciones = new ArrayList<Inscripcion>();
    }

    public Alumno(int cod,TipoAlumno tipoAlumno, TipoSeguro tipoSeguro, String nomyApe, String apellido, String tipoDoc, int nroDoc, String domicilio, String localidad, String provincia, String tel, Date fecNac, String sexo, String observaciones) {
        super(nomyApe, apellido, tipoDoc, nroDoc, domicilio, localidad, provincia, tel, fecNac, sexo, observaciones);
        this.id_a=cod;
        this.tipoAlumno = tipoAlumno;
        this.tipoSeguro = tipoSeguro;
        this.cuotasMensuales = new ArrayList<CuotaMensual>();
        this.inscripciones = new ArrayList<Inscripcion>();
    }

    public Alumno(int cod,TipoAlumno tipoAlumno, TipoSeguro tipoSeguro, String nomyApe, String tipoDoc, int nroDoc, String domicilio, String barrio, String localidad, String provincia, String tel, Date fecNac, String sexo, String observaciones) {
        super(nomyApe, tipoDoc, nroDoc, domicilio, barrio, localidad, provincia, tel, fecNac, sexo, observaciones);
        this.id_a=cod;
        this.tipoAlumno = tipoAlumno;
        this.tipoSeguro = tipoSeguro;
        this.cuotasMensuales = new ArrayList<CuotaMensual>();
        this.inscripciones = new ArrayList<Inscripcion>();
    }
    
    public void agregarCuotaMensual(CuotaMensual c){
        this.cuotasMensuales.add(c);
        c.setAlumno(this);
    }

    public void agregarInscripcion(Inscripcion i){
        this.inscripciones.add(i);
        i.setAlumno(this);
    }

    public TipoAlumno getTipoAlumno() {
        return tipoAlumno;
    }

    public void setTipoAlumno(TipoAlumno tipoAlumno) {
        this.tipoAlumno = tipoAlumno;
    }

    public TipoSeguro getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(TipoSeguro tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public List<CuotaMensual> getCuotasMensuales() {
        return cuotasMensuales;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    @Override
    public String toString() {
        return "Alumno{" + "tipoAlumno=" + tipoAlumno + ", tipoSeguro=" + tipoSeguro + ", cuotasMensuales=" + cuotasMensuales + ", inscripciones=" + inscripciones + '}';
    }
}