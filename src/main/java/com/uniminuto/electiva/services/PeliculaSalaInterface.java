/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.services;

import com.uniminuto.electiva.ui.PeliculaSalaUI;
import java.util.List;

/**
 *
 * @author joncasasq
 */

public interface PeliculaSalaInterface {

    public List<PeliculaSalaUI> getPeliculas(int idMultiplex);

}
