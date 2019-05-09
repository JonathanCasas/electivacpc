package com.uniminuto.electiva.repositories;

import com.uniminuto.electiva.entities.Empleados;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author joncasasq
 */
public interface EmpleadoRepository extends CrudRepository<Empleados, Integer> {

    Integer findMaxId();
}
