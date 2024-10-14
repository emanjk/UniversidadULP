
package Vista;

/*importamos las clases:*/
import Modelo.Alumno;
import Persistencia.AlumnoData;
import Modelo.Conexion;
/*importamos las clases de la API JDBC: */
import java.sql.SQLException;
import java.sql.PreparedStatement; /*guarda codigo SQL*/
import java.sql.ResultSet; /*obtener datos o registro de un alumno*/
/*Clases utilitarias*/
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class VistaAlumno extends javax.swing.JInternalFrame {
    //(1)PRIMERO:
    private Conexion conexion ; // Variable conexión necesaria para interactuar con la base de datos MariaDB.
    private AlumnoData alumnoData; // Variable para hacer: consultas, inserciones o actualizar en la BDS-universidadulp.
   
    public VistaAlumno() {
        initComponents();
        //(2)SEGUNDO:
        conexion = new Conexion("jdbc:mariadb://localhost:3306/universidadulp", "root", "");//nueva instancia y con argumentos:(URL de conexión a la base de datos, usuario de la base de datos,contraseña)
        alumnoData = new AlumnoData(conexion); //Una vez que la conexion a la BDS esta configurada, se crea una instancia de la clase AlumnoData y se le pasa el objeto conexion.
        /*Esto permite que la instancia de AlumnoData utilice la conexión
          para realizar operaciones en la base de datos.*/
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloAlumno = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtDocumento = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jrbEstado = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jdcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jbNuevo = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jtBuscar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbMostrar = new javax.swing.JButton();

        tituloAlumno.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        tituloAlumno.setForeground(new java.awt.Color(0, 204, 153));
        tituloAlumno.setText("Alumno");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Documento:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Apellido:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Estado");

        jrbEstado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Fecha de nacimiento");

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setBackground(new java.awt.Color(255, 0, 153));
        jbSalir.setForeground(new java.awt.Color(255, 255, 255));
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jtBuscar.setText("Buscar");
        jtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBuscarActionPerformed(evt);
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
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(99, 99, 99)
                                .addComponent(jrbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(tituloAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5)
                        .addGap(8, 8, 8))
                    .addComponent(jrbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addGap(125, 125, 125))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    //(1) Boton 'Buscar Alumno' por dni
    private void jtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBuscarActionPerformed
      
        if (jtDocumento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un número de documento", "Error", JOptionPane.ERROR_MESSAGE);
           
        }
        else {
            
        try {
            int dni = Integer.parseInt(jtDocumento.getText());
            Alumno alumno = alumnoData.buscarAlumnoPorDNI(dni); // 'alumnoData' conexión + consulta a la BD
            
            if (alumno != null) { // Verificar si el alumno fue encontrado
              
                jtApellido.setText(alumno.getApellido());
                jtNombre.setText(alumno.getNombre());
                jrbEstado.setSelected(alumno.isEstado()); // retorna true o false
                
                /* Seteamos 'LocalDate' a 'Date', la fecha. */
                LocalDate fechaNacimientoLocal = alumno.getFechaNacimiento(); // Obtener LocalDate
                Date fechaNacimiento = Date.from(fechaNacimientoLocal.atStartOfDay(ZoneId.systemDefault()).toInstant()); // Convertir a Date
                jdcFechaNacimiento.setDate(fechaNacimiento); // Establecer la fecha en el JDateChooser
            } else {
                // Si no se encuentra el alumno, mostrar mensaje
                JOptionPane.showMessageDialog(this, "No se encontró un alumno con el DNI ingresado", "Error", JOptionPane.ERROR_MESSAGE);
                // Limpiar campos si no se encontró
                jtApellido.setText("");
                jtNombre.setText("");
                jrbEstado.setSelected(false);
                jdcFechaNacimiento.setDate(null);
            }
            
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(this, "Ingrese un documento válido", "Error", JOptionPane.ERROR_MESSAGE);
            jtDocumento.setText("");
        }
    }
        
    }//GEN-LAST:event_jtBuscarActionPerformed

    
    //(2) Boton 'Salir'
    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
       this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    
    //(3) Boton 'Guardar'
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // 1. Chequeamos si todos los campos estan completos.
    if(jtDocumento.getText().isEmpty() || jtApellido.getText().isEmpty() || jtNombre.getText().isEmpty() || jdcFechaNacimiento == null){
        JOptionPane.showMessageDialog(this, "Complete todos los campos", "ERROR", JOptionPane.ERROR_MESSAGE);
        jtDocumento.setText("");
        jtApellido.setText("");
        jtNombre.setText("");
        return; // Salir del método si hay un error
    }
    else{
        
        // 2. Verificamos si el alumno ya existe en la BDS
        Alumno existente = alumnoData.buscarAlumnoPorDNI(Integer.parseInt(jtDocumento.getText()));
        if (existente != null) {
           JOptionPane.showMessageDialog(this, "Ya existe un alumno con ese DNI.", "Error", JOptionPane.ERROR_MESSAGE);
           return; // Salir del método si el DNI ya existe
        }
            
        else{
        
            try {
            // Obtener datos
            int dni = Integer.parseInt(jtDocumento.getText()); 
            String apellido = jtApellido.getText();
            String nombre = jtNombre.getText();
            LocalDate fechaNacimiento = jdcFechaNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // Convertir Date a LocalDate
            boolean estado = jrbEstado.isSelected(); // Obtener el estado del radio button

            // Crear un nuevo objeto Alumno
            Alumno nuevoAlumno = new Alumno(dni, apellido, nombre, fechaNacimiento, estado);

            // Llamar al método para guardar el alumno
            alumnoData.guardarAlumno(nuevoAlumno); 

            // Limpiar campos después de guardar
            jtDocumento.setText("");
            jtApellido.setText("");
            jtNombre.setText("");
            jdcFechaNacimiento.setDate(null); // Reiniciar el JDateChooser
            jrbEstado.setSelected(true); // Volver a seleccionar el estado por defecto, si es necesario

            JOptionPane.showMessageDialog(this, "Alumno guardado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        }catch (NumberFormatException e) {
            // Manejo de error por un DNI no numérico
            JOptionPane.showMessageDialog(this, "DNI inválido. Debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE);
        }
            // Manejo de error relacionado con la base de datos
             catch (Exception e) {
            //otros errores
            JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }     
        } /*fin else*/
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    
    //(4) Boton 'Eliminar Alumno por dni' (PREGUNTAR PORQUE ENUNCIADO DICE ID)
    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
     if (jtDocumento.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Ingrese un número de documento", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        try {
           int dni = Integer.parseInt(jtDocumento.getText()); // 1. Obtengo el documento del campo 
           Alumno alumno = alumnoData.buscarAlumnoPorDNI(dni); 
            
           if (alumno != null) { // Si el alumno está registrado
            //MENSAJE de confimacion 'Eliminacion'
            int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Seguro que quieres eliminar al alumno con DNI " + dni + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

            // Verificcamos eleccion
            if (confirmacion == JOptionPane.YES_OPTION) {
                // Llamar al método para eliminar el alumno por ID
                int id = alumno.getIdAlumno(); 
                alumnoData.eliminarAlumno(id); 
                JOptionPane.showMessageDialog(this, "Alumno eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                // Limpiar campos después de eliminar
                jtApellido.setText("");
                jtNombre.setText("");
                jrbEstado.setSelected(false);
                jdcFechaNacimiento.setDate(null);
            } 
        } else {
            // Si el alumno no existe, mostrar un mensaje
            JOptionPane.showMessageDialog(this, "El alumno con DNI " + dni + " no existe", "Error", JOptionPane.ERROR_MESSAGE);
            jtDocumento.setText("");
            jtApellido.setText("");
            jtNombre.setText("");
        }
        } catch (NumberFormatException nf) {
            JOptionPane.showMessageDialog(this, "Ingrese un documento válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }   
     
         
    }//GEN-LAST:event_jbEliminarActionPerformed

    
    //(5) Boton 'Nuevo'
    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        jtDocumento.setText("");
        jtApellido.setText("");
        jtNombre.setText("");
    }//GEN-LAST:event_jbNuevoActionPerformed

    //(6) Boton 'Mostrar Lista de los Alumnos'
    private void jbMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarActionPerformed
         // Creamos el nuevo JInternalFrame (ListaAlumnos)
       ListaAlumnos listaAlumnos = new ListaAlumnos(); 

       // Añadimos el nuevo JInternalFrame al JDesktopPane
       this.getDesktopPane().add(listaAlumnos);

       // Hacemos visible el nuevo JInternalFrame y lo traemos al frente
       listaAlumnos.setVisible(true);
       listaAlumnos.moveToFront();
    }//GEN-LAST:event_jbMostrarActionPerformed

    
//(7) Boton 'Actualizar Datos del Alumno' (setId(dni)) revisar mas tarde.
    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
      // Validar campos obligatorios
    if (jtDocumento.getText().isEmpty() || jtNombre.getText().isEmpty() || jtApellido.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        
        int dni = Integer.parseInt(jtDocumento.getText()); 
        String nombre = jtNombre.getText(); 
        String apellido = jtApellido.getText(); 
        LocalDate fechaNacimiento = jdcFechaNacimiento.getDate() != null ? 
        jdcFechaNacimiento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null; // Obtener la fecha de nacimiento
        boolean estado = jrbEstado.isSelected();

       
        Alumno alumno = new Alumno(dni, apellido, nombre, fechaNacimiento, estado);
        alumno.setIdAlumno(dni);

        // Llamar al método de actualización
        alumnoData.modificarAlumno(alumno); // Método que ya tienes en AlumnoData

       // Limpiar campos después de actualizar
        jtApellido.setText("");
        jtNombre.setText("");
        jrbEstado.setSelected(false);
        jdcFechaNacimiento.setDate(null);

    } catch (NumberFormatException nf) {
        JOptionPane.showMessageDialog(this, "Ingrese un documento válido", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al actualizar el alumno: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
        
        
        
        
    }//GEN-LAST:event_jbActualizarActionPerformed

    

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbMostrar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private com.toedter.calendar.JDateChooser jdcFechaNacimiento;
    private javax.swing.JRadioButton jrbEstado;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JButton jtBuscar;
    private javax.swing.JTextField jtDocumento;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JLabel tituloAlumno;
    // End of variables declaration//GEN-END:variables
}
