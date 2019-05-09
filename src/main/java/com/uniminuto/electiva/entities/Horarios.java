/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joncasasq
 */
@Entity
@Table(name = "horarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horarios.findAll", query = "SELECT h FROM Horarios h")
    , @NamedQuery(name = "Horarios.findById", query = "SELECT h FROM Horarios h WHERE h.horariosPK.id = :id")
    , @NamedQuery(name = "Horarios.findByInicio", query = "SELECT h FROM Horarios h WHERE h.inicio = :inicio")
    , @NamedQuery(name = "Horarios.findByFin", query = "SELECT h FROM Horarios h WHERE h.fin = :fin")
    , @NamedQuery(name = "Horarios.findByPeliculasSalaId", query = "SELECT h FROM Horarios h WHERE h.horariosPK.peliculasSalaId = :peliculasSalaId")
    , @NamedQuery(name = "Horarios.findByPeliculasSalaPeliculasId", query = "SELECT h FROM Horarios h WHERE h.horariosPK.peliculasSalaPeliculasId = :peliculasSalaPeliculasId")
    , @NamedQuery(name = "Horarios.findByPeliculasSalaSalasId", query = "SELECT h FROM Horarios h WHERE h.horariosPK.peliculasSalaSalasId = :peliculasSalaSalasId")
    , @NamedQuery(name = "Horarios.findByPeliculasSalaSalasMultiplexsId", query = "SELECT h FROM Horarios h WHERE h.horariosPK.peliculasSalaSalasMultiplexsId = :peliculasSalaSalasMultiplexsId")})
public class Horarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HorariosPK horariosPK;
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
    @JoinColumns({
        @JoinColumn(name = "peliculas_sala_id", referencedColumnName = "id", insertable = false, updatable = false)
        , @JoinColumn(name = "peliculas_sala_peliculas_id", referencedColumnName = "peliculas_id", insertable = false, updatable = false)
        , @JoinColumn(name = "peliculas_sala_salas_id", referencedColumnName = "salas_id", insertable = false, updatable = false)
        , @JoinColumn(name = "peliculas_sala_salas_multiplexs_id", referencedColumnName = "salas_multiplexs_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private PeliculasSala peliculasSala;

    public Horarios() {
    }

    public Horarios(HorariosPK horariosPK) {
        this.horariosPK = horariosPK;
    }

    public Horarios(HorariosPK horariosPK, Date inicio, Date fin) {
        this.horariosPK = horariosPK;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Horarios(int id, int peliculasSalaId, int peliculasSalaPeliculasId, int peliculasSalaSalasId, int peliculasSalaSalasMultiplexsId) {
        this.horariosPK = new HorariosPK(id, peliculasSalaId, peliculasSalaPeliculasId, peliculasSalaSalasId, peliculasSalaSalasMultiplexsId);
    }

    public HorariosPK getHorariosPK() {
        return horariosPK;
    }

    public void setHorariosPK(HorariosPK horariosPK) {
        this.horariosPK = horariosPK;
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

    public PeliculasSala getPeliculasSala() {
        return peliculasSala;
    }

    public void setPeliculasSala(PeliculasSala peliculasSala) {
        this.peliculasSala = peliculasSala;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horariosPK != null ? horariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horarios)) {
            return false;
        }
        Horarios other = (Horarios) object;
        if ((this.horariosPK == null && other.horariosPK != null) || (this.horariosPK != null && !this.horariosPK.equals(other.horariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.electiva.entities.Horarios[ horariosPK=" + horariosPK + " ]";
    }
    
}
