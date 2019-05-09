/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.controllers;

import com.uniminuto.electiva.entities.Multiplexs;
import com.uniminuto.electiva.entities.PeliculasSala;
import com.uniminuto.electiva.entities.Sillas;
import com.uniminuto.electiva.repositories.PeliculaSalaRepository;
import com.uniminuto.electiva.repositories.SillaRepository;
import com.uniminuto.electiva.request.SeleccionarSillaRequest;
import com.uniminuto.electiva.response.SeleccionarSillaResponse;
import com.uniminuto.electiva.services.CartService;
import com.uniminuto.electiva.services.PeliculaSeleccionadaService;
import com.uniminuto.electiva.ui.SillaUi;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author joncasasq
 */
@Controller
@RequestMapping(path = "multiplex/{multiplex}/pelicula/{peliculaSala}")
public class PeliculaController {

    @Autowired
    PeliculaSalaRepository peliculaSalaRepository;
    @Autowired
    PeliculaSeleccionadaService peliculaSeleccionadaService;
    @Autowired
    SillaRepository sillaRepository;
    @Autowired
    CartService cartService;

    @GetMapping(path = "")
    public ModelAndView index(@PathVariable(name = "multiplex") Multiplexs multiplexs, @PathVariable(name = "peliculaSala") int peliculaSala, Model model, HttpSession httpSession) {
        PeliculasSala peliculasSala = peliculaSalaRepository.findByPeliculasId(peliculaSala);
        model.addAttribute("multiplex", multiplexs);
        model.addAttribute("peliculasSala", peliculasSala);
        model.addAttribute("pelicula", peliculasSala.getPeliculas());
        model.addAttribute("columnas", peliculaSeleccionadaService.getColumnas().size());
        List<SillaUi> sillas = peliculaSeleccionadaService.getSillas(peliculaSala);
        SillaUi[][] sillasUi = new SillaUi[peliculaSeleccionadaService.getFilas().size()][peliculaSeleccionadaService.getColumnas().size()];
        for (SillaUi silla : sillas) {
            int fila = peliculaSeleccionadaService.getFilas().indexOf(silla.getFila());
            int columna = peliculaSeleccionadaService.getColumnas().indexOf(silla.getColumna());
            sillasUi[fila][columna] = silla;
        }
        model.addAttribute("sillas", sillasUi);
        return new ModelAndView("pelicula");
    }

    @PostMapping(path = "seleccionar")
    @ResponseBody
    public ResponseEntity<?> selectSilla(@PathVariable(name = "multiplex") Multiplexs multiplexs, @PathVariable(name = "peliculaSala") int peliculaSala, @RequestBody SeleccionarSillaRequest seleccionarSillaRequest, HttpSession httpSession) {
        if (seleccionarSillaRequest.getId() <= 0) {
            return ResponseEntity.ok(new SeleccionarSillaResponse("error", "Debe seleccionar una silla"));
        }
        Sillas silla = sillaRepository.findBySillaId(seleccionarSillaRequest.getId());
        if (silla == null) {
            return ResponseEntity.ok(new SeleccionarSillaResponse("error", "Debe seleccionar una silla"));
        }
        if (silla.getEstado() == 0) {
            return ResponseEntity.ok(new SeleccionarSillaResponse("error", "La silla seleccionada ya esta ocupada"));
        }
        PeliculasSala peliculasSala = peliculaSalaRepository.findByPeliculasId(peliculaSala);
        silla.setEstado((short) 0);
        sillaRepository.save(silla);
        cartService.init();
        cartService.addPelicula(peliculasSala.getPeliculas());
        cartService.addSilla(silla);
        cartService.addMultiplex(multiplexs);
        cartService.store();
        return ResponseEntity.ok(new SeleccionarSillaResponse("success", "Silla seleccionada correctamente"));
    }
}
