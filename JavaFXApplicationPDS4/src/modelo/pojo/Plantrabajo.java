/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojo;

/**
 *
 * @author samyt
 */
public class Plantrabajo {
    private String objetivo;
    private String planeacion;
    private int idPlanTrabajo;
    
    public Plantrabajo(String objetivo,String planeacion, int idPlanTrabajo) {
        this.objetivo = objetivo;
        this.planeacion = planeacion;
        this.idPlanTrabajo = idPlanTrabajo;
   }
    public Plantrabajo(){}
        
    public Plantrabajo(String objetivo,String planeacion) {
        this.objetivo = objetivo;
        this.planeacion = planeacion;
        this.idPlanTrabajo = 0;
   }
   
    public String getobjetivo() {
        return objetivo;
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
