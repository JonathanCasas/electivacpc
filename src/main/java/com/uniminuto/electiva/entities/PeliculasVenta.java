/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joncasasq
 */
@Entity
@Table(name = "peliculas_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeliculasVenta.findAll", query = "SELECT p FROM PeliculasVenta p")
    , @NamedQuery(name = "PeliculasVenta.findById", query = "SELECT p FROM PeliculasVenta p WHERE p.peliculasVentaPK.id = :id")
    , @NamedQuery(name = "PeliculasVenta.findByVentasId", query = "SELECT p FROM PeliculasVenta p WHERE p.peliculasVentaPK.ventasId = :ventasId")
    , @NamedQuery(name = "PeliculasVenta.findByVentasClientesId", query = "SELECT p FROM PeliculasVenta p WHERE p.peliculasVentaPK.ventasClientesId = :ventasClientesId")
    , @NamedQuery(name = "PeliculasVenta.findByPeliculasSalaId", query = "SELECT p FROM PeliculasVenta p WHERE p.peliculasVentaPK.peliculasSalaId = :peliculasSalaId")
    , @NamedQuery(name = "PeliculasVenta.findByPeliculasSalaPeliculasId", query = "SELECT p FROM PeliculasVenta p WHERE p.peliculasVentaPK.peliculasSalaPeliculasId = :peliculasSalaPeliculasId")
    , @NamedQuery(name = "PeliculasVenta.findByPeliculasSalaSalasId", query = "SELECT p FROM PeliculasVenta p WHERE p.peliculasVentaPK.peliculasSalaSalasId = :peliculasSalaSalasId")
    , @NamedQuery(name = "PeliculasVenta.findByPeliculasSalaSalasMultiplexsId", query = "SELECT p FROM PeliculasVenta p WHERE p.peliculasVentaPK.peliculasSalaSalasMultiplexsId = :peliculasSalaSalasMultiplexsId")
    , @NamedQuery(name = "PeliculasVenta.findByPuntos", query = "SELECT p FROM PeliculasVenta p WHERE p.puntos = :puntos")})
public class PeliculasVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PeliculasVentaPK peliculasVentaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puntos")
    private int puntos;
    @JoinColumns({
        @JoinColumn(name = "peliculas_sala_id", referencedColumnName = "id", insertable = false, updatable = false)
        , @JoinColumn(name = "peliculas_sala_peliculas_id", referencedColumnName = "peliculas_id", insertable = false, updatable = false)
        , @JoinColumn(name = "peliculas_sala_salas_id", referencedColumnName = "salas_id", insertable = false, updatable = false)
        , @JoinColumn(name = "peliculas_sala_salas_multiplexs_id", referencedColumnName = "salas_multiplexs_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PeliculasSala peliculasSala;
    @JoinColumns({
        @JoinColumn(name = "ventas_id", referencedColumnName = "id", insertable = false, updatable = false)
        , @JoinColumn(name = "ventas_clientes_id", referencedColumnName = "clientes_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Ventas ventas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peliculasVenta")
    private Collection<SillasVenta> sillasVentaCollection;

    public PeliculasVenta() {
    }

    public PeliculasVenta(PeliculasVentaPK peliculasVentaPK) {
        this.peliculasVentaPK = peliculasVentaPK;
    }

    public PeliculasVenta(PeliculasVentaPK peliculasVentaPK, int puntos) {
        this.peliculasVentaPK = peliculasVentaPK;
        this.puntos = puntos;
    }

    public PeliculasVenta(int id, int ventasId, int ventasClientesId, int peliculasSalaId, int peliculasSalaPeliculasId, int peliculasSalaSalasId, int peliculasSalaSalasMultiplexsId) {
        this.peliculasVentaPK = new PeliculasVentaPK(id, ventasId, ventasClientesId, peliculasSalaId, peliculasSalaPeliculasId, peliculasSalaSalasId, peliculasSalaSalasMultiplexsId);
    }

    public PeliculasVentaPK getPeliculasVentaPK() {
        return peliculasVentaPK;
    }

    public void setPeliculasVentaPK(PeliculasVentaPK peliculasVentaPK) {
        this.peliculasVentaPK = peliculasVentaPK;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public PeliculasSala getPeliculasSala() {
        return peliculasSala;
    }

    public void setPeliculasSala(PeliculasSala peliculasSala) {
        this.peliculasSala = peliculasSala;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    @XmlTransient
    public Collection<SillasVenta> getSillasVentaCollection() {
        return sillasVentaCollection;
    }

    public void setSillasVentaCollection(Collection<SillasVenta> sillasVentaCollection) {
        this.sillasVentaCollection = sillasVentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peliculasVentaPK != null ? peliculasVentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeliculasVenta)) {
            return false;
        }
        PeliculasVenta other = (PeliculasVenta) object;
        if ((this.peliculasVentaPK == null && other.peliculasVentaPK != null) || (this.peliculasVentaPK != null && !this.peliculasVentaPK.equals(other.peliculasVentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.electiva.entities.PeliculasVenta[ peliculasVentaPK=" + peliculasVentaPK + " ]";
    }
    
}
