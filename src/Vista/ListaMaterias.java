
package Vista;
import Modelo.Materia;
/*materiaData y Conexion*/
import  Persistencia.MateriaData;
import Modelo.Conexion;
/*Importamos las clases de la API de JDBC*/
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.Conexion;



import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel; // (1).modelo-tabla


public class ListaMaterias extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo= new DefaultTableModel ();
    
    private Conexion conexion ; //Variable que tendra la ruta a la BD 'universidadulp'.
    private MateriaData materiaData; //variable para hacer operaciones CRUD a la BDS.
    
    
    public ListaMaterias() {
        initComponents();
        armarCabecera();
        conexion = new Conexion ("jdbc:mariadb://localhost:3306/universidadulp", "root", "");
        materiaData = new MateriaData (conexion);
        cargarDatos();
        
       
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMaterias = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 0));
        jLabel1.setText("Materias Registradas");

        jtMaterias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtMaterias);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(148, 148, 148)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtMaterias;
    // End of variables declaration//GEN-END:variables



//1. Armar cabecera de la tabla Materias
     private void armarCabecera(){
         modelo.addColumn("Codigo");
         modelo.addColumn("Nombre");
         modelo.addColumn("Año de Materia");
         modelo.addColumn("Estado");
         
         jtMaterias.setModel(modelo);
         jtMaterias.getTableHeader().setReorderingAllowed(false); /*que no pueda mover las columnas*/
     
     }


     private void cargarDatos(){
         
         modelo.setRowCount(0); //Limpiamos la tabla modelo antes de cargar los datos
         MateriaData materiaData = new MateriaData (conexion);
         List<Materia> materias = materiaData.listarMaterias();
     
         //Recorremos la lista de materias y lo agregamos a la List 'materias'
          for (Materia m : materias) {
            modelo.addRow(new Object[]{
                m.getIdMateria(),
                m.getNombre(),
                m.getAnioMateria(),
                m.getEstado(),
              
            });
        }
     }
     
     
     
     
}
