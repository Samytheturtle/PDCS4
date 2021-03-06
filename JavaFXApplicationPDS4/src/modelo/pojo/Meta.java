/*
Nombre del archivo: nombre del archivo

Nombre del programador: nombre del autor original

Fecha de creación: fecha de creación del código

Fecha de Edición: última fecha de edición del código

Propósito: objetivo del código escrito en el archivo

Descripción de última edición: Descripción de los últimos cambios realizados

 */
package modelo.pojo;

import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Meta {
    private String nombre="";
    private int idPlanTrabajo;
    private int idMeta;
    private ArrayList<Accion> arregloAcciones = new ArrayList<>();
    
    public Meta(String nombre, int idPlanTrabajo, int idMeta) {
        this.nombre = nombre;
        this.idPlanTrabajo = idPlanTrabajo;
        this.idMeta = idMeta;
   }
        
    public Meta(String nombre,int idPlanTrabajo) {
        this.nombre = nombre;
        this.idPlanTrabajo = idPlanTrabajo;
        this.idMeta = 0;
    }
    public Meta(String nombre,Accion accion){
        this.nombre=nombre;
        this.arregloAcciones.add(accion);
    }
    public Meta(String nombre) {
        this.nombre = nombre;
   }
    public Meta() {}
   
    public String getNombre() {
        return nombre;
    }
    public int getIdPlanTrabajo() {
        return idPlanTrabajo;
    }
    public int getIdMeta() {
        return idMeta;
    }
    public void remove(int seleccion){
        arregloAcciones.remove(seleccion);
    }
    public Accion getAccion(int accion){
         return arregloAcciones.get(accion);
    }
    public void setnombre(String nombre) {
        this.nombre=nombre;
    }
    public void setAccion(Accion accion){
        this.arregloAcciones.add(accion);
    }
    public int getsize(){
        return arregloAcciones.size();
    }    
    public void setIdPlanTrabajo(int idplan) {
        this.idPlanTrabajo=idplan;
    }
    public void setIdMeta(int idMeta) {
        this.idMeta=idMeta;
    }    
    public ArrayList<Accion> getArregloAccion(){
        return arregloAcciones;
    }
    public String toString(){
        return nombre;
    }
}
