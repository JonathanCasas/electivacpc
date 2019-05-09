/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.repositories;

import com.uniminuto.electiva.entities.Ventas;
import com.uniminuto.electiva.entities.VentasPK;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author joncasasq
 */
public interface VentaRepository extends CrudRepository<Ventas, VentasPK>{
    
}
