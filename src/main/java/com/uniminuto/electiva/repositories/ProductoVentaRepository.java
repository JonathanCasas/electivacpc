/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.repositories;

import com.uniminuto.electiva.entities.ProductosVentas;
import com.uniminuto.electiva.entities.ProductosVentasPK;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author joncasasq
 */
public interface ProductoVentaRepository extends CrudRepository<ProductosVentas, ProductosVentasPK> {

}
