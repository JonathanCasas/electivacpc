/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.controllers;

import com.uniminuto.electiva.entities.Multiplexs;
import com.uniminuto.electiva.repositories.MultiplexRepository;
import com.uniminuto.electiva.services.PeliculaSalaInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author joncasasq
 */
@Controller
@RequestMapping(path = "multiplex")
public class MultiplexController {

    @Autowired
    MultiplexRepository multiplexRepository;
    @Autowired
    PeliculaSalaInterface peliculaSalaInterface;

    @GetMapping(path = "")
    public ModelAndView index(Model model) {
        List<Multiplexs> multiplexs = (List<Multiplexs>) multiplexRepository.findAll();
        model.addAttribute("multiplexs", multiplexs);
        return new ModelAndView("home");
    }

    /**
     *
     * @param model
     * @param id
     * @return
     */
    @GetMapping(path = "/{multiplex}")
    public ModelAndView show(Model model, @PathVariable(name = "multiplex") int id) {
        Optional<Multiplexs> multiplex = multiplexRepository.findById(id);
        Multiplexs sede = multiplex.get();
        model.addAttribute("multiplex", sede);
        model.addAttribute("peliculas", peliculaSalaInterface.getPeliculas(id));
        return new ModelAndView("multiplex");
    }
}
