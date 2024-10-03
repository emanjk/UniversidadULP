
package Modelo;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement ;
import java.sql.ResultSet ;

import java.sql.PreparedStatement ;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion { 
     // Atributo para la conexión
     private Connection conexion;

     
     
    //Constructor, cargamos Driver y Conexion
    
    public Conexion() {
        try {
            //(1) Cargamos el Driver 
            
            Class.forName("org.mariadb.jdbc.Driver"); //agregamos el paquete a nuestro proyecto.
           
            //(2) Conexion a nuestra base de datos
            
             conexion = DriverManager.getConnection("jdbc:mariadb://localhost:3306/universidadulp", "root","");           
            
          /*  //(3 )Agregamos un 'empleado'
            String sql = "INSERT INTO empleado (dni,apellido,nombre,acceso, estado)"
                    + "VALUES (42762255, 'Collea', 'Patricio',1, true )";
            
            PreparedStatement ps = conexion.prepareStatement(sql);
            int registros = ps.executeUpdate();
            System.out.println(registros);
         */  
            
            
        } catch (ClassNotFoundException ex) {
            
           JOptionPane.showMessageDialog(null, "Error al cargar Driver"+ ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de Conexion"+ ex.getMessage());
        }
     
    }   
    
    // Método para obtener la conexión
    public Connection getConexion() {
        return conexion;
    }
    
    
}

    
    
    

    




    

