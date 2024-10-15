
package Modelo;

import java.time.LocalDate;
import java.util.Date;


public class Alumno {
    //atributos
    private int idAlumno =-1; // -1 porque mariaDB lo va hacer auto incremental.
    private int dni;
    private String apellido; //VARCHAR
    private String nombre; // VARCAR
    private LocalDate fechaNacimiento ; //parsea DATETIME
    private boolean   estado ; //paresea TINYINT

    //Constructor vacio
    public Alumno() {
        
    }

    //constructor sin id
    public Alumno(int dni,String apellido, String nombre, LocalDate fechaNacimiento, boolean estado) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }
    
     //constructor con id
    public Alumno(int idAlumno, int dni, String apellido, String nombre, LocalDate fechaNacimiento, boolean estado) {
        this.idAlumno = idAlumno;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }
    
    

    //metodos getters
    public int getIdAlumno() {
        return idAlumno;
    }

    public int getDni() {
        return dni;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public boolean isEstado() {
        return estado;
    }

    
    //metodos setters
    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  idAlumno +", "+dni+ " , "+ apellido+" , "+nombre;
    }
    
    
    
}
