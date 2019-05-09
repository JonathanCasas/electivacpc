/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.repositories;

import com.uniminuto.electiva.entities.Sillas;
import com.uniminuto.electiva.entities.SillasPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author joncasasq
 */
public interface SillaRepository extends JpaRepository<Sillas, SillasPK> {

    List<String> findBySillasOrderByFila(@Param("salasId") int salasId);

    List<String> findBySillasOrderByColumna(@Param("salasId") int salasId);

    Sillas findByFilaAndColumna(@Param("fila") String fila, @Param("columna") String columna);

    Sillas findBySillaId(@Param("id") int id);
}
