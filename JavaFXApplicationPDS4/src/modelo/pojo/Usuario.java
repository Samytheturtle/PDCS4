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
public class Usuario {
        
    private int idUsuario;
    private String nombre;
    private String username;
    private String tipo;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
