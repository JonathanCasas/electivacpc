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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author joncasasq
 */
@Entity
@Table(name = "productos_ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductosVentas.findAll", query = "SELECT p FROM ProductosVentas p")
    , @NamedQuery(name = "ProductosVentas.findById", query = "SELECT p FROM ProductosVentas p WHERE p.productosVentasPK.id = :id")
    , @NamedQuery(name = "ProductosVentas.findByCantidad", query = "SELECT p FROM ProductosVentas p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "ProductosVentas.findByValor", query = "SELECT p FROM ProductosVentas p WHERE p.valor = :valor")
    , @NamedQuery(name = "ProductosVentas.findByTotal", query = "SELECT p FROM ProductosVentas p WHERE p.total = :total")
    , @NamedQuery(name = "ProductosVentas.findByPuntos", query = "SELECT p FROM ProductosVentas p WHERE p.puntos = :puntos")
    , @NamedQuery(name = "ProductosVentas.findByProductosId", query = "SELECT p FROM ProductosVentas p WHERE p.productosVentasPK.productosId = :productosId")
    , @NamedQuery(name = "ProductosVentas.findByVentasId", query = "SELECT p FROM ProductosVentas p WHERE p.productosVentasPK.ventasId = :ventasId")
    , @NamedQuery(name = "ProductosVentas.findByVentasClientesId", query = "SELECT p FROM ProductosVentas p WHERE p.productosVentasPK.ventasClientesId = :ventasClientesId")})
public class ProductosVentas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductosVentasPK productosVentasPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    @Column(name = "puntos")
    private Integer puntos;
    @JoinColumn(name = "productos_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;
    @JoinColumns({
        @JoinColumn(name = "ventas_id", referencedColumnName = "id", insertable = false, updatable = false)
        , @JoinColumn(name = "ventas_clientes_id", referencedColumnName = "clientes_id", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Ventas ventas;

    public ProductosVentas() {
    }

    public ProductosVentas(ProductosVentasPK productosVentasPK) {
        this.productosVentasPK = productosVentasPK;
    }

    public ProductosVentas(ProductosVentasPK productosVentasPK, int cantidad, double valor, double total) {
        this.productosVentasPK = productosVentasPK;
        this.cantidad = cantidad;
        this.valor = valor;
        this.total = total;
    }

    public ProductosVentas(int id, int productosId, int ventasId, int ventasClientesId) {
        this.productosVentasPK = new ProductosVentasPK(id, productosId, ventasId, ventasClientesId);
    }

    public ProductosVentasPK getProductosVentasPK() {
        return productosVentasPK;
    }

    public void setProductosVentasPK(ProductosVentasPK productosVentasPK) {
        this.productosVentasPK = productosVentasPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productosVentasPK != null ? productosVentasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosVentas)) {
            return false;
        }
        ProductosVentas other = (ProductosVentas) object;
        if ((this.productosVentasPK == null && other.productosVentasPK != null) || (this.productosVentasPK != null && !this.productosVentasPK.equals(other.productosVentasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uniminuto.electiva.entities.ProductosVentas[ productosVentasPK=" + productosVentasPK + " ]";
    }
    
}
