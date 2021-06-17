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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modelo.DAO.IntegranteDAO;
import modelo.DAO.LGAC_DAO;
import modelo.DAO.PrototipoDAO;
import modelo.DAO.ProyectoDeInvestigacionDAO;
import modelo.pojo.Integrante;
import modelo.pojo.LGAC;
import modelo.pojo.Prototipo;


/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLRegistrarPlanTrabajoController implements Initializable {

    @FXML
    private TextField ltobjetivo;
    @FXML
    private TextField ltplaneacion;
    @FXML
    private TextField ltmeta;
    @FXML
    private TextField ltacciones;
    @FXML
    private TextField ltfechaconclucion;
    @FXML
    private TextField ltresponsable;
    @FXML
    private TextField ltrecurso;
    @FXML
    private TableView<?> tbmetascreadas;
    @FXML
    private TableView<?> tbaccionescreadas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clicGuardarTodo(ActionEvent event) {
 
      
    }

    @FXML
    private void clicCancelarTodo(ActionEvent event) {
        changeWindow("FXMLPrincipal.fxml", event);
    }
    @FXML
    private void clicGuardarAcciones(ActionEvent event) {
    }

    @FXML
    private void clicAsociarAcciones(ActionEvent event) {
        
    }

    @FXML
    private void clicBorrarMeta(ActionEvent event) {
    }

    @FXML
    private void clicBorrarAccion(ActionEvent event) {
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
    
      private void mostrarAlert(String titulo, String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
     }

    @FXML
    private void clicguardarMeta(ActionEvent event) {
    }

    @FXML
    private void clicCancelarMeta(ActionEvent event) {
    }
}
