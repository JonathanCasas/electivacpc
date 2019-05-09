/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.controllers;

import com.uniminuto.electiva.entities.PeliculasSala;
import com.uniminuto.electiva.repositories.MultiplexRepository;
import com.uniminuto.electiva.repositories.PeliculaSalaRepository;
import com.uniminuto.electiva.services.PeliculaSalaInterface;
import com.uniminuto.electiva.ui.PeliculaSalaUI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author joncasasq
 */
@RestController
public class TestController {

    @Autowired
    MultiplexRepository multiplexRepository;
    @Autowired
    PeliculaSalaRepository peliculaSalaRepository;
    @Autowired
    PeliculaSalaInterface peliculaSalaService;

    @GetMapping(path = "/pruebas")
    public List<PeliculaSalaUI> multiplex() {
        String content = new String();
        for (PeliculasSala peliculasSala : peliculaSalaRepository.findBySalasMultiplexsId(1)) {
            content = content.concat(peliculasSala.getPeliculas().getNombre());
        }
        return peliculaSalaService.getPeliculas(1);
    }

}
