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
@Table(name = "sillas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sillas.findAll", query = "SELECT s FROM Sillas s")
    , @NamedQuery(name = "Sillas.findById", query = "SELECT s FROM Sillas s WHERE s.sillasPK.id = :id")
    , @NamedQuery(name = "Sillas.findBySillaId", query = "SELECT s FROM Sillas s WHERE s.sillasPK.id = :id")
    , @NamedQuery(name = "Sillas.findByFila", query = "SELECT s FROM Sillas s WHERE s.fila = :fila")
    , @NamedQuery(name = "Sillas.findByColumna", query = "SELECT s FROM Sillas s WHERE s.columna = :columna")
    , @NamedQuery(name = "Sillas.findByTipo", query = "SELECT s FROM Sillas s WHERE s.tipo = :tipo")
    , @NamedQuery(name = "Sillas.findBySalasId", query = "SELECT s FROM Sillas s WHERE s.sillasPK.salasId = :salasId")
    , @NamedQuery(name = "Sillas.findBySillasOrderByFila", query = "SELECT DISTINCT s.fila FROM Sillas s WHERE s.sillasPK.salasId = :salasId ORDER BY fila")
    , @NamedQuery(name = "Sillas.findBySillasOrderByColumna", query = "SELECT DISTINCT s.columna FROM Sillas s WHERE s.sillasPK.salasId = :salasId ORDER BY columna")
    , @NamedQuery(name = "Sillas.findByFilaAndColumna", query = "SELECT s FROM Sillas s WHERE s.fila = :fila AND s.columna = :columna")
    , @NamedQuery(name = "Sillas.findBySalasMultiplexsId", query = "SELECT s FROM Sillas s WHERE s.sillasPK.salasMultiplexsId = :salasMultiplexsId")
    , @NamedQuery(name = "Sillas.findByEstado", query = "SELECT s FROM Sillas s WHERE s.estado = :estado")})
public class Sillas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SillasPK sillasPK;
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
    @Column(name = "estado")
    private short estado;
    @JoinColumns({
        @JoinColumn(name = "salas_id", referencedColumnName = "id", insertable = false, updatable = false)
        , @JoinColumn(name = "salas_multiplexs_id", referencedColumnName = "multiplexs_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Salas salas;

    public Sillas() {
    }

    public Sillas(SillasPK sillasPK) {
        this.sillasPK = sillasPK;
    }

    public Sillas(SillasPK sillasPK, String fila, String columna, String tipo, short estado) {
        this.sillasPK = sillasPK;
        this.fila = fila;
        this.columna = columna;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Sillas(int id, int salasId, int salasMultiplexsId) {
        this.sillasPK = new SillasPK(id, salasId, salasMultiplexsId);
    }

    public SillasPK getSillasPK() {
        return sillasPK;
    }

    public void setSillasPK(SillasPK sillasPK) {
        this.sillasPK = sillasPK;
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

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public Salas getSalas() {
        return salas;
    }

    public void setSalas(Salas salas) {
        this.salas = salas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sillasPK != null ? sillasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sillas)) {
            return false;
        }
        Sillas other = (Sillas) object;
        if ((this.sillasPK == null && other.sillasPK != null) || (this.sillasPK != null && !this.sillasPK.equals(other.sillasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.electiva.entities.Sillas[ sillasPK=" + sillasPK + " ]";
    }

}
