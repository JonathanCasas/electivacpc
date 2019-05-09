/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.repositories;

import com.uniminuto.electiva.entities.PeliculasVenta;
import com.uniminuto.electiva.entities.PeliculasVentaPK;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author joncasasq
 */
public interface PeliculaVentaRepository extends CrudRepository<PeliculasVenta, PeliculasVentaPK> {

}
