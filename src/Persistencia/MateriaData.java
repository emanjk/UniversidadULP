
package Persistencia;
import Entidades.Materia ; //1. importamos la clase 'Materia'.

// paquetes para JDBC para interactuar con la BDS.
import java.sql.Connection ;  // 2. importamos la clase 'Connection' para hacer la conexion a la bd 'universidadulp'.
import java.sql.PreparedStatement ; // 3. Permite ejecutar consultas SQL.
import java.sql.ResultSet; // 4. Contiene o Guarda los resultados obtenidos atraves de PreparedStatement. 
import java.sql.SQLException; //5 Clase para manejar errores con operaciones SQL.

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;


public class MateriaData {
    //(1) 'con' almacena una conexion a una base de datos.
    private Connection con = null;

    
    //(2) Constructor donde recibimos la conexion a la bd
    public MateriaData(Conexion conexion) {
        this.con = conexion.buscarConexion(); //a 'MariaDB'
   
    }
    
    
             //Metodos para consultar en la BDS-universidadulp, tabla: materia
   
    
    //(1) Guardar materia
    public void guardarMateria(Materia materia){
         String sql = "INSERT INTO materia (nombre, anioMateria, activo) VALUES (?, ?, ?)"; // Consulta SQL para insertar una materia

    try {
        PreparedStatement ps = con.prepareStatement(sql); // Preparar la consulta

        // Establecer los valores del PreparedStatement
        ps.setString(1, materia.getNombre()); // Nombre de la materia
        ps.setInt(2, materia.getAnioMateria()); // Año de la materia
        ps.setBoolean(3, materia.isActivo()); // Estado (activo/inactivo)

        ps.executeUpdate(); // Ejecutar la inserción
        System.out.println("Materia guardada con éxito");

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al guardar la materia: " + ex.getMessage());
    }
    
    
    
    }
  
    
    //(2) Buscar materia por id
    public Materia buscarMateria(int id){
        Materia materia = null; // Inicializamos el objeto Materia como null
    String sql = "SELECT * FROM materia WHERE idMateria = ?"; // Consulta SQL para buscar una materia por ID

    try {
        PreparedStatement ps = con.prepareStatement(sql); // Preparar la consulta
        ps.setInt(1, id); // Establecer el parámetro ID

        ResultSet resultSet = ps.executeQuery(); // Ejecutar la consulta

        // Si se encuentra una materia con el ID dado
        if (resultSet.next()) {
            materia = new Materia(
                resultSet.getInt("idMateria"),
                resultSet.getString("nombre"),
                resultSet.getInt("anioMateria"),
                resultSet.getBoolean("activo")
            );
        } else {
            System.out.println("No se encontró ninguna materia con ID: " + id);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener la materia: " + ex.getMessage());
    }

    return materia;
    
    
        
        
        
    
    }   
    
    
    //(3) Modificar materia
    public void modificarMateria(Materia materia){
        String sql = "UPDATE materia SET nombre = ?, anioMateria = ?, activo = ? WHERE idMateria = ?"; // Consulta SQL para actualizar materia

    try {
        PreparedStatement ps = con.prepareStatement(sql); // Preparar la consulta

        // Establecer los valores del PreparedStatement
        ps.setString(1, materia.getNombre()); // Nombre de la materia
        ps.setInt(2, materia.getAnioMateria()); // Año de la materia
        ps.setBoolean(3, materia.isActivo()); // Estado (activo/inactivo)
        ps.setInt(4, materia.getIdMateria()); // ID de la materia a modificar

        ps.executeUpdate(); // Ejecutar la actualización
        System.out.println("Materia modificada con éxito");

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al modificar la materia: " + ex.getMessage());
    }
    
    }
    
    
    //(4) Eliminar una materia por id
    public void eliminarMateria(int id){
        String sql = "DELETE FROM materia WHERE idMateria = ?"; // Consulta SQL para eliminar materia

        try {
            PreparedStatement ps = con.prepareStatement(sql); // Preparar la consulta
            ps.setInt(1, id); // Establecer el ID de la materia a eliminar

            ps.executeUpdate(); // Ejecutar la eliminación
            System.out.println("Materia eliminada con éxito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la materia: " + ex.getMessage());
        }
    
    }
    
    
    //(5) Listar todas las materias
    public List<Materia> listarMaterias(){
        List<Materia> materias = new ArrayList<>(); // Lista para almacenar las materias
        String sql = "SELECT * FROM materia"; // Consulta SQL para listar todas las materias

        try {
            PreparedStatement ps = con.prepareStatement(sql); // Preparar la consulta
            ResultSet resultSet = ps.executeQuery(); // Ejecutar la consulta

            // Recorrer el ResultSet y agregar las materias a la lista
            while (resultSet.next()) {
                Materia materia = new Materia(
                    resultSet.getInt("idMateria"),
                    resultSet.getString("nombre"),
                    resultSet.getInt("anioMateria"),
                    resultSet.getBoolean("activo")
                );
                materias.add(materia); // Agregar materia a la lista
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las materias: " + ex.getMessage());
        }

        return materias; 

    }

    
}
