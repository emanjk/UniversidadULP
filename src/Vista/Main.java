
package Vista;

import Entidades.Alumno;
import Persistencia.AlumnoData;
import Persistencia.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet ; 
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;


public class Main {
    
    //(1)
    private AlumnoData alumnoData; // Variable para manejar los datos del alumno
    private Conexion conexion ; // Variable para manejar la conexión a la base de datos
   
    //(2)
    public Main() {
        // Inicializa la conexión y el objeto de datos del alumno
        conexion = new Conexion("jdbc:mariadb://localhost:3306/universidadulp", "root", "");
        alumnoData = new AlumnoData(conexion); // alumnoDate vinculada a la BD 'universidadulp'
    }
    
    
    
    //(3)
    public static void main(String[] args) throws SQLException {
       Main main = new Main(); // crear la instancia Main para inicializar 'conexion' y 'alumnoData'.
        
       //(1) Guardamos un alumno a la bd 'universidadulp'-'alumno'
       LocalDate fn = LocalDate.of(1999, 07, 9); 
       Alumno alumno = new Alumno (4076118, "Quispe","Emanuel",fn, true); //entidad
       main.conectar(alumno); // Conectar a la base de datos y guardar los alumnos
       
       //(2)Guardamos un segundo alumno
       LocalDate fn2 = LocalDate.of(2001,02,12);
       Alumno alumno2 = new Alumno (42712233, "Sosa", "Matias", fn2, true);
       main.conectar(alumno2);// Conectar a la base de datos y guardar los alumnos
       
       //(3)Guardamos un tercer alumno
        LocalDate fn3 = LocalDate.of(1999,12, 8);
        Alumno alumno3 = new Alumno (40779933, "Minguez","Marianela", fn3,true);
        main.conectar(alumno3); // Conectar a la base de datos y guardar los alumnos
        
       //(4)Guardamos un cuarto alumno
       LocalDate fn4 = LocalDate.of(2001, 01, 06) ;
       Alumno alumno4 = new Alumno(43114522, "Francisco", "Minguez",fn4, true);
       main.conectar(alumno4); // Conectar a la base de datos y guardar los alumnos
        
  
       //Buscamos un alumno por ID: ej id=1
       main.buscarAlumno(1);
    }
    
   
    
    
    
    
    
    //(1)Metodo: guardar un alumno
    public void conectar (Alumno alumno){
        
        alumnoData.guardarAlumno(alumno);
    }
    
    
    //(2)Metodo:  buscar un alumno por ID
    public void buscarAlumno(int id) {
        Alumno alumno = alumnoData.buscarAlumnoPorId(id);

        if (alumno != null) {
            // Mostrar la información del alumno
            System.out.println("Alumno encontrado:");
            System.out.println("ID: " + alumno.getIdAlumno() +
                               ", DNI: " + alumno.getDni() +
                               ", Apellido: " + alumno.getApellido() +
                               ", Nombre: " + alumno.getNombre() +
                               ", Fecha de Nacimiento: " + alumno.getFechaNacimiento() +
                               ", Estado: " + alumno.isEstado());
        }else {
            System.out.println("No se encontró ningún alumno con ID: " + id);
        }
    }
}