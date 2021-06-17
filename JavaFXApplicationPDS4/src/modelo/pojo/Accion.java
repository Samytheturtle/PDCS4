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
public class Accion {
    private String nombre;
    private String fechaconclusion;
    private String recurso;
    private int idMeta;
    private String descripcion;
    
    public Accion(String nombre,String fechaconclusion, String recurso, int idMeta, String descripcion) {
        this.nombre = nombre;
        this.fechaconclusion = fechaconclusion;
        this.recurso = recurso;
        this.idMeta = idMeta;
        this.descripcion = descripcion;
   }
        
    public Accion(String nombre,String fechaconclusion, String descripcion, String recurso) {
        this.nombre = nombre;
        this.fechaconclusion = fechaconclusion;
        this.recurso = recurso;
        this.idMeta = 0;
        this.descripcion = descripcion;
    }
    public Accion(){}
   
    public String getnombre() {
        return nombre;
    }

    public String getfechaconclusion() {
        return fechaconclusion;
    }

    public String getrecurso() {
        return recurso;
    }
    public int getIdMeta() {
        return idMeta;
    }
    public String getdescripcion() {
        return descripcion;
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
    public void setdescripcion(String descripcion) {
        this.descripcion=descripcion;
    }
}
