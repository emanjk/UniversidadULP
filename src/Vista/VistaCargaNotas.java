
package Vista;

import Modelo.Alumno;
import Modelo.Conexion;
import Modelo.Materia;
import Persistencia.AlumnoData;
import Persistencia.InscripcionData;
import Persistencia.MateriaData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VistaCargaNotas extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = new DefaultTableModel(); // (2).
    private Conexion conexion ; // Variable conexión necesaria para interactuar con la base de datos MariaDB.
    private AlumnoData alumnoData; // Variable para hacer: consultas, inserciones o actualizar en la BDS-universidadulp.
    private MateriaData materiaData ;
    private InscripcionData inscripcionData;
    
    public VistaCargaNotas() {
        initComponents();
        conexion = new Conexion("jdbc:mariadb://localhost:3306/universidadulp", "root", "");//nueva instancia y con argumentos:(URL de conexión a la base de datos, usuario de la base de datos,contraseña)
        alumnoData = new AlumnoData(conexion); //Una vez que la conexion a la BDS esta configurada, se crea una instancia de la clase AlumnoData y se le pasa el objeto conexion.
        materiaData = new MateriaData (conexion);
        inscripcionData = new InscripcionData (conexion);
        armarCabecera();
        cargaCombo ();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCargaNotas = new javax.swing.JTable();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Carga de Notas");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Seleccione un alumno:");

        jcbAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnoActionPerformed(evt);
            }
        });

        jtCargaNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtCargaNotas);
        if (jtCargaNotas.getColumnModel().getColumnCount() > 0) {
            jtCargaNotas.getColumnModel().getColumn(3).setResizable(false);
        }

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // 1. Boton 'Guardar'
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        // Verifica que haya filas en la tabla
    if (modelo.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "No hay materias para guardar.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Obtiene el ID del alumno seleccionado
    Alumno alumnoSeleccionado = (Alumno) jcbAlumno.getSelectedItem();
    if (alumnoSeleccionado == null) {
        JOptionPane.showMessageDialog(this, "Seleccione un alumno.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int idAlumno = alumnoSeleccionado.getIdAlumno(); // ID del alumno

    // Itera sobre las filas de la tabla para actualizar las notas
    for (int i = 0; i < modelo.getRowCount(); i++) {
        int idMateria = (int) modelo.getValueAt(i, 0); // ID de la materia (código)
        Object notaObj = modelo.getValueAt(i, 2); 
        
        if (notaObj == null || notaObj.toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La nota no puede estar vacía en la fila " + (i + 1), "Error", JOptionPane.ERROR_MESSAGE);
            continue; // Salta a la siguiente iteración
        }
        
        String notaString = notaObj.toString().trim(); 
        try {
            double nota = Double.parseDouble(notaString); // Convierte a Double
            // Llama al método para actualizar la nota
            inscripcionData.actualizarNota(idAlumno, idMateria, nota);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La nota debe ser un número válido en la fila " + (i + 1), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_jbGuardarActionPerformed

    // 2. Boton 'Salir'
    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
       this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    
    // 3. Cuando selecciono un alumno del 'jcbAlumno'
    private void jcbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnoActionPerformed
        // Verificar que hay un alumno seleccionado
        if (jcbAlumno.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un alumno.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Alumno alumnoSeleccionado = (Alumno) jcbAlumno.getSelectedItem();
        List<Materia> materiasCursadas = inscripcionData.obtenerMateriasCursadas(alumnoSeleccionado.getIdAlumno());

        // Cargar los datos en la tabla
        cargarNotasEnTabla(materiasCursadas);

        
        
        
    }//GEN-LAST:event_jcbAlumnoActionPerformed

   
    
    
   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcbAlumno;
    private javax.swing.JTable jtCargaNotas;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera(){
        
         // MODIFICAMOS LA EDICION DE LAS PRIMERAS DOS COLUMNAS.
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Solo permite la edición en la columna de "Nota"
                return column == 2; // 2 es el índice de la columna "Nota"
            }
            
       
        };
        
        
    
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Nota");

        jtCargaNotas.setModel(modelo);
        jtCargaNotas.getTableHeader().setReorderingAllowed(false); /*que no pueda mover las columnas*/
        
    }

    private void cargaCombo (){
        jcbAlumno.removeAllItems();
        jcbAlumno.addItem(null); 
         ArrayList <Alumno> alumnos =  (ArrayList <Alumno>) alumnoData.listarAlumnos();

         for(Alumno alu: alumnos){
             jcbAlumno.addItem(alu);

        }
    }

    private void cargarNotasEnTabla(List<Materia> materiasCursadas) {
    // Limpiar la tabla antes de cargar nuevos datos
    modelo.setRowCount(0); // Limpiar las filas de la tabla

    // Llenar la tabla con las materias cursadas
    for (Materia materia : materiasCursadas) {
        Object[] fila = new Object[3]; // Suponiendo que la tabla tiene 3 columnas: ID, Nombre y Nota
        fila[0] = materia.getIdMateria(); // ID de la materia
        fila[1] = materia.getNombre();     // Nombre de la materia
        fila[2] = ""; // Puedes dejar la nota vacía por ahora

        modelo.addRow(fila); // Añadir la fila a la tabla
    }

    // Asignar el modelo a la tabla
    jtCargaNotas.setModel(modelo);
}


}

