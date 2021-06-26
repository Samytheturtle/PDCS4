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
import java.util.Random;

/**
 *
 * @author samyt
 */
public class Plantrabajo {
    private String objetivo="";
    private String planeacion="";
    private int idPlanTrabajo;
    private ArrayList<Meta> arregloMetas = new ArrayList<>();
    
    public Plantrabajo(String objetivo,String planeacion,Meta meta) {
        this.objetivo = objetivo;
        this.planeacion = planeacion;
        this.idPlanTrabajo = idPlanTrabajo;
        arregloMetas.add(meta);
   }
    public Plantrabajo(){}
    public Plantrabajo(String objetivo,String planeacion) {
        this.objetivo = objetivo;
        this.planeacion = planeacion;
    }
    public Plantrabajo(String objetivo,String planeacion,int idPlanTrabajo) {
        this.objetivo = objetivo;
        this.planeacion = planeacion;
        this.idPlanTrabajo =idPlanTrabajo;
    }
   
    public String getobjetivo() {
        return objetivo;
    }
    public Meta getMetas(int meta){
         return arregloMetas.get(meta);
    }
    public void remove(int seleccion){
        arregloMetas.remove(seleccion);
    }
    public void setMetas(String nombre){
        Meta newmeta = new Meta(nombre);
        arregloMetas.add(newmeta);
    }
    public int getsize(){
        return arregloMetas.size();
    }
    
    public String getPlaneacion() {
        return planeacion;
    }

    public int getIdPlanTrabajo() {
        return idPlanTrabajo;
    }
    public void setobjetivo(String obj) {
        this.objetivo=obj;
    }

    public void setPlaneacion(String plan) {
        this.planeacion=plan;
    }
    public ArrayList<Meta> getArregloMetas(){
        return this.arregloMetas;
    }
    public void setIdPlanTrabajo(int id) {
        this.idPlanTrabajo=id;
    }
}
