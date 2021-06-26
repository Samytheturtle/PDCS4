/*
Nombre del archivo: nombre del archivo

Nombre del programador: nombre del autor original

Fecha de creación: fecha de creación del código

Fecha de Edición: última fecha de edición del código

Propósito: objetivo del código escrito en el archivo

Descripción de última edición: Descripción de los últimos cambios realizados

 */
package modelo.pojo;

/**
 *
 * @author Lenovo
 */
public class CuerpoAcademico {
    private String nombre;
    private String area;
    private int idCuerpoAcademico;
    private String disciplina;
    private String gradoConsolidacion;
    private String ies;
    private String clave;

    public CuerpoAcademico() {
        nombre = "vacio";
    }
    
    public CuerpoAcademico(String nombre, String area, int idCuerpoAcademico, String disciplina, String gradoConsolidacion, String ies, String clave) {
        this.nombre = nombre;
        this.area = area;
        this.idCuerpoAcademico = idCuerpoAcademico;
        this.disciplina = disciplina;
        this.gradoConsolidacion = gradoConsolidacion;
        this.ies = ies;
        this.clave = clave;
    }

    public CuerpoAcademico(String nombre, String area, String disciplina, String gradoConsolidacion, String ies, String clave) {
        this.idCuerpoAcademico = 0;
        this.nombre = nombre;
        this.area = area;
        this.disciplina = disciplina;
        this.gradoConsolidacion = gradoConsolidacion;
        this.ies = ies;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getArea() {
        return area;
    }

    public int getIdCuerpoAcademico() {
        return idCuerpoAcademico;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getGradoConsolidacion() {
        return gradoConsolidacion;
    }

    public String getIes() {
        return ies;
    }

    public String getClave() {
        return clave;
    }
        
    
    
    @Override
    public String toString() {
        return "CuerpoAcademico{" + "nombre=" + nombre + ", area=" + area + ", idCuerpoAcademico=" + idCuerpoAcademico + ", disciplina=" + disciplina + ", gradoConsolidacion=" + gradoConsolidacion + ", ies=" + ies + ", clave=" + clave + '}';
    }
}
