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
public class HorariosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peliculas_sala_id")
    private int peliculasSalaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peliculas_sala_peliculas_id")
    private int peliculasSalaPeliculasId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peliculas_sala_salas_id")
    private int peliculasSalaSalasId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peliculas_sala_salas_multiplexs_id")
    private int peliculasSalaSalasMultiplexsId;

    public HorariosPK() {
    }

    public HorariosPK(int id, int peliculasSalaId, int peliculasSalaPeliculasId, int peliculasSalaSalasId, int peliculasSalaSalasMultiplexsId) {
        this.id = id;
        this.peliculasSalaId = peliculasSalaId;
        this.peliculasSalaPeliculasId = peliculasSalaPeliculasId;
        this.peliculasSalaSalasId = peliculasSalaSalasId;
        this.peliculasSalaSalasMultiplexsId = peliculasSalaSalasMultiplexsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeliculasSalaId() {
        return peliculasSalaId;
    }

    public void setPeliculasSalaId(int peliculasSalaId) {
        this.peliculasSalaId = peliculasSalaId;
    }

    public int getPeliculasSalaPeliculasId() {
        return peliculasSalaPeliculasId;
    }

    public void setPeliculasSalaPeliculasId(int peliculasSalaPeliculasId) {
        this.peliculasSalaPeliculasId = peliculasSalaPeliculasId;
    }

    public int getPeliculasSalaSalasId() {
        return peliculasSalaSalasId;
    }

    public void setPeliculasSalaSalasId(int peliculasSalaSalasId) {
        this.peliculasSalaSalasId = peliculasSalaSalasId;
    }

    public int getPeliculasSalaSalasMultiplexsId() {
        return peliculasSalaSalasMultiplexsId;
    }

    public void setPeliculasSalaSalasMultiplexsId(int peliculasSalaSalasMultiplexsId) {
        this.peliculasSalaSalasMultiplexsId = peliculasSalaSalasMultiplexsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) peliculasSalaId;
        hash += (int) peliculasSalaPeliculasId;
        hash += (int) peliculasSalaSalasId;
        hash += (int) peliculasSalaSalasMultiplexsId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorariosPK)) {
            return false;
        }
        HorariosPK other = (HorariosPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.peliculasSalaId != other.peliculasSalaId) {
            return false;
        }
        if (this.peliculasSalaPeliculasId != other.peliculasSalaPeliculasId) {
            return false;
        }
        if (this.peliculasSalaSalasId != other.peliculasSalaSalasId) {
            return false;
        }
        if (this.peliculasSalaSalasMultiplexsId != other.peliculasSalaSalasMultiplexsId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.electiva.entities.HorariosPK[ id=" + id + ", peliculasSalaId=" + peliculasSalaId + ", peliculasSalaPeliculasId=" + peliculasSalaPeliculasId + ", peliculasSalaSalasId=" + peliculasSalaSalasId + ", peliculasSalaSalasMultiplexsId=" + peliculasSalaSalasMultiplexsId + " ]";
    }
    
}
