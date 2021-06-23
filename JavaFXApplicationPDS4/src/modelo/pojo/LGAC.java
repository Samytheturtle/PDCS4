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
public class LGAC {
    private int id;
    private String descripcion;
    private String nombreLgca;

    public LGAC(int id, String nombreLgca, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombreLgca = nombreLgca;
    }

    public LGAC(String nombreLgca, String descripcion) {
        this.descripcion = descripcion;
        this.nombreLgca = nombreLgca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreLgca() {
        return nombreLgca;
    }

    public void setNombreLgca(String nombreLgca) {
        this.nombreLgca = nombreLgca;
    }

    @Override
    public String toString() {
        return nombreLgca;
    }
}
