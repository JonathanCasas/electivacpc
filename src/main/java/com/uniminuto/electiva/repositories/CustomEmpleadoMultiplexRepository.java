/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.repositories;

import com.uniminuto.electiva.entities.EmpleadosMultiplex;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joncasasq
 */
@Repository
public class CustomEmpleadoMultiplexRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public EmpleadosMultiplex findByFinIsNull(int id) {
        return (EmpleadosMultiplex) entityManager
                .createQuery("SELECT e FROM EmpleadosMultiplex e WHERE e.empleados.id = :id AND e.fin IS NULL", EmpleadosMultiplex.class)
                .setParameter("id", id)
                .setMaxResults(1)
                .getSingleResult();
    }

}
