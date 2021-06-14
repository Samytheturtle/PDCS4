/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationpds4.vistas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLRegistrarCAController implements Initializable {

    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfClave;
    @FXML
    private TextField tfDisciplina;
    @FXML
    private TextField tfGradoConsol;
    @FXML
    private TextField tfIES;
    @FXML
    private TextField tfArea;
    @FXML
    private ComboBox<?> cbLGAC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clicBtnGuardar(ActionEvent event) {
    }

    @FXML
    private void clicBtnCancelar(ActionEvent event) {
    }
    
}
