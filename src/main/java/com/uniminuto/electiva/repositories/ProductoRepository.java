/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.repositories;

import com.uniminuto.electiva.entities.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author joncasasq
 */
public interface ProductoRepository extends JpaRepository<Productos, Integer> {

}
