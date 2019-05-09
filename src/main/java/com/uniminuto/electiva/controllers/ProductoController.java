/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.controllers;

import com.uniminuto.electiva.entities.Productos;
import com.uniminuto.electiva.repositories.ProductoRepository;
import com.uniminuto.electiva.request.AddProductRequest;
import com.uniminuto.electiva.response.SeleccionarSillaResponse;
import com.uniminuto.electiva.services.CartService;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author joncasasq
 */
@Controller
@RequestMapping(path = "productos")
public class ProductoController {

    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    CartService cartService;

    @GetMapping(path = "")
    public ModelAndView index(Model model) {
        model.addAttribute("productos", productoRepository.findAll());
        return new ModelAndView("snacks");
    }

    @PostMapping(path = "seleccionar")
    public ModelAndView addProductToCart(@Valid AddProductRequest addProductRequest, BindingResult bindingResult, RedirectAttributes redirAttrs) {
        if (bindingResult.hasErrors()) {
            redirAttrs.addFlashAttribute("message", "Campos incompletos");
            return new ModelAndView("redirect:/productos");
        }
        cartService.init();
        Optional<Productos> producto = productoRepository.findById(addProductRequest.getProducto());
        cartService.addProduct(producto.get(), addProductRequest.getCantidad());
        cartService.store();
        redirAttrs.addFlashAttribute("message", "Producto agregado");
        return new ModelAndView("redirect:/productos");
    }

}
