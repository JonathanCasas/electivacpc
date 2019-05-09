/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.ui;

/**
 *
 * @author joncasasq
 */
public class PeliculaSalaUI {

    private int id;
    private String nombre;
    private String inicio;
    private String fin;
    private String sala;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
    
    

    @Override
    public String toString() {
        return "PeliculaSalaUI{" + "id=" + id + ", nombre=" + nombre + ", inicio=" + inicio + ", fin=" + fin + '}';
    }

}
