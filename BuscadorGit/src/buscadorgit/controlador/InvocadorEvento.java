/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buscadorgit.controlador;

import buscadorgit.modelo.BusquedaListener;
import buscadorgit.modelo.EventoBusquedaTerminada;
import buscadorgit.modelo.EventoEncontrado;
import buscadorgit.modelo.EventoProgreso;

/**
 *
 * @author forest
 */
public interface InvocadorEvento {
    public void invocar(EventoBusquedaTerminada evento,BusquedaListener listener);
    public void invocar(EventoEncontrado evento,BusquedaListener listener);
    public void invocar(EventoProgreso evento,BusquedaListener listener);
}
