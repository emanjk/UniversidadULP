
package Persistencia;
import Entidades.Alumno;
import java.sql.Connection; /*Conexion a bd 'universidadulp*/
import java.sql.PreparedStatement; /*guarda codigo SQL*/
import java.sql.ResultSet; /*obtener datos o registro de un alumno*/

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.time.LocalDate;
import javax.swing.JOptionPane;



public class AlumnoData {
    //(1) 'con' almacena la conexion a la bd
    private Connection con=null ;

   
    
    
    
    //(2) constructor que recibe la conexion
    public AlumnoData(Conexion conexion) {   
        this.con = conexion.buscarConexion();           
    }
       
                         //metodos para el alumno:
    
    // (1) Guardar 1 alumno
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
        
    } catch (SQLException ex) {
        ex.printStackTrace();  /*me impre con mas deetalles la excepetion*/
        JOptionPane.showMessageDialog(null, "Error al guardar el alumno: " + ex.getMessage());
    }
           
    }
    

    
    //(2) Buscar 1 alumno por id
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
    
    
    //(3) Buscar 1 alumno por dni
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
    
    
}