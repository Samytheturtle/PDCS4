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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfUsuario;
    @FXML
    private Label lbErrorUsuario;
    @FXML
    private Label lbErrorPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clicBtnIniciar(ActionEvent event) {
        lbErrorPassword.setText("");
        lbErrorUsuario.setText("");
      String  txUsuario =tfUsuario.getText();
      String  txPassword=tfPassword.getText();
    
      boolean isCorrecto = true;
      if(txUsuario.isEmpty()){
        lbErrorUsuario.setText("Campo requerido");
        isCorrecto = false;
      }
   
      if(txPassword.isEmpty()){
        lbErrorPassword.setText("Campo requerido");
        isCorrecto = false;
      }  
      if(isCorrecto){
          PantallaPrincipal();
      }
    }
    private void PantallaPrincipal(){
        try {
            Stage stage = (Stage) tfUsuario.getScene().getWindow();
            Scene scenePrincipal = new Scene(FXMLLoader.load(getClass().getResource("FXMLPrincipal.fxml")));
            stage.setScene(scenePrincipal);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
