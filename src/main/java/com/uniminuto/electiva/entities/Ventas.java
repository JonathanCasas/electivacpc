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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author joncasasq
 */
@Entity
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v")
    , @NamedQuery(name = "Ventas.findById", query = "SELECT v FROM Ventas v WHERE v.ventasPK.id = :id")
    , @NamedQuery(name = "Ventas.findByTotal", query = "SELECT v FROM Ventas v WHERE v.total = :total")
    , @NamedQuery(name = "Ventas.findByClientesId", query = "SELECT v FROM Ventas v WHERE v.ventasPK.clientesId = :clientesId")
    , @NamedQuery(name = "Ventas.findByTotalPuntos", query = "SELECT v FROM Ventas v WHERE v.totalPuntos = :totalPuntos")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentasPK ventasPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_puntos")
    private double totalPuntos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventas")
    private Collection<PeliculasVenta> peliculasVentaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventas")
    private Collection<ProductosVentas> productosVentasCollection;
    @JoinColumn(name = "clientes_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clientes clientes;

    public Ventas() {
    }

    public Ventas(VentasPK ventasPK) {
        this.ventasPK = ventasPK;
    }

    public Ventas(VentasPK ventasPK, double total, double totalPuntos) {
        this.ventasPK = ventasPK;
        this.total = total;
        this.totalPuntos = totalPuntos;
    }

    public Ventas(int id, int clientesId) {
        this.ventasPK = new VentasPK(id, clientesId);
    }

    public VentasPK getVentasPK() {
        return ventasPK;
    }

    public void setVentasPK(VentasPK ventasPK) {
        this.ventasPK = ventasPK;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTotalPuntos() {
        return totalPuntos;
    }

    public void setTotalPuntos(double totalPuntos) {
        this.totalPuntos = totalPuntos;
    }

    @XmlTransient
    public Collection<PeliculasVenta> getPeliculasVentaCollection() {
        return peliculasVentaCollection;
    }

    public void setPeliculasVentaCollection(Collection<PeliculasVenta> peliculasVentaCollection) {
        this.peliculasVentaCollection = peliculasVentaCollection;
    }

    @XmlTransient
    public Collection<ProductosVentas> getProductosVentasCollection() {
        return productosVentasCollection;
    }

    public void setProductosVentasCollection(Collection<ProductosVentas> productosVentasCollection) {
        this.productosVentasCollection = productosVentasCollection;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventasPK != null ? ventasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.ventasPK == null && other.ventasPK != null) || (this.ventasPK != null && !this.ventasPK.equals(other.ventasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.electiva.entities.Ventas[ ventasPK=" + ventasPK + " ]";
    }
    
}
