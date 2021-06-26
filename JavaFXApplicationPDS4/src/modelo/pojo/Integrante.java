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
public class Integrante {
    private String nombre;
    private String programaEducativoImpacto;
    private String telefono;
    private String perfilPROMPEP;
    private String nivelSNI;
    private String iesGradoMaximo;
    private String gradoMaximoEstudio;
    private String curp;
    private String correoElectronico;
    private String cargo;
    private String areaPerteneciente;
    private String tipo;
    private int id;

    public Integrante() {
        this.id = 0;
    }
       
    public Integrante(String nombre, String programaEducativoImpacto, String telefono, String perfilPROMPEP, String nivelSNI, String iesGradoMaximo, String gradoMaximoEstudio, String curp, String correoElectronico, String cargo, String areaPerteneciente, int id, String tipo) {
        this.nombre = nombre;
        this.programaEducativoImpacto = programaEducativoImpacto;
        this.telefono = telefono;
        this.perfilPROMPEP = perfilPROMPEP;
        this.nivelSNI = nivelSNI;
        this.iesGradoMaximo = iesGradoMaximo;
        this.gradoMaximoEstudio = gradoMaximoEstudio;
        this.curp = curp;
        this.correoElectronico = correoElectronico;
        this.cargo = cargo;
        this.areaPerteneciente = areaPerteneciente;
        this.id = id;
        this.tipo = tipo;
    }
    
    public String getNombre() {
        return nombre;
    } 
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProgramaEducativoImpacto() {
        return programaEducativoImpacto;
    }

    public void setProgramaEducativoImpacto(String programaEducativoImpacto) {
        this.programaEducativoImpacto = programaEducativoImpacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPerfilPROMPEP() {
        return perfilPROMPEP;
    }

    public void setPerfilPROMPEP(String perfilPROMPEP) {
        this.perfilPROMPEP = perfilPROMPEP;
    }

    public String getNivelSNI() {
        return nivelSNI;
    }

    public void setNivelSNI(String nivelSNI) {
        this.nivelSNI = nivelSNI;
    }

    public String getIesGradoMaximo() {
        return iesGradoMaximo;
    }

    public void setIesGradoMaximo(String iesGradoMaximo) {
        this.iesGradoMaximo = iesGradoMaximo;
    }

    public String getGradoMaximoEstudio() {
        return gradoMaximoEstudio;
    }

    public void setGradoMaximoEstudio(String gradoMaximoEstudio) {
        this.gradoMaximoEstudio = gradoMaximoEstudio;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getAreaPerteneciente() {
        return areaPerteneciente;
    }

    public void setAreaPerteneciente(String areaPerteneciente) {
        this.areaPerteneciente = areaPerteneciente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Integrante{" + "nombre=" + nombre + ", programaEducativoImpacto=" + programaEducativoImpacto + ", telefono=" + telefono + ", perfilPROMPEP=" + perfilPROMPEP + ", nivelSNI=" + nivelSNI + ", iesGradoMaximo=" + iesGradoMaximo + ", gradoMaximoEstudio=" + gradoMaximoEstudio + ", curp=" + curp + ", correoElectronico=" + correoElectronico + ", cargo=" + cargo + ", areaPerteneciente=" + areaPerteneciente + ", tipo=" + tipo + ", id=" + id + '}';
    }
        
    
}
