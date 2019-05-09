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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "peliculas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peliculas.findAll", query = "SELECT p FROM Peliculas p")
    , @NamedQuery(name = "Peliculas.findById", query = "SELECT p FROM Peliculas p WHERE p.id = :id")
    , @NamedQuery(name = "Peliculas.findByNombre", query = "SELECT p FROM Peliculas p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Peliculas.findByCodigo", query = "SELECT p FROM Peliculas p WHERE p.codigo = :codigo")})
public class Peliculas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "peliculas")
    private Collection<PeliculasSala> peliculasSalaCollection;

    public Peliculas() {
    }

    public Peliculas(Integer id) {
        this.id = id;
    }

    public Peliculas(Integer id, String nombre, String codigo) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peliculas)) {
            return false;
        }
        Peliculas other = (Peliculas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.electiva.entities.Peliculas[ id=" + id + " ]";
    }
    
}
