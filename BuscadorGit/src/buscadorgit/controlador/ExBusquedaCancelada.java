/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buscadorgit.controlador;

/**
 *
 * @author forest
 */
public class ExBusquedaCancelada extends Exception {

    public ExBusquedaCancelada(Throwable cause) {
         super(cause);
    }

    public ExBusquedaCancelada(String message, Throwable cause) {
         super(message, cause);
    }

    public ExBusquedaCancelada(String message) {
        super(message);
    }

    public ExBusquedaCancelada() {
    }

}
