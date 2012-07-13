/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buscadorgit.modelo;

import java.net.URL;

/**
 *
 * @author forest
 */
public class EventoEncontrado implements  Evento {
   Coincidencia coincidencia;

    public EventoEncontrado(Coincidencia coincidencia) {
        this.coincidencia = coincidencia;
    }

    public Coincidencia getCoincidencia() {
        return coincidencia;
    }

   


}
