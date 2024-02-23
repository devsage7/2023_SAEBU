/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saebu.logica.clases;

public class GenerarPDF extends PDF{
    String nombre, tipo, linea, hora,nombreoperador,nombredisciplina, linea2, linea3, nomarchivo;
    int numero;
    float importe;

    public void setNomarchivo(String nomarchivo) {
        this.nomarchivo = nomarchivo;
    }

    public void setLinea2(String linea2) {
        this.linea2 = linea2;
    }

    public void setLinea3(String linea3) {
        this.linea3 = linea3;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setNombreoperador(String nombreoperador) {
        this.nombreoperador = nombreoperador;
    }

    public void setNombredisciplina(String nombredisciplina) {
        this.nombredisciplina = nombredisciplina;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
    
    @Override
    public String colocarAlumno() {
        return nombre;
    }

    @Override
    public int numero() {
        return numero;
    }

    @Override
    public String paragraph() {
        return linea;
    }

    @Override
    public String tipo() {
        return tipo;
    }

    @Override
    public String hora() {
        return hora;
    }

    @Override
    public String nombreoperador() {
        return nombreoperador;
    }

    @Override
    public String nombredisciplina() {
        return nombredisciplina;
    }

    @Override
    public float importe() {
        return importe;
    } 
    
    @Override
    public String linea2(){
        return linea2;
    }
    
    @Override
    public String linea3(){
        return linea3;
    }
    
    @Override
    public String nomarchivo(){
        return nomarchivo;
    }
}
