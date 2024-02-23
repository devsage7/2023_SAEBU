
package com.mycompany.saebu.logica.clases;

import java.sql.Date;


public abstract class Persona {
    String nomyApe;
    String tipoDoc;
    int nroDoc;
    String domicilio;
    String barrio;
    String localidad;
    String provincia;
    String tel;
    Date fecNac;
    String sexo;
    String observaciones;
   // int cod;

    public Persona(int nroDoc){
        this.nroDoc = nroDoc;
        this.nomyApe = "";
        this.tipoDoc = ""; 
        this.nroDoc = -1;
        this.domicilio = "";
        this.barrio = "";
        this.localidad = "";
        this.provincia = "";
        this.tel = "";
        this.fecNac = null;
        this.sexo = "";
        this.observaciones = "";
    }
    public Persona(){
        
    }
    public Persona(String nomyApe, String tipoDoc, int nroDoc, String domicilio, String localidad, String provincia, String tel, Date fecNac, String sexo) {
        this.nomyApe = nomyApe;
        this.tipoDoc = tipoDoc;
        this.nroDoc = nroDoc;
        this.domicilio = domicilio;
        this.localidad = localidad;
        this.provincia = provincia;
        this.tel = tel;
        this.fecNac = fecNac;
        this.sexo = sexo;
    }

    public Persona(String nomyApe, String tipoDoc, int nroDoc, String domicilio, String barrio, String localidad, String provincia, String tel, Date fecNac, String sexo) {
        this.nomyApe = nomyApe;
        this.tipoDoc = tipoDoc;
        this.nroDoc = nroDoc;
        this.domicilio = domicilio;
        this.barrio = barrio;
        this.localidad = localidad;
        this.provincia = provincia;
        this.tel = tel;
        this.fecNac = fecNac;
        this.sexo = sexo;
    }

    public Persona(String nomyApe, String apellido, String tipoDoc, int nroDoc, String domicilio, String localidad, String provincia, String tel, Date fecNac, String sexo, String observaciones) {
        this.nomyApe = nomyApe;
        this.tipoDoc = tipoDoc;
        this.nroDoc = nroDoc;
        this.domicilio = domicilio;
        this.localidad = localidad;
        this.provincia = provincia;
        this.tel = tel;
        this.fecNac = fecNac;
        this.sexo = sexo;
        this.observaciones = observaciones;
    }
    
    public Persona(String nomyApe, String tipoDoc, int nroDoc, String domicilio, String barrio, String localidad, String provincia, String tel, Date fecNac, String sexo, String observaciones) {
        this.nomyApe = nomyApe;
        this.tipoDoc = tipoDoc;
        this.nroDoc = nroDoc;
        this.domicilio = domicilio;
        this.barrio = barrio;
        this.localidad = localidad;
        this.provincia = provincia;
        this.tel = tel;
        this.fecNac = fecNac;
        this.sexo = sexo;
        this.observaciones = observaciones;
    }

    public String getNomyApe() {
        return nomyApe;
    }

    public void setNomyApe(String nomyApe) {
        this.nomyApe = nomyApe;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public int getNroDoc() {
        return nroDoc;
    }

    public void setNroDoc(int nroDoc) {
        this.nroDoc = nroDoc;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Persona{" + "nomyApe=" + nomyApe + ", tipoDoc=" + tipoDoc + ", nroDoc=" + nroDoc + ", domicilio=" + domicilio + ", barrio=" + barrio + ", localidad=" + localidad + ", provincia=" + provincia + ", tel=" + tel + ", fecNac=" + fecNac + ", sexo=" + sexo + ", observaciones=" + observaciones + '}';
    }

}
