
package Vista;
import Entidades.Alumno;
/*AlumnoDate y Conexion*/
import Persistencia.AlumnoData;
import Persistencia.Conexion;
/*importamos las clases de la API JDBC*/
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Persistencia.Conexion;



import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel; // (1).modelo-tabla



public class ListaAlumnos extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo = new DefaultTableModel(); // (2).
    
    private Conexion conexion ; // Variable conexión necesaria para interactuar con la base de datos MariaDB.
    private AlumnoData alumnoData; // Variable para hacer: consultas, inserciones o actualizar en la BDS-universidadulp.
    
    public ListaAlumnos() {
        initComponents();
        armarCabecera();
        conexion = new Conexion("jdbc:mariadb://localhost:3306/universidadulp", "root", "");//nueva instancia y con argumentos:(URL de conexión a la base de datos, usuario de la base de datos,contraseña)
        alumnoData = new AlumnoData(conexion); //Una vez que la conexion a la BDS esta configurada, se crea una instancia de la clase AlumnoData y se le pasa el objeto conexion.
        cargarDatos();
      
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAlumnos = new javax.swing.JTable();
        jbSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("Alumnos Registrados");

        jtAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtAlumnos);

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
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
       this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbSalir;
    private javax.swing.JTable jtAlumnos;
    // End of variables declaration//GEN-END:variables

//(3).
    
    private void armarCabecera(){
        modelo.addColumn("id");
        modelo.addColumn("DNI");
        modelo.addColumn("Apellido");
        modelo.addColumn("Nombre");
        modelo.addColumn("Fecha de Nacimiento");
        modelo.addColumn("Estado"); 
        
        jtAlumnos.setModel(modelo);
        jtAlumnos.getTableHeader().setReorderingAllowed(false); /*que no pueda mover las columnas*/
        
    }

    private void cargarDatos(){
     
        modelo.setRowCount(0); // Limpiamos el modelo antes de cargar nuevos datos
        AlumnoData alumnoData = new AlumnoData(conexion); // Asegúrate de que 'conexion' es tu objeto de conexión  
        List<Alumno> alumnos = alumnoData.listarAlumnos();
        // Recorremos la lista de alumnos y los agregamos al modelo
        for (Alumno a : alumnos) {
            modelo.addRow(new Object[]{
                a.getIdAlumno(), // Suponiendo que tienes el método getIdAlumno en tu clase Alumno
                a.getDni(),
                a.getApellido(),
                a.getNombre(),
                a.getFechaNacimiento(),
                a.isEstado()
            });
        }
    }
    
    
}