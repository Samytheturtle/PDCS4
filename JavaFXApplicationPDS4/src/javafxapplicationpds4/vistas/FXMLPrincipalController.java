/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationpds4.vistas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLPrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void salir(ActionEvent event) {
        changeWindow("FXMLLogin.fxml", event);
    }

    @FXML
    private void crearMinuta(ActionEvent event) {
        changeWindow("FXMLCrearMinuta.fxml", event);
    }

    @FXML
    private void registrarcurriculum(ActionEvent event) {
        changeWindow("FXMLRegistrarCA.fxml", event);
    }

    @FXML
    private void registrarprototipo(ActionEvent event) {
        changeWindow("FXMLRegistrarPrototipo.fxml", event);
    }

    @FXML
    private void registrarplantrabajo(ActionEvent event) {
        changeWindow("FXMLRegistrarPlanTrabajo.fxml", event);
    }

   private FXMLLoader changeWindow(String window, Event event){
        Stage stage = new Stage();
        FXMLLoader loader = null;
        try{
            loader = new FXMLLoader(getClass().getResource(window));
            stage.setScene(new Scene((Pane)loader.load()));
            stage.show(); 
            Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            currentStage.close();
        } catch(IOException io){
             System.out.println(io.getMessage());
        } finally {
            return loader;
        }
    }
}
