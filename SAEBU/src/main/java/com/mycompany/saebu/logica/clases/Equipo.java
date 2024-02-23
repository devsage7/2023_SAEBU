package com.mycompany.saebu.logica.clases;

public class Equipo {
    private int cod;
    private String nombre;
    private int cantIntegrantes;
    private PagoEquipo pagoEquipo;

    public Equipo(int cod, String nombre, int cantIntegrantes, PagoEquipo pe) {
        this.cod = cod;
        this.nombre = nombre;
        this.cantIntegrantes = cantIntegrantes;
        this.pagoEquipo = pe;
    }
    
    public Equipo( int cod, String nombre, int cantIntegrantes){
        this.cod = cod;
        this.nombre = nombre;
        this.cantIntegrantes = cantIntegrantes;
    }
    
    public Equipo( int id_e ){
        this.cod = id_e;
        this.nombre = "";
        this.cantIntegrantes = -1;
        this.pagoEquipo = null;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantIntegrantes() {
        return cantIntegrantes;
    }

    public void setCantIntegrantes(int cantIntegrantes) {
        this.cantIntegrantes = cantIntegrantes;
    }

    public PagoEquipo getPagoEquipo() {
        return pagoEquipo;
    }

    public void setPagoEquipo(PagoEquipo pagoEquipo) {
        this.pagoEquipo = pagoEquipo;
    }

    @Override
    public String toString() {
        return "Equipo{" + "cod=" + cod + ", nombre=" + nombre + ", cantIntegrantes=" + cantIntegrantes + ", pagoEquipo=" + pagoEquipo + '}';
    }
}
