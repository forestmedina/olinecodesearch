/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buscadorgit.modelo;

/**
 *
 * @author forest
 */
public class EventoBusquedaTerminada implements Evento {
    Exception  excepcion;
    long cantidadEncotrados;

    public EventoBusquedaTerminada(Exception excepcion, long cantidadEncotrados) {
        this.excepcion = excepcion;
        this.cantidadEncotrados = cantidadEncotrados;
    }

    


    
    public Exception getExcepcion() {
        return excepcion;
    }
    
    public boolean fallo(){
        return excepcion!=null;
    }

    public long getCantidadEncotrados() {
        return cantidadEncotrados;
    }

    

}
