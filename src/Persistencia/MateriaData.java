
package Persistencia;
import Modelo.Conexion;
import Modelo.Materia ; //1. importamos la clase 'Materia'.

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
     String sql = "INSERT INTO materia (id_Materia, nombre, anio, estado) VALUES (?, ?, ?, ?)"; // Consulta SQL para insertar una materia

    try {
        PreparedStatement ps = con.prepareStatement(sql); // Preparar la consulta

        // Establecer los valores del PreparedStatement
        ps.setInt(1, materia.getIdMateria());
        ps.setString(2, materia.getNombre()); // Nombre de la materia
        ps.setInt(3, materia.getAnioMateria()); // Año de la materia
        ps.setBoolean(4, materia.getEstado()); // Estado (activo/inactivo)

        ps.executeUpdate(); // Ejecutar la inserción
        System.out.println("Materia guardada con éxito");

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al guardar la materia: " + ex.getMessage());
    }
    
    }
  
    
    //(2) Buscar materia por id
    public Materia buscarMateria(int id){
        Materia materia = null; // Inicializamos el objeto Materia como null
        String sql = "SELECT * FROM materia WHERE id_Materia=?"; // Consulta SQL para buscar una materia por ID

    try {
        PreparedStatement ps = con.prepareStatement(sql); // Preparar la consulta
        ps.setInt(1, id); // 'id_Materia=?' el ?==id

        ResultSet resultSet = ps.executeQuery(); // Ejecutar la consulta

        // Si se encuentra una materia con el ID dado
        if (resultSet.next()) {
            materia = new Materia(
                resultSet.getInt("id_Materia"),
                resultSet.getString("nombre"),
                resultSet.getInt("anio"),
                resultSet.getBoolean("estado")
            );
        } else {
            System.out.println("No se encontró ninguna materia con ID: " + id);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener la materia: " + ex.getMessage());
    }

    return materia;
  
    }   
    
    //(3) Buscar materia por nombre (Agregado)
    public Materia buscarMateriaPorNombre(String nombre) {
    Materia materia = null; // Inicializamos el objeto Materia como null
    String sql = "SELECT * FROM materia WHERE nombre=?"; // Consulta SQL para buscar una materia por nombre

    try {
        PreparedStatement ps = con.prepareStatement(sql); // Preparar la consulta
        ps.setString(1, nombre); // 'nombre=?' el ?==nombre

        ResultSet resultSet = ps.executeQuery(); // Ejecutar la consulta

        // Si se encuentra una materia con el nombre dado
        if (resultSet.next()) {
            materia = new Materia(
                resultSet.getInt("id_Materia"),
                resultSet.getString("nombre"),
                resultSet.getInt("anio"),
                resultSet.getBoolean("estado")
            );
        } else {
            System.out.println("No se encontró ninguna materia con nombre: " + nombre);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener la materia: " + ex.getMessage());
    }

    return materia;
}
    
    
    //(4) Modificar materia
    public void modificarMateria(Materia materia){
        String sql = "UPDATE materia SET nombre = ?, anio = ?, estado = ? WHERE id_Materia = ?"; // Consulta SQL para actualizar materia

    try {
        PreparedStatement ps = con.prepareStatement(sql); // Preparar la consulta

        // Establecer los valores del PreparedStatement
        ps.setString(1, materia.getNombre()); // Nombre de la materia
        ps.setInt(2, materia.getAnioMateria()); // Año de la materia
        ps.setBoolean(3, materia.getEstado()); // Estado (activo/inactivo)
        ps.setInt(4, materia.getIdMateria()); // ID de la materia a modificar

        ps.executeUpdate(); // Ejecutar la actualización
        System.out.println("Materia modificada con éxito");

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al modificar la materia: " + ex.getMessage());
    }
    
    }
    
    
    //(5) Eliminar una materia por id
    public void eliminarMateria(int id){
        String sql = "DELETE FROM materia WHERE id_Materia = ?"; // Consulta SQL para eliminar materia

        try {
            PreparedStatement ps = con.prepareStatement(sql); // Preparar la consulta
            ps.setInt(1, id); // Establecer el ID de la materia a eliminar

            ps.executeUpdate(); // Ejecutar la eliminación
            System.out.println("Materia eliminada con éxito");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la materia: " + ex.getMessage());
        }
    
    }
    
    
    //(6) Listar todas las materias
    public List<Materia> listarMaterias(){
        List<Materia> materias = new ArrayList<>(); // Lista para almacenar las materias
        String sql = "SELECT * FROM materia"; // Consulta SQL para listar todas las materias

        try {
            PreparedStatement ps = con.prepareStatement(sql); // Preparar la consulta
            ResultSet resultSet = ps.executeQuery(); // Ejecutar la consulta

            // Recorrer el ResultSet y agregar las materias a la lista
            while (resultSet.next()) {
                Materia materia = new Materia(
                    resultSet.getInt("id_Materia"),
                    resultSet.getString("nombre"),
                    resultSet.getInt("anio"),
                    resultSet.getBoolean("estado")
                );
                materias.add(materia); // Agregar materia a la lista
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las materias: " + ex.getMessage());
        }

        return materias; 

    }

    
    //(7) Alta logica
    public void altaLogica(Materia materia) throws SQLException {
        String sql = "UPDATE materia SET estado = ? WHERE id_Materia = ?"; // El campo correcto es id_Materia

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, true); // Estado 'true' indica alta lógica
            ps.setInt(2, materia.getIdMateria());

            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("La materia ha sido dada de alta lógicamente.");
            } else {
                System.out.println("No se encontró la materia.");
            }
        } catch (SQLException e) {
            System.out.println("Error al dar de alta la materia: " + e.getMessage());
        }
}
    
    
    //(8) Baja logica
    public void bajaLogica(Materia materia) throws SQLException {
        String sql = "UPDATE materia SET estado = ? WHERE id_Materia = ?"; // El campo correcto es id_Materia

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, false); // Estado 'false' indica baja lógica
            ps.setInt(2, materia.getIdMateria());

            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("La materia ha sido dada de baja lógicamente.");
            } else {
                System.out.println("No se encontró la materia.");
            }
        } catch (SQLException e) {
            System.out.println("Error al dar de baja la materia: " + e.getMessage());
        }
    }

    
    
    
}
