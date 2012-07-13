/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buscadorgit.controlador;

/**
 *
 * @author forest
 */
public class ExBusquedaEnCurso extends Exception {

    public ExBusquedaEnCurso(Throwable cause) {
        super(cause);
    }

    public ExBusquedaEnCurso(String message, Throwable cause) {
        super(message, cause);
    }

    public ExBusquedaEnCurso(String message) {
        super(message);
    }

    public ExBusquedaEnCurso() {
    }

}
