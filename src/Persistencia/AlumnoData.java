
package Persistencia;
import Entidades.Alumno; // 1. Importamos la clase Alumno
import java.sql.Connection; //2. Conexion a bd 'universidadulp
import java.sql.PreparedStatement; //3. 'Declaracion preparada', permite ejecutar consultas SQL
import java.sql.ResultSet; //4. Contiene o Guarda los resultados de la consulta SQL ejecutada por PreparedStatement o Statement
import java.sql.SQLException; // 5. Clase para manejar errores relacionados a operaciones con SQL.
import java.sql.Date;

import java.util.ArrayList;
import java.time.LocalDate;

import java.util.List;
import javax.swing.JOptionPane;



public class AlumnoData {
    //(1) 'con' almacena la conexion a la bd
    private Connection con=null ;

 
    //(2) constructor que recibe la conexion
    public AlumnoData(Conexion conexion) {   
        this.con = conexion.buscarConexion();           
    }
       
    
            //Metodos para consultar la BDS-universidadulp, tabla: alumno
    
    
    // (1) Guardar Alumno
    public void guardarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";

    try {
        PreparedStatement ps = con.prepareStatement(sql); /*tiene la conexion a la bd 'universidadulp y la consulta SQL*/

        //obtenemos los datos de la bd
        ps.setInt(1, alumno.getDni()); /*en bd getDNI esta en int*/
        ps.setString(2, alumno.getApellido()); 
        ps.setString(3, alumno.getNombre());   
        // Convertir java.sql.Date a LocalDate
        ps.setDate(4, java.sql.Date.valueOf(alumno.getFechaNacimiento())); // Aquí es donde se realiza la conversión
        ps.setBoolean(5, alumno.isEstado());

        ps.executeUpdate();
        System.out.println("Alumno guardado con éxito");
        
    }
    
    catch (SQLException ex) {
        ex.printStackTrace();  /*me impreme con mas deetalles la excepetion*/
        JOptionPane.showMessageDialog(null, "Error al guardar el alumno: " + ex.getMessage());
    }
           
    }
    
    //(2) Buscar Alumno por id
    public Alumno buscarAlumnoPorId(int id) {
        Alumno alumno = null;  // Inicializamos el objeto Alumno como null
        String sql = "SELECT * FROM alumno WHERE id_Alumno = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);  // Asignamos el parámetro ID

        ResultSet resultSet = ps.executeQuery();  // Ejecutamos la consulta

        // Si se encuentra un alumno con el ID dado
        if (resultSet.next()) {
            java.sql.Date sqlDate = resultSet.getDate("fechaNacimiento"); // Obtener java.sql.Date
            LocalDate fechaNacimiento = sqlDate.toLocalDate(); // Convertir a LocalDate

            alumno = new Alumno(
                resultSet.getInt("dni"),
                resultSet.getString("apellido"),
                resultSet.getString("nombre"),
                fechaNacimiento, // Usar LocalDate
                resultSet.getBoolean("estado")
            );
            
            alumno.setIdAlumno(resultSet.getInt("id_Alumno"));
        } else {
            System.out.println("No se encontró ningún alumno con ID: " + id);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener el alumno: " + ex.getMessage());
    }
    
    return alumno;  // Devuelve el alumno encontrado o null si no existe
    
    
    
    }
      
    //(3) Buscar Alumno por DNI
    public Alumno buscarAlumnoPorDNI(int dni) {
        Alumno alumno = null;  // Inicializamos el objeto Alumno como null
        String sql = "SELECT * FROM alumno WHERE dni = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, dni);  // Asignamos el parámetro ID

        ResultSet resultSet = ps.executeQuery();  // Ejecutamos la consulta

        // Si se encuentra un alumno con el ID dado
        if (resultSet.next()) {
            java.sql.Date sqlDate = resultSet.getDate("fechaNacimiento"); // Obtener java.sql.Date
            LocalDate fechaNacimiento = sqlDate.toLocalDate(); // Convertir a LocalDate

            alumno = new Alumno(
                resultSet.getInt("dni"),
                resultSet.getString("apellido"),
                resultSet.getString("nombre"),
                fechaNacimiento, // Usar LocalDate
                resultSet.getBoolean("estado")
            );
            
            alumno.setIdAlumno(resultSet.getInt("id_Alumno"));
        } else {
            System.out.println("No se encontró ningún alumno con ID: " + dni);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener el alumno: " + ex.getMessage());
    }
    
    return alumno;  // Devuelve el alumno encontrado o null si no existe
    
    
    
    }
    
    //(4) Listar todos los alumnos
    public List<Alumno> listarAlumnos(){
        List<Alumno> alumnos = new ArrayList<>(); // Crear lista vacía de alumnos
        String sql = "SELECT * FROM alumno"; // Consulta SQL para obtener todos los alumnos

        try {
            PreparedStatement ps = con.prepareStatement(sql); // Preparar la consulta
            ResultSet resultSet = ps.executeQuery(); // Ejecutar la consulta y obtener los resultados

            // Recorrer los resultados
            while (resultSet.next()) {
                // Obtener los datos de cada alumno en la tabla
                int idAlumno = resultSet.getInt("id_Alumno");
                int dni = resultSet.getInt("dni");
                String apellido = resultSet.getString("apellido");
                String nombre = resultSet.getString("nombre");
                java.sql.Date sqlDate = resultSet.getDate("fechaNacimiento");
                LocalDate fechaNacimiento = sqlDate.toLocalDate(); // Convertir java.sql.Date a LocalDate
                boolean estado = resultSet.getBoolean("estado");

                // Crear un nuevo objeto Alumno con los datos obtenidos
                Alumno alumno = new Alumno(dni, apellido, nombre, fechaNacimiento, estado);
                alumno.setIdAlumno(idAlumno); // Establecer el ID del alumno

                // Agregar el alumno a la lista
                alumnos.add(alumno);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar los alumnos: " + ex.getMessage());
        }

        return alumnos; // Retornar la lista de alumnos
    
    }
    
    //(5) Modificar Alumno
    public void modificarAlumno(Alumno alumno){
       String sql = "UPDATE alumno SET dni = ?, apellido = ?, nombre = ?, fechaNacimiento = ?, estado = ? WHERE dni = ?";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento())); // Asegúrate de que fechaNacimiento no sea nula
            ps.setBoolean(5, alumno.isEstado());
            ps.setInt(6, alumno.getIdAlumno());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El alumno no existe.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno: " + ex.getMessage());
        }
    


    }
    
    //(6)Eliminar Alumno por id
    public void eliminarAlumno(int id){
          String sql = "DELETE FROM alumno WHERE id_Alumno = ?"; // Consulta SQL para eliminar un alumno

    try {
        PreparedStatement ps = con.prepareStatement(sql); // Preparar la consulta
        ps.setInt(1, id); // Establecer el ID del alumno a eliminar

        int filasAfectadas = ps.executeUpdate(); // Ejecutar la consulta de eliminación
        if (filasAfectadas > 0) {
            System.out.println("Alumno eliminado con éxito");
        } else {
            System.out.println("No se encontró ningún alumno con ID: " + id);
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al eliminar el alumno: " + ex.getMessage());
    }
    }
}