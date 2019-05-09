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
public class SalasPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "multiplexs_id")
    private int multiplexsId;

    public SalasPK() {
    }

    public SalasPK(int id, int multiplexsId) {
        this.id = id;
        this.multiplexsId = multiplexsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        hash += (int) multiplexsId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalasPK)) {
            return false;
        }
        SalasPK other = (SalasPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.multiplexsId != other.multiplexsId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.electiva.entities.SalasPK[ id=" + id + ", multiplexsId=" + multiplexsId + " ]";
    }
    
}
