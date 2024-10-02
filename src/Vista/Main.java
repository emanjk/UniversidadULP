
package Vista;

import Modelo.Conexion;
import org.mariadb.jdbc.Connection;




public class Main {

   
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Connection conn = (Connection) conexion.getConnection();

        // Aquí puedes realizar operaciones en la base de datos utilizando 'conn'

        // No olvides cerrar la conexión al final
        conexion.cerrarConexion();
       
        
        
    }
    
}
