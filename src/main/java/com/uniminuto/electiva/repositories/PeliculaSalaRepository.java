/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.repositories;

import com.uniminuto.electiva.entities.PeliculasSala;
import com.uniminuto.electiva.entities.PeliculasSalaPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author joncasasq
 */
public interface PeliculaSalaRepository extends JpaRepository<PeliculasSala, PeliculasSalaPK> {

    List<PeliculasSala> findBySalasMultiplexsId(@Param("salasMultiplexsId") int salasMultiplexsId);

    PeliculasSala findByPeliculasId(@Param("peliculasId") int peliculasId);

    PeliculasSala findByPeliculaSalaId(@Param("id") int id);

}
