/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joncasasq
 */
@Entity
@Table(name = "peliculas_sala")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeliculasSala.findAll", query = "SELECT p FROM PeliculasSala p")
    , @NamedQuery(name = "PeliculasSala.findById", query = "SELECT p FROM PeliculasSala p WHERE p.peliculasSalaPK.id = :id")
    , @NamedQuery(name = "PeliculasSala.findByPeliculaSalaId", query = "SELECT p FROM PeliculasSala p WHERE p.peliculasSalaPK.id = :id")
    , @NamedQuery(name = "PeliculasSala.findByPeliculasId", query = "SELECT p FROM PeliculasSala p WHERE p.peliculasSalaPK.peliculasId = :peliculasId")
    , @NamedQuery(name = "PeliculasSala.findBySalasId", query = "SELECT p FROM PeliculasSala p WHERE p.peliculasSalaPK.salasId = :salasId")
    , @NamedQuery(name = "PeliculasSala.findBySalasMultiplexsId", query = "SELECT p FROM PeliculasSala p WHERE p.peliculasSalaPK.salasMultiplexsId = :salasMultiplexsId")
    , @NamedQuery(name = "PeliculasSala.findByInicio", query = "SELECT p FROM PeliculasSala p WHERE p.inicio = :inicio")
    , @NamedQuery(name = "PeliculasSala.findByFin", query = "SELECT p FROM PeliculasSala p WHERE p.fin = :fin")})
public class PeliculasSala implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PeliculasSalaPK peliculasSalaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fin;
    @JoinColumn(name = "peliculas_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Peliculas peliculas;
    @JoinColumns({
        @JoinColumn(name = "salas_id", referencedColumnName = "id", insertable = false, updatable = false)
        , @JoinColumn(name = "salas_multiplexs_id", referencedColumnName = "multiplexs_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Salas salas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peliculasSala")
    private Collection<PeliculasVenta> peliculasVentaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peliculasSala")
    private Collection<Horarios> horariosCollection;

    public PeliculasSala() {
    }

    public PeliculasSala(PeliculasSalaPK peliculasSalaPK) {
        this.peliculasSalaPK = peliculasSalaPK;
    }

    public PeliculasSala(PeliculasSalaPK peliculasSalaPK, Date inicio, Date fin) {
        this.peliculasSalaPK = peliculasSalaPK;
        this.inicio = inicio;
        this.fin = fin;
    }

    public PeliculasSala(int id, int peliculasId, int salasId, int salasMultiplexsId) {
        this.peliculasSalaPK = new PeliculasSalaPK(id, peliculasId, salasId, salasMultiplexsId);
    }

    public PeliculasSalaPK getPeliculasSalaPK() {
        return peliculasSalaPK;
    }

    public void setPeliculasSalaPK(PeliculasSalaPK peliculasSalaPK) {
        this.peliculasSalaPK = peliculasSalaPK;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Peliculas getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Peliculas peliculas) {
        this.peliculas = peliculas;
    }

    public Salas getSalas() {
        return salas;
    }

    public void setSalas(Salas salas) {
        this.salas = salas;
    }

    @XmlTransient
    public Collection<PeliculasVenta> getPeliculasVentaCollection() {
        return peliculasVentaCollection;
    }

    public void setPeliculasVentaCollection(Collection<PeliculasVenta> peliculasVentaCollection) {
        this.peliculasVentaCollection = peliculasVentaCollection;
    }

    @XmlTransient
    public Collection<Horarios> getHorariosCollection() {
        return horariosCollection;
    }

    public void setHorariosCollection(Collection<Horarios> horariosCollection) {
        this.horariosCollection = horariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peliculasSalaPK != null ? peliculasSalaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeliculasSala)) {
            return false;
        }
        PeliculasSala other = (PeliculasSala) object;
        if ((this.peliculasSalaPK == null && other.peliculasSalaPK != null) || (this.peliculasSalaPK != null && !this.peliculasSalaPK.equals(other.peliculasSalaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.electiva.entities.PeliculasSala[ peliculasSalaPK=" + peliculasSalaPK + " ]";
    }

}
