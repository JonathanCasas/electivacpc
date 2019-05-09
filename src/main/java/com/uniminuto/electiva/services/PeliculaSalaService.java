/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.services;

import com.uniminuto.electiva.entities.PeliculasSala;
import com.uniminuto.electiva.repositories.PeliculaSalaRepository;
import com.uniminuto.electiva.ui.PeliculaSalaUI;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joncasasq
 */
@Service
public class PeliculaSalaService implements PeliculaSalaInterface {

    @Autowired
    PeliculaSalaRepository peliculaSalaRepository;

    @Override
    public List<PeliculaSalaUI> getPeliculas(int idMultiplex) {
        List<PeliculaSalaUI> peliculaSalaUIs = new ArrayList<>();
        List<PeliculasSala> peliculasSalas = peliculaSalaRepository.findBySalasMultiplexsId(idMultiplex);
        for (PeliculasSala peliculasSala : peliculasSalas) {
            PeliculaSalaUI peliculaSalaUI = new PeliculaSalaUI();
            peliculaSalaUI.setNombre(peliculasSala.getPeliculas().getNombre());
            peliculaSalaUI.setId(peliculasSala.getPeliculasSalaPK().getId());
            peliculaSalaUI.setInicio(peliculasSala.getInicio().toString());
            peliculaSalaUI.setFin(peliculasSala.getFin().toString());
            peliculaSalaUI.setSala(peliculasSala.getSalas().getNombre());
            peliculaSalaUIs.add(peliculaSalaUI);
        }
        return peliculaSalaUIs;
    }

}
