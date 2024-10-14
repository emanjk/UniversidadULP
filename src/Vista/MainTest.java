
package Vista;

import Modelo.Alumno;
import Modelo.Materia;
import Persistencia.AlumnoData;
import Persistencia.MateriaData;
import Modelo.Conexion;
/*Importamos las clases de la API JDBC*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet ; 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class MainTest {
    
    
    private Conexion conexion ; // Variable para manejar la conexión a la base de datos
    private AlumnoData alumnoData; // Variable para manejar los datos del alumno
    private MateriaData materiaData;
    
    public MainTest() {
        //Se debe conectar a la base de datos 
        conexion = new Conexion("jdbc:mariadb://localhost:3306/universidadulp", "root", "");
        alumnoData = new AlumnoData(conexion);
        materiaData = new MateriaData (conexion) ;
    }
    
    
   
    public static void main(String[] args) throws SQLException {
    MainTest main = new MainTest(); 
        

    System.out.println("     **** TESTEAMOS LOS ALUMNOS ****    ");
    System.out.println("\n");

    try {
        // 1. 'Insertar' un alumno            
        Alumno alumnoExistente = main.alumnoData.buscarAlumnoPorDNI(44556677);
        Alumno nuevoAlumno = null; 

        if (alumnoExistente == null) {
            nuevoAlumno = new Alumno(44556677, "Juan", "Perez", LocalDate.of(2000, 5, 15), true);
            main.alumnoData.guardarAlumno(nuevoAlumno);
            System.out.println("Alumno insertado: " + nuevoAlumno.getApellido());
        } else {
            System.out.println("Alumno con DNI 44556677 ya existe: " + alumnoExistente.getApellido());
        }
        System.out.println("-----------------------------------------"); 
        System.out.println("\n");

    
    // 2. 'Buscar' un alumno por ID            
        if (nuevoAlumno != null) {
            Alumno alumnoBuscado = main.alumnoData.buscarAlumnoPorId(nuevoAlumno.getIdAlumno());
            if (alumnoBuscado != null) {
                System.out.println("Alumno: " + alumnoBuscado.getApellido());

                // 3. 'Modificar' alumno
                alumnoBuscado.setNombre("Martin Perez");
                main.alumnoData.modificarAlumno(alumnoBuscado);
                System.out.println("Alumno modificado: " + alumnoBuscado.getApellido() + " DNI: " + alumnoBuscado.getDni());
                System.out.println("-----------------------------------------------");

                // 4. 'Eliminar' alumno por ID
                main.alumnoData.eliminarAlumno(alumnoBuscado.getIdAlumno());
                System.out.println("Alumno con ID " + alumnoBuscado.getIdAlumno() + " fue eliminado.");
                System.out.println("--------------------------------------------");
            } else {
                System.out.println("No se encontró el alumno");
            }
        } else {
            System.out.println("El alumno no existe");
        }
        System.out.println("--------------------------------------------");
        System.out.println("\n");
    
    // 5. 'Buscar' alumno por DNI
        Alumno alumnoPorDNI = main.alumnoData.buscarAlumnoPorDNI(44556677);
        if (alumnoPorDNI != null) {
            System.out.println("Alumno encontrado " + alumnoPorDNI.getApellido() + " DNI: " + alumnoPorDNI.getDni());
        } else {
            System.out.println("No se encontró el alumno");
        }
        System.out.println("---------------------------------------------");
        System.out.println("\n");
    
    // 6. 'Mostrar' todos los alumnos   
        System.out.println("ALUMNOS REGISTRADOS");
        List<Alumno> alumnos = main.alumnoData.listarAlumnos();    
        for (Alumno alumno : alumnos) {    
            System.out.println(alumno);
            System.out.println("------------------------------------------");
        }  
        System.out.println("\n");
        
    
    
    // 7. Baja alumno
        Alumno alumno2 = main.alumnoData.buscarAlumnoPorDNI(44556677);
        if (alumno2 != null) { // verificamos que se encuentre en la bds
            main.alumnoData.bajaLogica(alumno2);   
            System.out.println("El alumno: " + alumno2.getApellido() + " " + alumno2.getNombre() + " fue dado de baja.");
        } else {
            System.out.println("El alumno ingresado no se encuentra registrado");
        }
        System.out.println("\n");
        
        
    // 8. Alta alumno
        Alumno alumno3 = main.alumnoData.buscarAlumnoPorDNI(1122334455);
        if (alumno3 != null) { // verificamos que se encuentre en la bds
            main.alumnoData.altaLogica(alumno3);   
            System.out.println("El alumno: " + alumno3.getApellido() + " " + alumno3.getNombre() + " fue dado de alta.");
        } else {
            System.out.println("El alumno ingresado no se encuentra registrado");
        }    
        } catch (SQLException e) {
            System.out.println("Error con la Base de Datos: " + e.getMessage());
        }    
        System.out.println("\n");
             
    
        
        
     
    System.out.println("     **** TESTEAMOS LAS MATERIAS ****    ");
    System.out.println("\n");
    
    try{     
    // 1. Insertar
        System.out.println("Insertar Materia: ");
        Materia materia = new Materia(2, "Ingles", 1, true);
        main.materiaData.guardarMateria(materia);
        System.out.println("\n");
       
    // 2. Buscar Materia por id
        System.out.println("Buscar materia: ");
        Materia materiaEncontrada = main.materiaData.buscarMateria(2);
        if(materiaEncontrada != null) {
            System.out.println("Materia "+ materiaEncontrada.getNombre() +" encontrada en la bds");
        }else{
            System.out.println("La materia con id 2 no se encontró en la bds");
        }
        System.out.println("\n");
        
    // 3. Actualizar Materia encontrada
        System.out.println("Actualizar Materia");
        materiaEncontrada.setActivo(false);
        main.materiaData.modificarMateria(materiaEncontrada);
    
    // 4. Baja logica a una materia
        System.out.println("Baja Materia ");
        main.materiaData.bajaLogica(materiaEncontrada);
        System.out.println("Materia dada de baja lógicamente: " + materiaEncontrada.getNombre());
        System.out.println("\n");
        
    // 5. Verificamos el estado de la materia  
        System.out.println("Datos modificados de la materia: \n"+ materiaEncontrada );
    
    
    // 6. Alta logica
       main.materiaData.altaLogica(materiaEncontrada);
            System.out.println("Materia dada de alta lógicamente: " + materiaEncontrada.getNombre());
    
    
            // Verificar estado después de la alta lógica
            Materia materiaAlta = main.materiaData.buscarMateria(materiaEncontrada.getIdMateria());
            System.out.println("Estado actual de la materia (después de alta lógica): " + (materiaAlta.getEstado() ? "Activa" : "Inactiva"));

            // Borrar materia
            main.materiaData.eliminarMateria(materiaEncontrada.getIdMateria());
            System.out.println("Materia borrada.");

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }        
            
        
            
            
            
            
            
    }
    
    
    
    }
