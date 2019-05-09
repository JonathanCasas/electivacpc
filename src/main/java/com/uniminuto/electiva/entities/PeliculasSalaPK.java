/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author joncasasq
 */
@Embeddable
public class PeliculasSalaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peliculas_id")
    private int peliculasId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salas_id")
    private int salasId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salas_multiplexs_id")
    private int salasMultiplexsId;

    public PeliculasSalaPK() {
    }

    public PeliculasSalaPK(int id, int peliculasId, int salasId, int salasMultiplexsId) {
        this.id = id;
        this.peliculasId = peliculasId;
        this.salasId = salasId;
        this.salasMultiplexsId = salasMultiplexsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeliculasId() {
        return peliculasId;
    }

    public void setPeliculasId(int peliculasId) {
        this.peliculasId = peliculasId;
    }

    public int getSalasId() {
        return salasId;
    }

    public void setSalasId(int salasId) {
        this.salasId = salasId;
    }

    public int getSalasMultiplexsId() {
        return salasMultiplexsId;
    }

    public void setSalasMultiplexsId(int salasMultiplexsId) {
        this.salasMultiplexsId = salasMultiplexsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) peliculasId;
        hash += (int) salasId;
        hash += (int) salasMultiplexsId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeliculasSalaPK)) {
            return false;
        }
        PeliculasSalaPK other = (PeliculasSalaPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.peliculasId != other.peliculasId) {
            return false;
        }
        if (this.salasId != other.salasId) {
            return false;
        }
        if (this.salasMultiplexsId != other.salasMultiplexsId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.electiva.entities.PeliculasSalaPK[ id=" + id + ", peliculasId=" + peliculasId + ", salasId=" + salasId + ", salasMultiplexsId=" + salasMultiplexsId + " ]";
    }
    
}
