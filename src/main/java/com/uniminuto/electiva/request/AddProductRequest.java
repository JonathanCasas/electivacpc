/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author joncasasq
 */
public class AddProductRequest {

    @NotNull
    private int producto;
    @Min(1)
    private int cantidad;
    

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    

}
