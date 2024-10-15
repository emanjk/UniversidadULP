
package Vista;


public class MenuPrincipal extends javax.swing.JFrame {

   
    public MenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null) ;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        jmAgregarAlumno = new javax.swing.JMenu();
        jmiAlumno = new javax.swing.JMenuItem();
        jMenuMateria = new javax.swing.JMenu();
        jmMateria = new javax.swing.JMenuItem();
        jMenuAdministracion = new javax.swing.JMenu();
        jmInscripciones = new javax.swing.JMenuItem();
        jmNotas = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jmAlumnosMateria = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenu();
        jmSalir = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar3.add(jMenu3);

        jMenu8.setText("Edit");
        jMenuBar3.add(jMenu8);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
        );

        jmAgregarAlumno.setText("Alumno");

        jmiAlumno.setText("Formulario Alumno");
        jmiAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAlumnoActionPerformed(evt);
            }
        });
        jmAgregarAlumno.add(jmiAlumno);

        jMenuBar2.add(jmAgregarAlumno);

        jMenuMateria.setText("Materia");

        jmMateria.setText("Formulario Materia");
        jmMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmMateriaActionPerformed(evt);
            }
        });
        jMenuMateria.add(jmMateria);

        jMenuBar2.add(jMenuMateria);

        jMenuAdministracion.setText("Administracion");

        jmInscripciones.setText("Manejo de inscripciones");
        jmInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmInscripcionesActionPerformed(evt);
            }
        });
        jMenuAdministracion.add(jmInscripciones);

        jmNotas.setText("Manipulacion de notas");
        jmNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmNotasActionPerformed(evt);
            }
        });
        jMenuAdministracion.add(jmNotas);

        jMenuBar2.add(jMenuAdministracion);

        jMenu9.setText("Consultas");

        jmAlumnosMateria.setText("Alumnos por materia");
        jmAlumnosMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAlumnosMateriaActionPerformed(evt);
            }
        });
        jMenu9.add(jmAlumnosMateria);

        jMenuBar2.add(jMenu9);

        salir.setText("Salir");

        jmSalir.setText("Salir");
        jmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSalirActionPerformed(evt);
            }
        });
        salir.add(jmSalir);

        jMenuBar2.add(salir);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    
    
    /*Menu: Registro Materias*/
    private void jmMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmMateriaActionPerformed
      escritorio.removeAll();
      escritorio.repaint();
      VistaMateria gestionM = new VistaMateria();
      gestionM.setVisible(true);
      escritorio.add(gestionM);
      escritorio.moveToFront(gestionM);
    }//GEN-LAST:event_jmMateriaActionPerformed

    /*Menu: Registro alumnos*/
    private void jmiAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAlumnoActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaAlumno gestionA = new VistaAlumno();
        gestionA.setVisible(true);
        escritorio.add(gestionA);
        escritorio.moveToFront(gestionA);
    }//GEN-LAST:event_jmiAlumnoActionPerformed

    private void jmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSalirActionPerformed
       this.dispose();
    }//GEN-LAST:event_jmSalirActionPerformed

    
    /*Formulario de Inscripcion */
    private void jmInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmInscripcionesActionPerformed
      escritorio.removeAll();
      escritorio.repaint();
      VistaInscripcion vi = new VistaInscripcion();
      vi.setVisible(true);
      escritorio.add(vi);
      escritorio.moveToFront(vi);
        
        
    }//GEN-LAST:event_jmInscripcionesActionPerformed

    private void jmNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmNotasActionPerformed
      escritorio.removeAll();
      escritorio.repaint();
      VistaCargaNotas notas = new VistaCargaNotas();
      notas.setVisible(true);
      escritorio.add(notas);
      escritorio.moveToFront(notas);
    }//GEN-LAST:event_jmNotasActionPerformed

    private void jmAlumnosMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAlumnosMateriaActionPerformed
      escritorio.removeAll();
      escritorio.repaint();
      VistaListarInscripciones consulta = new VistaListarInscripciones();
      consulta.setVisible(true);
      escritorio.add(consulta);
      escritorio.moveToFront(consulta);
    }//GEN-LAST:event_jmAlumnosMateriaActionPerformed

    
    
    
    
    
    
   
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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenu jMenuAdministracion;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenu jMenuMateria;
    private javax.swing.JMenu jmAgregarAlumno;
    private javax.swing.JMenuItem jmAlumnosMateria;
    private javax.swing.JMenuItem jmInscripciones;
    private javax.swing.JMenuItem jmMateria;
    private javax.swing.JMenuItem jmNotas;
    private javax.swing.JMenuItem jmSalir;
    private javax.swing.JMenuItem jmiAlumno;
    private javax.swing.JMenu salir;
    // End of variables declaration//GEN-END:variables
}
