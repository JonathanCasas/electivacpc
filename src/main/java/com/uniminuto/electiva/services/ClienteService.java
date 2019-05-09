/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.services;

import com.uniminuto.electiva.entities.Clientes;
import com.uniminuto.electiva.entities.PeliculasSala;
import com.uniminuto.electiva.entities.PeliculasVenta;
import com.uniminuto.electiva.entities.PeliculasVentaPK;
import com.uniminuto.electiva.entities.Productos;
import com.uniminuto.electiva.entities.ProductosVentas;
import com.uniminuto.electiva.entities.ProductosVentasPK;
import com.uniminuto.electiva.entities.SillasVenta;
import com.uniminuto.electiva.entities.SillasVentaPK;
import com.uniminuto.electiva.entities.Ventas;
import com.uniminuto.electiva.entities.VentasPK;
import com.uniminuto.electiva.repositories.ClienteRepository;
import com.uniminuto.electiva.repositories.PeliculaRepository;
import com.uniminuto.electiva.repositories.PeliculaSalaRepository;
import com.uniminuto.electiva.repositories.PeliculaVentaRepository;
import com.uniminuto.electiva.repositories.ProductoRepository;
import com.uniminuto.electiva.repositories.ProductoVentaRepository;
import com.uniminuto.electiva.repositories.SillaVentaRepository;
import com.uniminuto.electiva.repositories.VentaRepository;
import com.uniminuto.electiva.request.FinalizarPagoRequest;
import com.uniminuto.electiva.session.Cart;
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
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ProductoVentaRepository productoVentaRepository;
    @Autowired
    VentaRepository ventaRepository;
    @Autowired
    PeliculaVentaRepository peliculaVentaRepository;
    @Autowired
    SillaVentaRepository sillaVentaRepository;
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    PeliculaRepository peliculaRepository;
    @Autowired
    PeliculaSalaRepository peliculaSalaRepository;
    @Autowired
    HttpSession httpSession;

    Clientes cliente;
    Ventas ventas;
    Cart cart;
    PeliculasVenta peliculasVenta;
    PeliculasSala peliculasSala;

    public void init() {
        cart = (Cart) httpSession.getAttribute(Cart.SESSION_NAME);
    }

    public void crearCliente(FinalizarPagoRequest finalizarPagoRequest) {
        cliente = new Clientes();
        cliente.setDireccion(finalizarPagoRequest.getDireccion());
        cliente.setTelefono(finalizarPagoRequest.getTelefono());
        cliente.setNombre(finalizarPagoRequest.getNombre());
        Integer id = clienteRepository.findMaxId();
        if (id == null) {
            id = 0;
        }
        cliente.setId(id + 1);
        cliente = clienteRepository.save(cliente);
    }

    public void crearVenta() {
        VentasPK ventasPK = new VentasPK();
        ventas = new Ventas();
        ventas.setClientes(cliente);
        ventas.setTotalPuntos(1);
        ventas.setTotal(20000);
        ventasPK.setClientesId(cliente.getId());
        ventas.setVentasPK(ventasPK);
        ventas = ventaRepository.save(ventas);
    }

    public void productosVentas() {
        for (ProductoCart productoCart : cart.getProductosCart()) {
            ProductosVentas productosVentas = new ProductosVentas();
            Productos productos = productoRepository.getOne(productoCart.getId());
            productosVentas.setCantidad(productoCart.getCantidad());
            productosVentas.setProductos(productos);
            productosVentas.setPuntos(1);
            productosVentas.setTotal(productoCart.getTotal());
            productosVentas.setValor(productoCart.getPrecio());
            ProductosVentasPK productosVentasPK = new ProductosVentasPK();
            productosVentasPK.setProductosId(productos.getId());
            productosVentasPK.setVentasClientesId(cliente.getId());
            productosVentasPK.setVentasId(ventas.getVentasPK().getId());
            productosVentas.setProductosVentasPK(productosVentasPK);
            productoVentaRepository.save(productosVentas);
        }
    }

    public void peliculasVenta() {
        peliculasVenta = new PeliculasVenta();
        peliculasVenta.setPuntos(10);
        peliculasVenta.setVentas(ventas);
        peliculasSala = peliculaSalaRepository.findByPeliculaSalaId(cart.getPeliculaCart().getPeliculaSalaId());
        peliculasVenta.setPeliculasSala(peliculasSala);
        PeliculasVentaPK peliculasVentaPK = new PeliculasVentaPK();
        peliculasVentaPK.setPeliculasSalaId(peliculasSala.getPeliculasSalaPK().getId());
        peliculasVentaPK.setPeliculasSalaPeliculasId(peliculasSala.getPeliculasSalaPK().getPeliculasId());
        peliculasVentaPK.setPeliculasSalaSalasId(peliculasSala.getPeliculasSalaPK().getSalasId());
        peliculasVentaPK.setPeliculasSalaSalasMultiplexsId(cart.getMultiplexs().getId());
        peliculasVentaPK.setVentasClientesId(cliente.getId());
        peliculasVentaPK.setVentasId(ventas.getVentasPK().getId());
        peliculasVenta.setPeliculasVentaPK(peliculasVentaPK);
        peliculaVentaRepository.save(peliculasVenta);
    }

    public void sillas() {
        for (SillaCart silla : cart.getSillas()) {
            SillasVenta sillasVenta = new SillasVenta();
            sillasVenta.setColumna(silla.getColumna());
            sillasVenta.setFila(silla.getFila());
            sillasVenta.setPuntos(10);
            sillasVenta.setPeliculasVenta(peliculasVenta);
            sillasVenta.setTipo(silla.getTipo());
            SillasVentaPK sillasVentaPK = new SillasVentaPK();
            sillasVentaPK.setPeliculasVentaId(peliculasVenta.getPeliculasVentaPK().getId());
            sillasVentaPK.setPeliculasVentaPeliculasSalaId(ventas.getVentasPK().getId());
            sillasVentaPK.setPeliculasVentaPeliculasSalaPeliculasId(ventas.getVentasPK().getClientesId());
            sillasVentaPK.setPeliculasVentaPeliculasSalaSalasId(peliculasSala.getPeliculasSalaPK().getId());
            sillasVentaPK.setPeliculasVentaPeliculasSalaSalasMultiplexsId(cart.getMultiplexs().getId());
            sillasVentaPK.setPeliculasVentaVentasClientesId(cliente.getId());
            sillasVentaPK.setPeliculasVentaVentasId(ventas.getVentasPK().getId());
            sillasVenta.setSillasVentaPK(sillasVentaPK);
            sillaVentaRepository.save(sillasVenta);
        }
    }
}
