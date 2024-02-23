package com.mycompany.saebu.logica.clases;

import java.sql.*;

public class PagoDeCuota {
    private int nroPago;
    private Date fecha;
    private Time hora;
    private float importe;
    private CuotaMensual cuotaMensual;
    private Operador operador;

    public PagoDeCuota( PagoDeCuota pago){
        this.nroPago = pago.getNroPago();
        this.fecha = pago.getFecha();
        this.hora = pago.getHora();
        this.importe = pago.getImporte();
        this.cuotaMensual = pago.getCuotaMensual();
        this.operador = pago.getOperador();
    }
    
    public PagoDeCuota(int nroPago, Date fecha, Time hora, float importe, CuotaMensual cuotaMensual, Operador operador) {
        this.nroPago = nroPago;
        this.fecha = fecha;
        this.hora = hora;
        this.importe = importe;
        this.cuotaMensual = cuotaMensual;
        this.operador = operador;
    }

    public PagoDeCuota(Date fecha, Time hora, float importe, CuotaMensual cuotaMensual, Operador operador) {
        this.nroPago = nroPago;
        this.fecha = fecha;
        this.hora = hora;
        this.importe = importe;
        this.cuotaMensual = cuotaMensual;
        this.operador = operador;
    }
      
    public PagoDeCuota(Date fecha, Time hora, float importe) {
        this.nroPago = nroPago;
        this.fecha = fecha;
        this.hora = hora;
        this.importe = importe;
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

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public CuotaMensual getCuotaMensual() {
        return cuotaMensual;
    }

    public void setCuotaMensual(CuotaMensual cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    @Override
    public String toString() {
        return "PagoDeCuota{" + "nroPago=" + nroPago + ", fecha=" + fecha + ", hora=" + hora + ", importe=" + importe + ", cuotaMensual=" + cuotaMensual + ", operador=" + operador + '}';
    }
}
