/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationpds4.vistas;

//import interfaz.NotificaCambios;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class FXMLRegistrarNotaController implements Initializable {

    @FXML
    private TextField tfDescripcion;

    
    //private NotificaCambios notificacion;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clicBtnCancelar(ActionEvent event) {
        cerrarVentana();
    }

    @FXML
    private void clicBtnAceptar(ActionEvent event) {
        
    }
    
    private void cerrarVentana(){
        Stage escenarioActual = (Stage) tfDescripcion.getScene().getWindow();
        escenarioActual.close();
    }
    
    
}
