/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.services;

import com.uniminuto.electiva.entities.Sillas;
import com.uniminuto.electiva.repositories.SillaRepository;
import com.uniminuto.electiva.ui.SillaUi;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author joncasasq
 */
@Service
public class PeliculaSeleccionadaService {

    @Autowired
    SillaRepository sillaRepository;
    List<String> filas = new ArrayList<>();
    List<String> columnas = new ArrayList<>();

    public List<String> filas(int SalasId) {
        filas = sillaRepository.findBySillasOrderByFila(SalasId);
        return filas;
    }

    public List<String> columnas(int SalasId) {
        columnas = sillaRepository.findBySillasOrderByColumna(SalasId);
        return columnas;
    }

    public List<SillaUi> getSillas(int SalaId) {
        List<SillaUi> sillas = new ArrayList<>();
        this.filas(SalaId);
        this.columnas(SalaId);
        for (String fila : filas) {
            for (String columna : columnas) {
                SillaUi sillaUi = new SillaUi();
                Sillas silla = sillaRepository.findByFilaAndColumna(fila, columna);
                sillaUi.setId(silla.getSillasPK().getId());
                sillaUi.setColumna(silla.getColumna());
                sillaUi.setFila(silla.getFila());
                sillaUi.setEstado((silla.getEstado() == 1));
                sillaUi.setTipo(silla.getTipo());
                sillas.add(sillaUi);
            }
        }
        return sillas;
    }

    public List<String> getFilas() {
        return filas;
    }

    public List<String> getColumnas() {
        return columnas;
    }

    public SillaUi[][] getSillasUI(List<SillaUi> sillas) {
        SillaUi[][] sillasUi = new SillaUi[filas.size()][columnas.size()];
        for (SillaUi silla : sillas) {
            int fila = filas.indexOf(silla.getFila());
            int columna = filas.indexOf(silla.getColumna());
            sillasUi[fila][columna] = silla;
        }
        return sillasUi;
    }

}
