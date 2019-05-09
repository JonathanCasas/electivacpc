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
public class SillasVentaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peliculas_venta_id")
    private int peliculasVentaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peliculas_venta_ventas_id")
    private int peliculasVentaVentasId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peliculas_venta_ventas_clientes_id")
    private int peliculasVentaVentasClientesId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peliculas_venta_peliculas_sala_id")
    private int peliculasVentaPeliculasSalaId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peliculas_venta_peliculas_sala_peliculas_id")
    private int peliculasVentaPeliculasSalaPeliculasId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peliculas_venta_peliculas_sala_salas_id")
    private int peliculasVentaPeliculasSalaSalasId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peliculas_venta_peliculas_sala_salas_multiplexs_id")
    private int peliculasVentaPeliculasSalaSalasMultiplexsId;

    public SillasVentaPK() {
    }

    public SillasVentaPK(int id, int peliculasVentaId, int peliculasVentaVentasId, int peliculasVentaVentasClientesId, int peliculasVentaPeliculasSalaId, int peliculasVentaPeliculasSalaPeliculasId, int peliculasVentaPeliculasSalaSalasId, int peliculasVentaPeliculasSalaSalasMultiplexsId) {
        this.id = id;
        this.peliculasVentaId = peliculasVentaId;
        this.peliculasVentaVentasId = peliculasVentaVentasId;
        this.peliculasVentaVentasClientesId = peliculasVentaVentasClientesId;
        this.peliculasVentaPeliculasSalaId = peliculasVentaPeliculasSalaId;
        this.peliculasVentaPeliculasSalaPeliculasId = peliculasVentaPeliculasSalaPeliculasId;
        this.peliculasVentaPeliculasSalaSalasId = peliculasVentaPeliculasSalaSalasId;
        this.peliculasVentaPeliculasSalaSalasMultiplexsId = peliculasVentaPeliculasSalaSalasMultiplexsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeliculasVentaId() {
        return peliculasVentaId;
    }

    public void setPeliculasVentaId(int peliculasVentaId) {
        this.peliculasVentaId = peliculasVentaId;
    }

    public int getPeliculasVentaVentasId() {
        return peliculasVentaVentasId;
    }

    public void setPeliculasVentaVentasId(int peliculasVentaVentasId) {
        this.peliculasVentaVentasId = peliculasVentaVentasId;
    }

    public int getPeliculasVentaVentasClientesId() {
        return peliculasVentaVentasClientesId;
    }

    public void setPeliculasVentaVentasClientesId(int peliculasVentaVentasClientesId) {
        this.peliculasVentaVentasClientesId = peliculasVentaVentasClientesId;
    }

    public int getPeliculasVentaPeliculasSalaId() {
        return peliculasVentaPeliculasSalaId;
    }

    public void setPeliculasVentaPeliculasSalaId(int peliculasVentaPeliculasSalaId) {
        this.peliculasVentaPeliculasSalaId = peliculasVentaPeliculasSalaId;
    }

    public int getPeliculasVentaPeliculasSalaPeliculasId() {
        return peliculasVentaPeliculasSalaPeliculasId;
    }

    public void setPeliculasVentaPeliculasSalaPeliculasId(int peliculasVentaPeliculasSalaPeliculasId) {
        this.peliculasVentaPeliculasSalaPeliculasId = peliculasVentaPeliculasSalaPeliculasId;
    }

    public int getPeliculasVentaPeliculasSalaSalasId() {
        return peliculasVentaPeliculasSalaSalasId;
    }

    public void setPeliculasVentaPeliculasSalaSalasId(int peliculasVentaPeliculasSalaSalasId) {
        this.peliculasVentaPeliculasSalaSalasId = peliculasVentaPeliculasSalaSalasId;
    }

    public int getPeliculasVentaPeliculasSalaSalasMultiplexsId() {
        return peliculasVentaPeliculasSalaSalasMultiplexsId;
    }

    public void setPeliculasVentaPeliculasSalaSalasMultiplexsId(int peliculasVentaPeliculasSalaSalasMultiplexsId) {
        this.peliculasVentaPeliculasSalaSalasMultiplexsId = peliculasVentaPeliculasSalaSalasMultiplexsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) peliculasVentaId;
        hash += (int) peliculasVentaVentasId;
        hash += (int) peliculasVentaVentasClientesId;
        hash += (int) peliculasVentaPeliculasSalaId;
        hash += (int) peliculasVentaPeliculasSalaPeliculasId;
        hash += (int) peliculasVentaPeliculasSalaSalasId;
        hash += (int) peliculasVentaPeliculasSalaSalasMultiplexsId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SillasVentaPK)) {
            return false;
        }
        SillasVentaPK other = (SillasVentaPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.peliculasVentaId != other.peliculasVentaId) {
            return false;
        }
        if (this.peliculasVentaVentasId != other.peliculasVentaVentasId) {
            return false;
        }
        if (this.peliculasVentaVentasClientesId != other.peliculasVentaVentasClientesId) {
            return false;
        }
        if (this.peliculasVentaPeliculasSalaId != other.peliculasVentaPeliculasSalaId) {
            return false;
        }
        if (this.peliculasVentaPeliculasSalaPeliculasId != other.peliculasVentaPeliculasSalaPeliculasId) {
            return false;
        }
        if (this.peliculasVentaPeliculasSalaSalasId != other.peliculasVentaPeliculasSalaSalasId) {
            return false;
        }
        if (this.peliculasVentaPeliculasSalaSalasMultiplexsId != other.peliculasVentaPeliculasSalaSalasMultiplexsId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.electiva.entities.SillasVentaPK[ id=" + id + ", peliculasVentaId=" + peliculasVentaId + ", peliculasVentaVentasId=" + peliculasVentaVentasId + ", peliculasVentaVentasClientesId=" + peliculasVentaVentasClientesId + ", peliculasVentaPeliculasSalaId=" + peliculasVentaPeliculasSalaId + ", peliculasVentaPeliculasSalaPeliculasId=" + peliculasVentaPeliculasSalaPeliculasId + ", peliculasVentaPeliculasSalaSalasId=" + peliculasVentaPeliculasSalaSalasId + ", peliculasVentaPeliculasSalaSalasMultiplexsId=" + peliculasVentaPeliculasSalaSalasMultiplexsId + " ]";
    }
    
}
