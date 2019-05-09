/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.request;

/**
 *
 * @author joncasasq
 */
public class StoreEmpleadoRequest {

    private String nombre;
    private String codigo;
    private String telefono;
    private String cedula;
    private int multiplex;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getMultiplex() {
        return multiplex;
    }

    public void setMultiplex(int multiplex) {
        this.multiplex = multiplex;
    }

}
