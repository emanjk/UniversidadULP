package Vista;

/*Importamos las clases*/
import Entidades.Materia;
import Persistencia.Conexion;
import Persistencia.MateriaData;
/*Importamos las clases de la API JDBC*/
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*clases utilitarias*/
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class VistaMateria extends javax.swing.JInternalFrame {
    //1.
    private Conexion conexion;
    private MateriaData materiaData;
    
    
   
    public VistaMateria() {
        initComponents();
        //2.
        conexion = new Conexion ("jdbc:mariadb://localhost:3306/universidadulp", "root", "");
        materiaData = new MateriaData (conexion) ;
        
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtCodigo = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jtAnio = new javax.swing.JTextField();
        jrbEstado = new javax.swing.JRadioButton();
        jbBuscar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jtEliminar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbMostrar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(620, 510));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 0));
        jLabel1.setText("Materia");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Codigo:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Año:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Estado:");

        jrbEstado.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jtEliminar.setText("Eliminar");
        jtEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEliminarActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(255, 0, 0));
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbMostrar.setText("Mostrar");
        jbMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jbActualizar)
                        .addGap(12, 12, 12)
                        .addComponent(jbMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                                .addComponent(jtCodigo, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(37, 37, 37)
                                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jrbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // 1. Boton 'Buscar Materia por codigo'
    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // 1. Verificamos que el campo de código (id_Materia) no esté vacío.
       if (jtCodigo.getText().isEmpty()) {
           JOptionPane.showMessageDialog(this, "Ingrese el código de la materia", "ERROR", JOptionPane.ERROR_MESSAGE);
           return; // Salir del método si el código está vacío
       }

       try {
           // 2. Obtener el valor del campo código (id_Materia)
           int idMateria = Integer.parseInt(jtCodigo.getText());

           // 3. Buscar la materia en la base de datos usando el método buscarMateria(int id)
           Materia materia = materiaData.buscarMateria(idMateria);

           // 4. Verificar si se encontró la materia
           if (materia != null) {
               // Si se encuentra la materia, llenamos los campos con los datos
               jtNombre.setText(materia.getNombre());
               jtAnio.setText(String.valueOf(materia.getAnioMateria()));
               jrbEstado.setSelected(materia.getEstado());
           } else {
               // Si no se encuentra la materia, mostramos un mensaje de error
               JOptionPane.showMessageDialog(this, "No se encontró ninguna materia con el código: " + idMateria, "ERROR", JOptionPane.ERROR_MESSAGE);
               // Limpiamos los camposs
               jtNombre.setText("");
               jtAnio.setText("");
               jrbEstado.setSelected(false);
           }

       } catch (NumberFormatException e) {
           // Si el código ingresado no es un número, mostramos un mensaje de error
           JOptionPane.showMessageDialog(this, "El código debe ser un número", "ERROR", JOptionPane.ERROR_MESSAGE);
       } catch (Exception e) {
           //Cualquier otro error je
           JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
       }
                
        
    }//GEN-LAST:event_jbBuscarActionPerformed

    // 2. Boton 'Salir'
    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
       this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

  
    // 3. Boton 'Guardar Materia'
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // 1. Verificamos que los campos no estén vacíos
    if (jtNombre.getText().isEmpty() || jtAnio.getText().isEmpty() || jtCodigo.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Complete todos los campos", "ERROR", JOptionPane.ERROR_MESSAGE);
        return; // Salir si hay campos vacíos
    }

    try {
        // 2. Obtener los valores del formulario
        int codigo = Integer.parseInt(jtCodigo.getText());
        String nombre = jtNombre.getText();
        int anio = Integer.parseInt(jtAnio.getText());
        boolean estado = jrbEstado.isSelected(); 

        // 3. Verificar si ya existe una materia con ese código
        Materia materiaExistentePorCodigo = materiaData.buscarMateria(codigo);
        
        if (materiaExistentePorCodigo != null) {
            // verificamos si ya existe la materia con codigo repetido
            JOptionPane.showMessageDialog(this, "Error, ya existe una materia " + materiaExistentePorCodigo.getNombre() + " con el código: " + materiaExistentePorCodigo.getIdMateria(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 4. Verificar si ya existe una materia con ese nombre
        Materia materiaExistentePorNombre = materiaData.buscarMateriaPorNombre(nombre);
        
        if (materiaExistentePorNombre != null) {
            // Si ya existe una materia con el mismo nombre, mostrar mensaje y salir
            JOptionPane.showMessageDialog(this, "Error, ya existe una materia con el nombre: " + materiaExistentePorNombre.getNombre(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 5. Crear una nueva materia si no existe
        Materia nuevaMateria = new Materia(codigo, nombre, anio, estado);

        // 6. Guardar la nueva materia en la base de datos
        materiaData.guardarMateria(nuevaMateria); 
        
        // 7. 
        JOptionPane.showMessageDialog(this, "Materia guardada con exito", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        // 8. Limpiamos los campos
        jtCodigo.setText("");
        jtNombre.setText("");
        jtAnio.setText("");
        jrbEstado.setSelected(false);

    } catch (NumberFormatException e) {
        // Si el código o el año no son válidos
        JOptionPane.showMessageDialog(this, "El código y el año deben ser números", "ERROR", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
     
        JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); 
    }
     
    
    
   
        
    
        
    }//GEN-LAST:event_jbGuardarActionPerformed

    
    // 4. Boton 'Eliminar Materia'
    private void jtEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEliminarActionPerformed
        // 1. Verificar que el campo de código no esté vacío
        if (jtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el código de la materia que desea eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);
            return; // Salir si el campo está vacío
        }

        try {
            // 2. Obtener el código de la materia a eliminar
            int codigo = Integer.parseInt(jtCodigo.getText());

            // 3. Verificar si la materia existe en la bds
            Materia materiaExistente = materiaData.buscarMateria(codigo); 
            if (materiaExistente == null) {
                JOptionPane.showMessageDialog(this, "No se encontró ninguna materia con el código: " + codigo, "ERROR", JOptionPane.ERROR_MESSAGE);
                return; 
            }

            // 4. Preguntamos si confimar eliminar la materia.
            int confirm = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro que desea eliminar la materia " + materiaExistente.getNombre() + "?", 
                "Confirmación de eliminación", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

            // 5. si elige 'si':
            if (confirm == JOptionPane.YES_OPTION) {
                materiaData.eliminarMateria(codigo);

                // 6. mensaje de confirmacion
                JOptionPane.showMessageDialog(this, "Materia eliminada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);    
                jtCodigo.setText("");
                jtNombre.setText("");
                jtAnio.setText("");         
            }

        } catch (NumberFormatException e) {
            // Si el código no es un número válido
            JOptionPane.showMessageDialog(this, "El código debe ser un número", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Cualquier otro error
            JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtEliminarActionPerformed

    // 5. Boton 'Limpiar Campos'
    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        jtCodigo.setText("");
        jtNombre.setText("");
        jtAnio.setText("");
        jrbEstado.isSelected();
    }//GEN-LAST:event_jbNuevoActionPerformed

    
    // 6. Boton 'Actualizar Datos'
    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        // 1. Verificamos que los campos no estén vacíos
      if (jtNombre.getText().isEmpty() || jtAnio.getText().isEmpty()) {
          JOptionPane.showMessageDialog(this, "Complete los campos Nombre y Año", "ERROR", JOptionPane.ERROR_MESSAGE);
          return; // Salir si hay campos vacíos
      }

      try {
          // 2. Obtener los valores del formulario
          String nombre = jtNombre.getText();
          int anio = Integer.parseInt(jtAnio.getText());
          boolean estado = jrbEstado.isSelected(); 
          int codigo = Integer.parseInt(jtCodigo.getText()); 

          // 3. Crear una nueva materia con los valores actualizados
          Materia materiaModificada = new Materia(codigo, nombre, anio, estado); 

          // 4. Llamar al método para modificar la materia
          materiaData.modificarMateria(materiaModificada); 

          // 5. Mostrar un mensaje de éxito
          JOptionPane.showMessageDialog(this, "Materia modificada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
          jtCodigo.setText("");
          jtNombre.setText("");
          jtAnio.setText("");
          
      } catch (NumberFormatException e) {
          // Si el año o el código no son válidos
          JOptionPane.showMessageDialog(this, "Los campos Año y Código deben ser números", "ERROR", JOptionPane.ERROR_MESSAGE);
      } catch (Exception e) {
        
          JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
      }
    }//GEN-LAST:event_jbActualizarActionPerformed

    // 7. Boton 'Mostrar Materias'
    private void jbMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarActionPerformed
          // Creamos el nuevo JInternalFrame (ListaMaterias)
       ListaMaterias listaMaterias = new ListaMaterias(); 

       // Añadimos el nuevo JInternalFrame al JDesktopPane
       this.getDesktopPane().add(listaMaterias);

       // Hacemos visible el nuevo JInternalFrame y lo traemos al frente
       listaMaterias.setVisible(true);
       listaMaterias.moveToFront();
        
        
    }//GEN-LAST:event_jbMostrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbMostrar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JRadioButton jrbEstado;
    private javax.swing.JTextField jtAnio;
    private javax.swing.JTextField jtCodigo;
    private javax.swing.JButton jtEliminar;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}
