/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buscadorgit.modelo;

/**
 *
 * @author forest
 */
public class Busqueda {
    private String usuario;
    private String repositorio;
    private String patron;

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the repositorio
     */
    public String getRepositorio() {
        return repositorio;
    }

    /**
     * @param repositorio the repositorio to set
     */
    public void setRepositorio(String repositorio) {
        this.repositorio = repositorio;
    }

    /**
     * @return the patron
     */
    public String getPatron() {
        return patron;
    }

    /**
     * @param patron the patron to set
     */
    public void setPatron(String patron) {
        this.patron = patron;
    }

}
