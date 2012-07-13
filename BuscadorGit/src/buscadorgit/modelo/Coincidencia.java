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
public class Coincidencia {
    private URL url;
    private long linea;
    private String path;

    public Coincidencia(URL url, long linea, String path) {
        this.url = url;
        this.linea = linea;
        this.path = path;
    }

    public long getLinea() {
        return linea;
    }

    public String getPath() {
        return path;
    }

    public URL getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return (path==null?"<path desconocido>":path)+":"+linea;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coincidencia other = (Coincidencia) obj;
        if (this.linea != other.linea) {
            return false;
        }
        if ((this.path == null) ? (other.path != null) : !this.path.equals(other.path)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (int) (this.linea ^ (this.linea >>> 32));
        hash = 11 * hash + (this.path != null ? this.path.hashCode() : 0);
        return hash;
    }


}
