/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author samyt
 */
public class Plantrabajo {
    private String objetivo;
    private String planeacion;
    private int idPlanTrabajo;
    private ArrayList<Meta> arregloMetas = new ArrayList<>();
    
    public Plantrabajo(String objetivo,String planeacion,Meta meta) {
        this.objetivo = objetivo;
        this.planeacion = planeacion;
        this.idPlanTrabajo = idPlanTrabajo;
        arregloMetas.add(meta);
   }
    public Plantrabajo(){}
        
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

    public void setIdPlanTrabajo(int id) {
        this.idPlanTrabajo=id;
    }
}
