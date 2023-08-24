package org.udemy.estructuradatos.encuentratuvuelo;

import java.util.Date;

public class Vuelo {
    private String nombre;
    private String origen;
    private String destino;
    private Date fechaLlegada;
    private int cantPasajeros;

    public Vuelo(String nombre, String origen, String destino, Date fechayHoraLlegada, int numeroPasajeros) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.fechaLlegada = fechayHoraLlegada;
        this.cantPasajeros = numeroPasajeros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public void setCantPasajeros(int cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "nombre='" + nombre + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", fechaLlegada=" + fechaLlegada +
                ", cantPasajeros=" + cantPasajeros +
                '}';
    }
}
