/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buscadorgit.controlador;

import buscadorgit.modelo.BusquedaListener;
import buscadorgit.modelo.EventoBusquedaTerminada;
import buscadorgit.modelo.EventoEncontrado;
import buscadorgit.modelo.EventoProgreso;
import javax.swing.SwingUtilities;

/**
 *
 * @author forest
 */
public class InvocadorEventoSwing implements InvocadorEvento{

    public InvocadorEventoSwing( ) {
    }
    public void invocar(EventoBusquedaTerminada evento,BusquedaListener listener){
        SwingUtilities.invokeLater(new EjecutarBusquedaTerminada(evento, listener));
    }
    public void invocar(EventoEncontrado evento,BusquedaListener listener){
        SwingUtilities.invokeLater(new EjecutarEncotrado(evento, listener));
    }

    public void invocar(EventoProgreso evento, BusquedaListener listener) {
        SwingUtilities.invokeLater(new EjecutarProgreso(evento, listener));
    }

    private class EjecutarBusquedaTerminada implements Runnable{
        private EventoBusquedaTerminada evento;
        private BusquedaListener listener;

        public EjecutarBusquedaTerminada(EventoBusquedaTerminada evento, BusquedaListener listener) {
            this.evento = evento;
            this.listener = listener;
        }
        public void run() {
            listener.busquedaTerminada(evento);
        }


    }

    private class EjecutarEncotrado implements Runnable{
        private EventoEncontrado evento;
        private BusquedaListener listener;

        public EjecutarEncotrado(EventoEncontrado evento, BusquedaListener listener) {
            this.evento = evento;
            this.listener = listener;
        }
        public void run() {
                listener.encontrado(evento);
        }
    }
    private class EjecutarProgreso implements Runnable{
        private EventoProgreso evento;
        private BusquedaListener listener;

        public EjecutarProgreso(EventoProgreso evento, BusquedaListener listener) {
            this.evento =  evento;
            this.listener = listener;
        }
        public void run() {
                listener.progresoBusqueda(evento);
        }
    }
}
