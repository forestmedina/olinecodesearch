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
public interface BusquedaListener {
    public void encontrado(EventoEncontrado evento);
    public void busquedaTerminada(EventoBusquedaTerminada evento);
    public void progresoBusqueda(EventoProgreso evento);
}
