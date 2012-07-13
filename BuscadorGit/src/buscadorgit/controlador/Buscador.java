/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buscadorgit.controlador;

import buscadorgit.modelo.Busqueda;
import buscadorgit.modelo.BusquedaListener;
import buscadorgit.modelo.Coincidencia;
import buscadorgit.modelo.EventoBusquedaTerminada;
import buscadorgit.modelo.EventoEncontrado;
import buscadorgit.modelo.EventoProgreso;
import java.io.IOException;
import java.net.URL;
import java.nio.CharBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;
import org.eclipse.egit.github.core.Blob;
import org.eclipse.egit.github.core.Reference;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryCommit;
import org.eclipse.egit.github.core.Tree;
import org.eclipse.egit.github.core.TreeEntry;
import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.service.DataService;
import org.eclipse.egit.github.core.service.RepositoryService;

/**
 *
 * @author forest
 */
public class Buscador implements Runnable{

    public final String GITHUB_URL_BASE="https://github.com/";
    private Thread hilo;
    private InvocadorEvento invocadorEvento;
    private Busqueda busqueda;
    private boolean continuar;
    private List<BusquedaListener> listeners;
    int intervaloActalizacion;
    

    public Buscador(InvocadorEvento invocadorEvento) {
        hilo= new Thread(this);
        this.invocadorEvento=invocadorEvento;
        listeners= new LinkedList<BusquedaListener>();
        intervaloActalizacion= 10;
    }

    public void setIntervaloActalizacion(int intervaloActalizacion) {
        this.intervaloActalizacion = intervaloActalizacion;
    }

    public int getIntervaloActalizacion() {
        return intervaloActalizacion;
    }
    

    /**
     * El metodo buscar es asincrono
     */
    public void buscar(Busqueda busqueda)throws ExBusquedaEnCurso{
        
        if(!hilo.isAlive()){
            this.busqueda=busqueda;
            continuar=true;
            hilo= new Thread(this);
            hilo.start();
        }else{
            throw new ExBusquedaEnCurso("Existe una busqueda en curso");
        }

    }

    public boolean  estaBuscando(){
        return hilo.isAlive();
    }
    
    public void run() {
        long contador=0;
        try {
            RepositoryService servRepositorio = new RepositoryService();
            Repository repo = servRepositorio.getRepository(busqueda.getUsuario(), busqueda.getRepositorio());
            
            /***
             * Se obtiene una referencia
             */
            DataService servicioData= new DataService();

            Reference ref= servicioData.getReference(repo, "heads/"+repo.getMasterBranch());

            CommitService commitService= new CommitService();
            RepositoryCommit commit=commitService.getCommit(repo, ref.getObject().getSha());
            
            Tree arbol=servicioData.getTree(repo, commit.getCommit().getTree().getSha(),true);
            contador=0;
            for(TreeEntry hoja:arbol.getTree()){
                if(hoja.getType().compareTo(TreeEntry.TYPE_BLOB)==0){
                    Blob blob=servicioData.getBlob(repo, hoja.getSha());
                    String contenido;
                    if(blob.getEncoding().compareTo(Blob.ENCODING_BASE64)==0){
                        if(contador %intervaloActalizacion==0){
                              if(!continuar()){
                                 throw new ExBusquedaCancelada("El usuario cancelo la busqueda");
                              }
                              for(BusquedaListener listener:listeners){
                                    invocadorEvento.invocar(new EventoProgreso(hoja.getPath()),listener);
                               }
                        }
                        contenido= new String(Base64.decodeBase64(blob.getContent()));
                        CharBuffer buffer= CharBuffer.wrap(contenido);
                        Scanner scaner= new Scanner(buffer);

                        long linea=0;
                        String cadenaLinea;
                        boolean escanear=true;
                        while(escanear){
                           linea++;
                           if(scaner.findInLine(busqueda.getPatron())!=null){
                               for(BusquedaListener listener:listeners){
                                    invocadorEvento.invocar(new EventoEncontrado(new Coincidencia( new URL(repo.getHtmlUrl()+"/blob/"+repo.getMasterBranch()+"/"+hoja.getPath()+"#L"+linea),
                                                                                                     linea,
                                                                                                     hoja.getPath()
                                                                                                  )
                                                                                )
                                                            ,listener
                                                           );
                               }
                               contador++;
                           }
                           escanear=scaner.hasNextLine();
                           if(escanear){
                               scaner.nextLine();
                           }
                        }
                    }
                }
            }
            for(BusquedaListener l:listeners){
                invocadorEvento.invocar(new EventoBusquedaTerminada(null, contador),l);
            }
        } catch (IOException ex) {
            Logger.getLogger(Buscador.class.getName()).log(Level.SEVERE, null, ex);
            for(BusquedaListener l:listeners){
                invocadorEvento.invocar(new EventoBusquedaTerminada(ex, contador),l);
            }
        }catch(ExBusquedaCancelada ex){
            Logger.getLogger(Buscador.class.getName()).log(Level.SEVERE, null, ex);
            for(BusquedaListener l:listeners){
                invocadorEvento.invocar(new EventoBusquedaTerminada(ex, contador),l);
            }
        }catch(Exception ex){
            Logger.getLogger(Buscador.class.getName()).log(Level.SEVERE, null, ex);
            for(BusquedaListener l:listeners){
                invocadorEvento.invocar(new EventoBusquedaTerminada(ex, contador),l);
            }
        }

    }

    public void addListener(BusquedaListener listener){
        listeners.add(listener);
    }
    public void removeListener(BusquedaListener listener){
        listeners.remove(listener);
    }

    private synchronized boolean continuar(){
        return continuar;
    }

    public synchronized  void detener(){
        continuar=false;
    }

}
