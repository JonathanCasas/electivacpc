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
@Table(name = "empleados_multiplex")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadosMultiplex.findAll", query = "SELECT e FROM EmpleadosMultiplex e")
    , @NamedQuery(name = "EmpleadosMultiplex.findById", query = "SELECT e FROM EmpleadosMultiplex e WHERE e.empleadosMultiplexPK.id = :id")
    , @NamedQuery(name = "EmpleadosMultiplex.findByInicio", query = "SELECT e FROM EmpleadosMultiplex e WHERE e.inicio = :inicio")
    , @NamedQuery(name = "EmpleadosMultiplex.findByFin", query = "SELECT e FROM EmpleadosMultiplex e WHERE e.fin = :fin")
    , @NamedQuery(name = "EmpleadosMultiplex.findByEmpleadosId", query = "SELECT e FROM EmpleadosMultiplex e WHERE e.empleadosMultiplexPK.empleadosId = :empleadosId")
    , @NamedQuery(name = "EmpleadosMultiplex.findByMultiplexsId", query = "SELECT e FROM EmpleadosMultiplex e WHERE e.empleadosMultiplexPK.multiplexsId = :multiplexsId")})
public class EmpleadosMultiplex implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadosMultiplexPK empleadosMultiplexPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Column(name = "fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fin;
    @JoinColumn(name = "empleados_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empleados empleados;
    @JoinColumn(name = "multiplexs_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Multiplexs multiplexs;

    public EmpleadosMultiplex() {
    }

    public EmpleadosMultiplex(EmpleadosMultiplexPK empleadosMultiplexPK) {
        this.empleadosMultiplexPK = empleadosMultiplexPK;
    }

    public EmpleadosMultiplex(EmpleadosMultiplexPK empleadosMultiplexPK, Date inicio) {
        this.empleadosMultiplexPK = empleadosMultiplexPK;
        this.inicio = inicio;
    }

    public EmpleadosMultiplex(int id, int empleadosId, int multiplexsId) {
        this.empleadosMultiplexPK = new EmpleadosMultiplexPK(id, empleadosId, multiplexsId);
    }

    public EmpleadosMultiplexPK getEmpleadosMultiplexPK() {
        return empleadosMultiplexPK;
    }

    public void setEmpleadosMultiplexPK(EmpleadosMultiplexPK empleadosMultiplexPK) {
        this.empleadosMultiplexPK = empleadosMultiplexPK;
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

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public Multiplexs getMultiplexs() {
        return multiplexs;
    }

    public void setMultiplexs(Multiplexs multiplexs) {
        this.multiplexs = multiplexs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadosMultiplexPK != null ? empleadosMultiplexPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadosMultiplex)) {
            return false;
        }
        EmpleadosMultiplex other = (EmpleadosMultiplex) object;
        if ((this.empleadosMultiplexPK == null && other.empleadosMultiplexPK != null) || (this.empleadosMultiplexPK != null && !this.empleadosMultiplexPK.equals(other.empleadosMultiplexPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.electiva.entities.EmpleadosMultiplex[ empleadosMultiplexPK=" + empleadosMultiplexPK + " ]";
    }

}
