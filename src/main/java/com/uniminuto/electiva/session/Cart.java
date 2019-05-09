/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.session;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author joncasasq
 */
public class Cart implements Serializable {

    public static final String SESSION_NAME = "cart";

    private double total;
    private final ArrayList<SillaCart> sillas;
    private final ArrayList<ProductoCart> productosCart;
    private PeliculaCart peliculaCart;
    private Multiplex multiplex;

    private boolean empty = true;

    public Cart() {
        sillas = new ArrayList<>();
        productosCart = new ArrayList<>();
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public PeliculaCart getPeliculaCart() {
        return peliculaCart;
    }

    public void setPeliculaCart(PeliculaCart peliculaCart) {
        this.peliculaCart = peliculaCart;
    }

    public ArrayList<SillaCart> getSillas() {
        return sillas;
    }

    public ArrayList<ProductoCart> getProductosCart() {
        return productosCart;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public Multiplex getMultiplexs() {
        return multiplex;
    }

    public void setMultiplexs(Multiplex multiplex) {
        this.multiplex = multiplex;
    }

}
