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
public class Prototipo {
    private String anio;
    private String autor;
    private String caracteristicas;
    private String estadoActual;
    private String institucion;
    private String nompre;
    private String objetivo;
    private String pais;
    private String proposito;
    private int idPrototipo;
    private int idProyecto;
    private int idLgac;
    private int idIntegrante;

    public Prototipo(String anio, String autor, String caracteristicas, String estadoActual, String institucion, String nompre, String objetivo, String pais, String proposito, int idPrototipo, int idProyecto, int idLgac, int idIntegrante) {
        this.anio = anio;
        this.autor = autor;
        this.caracteristicas = caracteristicas;
        this.estadoActual = estadoActual;
        this.institucion = institucion;
        this.nompre = nompre;
        this.objetivo = objetivo;
        this.pais = pais;
        this.proposito = proposito;
        this.idPrototipo = idPrototipo;
        this.idProyecto = idProyecto;
        this.idLgac = idLgac;
        this.idIntegrante = idIntegrante;
    }

    public Prototipo(String anio, String autor, String caracteristicas, String estadoActual, String institucion, String nompre, String objetivo, String pais, String proposito, int idProyecto, int idLgac, int idIntegrante) {
        this.idPrototipo = 0;
        this.anio = anio;
        this.autor = autor;
        this.caracteristicas = caracteristicas;
        this.estadoActual = estadoActual;
        this.institucion = institucion;
        this.nompre = nompre;
        this.objetivo = objetivo;
        this.pais = pais;
        this.proposito = proposito;
        this.idProyecto = idProyecto;
        this.idLgac = idLgac;
        this.idIntegrante = idIntegrante;
    }

    public String getAnio() {
        return anio;
    }

    public String getAutor() {
        return autor;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public String getInstitucion() {
        return institucion;
    }

    public String getNompre() {
        return nompre;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public String getPais() {
        return pais;
    }

    public String getProposito() {
        return proposito;
    }

    public int getIdPrototipo() {
        return idPrototipo;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public int getIdLgac() {
        return idLgac;
    }

    public int getIdIntegrante() {
        return idIntegrante;
    }

    public void setIdIntegrante(int idIntegrante) {
        this.idIntegrante = idIntegrante;
    }
    

    @Override
    public String toString() {
        return "Prototipo{" + "anio=" + anio + ", autor=" + autor + ", caracteristicas=" + caracteristicas + ", estadoActual=" + estadoActual + ", institucion=" + institucion + ", nompre=" + nompre + ", objetivo=" + objetivo + ", pais=" + pais + ", proposito=" + proposito + ", idPrototipo=" + idPrototipo + ", idProyecto=" + idProyecto + ", idLgac=" + idLgac + '}';
    }
             
}
