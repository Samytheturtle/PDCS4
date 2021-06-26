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
public class ProyectoDeInvestigacion {
    private int idProyecto;
    private String patrocinador;
    private String tipoPatrocinador;
    private String fechaIni;
    private String fechaFin;
    private String nombreProyecto;

    public ProyectoDeInvestigacion(int idProyecto, String patrocinador, String tipoPatrocinador, String fechaIni, String fechaFin, String nombreProyecto) {
        this.idProyecto = idProyecto;
        this.patrocinador = patrocinador;
        this.tipoPatrocinador = tipoPatrocinador;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.nombreProyecto = nombreProyecto;
    }

    public int getId() {
        return idProyecto;
    }

    @Override
    public String toString() {
        return nombreProyecto;
    }
    
    
}
