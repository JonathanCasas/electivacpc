/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.controllers;

import com.uniminuto.electiva.repositories.ClienteRepository;
import com.uniminuto.electiva.request.FinalizarPagoRequest;
import com.uniminuto.electiva.services.ClienteService;
import com.uniminuto.electiva.session.Cart;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author joncasasq
 */
@Controller
@RequestMapping(path = "pagar")
public class CartController {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ClienteService clienteService;

    @GetMapping(path = "")
    public ModelAndView index(HttpSession session, Model model) {
        Cart cart = (Cart) session.getAttribute(Cart.SESSION_NAME);
        if (cart == null || cart.isEmpty()) {
            return new ModelAndView("redirect:/pagar/vacio");
        }
        model.addAttribute("cart", cart);
        model.addAttribute("productos", cart.getProductosCart());
        model.addAttribute("pelicula", cart.getPeliculaCart());
        model.addAttribute("sillas", cart.getSillas());
        model.addAttribute("multiplex", cart.getMultiplexs());
        return new ModelAndView("carrito");
    }

    @GetMapping(path = "/vacio")
    public ModelAndView empty() {
        return new ModelAndView("vacio");
    }

    @PostMapping(path = "/cancelar")
    public ModelAndView clean(HttpSession session) {
        session.invalidate();
        return new ModelAndView("redirect:/");
    }

    @GetMapping(path = "/finalizar")
    public ModelAndView finalizar() {
        return new ModelAndView("finalizar");
    }

    @PostMapping(path = "/finalizar")
    public ModelAndView finalizar(HttpSession httpSession, @ModelAttribute FinalizarPagoRequest finalizarPagoRequest) {
        clienteService.init();
        clienteService.crearCliente(finalizarPagoRequest);
        clienteService.crearVenta();
        //clienteService.productosVentas();
        //clienteService.peliculasVenta();
        //clienteService.sillas();
        httpSession.invalidate();
        
        return new ModelAndView("finalizar");
    }

}
