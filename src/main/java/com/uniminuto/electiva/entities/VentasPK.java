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
public class VentasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clientes_id")
    private int clientesId;

    public VentasPK() {
    }

    public VentasPK(int id, int clientesId) {
        this.id = id;
        this.clientesId = clientesId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientesId() {
        return clientesId;
    }

    public void setClientesId(int clientesId) {
        this.clientesId = clientesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) clientesId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasPK)) {
            return false;
        }
        VentasPK other = (VentasPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.clientesId != other.clientesId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.electiva.entities.VentasPK[ id=" + id + ", clientesId=" + clientesId + " ]";
    }
    
}
