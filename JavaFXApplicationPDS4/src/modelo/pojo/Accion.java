/*
Nombre del archivo: Accion.java

Nombre del programador: Samuel Suarez Colin 

Fecha de creación: 10/06/2021

Fecha de Edición: 24/06/2021

Propósito: Clase para la creacion de las acciones asociadas a una meta de un plan de trabajo

Descripción de última edición: Creacion de un constructor para ingresar los datos unicamente 
pertenecientes a la accion y creacion de un toString


 */
package modelo.pojo;

/**
 *
 * @author samyt
 */
public class Accion {
    private int idMeta;
    private String nombre="";
    private String fechaconclusion="";
    private String recurso="";
    private String representante="";
    
    public Accion(String nombre,String fechaconclusion, String recurso, String representante, int idMeta) {
        this.nombre = nombre;
        this.fechaconclusion = fechaconclusion;
        this.recurso = recurso;
        this.idMeta = idMeta;
        this.representante = representante;
   }
        
    public Accion(String nombre,String fechaconclusion, String representante, String recurso) {
        this.nombre = nombre;
        this.fechaconclusion = fechaconclusion;
        this.representante = representante;
        this.recurso = recurso;
    }
    public Accion(){}
    public int getIdMeta() {
        return idMeta;
    }
    public String getNombre() {
        return nombre;
    }

    public String getFechaconclusion() {
        return fechaconclusion;
    }

    public String getRecurso() {
        return recurso;
    }
    public String getRepresentante() {
        return representante;
    }
    public void setnombre(String nombre) {
        this.nombre=nombre;
    }

    public void setfechaconclusion(String fecha) {
        this.fechaconclusion=fecha;
    }

    public void setrecurso(String recurso) {
        this.recurso=recurso;
    }
    public void setIdMeta(int id) {
        this.idMeta=id;
    }
    public void setrepresentante(String representante) {
        this.representante=representante;
    }
    public String toString(){
        return this.nombre+"\n"+this.fechaconclusion+"\n"+this.representante+"\n"+this.recurso+"\n";
    }
}
