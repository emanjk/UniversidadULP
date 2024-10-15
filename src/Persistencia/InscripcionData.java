
package Persistencia;
import Modelo.Conexion;
import Modelo.Alumno;
import Modelo.Inscripcion;
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
  
    private Connection con = null ;
    private AlumnoData aluData= null;
    private MateriaData mateData = null ;
    
   

    public InscripcionData(Conexion conexion) {
        this.con = conexion.buscarConexion();
        this.aluData = new AlumnoData(conexion);
        this.mateData = new MateriaData(conexion);
    }
    
    public InscripcionData() {
        
    }
    
    // 1. Guardar Inscripcion
    public void guardarInscripcion (Inscripcion ins){
         String sql = "INSERT INTO Inscripcion (nota, id_Alumno, id_Materia) VALUES (?, ?, ?)";

    try {
        PreparedStatement statement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        statement.setDouble(1, ins.getNota()); // Asignar la nota
        statement.setInt(2, ins.getAlumno().getIdAlumno()); // Asignar el ID del alumno
        statement.setInt(3, ins.getMateria().getIdMateria()); // Asignar el ID de la materia

        // Ejecutar la consulta SQL
        int filasAfectadas = statement.executeUpdate();

        if (filasAfectadas > 0) {
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                ins.setIdInscripcion(rs.getInt(1)); // Obtener el ID generado y asignarlo a la inscripción
                JOptionPane.showMessageDialog(null, "Inscripción guardada con ID: " + ins.getIdInscripcion());
            }
            rs.close();
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo guardar la inscripción.");
        }

        statement.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al guardar la inscripción: " + e.getMessage());
    }
    
    }
    
    
    // 2. Obtener Inscripciones
    public List<Inscripcion> obtenerInscripciones (){
        List<Inscripcion> inscripciones = new ArrayList<>(); // Lista para almacenar las inscripciones
        String sql = "SELECT id_Inscripcion, nota, id_Alumno, id_Materia FROM inscripcion"; // Consulta SQL

        try {
            PreparedStatement ps = con.prepareStatement(sql); // Prepara la declaración
            ResultSet rs = ps.executeQuery(); // Ejecuta la consulta

            while (rs.next()) { // Itera sobre los resultados
                int idInscripcion = rs.getInt("id_Inscripcion");
                double nota = rs.getDouble("nota");
                int idAlumno = rs.getInt("id_Alumno");
                int idMateria = rs.getInt("id_Materia");

                // Obtén el Alumno y Materia correspondientes usando sus ID
                Alumno alumno = aluData.buscarAlumnoPorId(idAlumno); 
                Materia materia = mateData.buscarMateria(idMateria); 

                // Crea una nueva Inscripcion y añádela a la lista
                Inscripcion inscripcion = new Inscripcion(idInscripcion, alumno, materia, nota);
                inscripciones.add(inscripcion);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener inscripciones: " + e.getMessage());
        }

        return inscripciones; // Retorna la lista de inscripciones
    
    }
    
    
    //3. Obtener Inscripciones por Alumno
    public List <Inscripcion> obtenerInscripcionesPorAlumno (int id){
        List<Inscripcion> inscripciones = new ArrayList<>(); // Lista para almacenar las inscripciones
        String sql = "SELECT id_Inscripcion, nota, id_Materia FROM inscripcion WHERE id_Alumno = ?"; // Consulta SQL

        try {
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setInt(1, id); 
            ResultSet rs = ps.executeQuery(); // Ejecuta la consulta

            // Obtener el Alumno solo una vez al inicio
            Alumno alumno = aluData.buscarAlumnoPorId(id); // Obtén el objeto Alumno

            while (rs.next()) { // Itera sobre los resultados
                int idInscripcion = rs.getInt("id_Inscripcion");
                double nota = rs.getDouble("nota");
                int idMateria = rs.getInt("id_Materia");

                //Materia correspondiente usando su ID
                Materia materia = mateData.buscarMateria(idMateria); 

                // Crea una nueva Inscripcion y añádela a la lista
                Inscripcion inscripcion = new Inscripcion(idInscripcion, alumno, materia, nota); 
                inscripciones.add(inscripcion);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener inscripciones por alumno: " + e.getMessage());
        }

        return inscripciones; 
   
        
    }

    
    // 4. Obtenener materias Cursadas
    public List <Materia> obtenerMateriasCursadas (int id){
        List<Materia> materiasCursadas = new ArrayList<>(); // Lista para almacenar las materias cursadas
        String sql = "SELECT m.id_Materia, m.nombre, m.anio, m.estado FROM inscripcion i " +
                     "JOIN materia m ON i.id_Materia = m.id_Materia " +
                     "WHERE i.id_Alumno = ?"; // Consulta SQL

        try {
            PreparedStatement ps = con.prepareStatement(sql); 
            ps.setInt(1, id); // Establece el ID del alumno en la consulta
            ResultSet rs = ps.executeQuery();

            while (rs.next()) { // Itera sobre los resultados
                int idMateria = rs.getInt("id_Materia");
                String nombreMateria = rs.getString("nombre");
                int anioMateria = rs.getInt("anio");
                boolean activo = rs.getBoolean("estado");

                // Crea una nueva Materia y añádela a la lista
                Materia materia = new Materia(idMateria, nombreMateria, anioMateria, activo);
                materiasCursadas.add(materia);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener materias cursadas: " + e.getMessage());
        }

        return materiasCursadas; // Retorna la lista de materias cursadas
    
    }
    
    
    // 5. Obtener materias NO cursadas  
    public List <Materia> obtenerMateriasNoCursadas(int id){
        List<Materia> materiasNoCursadas = new ArrayList<>(); // Lista para almacenar las materias no cursadas
        String sql = "SELECT m.id_Materia, m.nombre, m.anio, m.estado FROM materia m " +
                     "WHERE m.id_Materia NOT IN (SELECT i.id_Materia FROM inscripcion i WHERE i.id_Alumno = ?)"; // Consulta SQL

        try {
            PreparedStatement ps = con.prepareStatement(sql); // Prepara la declaración
            ps.setInt(1, id); // Establece el ID del alumno en la consulta
            ResultSet rs = ps.executeQuery(); // Ejecuta la consulta

            while (rs.next()) { // Itera sobre los resultados
                int idMateria = rs.getInt("id_Materia");
                String nombreMateria = rs.getString("nombre");
                int anioMateria = rs.getInt("anio");
                boolean activo = rs.getBoolean("estado");

                // Crea una nueva Materia y añádela a la lista
                Materia materia = new Materia(idMateria, nombreMateria, anioMateria, activo);
                materiasNoCursadas.add(materia);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener materias no cursadas: " + e.getMessage());
        }

        return materiasNoCursadas; // Retorna la lista de materias no cursadas
    }
    
    
    // 6. Borrar inscripcion 
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria){
        String sql = "DELETE FROM inscripcion WHERE id_Alumno = ? AND id_Materia = ?"; 

        try {
            PreparedStatement ps = con.prepareStatement(sql); // Prepara la declaración
            ps.setInt(1, idAlumno); // Establece el ID del alumno en la consulta
            ps.setInt(2, idMateria); // Establece el ID de la materia en la consulta

            int filasAfectadas = ps.executeUpdate(); 

            if (filasAfectadas > 0) { 
                JOptionPane.showMessageDialog(null, "Inscripción eliminada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la inscripción para eliminar.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la inscripción: " + e.getMessage());
        }
    
    }
    
    
    // 7.Actualizar nota
    public void actualizarNota (int idAlumno, int idMateria, double nota){
      String sql = "UPDATE inscripcion SET nota = ? WHERE id_Alumno = ? AND id_Materia = ?"; // Consulta SQL para actualizar la nota

    try (PreparedStatement ps = con.prepareStatement(sql)) { // Prepara la declaración
        ps.setDouble(1, nota); // Establece la nueva nota
        ps.setInt(2, idAlumno); // Establece el ID del alumno
        ps.setInt(3, idMateria); // Establece el ID de la materia

        int filasAfectadas = ps.executeUpdate(); // Ejecuta la consulta

        if (filasAfectadas > 0) { 
            JOptionPane.showMessageDialog(null, "Nota actualizada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la inscripción para actualizar la nota.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar la nota: " + e.getMessage());
    }
    }
    
    
    // 8. Obtener alumnos por materias
    public List<Alumno> obtenerAlumnosXMateria(int idMateria){
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT a.* FROM alumno a " +
                     "JOIN inscripcion i ON a.id_Alumno = i.id_Alumno " +
                     "WHERE i.id_Materia = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria); // Establecer el ID de la materia
            ResultSet rs = ps.executeQuery(); // Ejecutar la consulta

            while (rs.next()) {
                // Crear un nuevo objeto Alumno a partir de los datos del ResultSet
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("id_Alumno"));
                alumno.setDni(rs.getInt("dni")); 
                alumno.setApellido(rs.getString("apellido")); 
                alumno.setNombre(rs.getString("nombre"));  
                alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado")); 

                alumnos.add(alumno); // Agregar el alumno a la lista
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los alumnos por materia: " + e.getMessage());
        }
        return alumnos; // Retornar la lista de alumnos

        }
    
    
    
    
    
    
    
}
    
    

