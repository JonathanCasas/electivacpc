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
public class EmpleadosMultiplexPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "empleados_id")
    private int empleadosId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "multiplexs_id")
    private int multiplexsId;

    public EmpleadosMultiplexPK() {
    }

    public EmpleadosMultiplexPK(int id, int empleadosId, int multiplexsId) {
        this.id = id;
        this.empleadosId = empleadosId;
        this.multiplexsId = multiplexsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpleadosId() {
        return empleadosId;
    }

    public void setEmpleadosId(int empleadosId) {
        this.empleadosId = empleadosId;
    }

    public int getMultiplexsId() {
        return multiplexsId;
    }

    public void setMultiplexsId(int multiplexsId) {
        this.multiplexsId = multiplexsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) empleadosId;
        hash += (int) multiplexsId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadosMultiplexPK)) {
            return false;
        }
        EmpleadosMultiplexPK other = (EmpleadosMultiplexPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.empleadosId != other.empleadosId) {
            return false;
        }
        if (this.multiplexsId != other.multiplexsId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.electiva.entities.EmpleadosMultiplexPK[ id=" + id + ", empleadosId=" + empleadosId + ", multiplexsId=" + multiplexsId + " ]";
    }
    
}
