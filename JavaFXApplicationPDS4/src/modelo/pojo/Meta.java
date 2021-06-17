/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojo;

/**
 *
 * @author Lenovo
 */
public class Meta {
    private String nombre;
    private String planeacion;
    private int idPlanTrabajo;
    private int idMeta;
    
    public Meta(String objetivo,String planeacion, int idPlanTrabajo, int idMeta) {
        this.nombre = nombre;
        this.planeacion = planeacion;
        this.idPlanTrabajo = idPlanTrabajo;
        this.idMeta = idMeta;
   }
        
    public Meta(String objetivo,String planeacion) {
        this.nombre = nombre;
        this.planeacion = planeacion;
        this.idPlanTrabajo = 0;
        this.idMeta = 0;
   }

    public Meta() {}
   
    public String getnombre() {
        return nombre;
    }

    public String getPlaneacion() {
        return planeacion;
    }

    public int getIdPlanTrabajo() {
        return idPlanTrabajo;
    }
    public int getIdMeta() {
        return idMeta;
    }
    public void setnombre(String nombre) {
        this.nombre=nombre;
    }

    public void setPlaneacion(String planeacion) {
        this.planeacion=planeacion;
    }

    public void setIdPlanTrabajo(int idplan) {
        this.idPlanTrabajo=idplan;
    }
    public void setIdMeta(int idMeta) {
        this.idMeta=idMeta;
    }    
}
