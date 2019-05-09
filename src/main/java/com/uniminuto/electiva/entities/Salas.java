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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joncasasq
 */
@Entity
@Table(name = "salas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salas.findAll", query = "SELECT s FROM Salas s")
    , @NamedQuery(name = "Salas.findById", query = "SELECT s FROM Salas s WHERE s.salasPK.id = :id")
    , @NamedQuery(name = "Salas.findByNombre", query = "SELECT s FROM Salas s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Salas.findByCodigo", query = "SELECT s FROM Salas s WHERE s.codigo = :codigo")
    , @NamedQuery(name = "Salas.findByMultiplexsId", query = "SELECT s FROM Salas s WHERE s.salasPK.multiplexsId = :multiplexsId")})
public class Salas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalasPK salasPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "codigo")
    private String codigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salas")
    private Collection<PeliculasSala> peliculasSalaCollection;
    @JoinColumn(name = "multiplexs_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Multiplexs multiplexs;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salas")
    private Collection<Sillas> sillasCollection;

    public Salas() {
    }

    public Salas(SalasPK salasPK) {
        this.salasPK = salasPK;
    }

    public Salas(SalasPK salasPK, String nombre, String codigo) {
        this.salasPK = salasPK;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public Salas(int id, int multiplexsId) {
        this.salasPK = new SalasPK(id, multiplexsId);
    }

    public SalasPK getSalasPK() {
        return salasPK;
    }

    public void setSalasPK(SalasPK salasPK) {
        this.salasPK = salasPK;
    }

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

    @XmlTransient
    public Collection<PeliculasSala> getPeliculasSalaCollection() {
        return peliculasSalaCollection;
    }

    public void setPeliculasSalaCollection(Collection<PeliculasSala> peliculasSalaCollection) {
        this.peliculasSalaCollection = peliculasSalaCollection;
    }

    public Multiplexs getMultiplexs() {
        return multiplexs;
    }

    public void setMultiplexs(Multiplexs multiplexs) {
        this.multiplexs = multiplexs;
    }

    @XmlTransient
    public Collection<Sillas> getSillasCollection() {
        return sillasCollection;
    }

    public void setSillasCollection(Collection<Sillas> sillasCollection) {
        this.sillasCollection = sillasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salasPK != null ? salasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salas)) {
            return false;
        }
        Salas other = (Salas) object;
        if ((this.salasPK == null && other.salasPK != null) || (this.salasPK != null && !this.salasPK.equals(other.salasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.electiva.entities.Salas[ salasPK=" + salasPK + " ]";
    }
    
}
