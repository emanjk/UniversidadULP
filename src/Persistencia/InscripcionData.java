
package Persistencia;
import Modelo.Conexion;
import Modelo.Alumno;
import Modelo.Materia;
/*clases de la API JDBC*/
import java.sql.Connection; //2. Conexion a bd 'universidadulp
import java.sql.PreparedStatement; //3. 'Declaracion preparada', permite ejecutar consultas SQL
import java.sql.ResultSet; //4. Contiene o Guarda los resultados de la consulta SQL ejecutada por PreparedStatement o Statement
import java.sql.SQLException; // 5. Clase para manejar errores relacionados a operaciones con SQL.
import java.sql.Date;

import java.util.ArrayList;
import java.time.LocalDate;

import java.util.List;
import javax.swing.JOptionPane;


public class InscripcionData {
    // 1.
    private Connection con = null ;
    private AlumnoData aluData= null;
    private MateriaData mateData = null ;
    
    // 2.

    public InscripcionData(Conexion conexion) {
        this.con = conexion.buscarConexion();
        
    }
    
    // 3.
    
    
    
    
    
    
    
    
    
    
}
