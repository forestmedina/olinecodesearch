/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zkgithub;

import buscadorgit.controlador.InvocadorEvento;
import buscadorgit.modelo.BusquedaListener;
import buscadorgit.modelo.EventoBusquedaTerminada;
import buscadorgit.modelo.EventoEncontrado;
import buscadorgit.modelo.EventoProgreso;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.DesktopUnavailableException;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Window;

/**
 *
 * @author forest
 */
public class InvocadorEventoZK implements InvocadorEvento{
    Desktop desktop;

    public InvocadorEventoZK(Desktop desktop) {
        this.desktop = desktop;
    }

    
    
    public void invocar(EventoBusquedaTerminada evento, BusquedaListener listener) {
        try {
            Executions.activate(desktop);
            listener.busquedaTerminada(evento);
            Executions.deactivate(desktop);
        } catch (InterruptedException ex) {
            Logger.getLogger(InvocadorEventoZK.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DesktopUnavailableException ex) {
            Logger.getLogger(InvocadorEventoZK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void invocar(EventoEncontrado evento, BusquedaListener listener) {
        try {
            Executions.activate(desktop);
            listener.encontrado(evento);
            Executions.deactivate(desktop);
        } catch (InterruptedException ex) {
            Logger.getLogger(InvocadorEventoZK.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DesktopUnavailableException ex) {
            Logger.getLogger(InvocadorEventoZK.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void invocar(EventoProgreso evento, BusquedaListener listener) {
         try {
            Executions.activate(desktop);
            listener.progresoBusqueda(evento);
            Executions.deactivate(desktop);
        } catch (InterruptedException ex) {
            Logger.getLogger(InvocadorEventoZK.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DesktopUnavailableException ex) {
            Logger.getLogger(InvocadorEventoZK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
