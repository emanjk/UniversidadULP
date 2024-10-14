
package Modelo;


public class Materia {
    //atributos
    private int idMateria;
    private String nombre;
    private int anioMateria ;
    private boolean activo;

    
    
    
    //Constructor vacio
    public Materia() {
    }

    //Constructor sin idMateria

    public Materia(String nombre, int anioMateria, boolean activo) {
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.activo = activo;
    }
    

    //Constructor con idMateria
    public Materia(int idMateria, String nombre, int anioMateria, boolean activo) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.activo = activo;
    }

    
    //Metodos getters
    public int getIdMateria() {
        return idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnioMateria() {
        return anioMateria;
    }

    public boolean getEstado() {
        return activo;
    }
    
    
    //Metodos setters
    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAnioMateria(int anioMateria) {
        this.anioMateria = anioMateria;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "id_Materia: "+ idMateria+ " Nombre: "+nombre+" Año de la materia: "+ anioMateria+" Activo: "+activo;
    }          
                
                
    
    
    
    
    
}
