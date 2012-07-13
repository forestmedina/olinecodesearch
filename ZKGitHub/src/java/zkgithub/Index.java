/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zkgithub;

import buscadorgit.controlador.Buscador;
import buscadorgit.controlador.ExBusquedaEnCurso;
import buscadorgit.modelo.Busqueda;
import buscadorgit.modelo.BusquedaListener;
import buscadorgit.modelo.Coincidencia;
import buscadorgit.modelo.EventoBusquedaTerminada;
import buscadorgit.modelo.EventoEncontrado;
import buscadorgit.modelo.EventoProgreso;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.event.SelectEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Html;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Tree;

/**
 *
 * @author forest
 */
public class Index extends GenericForwardComposer implements BusquedaListener{
     private Buscador buscador;
     private Textbox txtPatron;
     private Textbox txtUsuario;
     private Textbox txtRepositorio;
     private Label lblArchivoActual;
     private Html htmlContenido;
     private Tree arbResultado;
    public void onCreate$wndPrincipal(Event evento){
        arbResultado.setModel(new DefaultTreeModel(new DefaultTreeNode("Resultado",new LinkedList())));
        buscador= new Buscador(new InvocadorEventoZK(desktop));
        buscador.addListener(this);
        desktop.enableServerPush(true);

    }

     public void onClick$btnDetener(Event evento) {
         buscador.detener();
     }
    public void onClick$btnBuscar(Event evento) {
        Busqueda busqueda= new Busqueda();
        busqueda.setPatron(txtPatron.getText());
        busqueda.setRepositorio(txtRepositorio.getText());
        busqueda.setUsuario(txtUsuario.getText());

        try {
            if(!buscador.estaBuscando()){
                ((DefaultTreeNode)arbResultado.getModel().getRoot()).getChildren().clear();
                
                lblArchivoActual.setValue("");
                buscador.buscar(busqueda);   
            }
        } catch (ExBusquedaEnCurso ex) {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void encontrado(EventoEncontrado evento) {
        Coincidencia coincidencia=evento.getCoincidencia();
        DefaultTreeModel modelo=(DefaultTreeModel) arbResultado.getModel();
        DefaultTreeNode nodoNuevo=new DefaultTreeNode(coincidencia);
        ((DefaultTreeNode)modelo.getRoot()).add(nodoNuevo);
        System.out.println(coincidencia.getPath()+":"+coincidencia.getLinea());
    }

    public void busquedaTerminada(EventoBusquedaTerminada evento) {
        lblArchivoActual.setValue("");
        if(evento.fallo()){
            alert("Ocurrio un error al buscar: "+evento.getExcepcion().getMessage());
        }else{
            alert("Culmino la busqueda se encontraron   "+evento.getCantidadEncotrados()+"  coincidencias ");
        }
    }

    public void progresoBusqueda(EventoProgreso evento) {
        lblArchivoActual.setValue(evento.getArchivoActual());
    }
    public void onSelect$arbResultado(Event evento){
        SelectEvent eventoSelect= (SelectEvent)((ForwardEvent)evento).getOrigin();
        Coincidencia coincidencia = (Coincidencia) ((DefaultTreeNode) eventoSelect.getSelectedObjects().iterator().next()).getData();
        htmlContenido.setContent("URL <a href='#' onclick='window.open(\""+ coincidencia.getUrl().toExternalForm()+"\")'>" + coincidencia.getUrl().toExternalForm()+"</a>");
        
    }
}
