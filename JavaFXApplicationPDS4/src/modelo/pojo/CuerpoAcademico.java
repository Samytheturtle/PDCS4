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
public class CuerpoAcademico {
    private String nombre;
    private String area;
    private int idCuerpoAcademico;
    private String disciplina;
    private String gradoConsolidacion;
    private String ies;
    private String clave;

    public CuerpoAcademico(String nombre, String area, int idCuerpoAcademico, String disciplina, String gradoConsolidacion, String ies, String clave) {
        this.nombre = nombre;
        this.area = area;
        this.idCuerpoAcademico = idCuerpoAcademico;
        this.disciplina = disciplina;
        this.gradoConsolidacion = gradoConsolidacion;
        this.ies = ies;
        this.clave = clave;
    }

    public CuerpoAcademico(String nombre, String area, String disciplina, String gradoConsolidacion, String ies, String clave) {
        this.idCuerpoAcademico = 0;
        this.nombre = nombre;
        this.area = area;
        this.disciplina = disciplina;
        this.gradoConsolidacion = gradoConsolidacion;
        this.ies = ies;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getArea() {
        return area;
    }

    public int getIdCuerpoAcademico() {
        return idCuerpoAcademico;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getGradoConsolidacion() {
        return gradoConsolidacion;
    }

    public String getIes() {
        return ies;
    }

    public String getClave() {
        return clave;
    }
        
    
    
    @Override
    public String toString() {
        return "CuerpoAcademico{" + "nombre=" + nombre + ", area=" + area + ", idCuerpoAcademico=" + idCuerpoAcademico + ", disciplina=" + disciplina + ", gradoConsolidacion=" + gradoConsolidacion + ", ies=" + ies + ", clave=" + clave + '}';
    }
}
