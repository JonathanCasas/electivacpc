/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.electiva.response;

/**
 *
 * @author joncasasq
 */
public class SeleccionarSillaResponse {

    private String result;
    private String message;

    public SeleccionarSillaResponse() {
    }

    public SeleccionarSillaResponse(String result) {
        this.result = result;
    }

    public SeleccionarSillaResponse(String result, String message) {
        this.result = result;
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
