/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationpds4.vistas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.DAO.IntegranteDAO;
import modelo.DAO.LGAC_DAO;
import modelo.DAO.PrototipoDAO;
import modelo.DAO.ProyectoDeInvestigacionDAO;
import modelo.pojo.Integrante;
import modelo.pojo.LGAC;
import modelo.pojo.Prototipo;
import modelo.pojo.ProyectoDeInvestigacion;

/**
 *
 * @author Lenovo
 */
public class FXMLRegistrarPrototipoController implements Initializable {

    @FXML
    private TextField tfTitulo;
    @FXML
    private TextField tfAnio;
    @FXML
    private TextField tfAutor;
    @FXML
    private TextField tfCaracteristicas;
    @FXML
    private TextField tfInstitucion;
    @FXML
    private TextField tfObjetivo;
    @FXML
    private TextField tfProposito;
    @FXML
    private TextField tfEstadoActual;
    @FXML
    private TextField tfPais;
    @FXML
    private ComboBox<LGAC> cboxLgac;
    @FXML
    private ComboBox<ProyectoDeInvestigacion> cboxProyecto;
    @FXML
    private ComboBox<Integrante> cboxColaboradores;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cboxLgac.getItems().addAll(LGAC_DAO.getAll());
        cboxProyecto.getItems().addAll(ProyectoDeInvestigacionDAO.getAll());
        cboxColaboradores.getItems().addAll(IntegranteDAO.getAllIntegrantes());
    }    

    @FXML
    private void clicBtnGuardar(ActionEvent event) {
        String anio = tfAnio.getText();
        String autor = tfAutor.getText();
        String caracteristicas = tfCaracteristicas.getText();
        String estadoActual = tfEstadoActual.getText();
        String institucion = tfInstitucion.getText();
        String nombre = tfTitulo.getText();
        String objetivo = tfObjetivo.getText();
        String pais = tfPais.getText();
        String proposito = tfProposito.getText();
        
        if(cboxLgac.getValue() == null || cboxProyecto.getValue() == null){
            mostrarAlerta("Campo vacio", "Error, campos existentes sin completar");
        }
        else {
            int lgac = cboxLgac.getValue().getId();
            int proyecto = cboxProyecto.getValue().getId();

            if(validarCampos()){
                Prototipo proto = new Prototipo(anio, autor, caracteristicas, estadoActual, institucion, nombre, objetivo, pais, proposito, lgac, proyecto);
                PrototipoDAO.insert(proto);
                System.out.println(proto);
                
                mostrarAlerta("Se ha guardado el prototipo", "Se ha guardado el prototipo");
                changeWindow("FXMLPrincipal.fxml", event);
            }
            else{
                mostrarAlerta("Campo vacio", "Error, campos existentes sin completar");
            }
        }  
    }
        
    @FXML
    private void clicBtnCancelar(ActionEvent event) {
        if("OK_DONE".equals(confirmarAlerta("Confirmación", "¿Está seguro que desea cancelar el registro?").toString())){
            changeWindow("FXMLPrincipal.fxml", event);
        }
    }
    
    private void changeWindow(String window, Event event){
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(window));
        try{
            stage.setScene(new Scene((Pane)loader.load()));
            stage.show(); 
            Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            currentStage.close();
        } catch(IOException io){
             System.out.println(io.getMessage());
        } 
    }
    
    private ButtonBar.ButtonData confirmarAlerta(String titulo, String mensaje){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
        
        return alert.getResult().getButtonData();
    }
    private ButtonBar.ButtonData mostrarAlerta(String titulo, String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
        
        return alert.getResult().getButtonData();
    }

    private boolean validarCampos() {     
        if(tfTitulo.getText().equals(""))
            return false;
        if(tfAnio.getText().equals(""))
            return false;
        if(tfAutor.getText().equals(""))
            return false;
        if(tfCaracteristicas.getText().equals(""))
            return false;
        if(tfInstitucion.getText().equals(""))
            return false;
        if(tfObjetivo.getText().equals(""))
            return false;
        if(tfProposito.getText().equals(""))
            return false;
        if(tfEstadoActual.getText().equals(""))
            return false;
        if(tfPais.getText().equals(""))
            return false;
        
        return true;
    }
}
