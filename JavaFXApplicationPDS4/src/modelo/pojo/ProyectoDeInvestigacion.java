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
