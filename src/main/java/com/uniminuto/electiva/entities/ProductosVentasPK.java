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
public class ProductosVentasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "productos_id")
    private int productosId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ventas_id")
    private int ventasId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ventas_clientes_id")
    private int ventasClientesId;

    public ProductosVentasPK() {
    }

    public ProductosVentasPK(int id, int productosId, int ventasId, int ventasClientesId) {
        this.id = id;
        this.productosId = productosId;
        this.ventasId = ventasId;
        this.ventasClientesId = ventasClientesId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductosId() {
        return productosId;
    }

    public void setProductosId(int productosId) {
        this.productosId = productosId;
    }

    public int getVentasId() {
        return ventasId;
    }

    public void setVentasId(int ventasId) {
        this.ventasId = ventasId;
    }

    public int getVentasClientesId() {
        return ventasClientesId;
    }

    public void setVentasClientesId(int ventasClientesId) {
        this.ventasClientesId = ventasClientesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) productosId;
        hash += (int) ventasId;
        hash += (int) ventasClientesId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosVentasPK)) {
            return false;
        }
        ProductosVentasPK other = (ProductosVentasPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.productosId != other.productosId) {
            return false;
        }
        if (this.ventasId != other.ventasId) {
            return false;
        }
        if (this.ventasClientesId != other.ventasClientesId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.electiva.entities.ProductosVentasPK[ id=" + id + ", productosId=" + productosId + ", ventasId=" + ventasId + ", ventasClientesId=" + ventasClientesId + " ]";
    }
    
}
