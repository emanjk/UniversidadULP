
package Vista;

import Modelo.Alumno;
import Persistencia.AlumnoData;
import Modelo.Conexion;
/*importamos las clases de la API JDBC*/
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.Conexion;
import Modelo.Inscripcion;
import Modelo.Materia;
import Persistencia.InscripcionData;
import Persistencia.MateriaData;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane ;
import javax.swing.table.DefaultTableModel; // (1).modelo-tabla


public class VistaInscripcion extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = new DefaultTableModel(); // (2).
    private Conexion conexion ; // Variable conexión necesaria para interactuar con la base de datos MariaDB.
    private AlumnoData alumnoData; // Variable para hacer: consultas, inserciones o actualizar en la BDS-universidadulp.
    private MateriaData materiaData ;
    private InscripcionData inscripcionData;
    
    public VistaInscripcion() {
        initComponents();
        conexion = new Conexion("jdbc:mariadb://localhost:3306/universidadulp", "root", "");//nueva instancia y con argumentos:(URL de conexión a la base de datos, usuario de la base de datos,contraseña)
        alumnoData = new AlumnoData(conexion); //Una vez que la conexion a la BDS esta configurada, se crea una instancia de la clase AlumnoData y se le pasa el objeto conexion.
        inscripcionData = new InscripcionData (conexion);
        
        armarCabecera();
        cargaCombo ();
      
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbAlumno = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jrbMateInscriptas = new javax.swing.JRadioButton();
        jrbMateNoInscriptas = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtInscripcion = new javax.swing.JTable();
        jbInscribir = new javax.swing.JButton();
        jbAnularInscripcion = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 0));
        jLabel1.setText("Formulario de Inscripcion");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Seleccione un alumno: ");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Listado de materias");

        jrbMateInscriptas.setText("Materias inscriptas");
        jrbMateInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMateInscriptasActionPerformed(evt);
            }
        });

        jrbMateNoInscriptas.setText("Materias no inscriptas");
        jrbMateNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbMateNoInscriptasActionPerformed(evt);
            }
        });

        jtInscripcion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtInscripcion);

        jbInscribir.setText("Inscribir");
        jbInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInscribirActionPerformed(evt);
            }
        });

        jbAnularInscripcion.setText("Anular Inscripcion");
        jbAnularInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnularInscripcionActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jrbMateInscriptas)
                        .addGap(72, 72, 72)
                        .addComponent(jrbMateNoInscriptas))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(93, 93, 93))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jbInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbAnularInscripcion)
                .addGap(76, 76, 76)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbMateInscriptas)
                    .addComponent(jrbMateNoInscriptas))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAnularInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // 1. Boton 'Salir'
    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
       this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    
    // 2. Radio Button, 'Materias Inscriptas'
    private void jrbMateInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMateInscriptasActionPerformed
       if (jrbMateInscriptas.isSelected()) {
        jrbMateNoInscriptas.setSelected(false);
       }
    
    // Verificamos si hay un alumno seleccionado en el combo
    if (jcbAlumno.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Selecciona un alumno.");
        jrbMateInscriptas.setSelected(false);
        return; 
        
    } else {
        // Obtenemos el alumno seleccionado
        Alumno alumnoSeleccionado = (Alumno) jcbAlumno.getSelectedItem();
        
        // Obtenemos las inscripciones del alumno seleccionado
        List<Inscripcion> inscripciones = inscripcionData.obtenerInscripcionesPorAlumno(alumnoSeleccionado.getIdAlumno());

        // Limpiamos la tabla antes de cargar nuevos datos
        DefaultTableModel modelo = (DefaultTableModel) jtInscripcion.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        // Llenamos la tabla con las materias inscriptas
        for (Inscripcion inscripcion : inscripciones) {
            Object[] row = new Object[3]; 
            row[0] = inscripcion.getMateria().getIdMateria(); // ID de la Materia
            row[1] = inscripcion.getMateria().getNombre(); // Nombre de la Materia
            row[2] = inscripcion.getMateria().getAnioMateria(); // Año de la Materia
            modelo.addRow(row); // Agregar fila a la tabla
        }
    }
      
      
      
      
      
    }//GEN-LAST:event_jrbMateInscriptasActionPerformed

    
    // 3. Radio Button, 'Materias NO Inscriptas'
    private void jrbMateNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbMateNoInscriptasActionPerformed
       
        if (jrbMateNoInscriptas.isSelected()) {
            jrbMateInscriptas.setSelected(false);
        }

        // Verificar si hay un alumno seleccionado en el JComboBox
        if (jcbAlumno.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecciona un alumno.");
            jrbMateNoInscriptas.setSelected(false);
            return; // Salir si no hay alumno seleccionado
        }
        else{

        Alumno alumnoSeleccionado = (Alumno) jcbAlumno.getSelectedItem();
        List<Materia> materiasNoCursadas = inscripcionData.obtenerMateriasNoCursadas(alumnoSeleccionado.getIdAlumno());

        DefaultTableModel modelo = (DefaultTableModel) jtInscripcion.getModel();
        modelo.setRowCount(0); // Eliminar todas las filas actuales
        // Cargar los datos en la tabla
        for (Materia materia : materiasNoCursadas) {
            modelo.addRow(new Object[]{
                materia.getIdMateria(), // ID de la materia
                materia.getNombre(),     // Nombre de la materia
                materia.getAnioMateria(),// Año de la materia
                materia.getEstado()
            });
        }
    
        }
    }//GEN-LAST:event_jrbMateNoInscriptasActionPerformed

    
    
    // 4. Boton 'Anular Inscripcion'
    private void jbAnularInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnularInscripcionActionPerformed
          // Verificar que hay un alumno seleccionado
    if (jcbAlumno.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Seleccione un alumno.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Obtener el índice de la fila seleccionada en la tabla
    int filaSeleccionada = jtInscripcion.getSelectedRow();
    
    // Verificar si se seleccionó alguna fila
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione una inscripción en la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Obtener el ID de la materia de la fila seleccionada
    int idMateria = (int) jtInscripcion.getValueAt(filaSeleccionada, 0); // Suponiendo que el ID de la materia está en la primera columna

    // Obtener el alumno seleccionado
    Alumno alumnoSeleccionado = (Alumno) jcbAlumno.getSelectedItem();

    // Crear una instancia de InscripcionData
    InscripcionData inscripcionData = new InscripcionData(conexion); 

    // Llamar al método para borrar la inscripción
    inscripcionData.borrarInscripcionMateriaAlumno(alumnoSeleccionado.getIdAlumno(), idMateria);
    
    cargarInscripciones();
    }//GEN-LAST:event_jbAnularInscripcionActionPerformed

    
    // 5. Boton 'Inscribir a una materia'
    private void jbInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInscribirActionPerformed
       // Verificar que hay un alumno seleccionado
    if (jcbAlumno.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Seleccione un alumno.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Verificar que el radio button de "Materias No Inscriptas" esté seleccionado
    if (!jrbMateNoInscriptas.isSelected()) {
        JOptionPane.showMessageDialog(this, "Seleccione 'Materias No Inscriptas' para inscribir.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int filaSeleccionada = jtInscripcion.getSelectedRow();
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione una materia para inscribir en la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Obtener el ID de la materia de la fila seleccionada
    int idMateria = (int) jtInscripcion.getValueAt(filaSeleccionada, 0); 

    // Obtener el alumno seleccionado
    Alumno alumnoSeleccionado = (Alumno) jcbAlumno.getSelectedItem();
    
    // Obtener la materia seleccionada (crear una instancia de Materia con el ID seleccionado)
    Materia materiaSeleccionada = new Materia();
    materiaSeleccionada.setIdMateria(idMateria);

    // Crear una nueva inscripción con el alumno y la materia seleccionada
    Inscripcion nuevaInscripcion = new Inscripcion();
    nuevaInscripcion.setAlumno(alumnoSeleccionado);
    nuevaInscripcion.setMateria(materiaSeleccionada);
    nuevaInscripcion.setNota(0); 
    
    InscripcionData inscripcionData = new InscripcionData(conexion); 

    // Llamar al método para guardar la inscripción
    inscripcionData.guardarInscripcion(nuevaInscripcion);
    
    jrbMateNoInscriptas.setSelected(false);
    cargarInscripciones();
    }//GEN-LAST:event_jbInscribirActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbAnularInscripcion;
    private javax.swing.JButton jbInscribir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcbAlumno;
    private javax.swing.JRadioButton jrbMateInscriptas;
    private javax.swing.JRadioButton jrbMateNoInscriptas;
    private javax.swing.JTable jtInscripcion;
    // End of variables declaration//GEN-END:variables

 private void armarCabecera(){
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
        
        jtInscripcion.setModel(modelo);
        jtInscripcion.getTableHeader().setReorderingAllowed(false); /*que no pueda mover las columnas*/
        
 }
 
private void cargaCombo (){ 
    
    jcbAlumno.removeAllItems();
    jcbAlumno.addItem(null); 
    // Obtener la lista de alumnos
    ArrayList<Alumno> alumnos = (ArrayList<Alumno>) alumnoData.listarAlumnos();
    for (Alumno alu : alumnos) {
        jcbAlumno.addItem(alu); // Asegúrate de que la clase Alumno tenga un método toString() adecuado
    }
             
  
  
  
  }
  
public void cargarInscripciones() {
   
    if (jcbAlumno.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Seleccione un alumno para ver sus inscripciones.");
        return;
    }
    Alumno alumnoSeleccionado = (Alumno) jcbAlumno.getSelectedItem();
    List<Inscripcion> inscripciones = inscripcionData.obtenerInscripcionesPorAlumno(alumnoSeleccionado.getIdAlumno());
    DefaultTableModel modelo = (DefaultTableModel) jtInscripcion.getModel();
    modelo.setRowCount(0); // Limpia las filas actuales de la tabla

    // Llenar la tabla con las inscripciones del alumno
    for (Inscripcion inscripcion : inscripciones) {
        Object[] fila = new Object[3]; 
        fila[0] = inscripcion.getMateria().getIdMateria(); // ID de la materia
        fila[1] = inscripcion.getMateria().getNombre(); // Nombre de la materia
        fila[2] = inscripcion.getMateria().getAnioMateria(); // Año de la materia
        modelo.addRow(fila); // Agregar fila a la tabla
    }
}

  
}





