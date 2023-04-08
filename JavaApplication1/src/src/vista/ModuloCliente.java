
package src.vista;

import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static src.controlador.ClienteControlador.botonoOperadorVolver;
import src.controlador.ClienteControlador;


public class ModuloCliente extends javax.swing.JFrame {

    /**
     * Creates new form ModuloCliente
     */
    public ModuloCliente() {
        initComponents();
        setLocationRelativeTo(null);
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Volver = new javax.swing.JButton();
        CRUD = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        id_cl = new javax.swing.JTextField();
        name_cl = new javax.swing.JTextField();
        email_cl = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pass_cl = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Acciones = new javax.swing.JPanel();
        guardar_cl = new javax.swing.JButton();
        listar_cl = new javax.swing.JButton();
        editar_cl = new javax.swing.JButton();
        confirmar_edicion_cl1 = new javax.swing.JButton();
        eliminar_cl = new javax.swing.JButton();
        import_data = new javax.swing.JButton();
        export_data = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Volver.setBackground(new java.awt.Color(255, 0, 0));
        Volver.setText("VOLVER");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        CRUD.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setText("Correo Electrónico:");

        jLabel2.setText("Nombre Completo:");

        jLabel3.setText("Identificación:");

        name_cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_clActionPerformed(evt);
            }
        });

        jLabel4.setText("Contraseña:");

        javax.swing.GroupLayout CRUDLayout = new javax.swing.GroupLayout(CRUD);
        CRUD.setLayout(CRUDLayout);
        CRUDLayout.setHorizontalGroup(
            CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CRUDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CRUDLayout.createSequentialGroup()
                        .addGroup(CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_cl)
                            .addComponent(name_cl)))
                    .addGroup(CRUDLayout.createSequentialGroup()
                        .addGroup(CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(email_cl)
                            .addComponent(pass_cl))))
                .addContainerGap())
        );
        CRUDLayout.setVerticalGroup(
            CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CRUDLayout.createSequentialGroup()
                .addGroup(CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name_cl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_cl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(email_cl, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pass_cl, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de Cliente", "Nombre Completo", "Identificación", "Correo Electrónico"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Acciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        guardar_cl.setText("Guardar");
        guardar_cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_clActionPerformed(evt);
            }
        });

        listar_cl.setText("Listar");
        listar_cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listar_clActionPerformed(evt);
            }
        });

        editar_cl.setText("Seleccionar");
        editar_cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar_clActionPerformed(evt);
            }
        });

        confirmar_edicion_cl1.setText("Editar");
        confirmar_edicion_cl1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmar_edicion_cl1ActionPerformed(evt);
            }
        });

        eliminar_cl.setText("Eliminar");
        eliminar_cl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar_clActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AccionesLayout = new javax.swing.GroupLayout(Acciones);
        Acciones.setLayout(AccionesLayout);
        AccionesLayout.setHorizontalGroup(
            AccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(guardar_cl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(listar_cl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editar_cl, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(confirmar_edicion_cl1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(eliminar_cl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        AccionesLayout.setVerticalGroup(
            AccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar_cl, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(listar_cl, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(editar_cl, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(eliminar_cl, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(confirmar_edicion_cl1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                .addContainerGap())
        );

        import_data.setBackground(new java.awt.Color(255, 255, 0));
        import_data.setText("Importar Data");
        import_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                import_dataActionPerformed(evt);
            }
        });

        export_data.setBackground(new java.awt.Color(51, 204, 0));
        export_data.setText("Exportar Data");
        export_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                export_dataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Volver, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(import_data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(export_data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(Acciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(export_data, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(import_data, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CRUD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Acciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        // TODO add your handling code here:
        botonoOperadorVolver("operador");
    }//GEN-LAST:event_VolverActionPerformed

    private void name_clActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_clActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_clActionPerformed

    private void confirmar_edicion_cl1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmar_edicion_cl1ActionPerformed
        // TODO add your handling code here:
        ClienteControlador cliente = new ClienteControlador();
        cliente.actualizar(jTable1,name_cl, id_cl, email_cl,pass_cl);
        cliente.limpiarTabla(jTable1);
        cliente.listarClientes(jTable1);
    }//GEN-LAST:event_confirmar_edicion_cl1ActionPerformed

    private void eliminar_clActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar_clActionPerformed
        // TODO add your handling code here:
        ClienteControlador cliente = new ClienteControlador();
        cliente.eliminar(jTable1);
        cliente.limpiarTabla(jTable1);
        cliente.listarClientes(jTable1);
    }//GEN-LAST:event_eliminar_clActionPerformed

    private void editar_clActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar_clActionPerformed
        // TODO add your handling code here:
        ClienteControlador cliente = new ClienteControlador();
        cliente.editar(jTable1,name_cl, id_cl, email_cl,pass_cl);
    }//GEN-LAST:event_editar_clActionPerformed

    private void listar_clActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listar_clActionPerformed
        // TODO add your handling code here:
        ClienteControlador cliente = new ClienteControlador();
        cliente.limpiarTabla(jTable1);
        cliente.listarClientes(jTable1);
    }//GEN-LAST:event_listar_clActionPerformed

    private void guardar_clActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_clActionPerformed
        // TODO add your handling code here:
        ClienteControlador cliente = new ClienteControlador();
        cliente.agregar(name_cl, id_cl, email_cl, pass_cl,jTable1);
        cliente.limpiarTabla(jTable1);
        cliente.listarClientes(jTable1);
    }//GEN-LAST:event_guardar_clActionPerformed

    private void export_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_export_dataActionPerformed
        // TODO add your handling code here:
        ClienteControlador cliente = new ClienteControlador();
        cliente.imprimirPdf();
    }//GEN-LAST:event_export_dataActionPerformed

    private void import_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_import_dataActionPerformed
        // TODO add your handling code here:
        ClienteControlador cliente = new ClienteControlador();
        JFileChooser seleccionarArchivo = new JFileChooser();
        int seleccionar = seleccionarArchivo.showOpenDialog(this);
        if (seleccionar == JFileChooser.APPROVE_OPTION){
            File archivo = seleccionarArchivo.getSelectedFile();
            try {
                cliente.cargarCSV(archivo);
            } catch (SQLException ex) {
                Logger.getLogger(ModuloCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        cliente.limpiarTabla(jTable1);
        cliente.listarClientes(jTable1);
    }//GEN-LAST:event_import_dataActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModuloCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModuloPrincipal frame = new ModuloPrincipal();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Acciones;
    private javax.swing.JPanel CRUD;
    private javax.swing.JButton Volver;
    private javax.swing.JButton confirmar_edicion_cl1;
    private javax.swing.JButton editar_cl;
    private javax.swing.JButton eliminar_cl;
    private javax.swing.JTextField email_cl;
    private javax.swing.JButton export_data;
    private javax.swing.JButton guardar_cl;
    private javax.swing.JTextField id_cl;
    private javax.swing.JButton import_data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JButton listar_cl;
    private javax.swing.JTextField name_cl;
    private javax.swing.JTextField pass_cl;
    // End of variables declaration//GEN-END:variables
}