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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.DAO.UsuarioDAO;
import modelo.pojo.Usuario;


/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLPrincipalController implements Initializable {

    @FXML
    private Button clicminuta;
    @FXML
    private Button clicCuerpoacademico;
    FXMLLoginController logincontroler2;

    /**
     * Initializes the controller class.
     */
    @Override
    public  void initialize(URL url, ResourceBundle rb) {     
     //TODO
    }  
    @FXML
    public void recibirdatos(FXMLLoginController controler, String tipo){
            //clicminuta.setOpacity(0);
            //clicminuta.setDisable(true);
            String tipoacc1="INTEGRANTE";
            String tipoacc2="REPRESENTANTE";
            String tipoacc3="ADMIN";
            Usuario userLogin = UsuarioDAO.getAllIntegrantes(tipo);
            String tipoac = userLogin.getTipo();
            System.out.println(tipoac);
            if(tipoac.equals(tipoacc1)){
                clicminuta.setDisable(true);
                clicCuerpoacademico.setDisable(true);
            }
            if(tipoac.equals(tipoacc2)){
                clicCuerpoacademico.setDisable(true);
            }
                        
            logincontroler2=controler;
    }

    @FXML
    private void salir(ActionEvent event) {
        changeWindow("FXMLLogin.fxml", event);
        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        currentStage.close();
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
  
        } catch(IOException io){
             System.out.println(io.getMessage());
        } finally {
            return loader;
        }
    }
    private void mostrarAlert(String titulo, String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
