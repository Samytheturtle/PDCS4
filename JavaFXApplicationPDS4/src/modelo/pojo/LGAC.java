/*
Nombre del archivo: nombre del archivo

Nombre del programador: nombre del autor original

Fecha de creación: fecha de creación del código

Fecha de Edición: última fecha de edición del código

Propósito: objetivo del código escrito en el archivo

Descripción de última edición: Descripción de los últimos cambios realizados

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
