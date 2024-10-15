
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

public class VistaListarInscripciones extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = new DefaultTableModel(); // (2).
    private Conexion conexion ; // Variable conexión necesaria para interactuar con la base de datos MariaDB.
    private AlumnoData alumnoData; // Variable para hacer: consultas, inserciones o actualizar en la BDS-universidadulp.
    private MateriaData materiaData;// Variable para hacer: consultas, inserciones o actualizar en la BDS-universidadulp.
    private InscripcionData inscripcionData;
    
    public VistaListarInscripciones() {
        initComponents();
        conexion = new Conexion("jdbc:mariadb://localhost:3306/universidadulp", "root", "");//nueva instancia y con argumentos:(URL de conexión a la base de datos, usuario de la base de datos,contraseña)
        alumnoData = new AlumnoData(conexion); //Una vez que la conexion a la BDS esta configurada, se crea una instancia de la clase AlumnoData y se le pasa el objeto conexion.
        materiaData = new MateriaData(conexion);//Una vez que la conexion a la BDS esta configurada, se crea una instancia de la clase MateriaData y se le pasa el objeto conexion.
        inscripcionData = new InscripcionData (conexion);
        armarCabecera();
        cargaCombo ();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbMateria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtConsultaAlumno = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listado de Alumnos por Materia");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Seleccione una materia:");

        jcbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMateriaActionPerformed(evt);
            }
        });

        jtConsultaAlumno.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtConsultaAlumno);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salir");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(62, 62, 62)
                                .addComponent(jcbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // 2. Cuando selecciono el 'jcbMateria'
    private void jcbMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMateriaActionPerformed
       if (jcbMateria.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Seleccione una materia", "Error", JOptionPane.ERROR_MESSAGE);
        return;      
    }

    // Obtener la materia seleccionada
    Materia materiaSeleccionada = (Materia) jcbMateria.getSelectedItem();
    int idMateria = materiaSeleccionada.getIdMateria(); // Asegúrate de que la clase Materia tenga un método getIdMateria()

    // Limpiar la tabla antes de cargar nuevos datos
    DefaultTableModel model = (DefaultTableModel) jtConsultaAlumno.getModel();
    model.setRowCount(0); // Limpia las filas de la tabla

    // Obtener los alumnos inscritos en la materia seleccionada
    List<Alumno> alumnos = inscripcionData.obtenerAlumnosXMateria(idMateria);

    // Llenar la tabla con los datos de los alumnos
    for (Alumno alumno : alumnos) {
        model.addRow(new Object[]{
            alumno.getIdAlumno(), // ID
            alumno.getDni(), // DNI
            alumno.getApellido(), // Apellido
            alumno.getNombre() // Nombre
        });
    }
      
      
    }//GEN-LAST:event_jcbMateriaActionPerformed

    private void armarCabecera(){
        modelo.addColumn("ID");
        modelo.addColumn("DNI");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");

        jtConsultaAlumno.setModel(modelo);
        jtConsultaAlumno.getTableHeader().setReorderingAllowed(false); /*que no pueda mover las columnas*/
        
    }
 
  private void cargaCombo (){
     jcbMateria.removeAllItems();
     jcbMateria.addItem(null); 
     ArrayList <Materia> materias =  (ArrayList <Materia>) materiaData.listarMaterias(); 
     for(Materia mat: materias){
         jcbMateria.addItem(mat);
     
     }
  }
     
     
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Materia> jcbMateria;
    private javax.swing.JTable jtConsultaAlumno;
    // End of variables declaration//GEN-END:variables
}
