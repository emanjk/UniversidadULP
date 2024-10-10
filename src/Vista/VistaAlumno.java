
package Vista;

import Entidades.Alumno;
import Persistencia.AlumnoData;
import Persistencia.Conexion;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.PreparedStatement; /*guarda codigo SQL*/
import java.sql.ResultSet; /*obtener datos o registro de un alumno*/


public class VistaAlumno extends javax.swing.JInternalFrame {
    //(1)PRIMERO:
    private AlumnoData alumnoData; // Variable para hacer: consultas, inserciones o actualizar en la BDS.
    private Conexion conexion ; // Variable conexión necesaria para interactuar con la base de datos MariaDB.
   
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

        jLabel1 = new javax.swing.JLabel();
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

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Alumno");

        jLabel2.setText("Documento:");

        jLabel3.setText("Apellido:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Estado");

        jLabel6.setText("Fecha de nacimiento");

        jbNuevo.setText("Nuevo");

        jbEliminar.setText("Eliminar");

        jbGuardar.setText("Guardar");

        jbSalir.setText("Salir");

        jtBuscar.setText("Buscar");
        jtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jbNuevo)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(jtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtDocumento, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jrbEstado)
                                    .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbEliminar)
                                .addGap(36, 36, 36)
                                .addComponent(jbGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                                .addComponent(jbSalir)
                                .addGap(25, 25, 25)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtBuscar))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jrbEstado))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jdcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo)
                    .addComponent(jbEliminar)
                    .addComponent(jbGuardar)
                    .addComponent(jbSalir))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    //(1) Boton 'Buscar Alumno' en la BD
    private void jtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBuscarActionPerformed
       if(jtDocumento.getText().isEmpty())
           JOptionPane.showMessageDialog(this, "Ingrese numero de documento ");
       else{
           try{
               int dni = Integer.parseInt(jtDocumento.getText());
               Alumno alumno = alumnoData.buscarAlumnoPorDNI(dni);
               JOptionPane.showMessageDialog(this, alumno);
           
           
           }catch(NumberFormatException nf){
               JOptionPane.showMessageDialog(this, "Ingrese un documento valido");
      
           }
       
       
       
       
       
       
       }
        
        
    }//GEN-LAST:event_jtBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private com.toedter.calendar.JDateChooser jdcFechaNacimiento;
    private javax.swing.JRadioButton jrbEstado;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JButton jtBuscar;
    private javax.swing.JTextField jtDocumento;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}
