/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.services;

import com.uniminuto.electiva.entities.Multiplexs;
import com.uniminuto.electiva.entities.Peliculas;
import com.uniminuto.electiva.entities.Productos;
import com.uniminuto.electiva.entities.Sillas;
import com.uniminuto.electiva.session.Cart;
import com.uniminuto.electiva.session.Multiplex;
import com.uniminuto.electiva.session.PeliculaCart;
import com.uniminuto.electiva.session.ProductoCart;
import com.uniminuto.electiva.session.SillaCart;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joncasasq
 */
@Service
public class CartService {

    @Autowired
    HttpSession httpSession;

    Cart cart;

    public void init() {
        cart = (Cart) httpSession.getAttribute(Cart.SESSION_NAME);
        if (cart == null) {
            cart = new Cart();
        }
    }

    public void addPelicula(Peliculas pelicula) {
        PeliculaCart peliculaCart = new PeliculaCart();
        peliculaCart.setId(pelicula.getId());
        peliculaCart.setNombre(pelicula.getNombre());
        cart.setPeliculaCart(peliculaCart);
        cart.setEmpty(false);
    }

    public void addSilla(Sillas silla) {
        SillaCart sillaCart = new SillaCart();
        sillaCart.setColumna(silla.getColumna());
        sillaCart.setFila(silla.getFila());
        sillaCart.setTipo(sillaCart.getTipo());
        sillaCart.setId(silla.getSillasPK().getId());
        cart.getSillas().add(sillaCart);
        cart.setEmpty(false);
    }

    public void addMultiplex(Multiplexs multiplexs) {
        Multiplex multiplex = new Multiplex();
        multiplex.setId(multiplexs.getId());
        multiplex.setNombre(multiplexs.getNombre());
        cart.setMultiplexs(multiplex);
    }

    public void addProduct(Productos producto, int cantidad) {
        ProductoCart productoCart = new ProductoCart();
        productoCart.setCantidad(cantidad);
        productoCart.setNombre(producto.getNombre());
        productoCart.setPrecio(producto.getPrecio());
        productoCart.setId(producto.getId());
        productoCart.setTotal(cantidad * producto.getPrecio());
        cart.getProductosCart().add(productoCart);
    }

    public void store() {
        httpSession.setAttribute(Cart.SESSION_NAME, cart);
    }

}
