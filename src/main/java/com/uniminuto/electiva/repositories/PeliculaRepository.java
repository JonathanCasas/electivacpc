/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.repositories;

import com.uniminuto.electiva.entities.Peliculas;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author joncasasq
 */
public interface PeliculaRepository extends CrudRepository<Peliculas, Integer>{
    
}
