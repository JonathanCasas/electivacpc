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
public class PeliculasVentaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ventas_id")
    private int ventasId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ventas_clientes_id")
    private int ventasClientesId;
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

    public PeliculasVentaPK() {
    }

    public PeliculasVentaPK(int id, int ventasId, int ventasClientesId, int peliculasSalaId, int peliculasSalaPeliculasId, int peliculasSalaSalasId, int peliculasSalaSalasMultiplexsId) {
        this.id = id;
        this.ventasId = ventasId;
        this.ventasClientesId = ventasClientesId;
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

    public int getVentasId() {
        return ventasId;
    }

    public void setVentasId(int ventasId) {
        this.ventasId = ventasId;
    }

    public int getVentasClientesId() {
        return ventasClientesId;
    }

    public void setVentasClientesId(int ventasClientesId) {
        this.ventasClientesId = ventasClientesId;
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
        hash += (int) ventasId;
        hash += (int) ventasClientesId;
        hash += (int) peliculasSalaId;
        hash += (int) peliculasSalaPeliculasId;
        hash += (int) peliculasSalaSalasId;
        hash += (int) peliculasSalaSalasMultiplexsId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeliculasVentaPK)) {
            return false;
        }
        PeliculasVentaPK other = (PeliculasVentaPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.ventasId != other.ventasId) {
            return false;
        }
        if (this.ventasClientesId != other.ventasClientesId) {
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
        return "com.uniminuto.electiva.entities.PeliculasVentaPK[ id=" + id + ", ventasId=" + ventasId + ", ventasClientesId=" + ventasClientesId + ", peliculasSalaId=" + peliculasSalaId + ", peliculasSalaPeliculasId=" + peliculasSalaPeliculasId + ", peliculasSalaSalasId=" + peliculasSalaSalasId + ", peliculasSalaSalasMultiplexsId=" + peliculasSalaSalasMultiplexsId + " ]";
    }
    
}
