/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Busqueda.java
 *
 * Created on 11-jul-2012, 3:26:59
 */

package buscadorgit.vista;

import buscadorgit.controlador.Buscador;
import buscadorgit.controlador.ExBusquedaEnCurso;
import buscadorgit.controlador.InvocadorEventoSwing;
import buscadorgit.modelo.Busqueda;
import buscadorgit.modelo.BusquedaListener;
import buscadorgit.modelo.Coincidencia;
import buscadorgit.modelo.EventoBusquedaTerminada;
import buscadorgit.modelo.EventoEncontrado;
import buscadorgit.modelo.EventoProgreso;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author forest
 */
public class VBusqueda extends javax.swing.JFrame implements BusquedaListener, ClipboardOwner{

    /** Creates new form Busqueda */
    public VBusqueda() {
        initComponents();
        buscador= new Buscador(new InvocadorEventoSwing());
        buscador.addListener(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        arbResultado = new javax.swing.JTree();
        btnBuscar = new javax.swing.JButton();
        txtPatron = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRepositorio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtURL = new javax.swing.JTextField();
        btnCopiar = new javax.swing.JButton();
        btnAbrir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtArchivoActual = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        arbResultado.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Resultado") ));
        arbResultado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arbResultadoMouseClicked(evt);
            }
        });
        arbResultado.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                arbResultadoValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(arbResultado);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtPatron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatronActionPerformed(evt);
            }
        });

        jLabel5.setText("Cadena a buscar");

        jLabel3.setText("Usuario");

        jLabel1.setText("https://github.com/");

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        jLabel2.setText("/");

        jLabel4.setText("Repositorio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(txtRepositorio, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel4)
                        .addGap(23, 23, 23)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRepositorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("URL");

        txtURL.setEditable(false);
        txtURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtURLActionPerformed(evt);
            }
        });

        btnCopiar.setText("copiar URL");
        btnCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiarActionPerformed(evt);
            }
        });

        btnAbrir.setText("abrir URL");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        jLabel7.setText("Archivo Actual:");

        txtArchivoActual.setEditable(false);

        jButton1.setText("Detener");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtURL, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnCopiar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPatron, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtArchivoActual))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(36, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPatron, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtArchivoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCopiar)
                    .addComponent(btnAbrir))
                .addGap(78, 78, 78))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtPatronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatronActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtPatronActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Busqueda busqueda= new Busqueda();
        busqueda.setPatron(txtPatron.getText());
        busqueda.setRepositorio(txtRepositorio.getText());
        busqueda.setUsuario(txtUsuario.getText());
        try {
            if(!buscador.estaBuscando()){
                DefaultTreeModel modelo =(DefaultTreeModel) arbResultado.getModel();
                txtArchivoActual.setText("");
                ((DefaultMutableTreeNode)modelo.getRoot()).removeAllChildren();
                buscador.buscar(busqueda);
                btnBuscar.setEnabled(false);
            }
        } catch (ExBusquedaEnCurso ex) {
            Logger.getLogger(VBusqueda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void arbResultadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arbResultadoMouseClicked
        if(evt.getClickCount()==2){
            TreePath ruta=arbResultado.getPathForLocation(evt.getX(), evt.getY());
            if(ruta!=null){
               DefaultMutableTreeNode nodo= (DefaultMutableTreeNode)ruta.getLastPathComponent();
               if(nodo.getUserObject() instanceof Coincidencia){
                   Coincidencia coincidencia= (Coincidencia)nodo.getUserObject();
                   abrirURL(coincidencia.getUrl());
               }
            }
        }
    }//GEN-LAST:event_arbResultadoMouseClicked

    private void txtURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtURLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtURLActionPerformed

    private void btnCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiarActionPerformed
         if(txtURL.getText()!=null&&txtURL.getText().compareTo("")!=0){
            StringSelection contenido = new StringSelection( txtURL.getText());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents( contenido, this );
         }
    }//GEN-LAST:event_btnCopiarActionPerformed

    private void arbResultadoValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_arbResultadoValueChanged
       TreePath ruta=evt.getPath();
       DefaultMutableTreeNode nodo= (DefaultMutableTreeNode)ruta.getLastPathComponent();
       if(nodo.getUserObject() instanceof Coincidencia){
           Coincidencia coincidencia= (Coincidencia) nodo.getUserObject();
           txtURL.setText(coincidencia.getUrl().toExternalForm());
       }
    }//GEN-LAST:event_arbResultadoValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscador.detener();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirActionPerformed
         if(Desktop.isDesktopSupported()&&txtURL.getText()!=null&&txtURL.getText().compareTo("")!=0){
            try {
                Desktop.getDesktop().browse(new URI(txtURL.getText()));
            } catch (URISyntaxException ex) {
                JOptionPane.showMessageDialog(this, "No se puede abrir la url");
                Logger.getLogger(VBusqueda.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "No se puede abrir la url");
                Logger.getLogger(VBusqueda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAbrirActionPerformed
    private void abrirURL(URL url){
        if(Desktop.isDesktopSupported()){
            try {
                Desktop.getDesktop().browse(url.toURI());
            } catch (URISyntaxException ex) {
                JOptionPane.showMessageDialog(this, "No se puede abrir la url");
                Logger.getLogger(VBusqueda.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "No se puede abrir la url");
                Logger.getLogger(VBusqueda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VBusqueda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbResultado;
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCopiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtArchivoActual;
    private javax.swing.JTextField txtPatron;
    private javax.swing.JTextField txtRepositorio;
    private javax.swing.JTextField txtURL;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    private Buscador buscador;
    public void encontrado(EventoEncontrado evento) {
        Coincidencia coincidencia=evento.getCoincidencia();
        DefaultTreeModel modelo=(DefaultTreeModel) arbResultado.getModel();
        DefaultMutableTreeNode nodoNuevo=new DefaultMutableTreeNode(coincidencia);
        modelo.insertNodeInto(nodoNuevo, (DefaultMutableTreeNode)modelo.getRoot(), modelo.getChildCount(modelo.getRoot()));
        arbResultado.expandRow(0);
        System.out.println(coincidencia.getPath()+":"+coincidencia.getLinea());

    }

    public void busquedaTerminada(EventoBusquedaTerminada evento) {
        btnBuscar.setEnabled(true);
        txtArchivoActual.setText("");
        if(evento.fallo()){
            JOptionPane.showMessageDialog(this, "Ocurrio un error al buscar: "+evento.getExcepcion().getMessage());
        }else{
            JOptionPane.showMessageDialog(this, "Culmino la busqueda se encontraron   "+evento.getCantidadEncotrados()+"  coincidencias ");
        }

    }
    public void progresoBusqueda(EventoProgreso evento) {
        txtArchivoActual.setText(evento.getArchivoActual());
    }
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        
    }



}
