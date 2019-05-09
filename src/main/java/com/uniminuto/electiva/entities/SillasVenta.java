/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joncasasq
 */
@Entity
@Table(name = "sillas_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SillasVenta.findAll", query = "SELECT s FROM SillasVenta s")
    , @NamedQuery(name = "SillasVenta.findById", query = "SELECT s FROM SillasVenta s WHERE s.sillasVentaPK.id = :id")
    , @NamedQuery(name = "SillasVenta.findByFila", query = "SELECT s FROM SillasVenta s WHERE s.fila = :fila")
    , @NamedQuery(name = "SillasVenta.findByColumna", query = "SELECT s FROM SillasVenta s WHERE s.columna = :columna")
    , @NamedQuery(name = "SillasVenta.findByTipo", query = "SELECT s FROM SillasVenta s WHERE s.tipo = :tipo")
    , @NamedQuery(name = "SillasVenta.findByPeliculasVentaId", query = "SELECT s FROM SillasVenta s WHERE s.sillasVentaPK.peliculasVentaId = :peliculasVentaId")
    , @NamedQuery(name = "SillasVenta.findByPeliculasVentaVentasId", query = "SELECT s FROM SillasVenta s WHERE s.sillasVentaPK.peliculasVentaVentasId = :peliculasVentaVentasId")
    , @NamedQuery(name = "SillasVenta.findByPeliculasVentaVentasClientesId", query = "SELECT s FROM SillasVenta s WHERE s.sillasVentaPK.peliculasVentaVentasClientesId = :peliculasVentaVentasClientesId")
    , @NamedQuery(name = "SillasVenta.findByPeliculasVentaPeliculasSalaId", query = "SELECT s FROM SillasVenta s WHERE s.sillasVentaPK.peliculasVentaPeliculasSalaId = :peliculasVentaPeliculasSalaId")
    , @NamedQuery(name = "SillasVenta.findByPeliculasVentaPeliculasSalaPeliculasId", query = "SELECT s FROM SillasVenta s WHERE s.sillasVentaPK.peliculasVentaPeliculasSalaPeliculasId = :peliculasVentaPeliculasSalaPeliculasId")
    , @NamedQuery(name = "SillasVenta.findByPeliculasVentaPeliculasSalaSalasId", query = "SELECT s FROM SillasVenta s WHERE s.sillasVentaPK.peliculasVentaPeliculasSalaSalasId = :peliculasVentaPeliculasSalaSalasId")
    , @NamedQuery(name = "SillasVenta.findByPeliculasVentaPeliculasSalaSalasMultiplexsId", query = "SELECT s FROM SillasVenta s WHERE s.sillasVentaPK.peliculasVentaPeliculasSalaSalasMultiplexsId = :peliculasVentaPeliculasSalaSalasMultiplexsId")
    , @NamedQuery(name = "SillasVenta.findByPuntos", query = "SELECT s FROM SillasVenta s WHERE s.puntos = :puntos")})
public class SillasVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SillasVentaPK sillasVentaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fila")
    private String fila;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "columna")
    private String columna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntos")
    private int puntos;
    @JoinColumns({
        @JoinColumn(name = "peliculas_venta_id", referencedColumnName = "id", insertable = false, updatable = false)
        , @JoinColumn(name = "peliculas_venta_ventas_id", referencedColumnName = "ventas_id", insertable = false, updatable = false)
        , @JoinColumn(name = "peliculas_venta_ventas_clientes_id", referencedColumnName = "ventas_clientes_id", insertable = false, updatable = false)
        , @JoinColumn(name = "peliculas_venta_peliculas_sala_id", referencedColumnName = "peliculas_sala_id", insertable = false, updatable = false)
        , @JoinColumn(name = "peliculas_venta_peliculas_sala_peliculas_id", referencedColumnName = "peliculas_sala_peliculas_id", insertable = false, updatable = false)
        , @JoinColumn(name = "peliculas_venta_peliculas_sala_salas_id", referencedColumnName = "peliculas_sala_salas_id", insertable = false, updatable = false)
        , @JoinColumn(name = "peliculas_venta_peliculas_sala_salas_multiplexs_id", referencedColumnName = "peliculas_sala_salas_multiplexs_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PeliculasVenta peliculasVenta;

    public SillasVenta() {
    }

    public SillasVenta(SillasVentaPK sillasVentaPK) {
        this.sillasVentaPK = sillasVentaPK;
    }

    public SillasVenta(SillasVentaPK sillasVentaPK, String fila, String columna, String tipo, int puntos) {
        this.sillasVentaPK = sillasVentaPK;
        this.fila = fila;
        this.columna = columna;
        this.tipo = tipo;
        this.puntos = puntos;
    }

    public SillasVenta(int id, int peliculasVentaId, int peliculasVentaVentasId, int peliculasVentaVentasClientesId, int peliculasVentaPeliculasSalaId, int peliculasVentaPeliculasSalaPeliculasId, int peliculasVentaPeliculasSalaSalasId, int peliculasVentaPeliculasSalaSalasMultiplexsId) {
        this.sillasVentaPK = new SillasVentaPK(id, peliculasVentaId, peliculasVentaVentasId, peliculasVentaVentasClientesId, peliculasVentaPeliculasSalaId, peliculasVentaPeliculasSalaPeliculasId, peliculasVentaPeliculasSalaSalasId, peliculasVentaPeliculasSalaSalasMultiplexsId);
    }

    public SillasVentaPK getSillasVentaPK() {
        return sillasVentaPK;
    }

    public void setSillasVentaPK(SillasVentaPK sillasVentaPK) {
        this.sillasVentaPK = sillasVentaPK;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public PeliculasVenta getPeliculasVenta() {
        return peliculasVenta;
    }

    public void setPeliculasVenta(PeliculasVenta peliculasVenta) {
        this.peliculasVenta = peliculasVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sillasVentaPK != null ? sillasVentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SillasVenta)) {
            return false;
        }
        SillasVenta other = (SillasVenta) object;
        if ((this.sillasVentaPK == null && other.sillasVentaPK != null) || (this.sillasVentaPK != null && !this.sillasVentaPK.equals(other.sillasVentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.electiva.entities.SillasVenta[ sillasVentaPK=" + sillasVentaPK + " ]";
    }
    
}
