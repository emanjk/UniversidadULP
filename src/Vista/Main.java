
package Vista;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;





public class Main {

   
    public static void main(String[] args) throws SQLException {
       
       //(1)Crear una instancia de la clase Conexion
        Conexion conexionBD = new Conexion(); //(1)Crear una instancia de la clase Conexion
        
       //(2)Obtener la conexion  
       Connection conexion = conexionBD.getConexion() ; //conexion 'tiene' la BD universidadULP
        
        
       //(3)Agregamos un alumno a la tabla 'alumno'
      
      try { 
      //(a) Definir la consulta SQL//
      String sql = "INSERT INTO alumno(dni,apellido,nombre,fechaNacimiento,estado)"
              + "VALUES (43761169, 'Ruiz', 'Sofia', '2002-03-23', true)" ;
        
      /*(b) tomamos la conexion a BD y la consulta SQL */
      PreparedStatement ps = conexion.prepareStatement(sql);
      
      /*(c) ejecutamos la consulta*/
      int registro = ps.executeUpdate();
      }catch (SQLException ex){
          JOptionPane.showMessageDialog(null, "Error al insertar los datos" + ex.getMessage());
      
      }  
      
      
    }
    
}
