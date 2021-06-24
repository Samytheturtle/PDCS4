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
    private String representante;
    
    public Accion(String nombre,String fechaconclusion, String recurso, int idMeta, String representante) {
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
