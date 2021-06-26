/*
Nombre del archivo: Accion.java

Nombre del programador: Kevin Moncayo Gutierrez

Fecha de creación: 10/06/2021

Fecha de Edición: 24/06/2021

Propósito: Clase para la creacion de los acuerdos  relacionados con la creacion de una 
minuta

Descripción de última edición: 
 */
package modelo.pojo;

/**
 *
 * @author Lenovo
 */
public class Acuerdo {
    private String descripcion;
    private String fecha;
    private int idAcuerdo;
    private int idMinuta;
    private String responsable;
    
    public Acuerdo(){
        
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdAcuerdo() {
        return idAcuerdo;
    }

    public void setIdAcuerdo(int idAcuerdo) {
        this.idAcuerdo = idAcuerdo;
    }

    public int getIdMinuta() {
        return idMinuta;
    }

    public void setIdMinuta(int idMinuta) {
        this.idMinuta = idMinuta;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    
    
    
}
