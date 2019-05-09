package com.uniminuto.electiva.session;

import java.io.Serializable;

/**
 *
 * @author joncasasq
 */
public class PeliculaCart implements Serializable{

    private int id;
    private String nombre;
    private int peliculaSalaId;

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

    public int getPeliculaSalaId() {
        return peliculaSalaId;
    }

    public void setPeliculaSalaId(int peliculaSalaId) {
        this.peliculaSalaId = peliculaSalaId;
    }
    
    

}
