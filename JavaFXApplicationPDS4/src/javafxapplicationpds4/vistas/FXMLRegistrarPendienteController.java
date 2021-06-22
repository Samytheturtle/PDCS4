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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static modelo.DAO.PendienteDAO.guardaPendiente;
import modelo.pojo.Pendiente;

/**
 * FXML Controller class
 *
 * @author kevin
 */
public class FXMLRegistrarPendienteController implements Initializable {

    @FXML
    private TextField tfDescripcion;
    
    private int idMinuta;
    
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
        if(!tfDescripcion.getText().equals("")){
            
            String descripcion = tfDescripcion.getText();
            
            Pendiente pendienteTemp = new Pendiente();
            pendienteTemp.setDescripcion(descripcion);
            pendienteTemp.setIdMinuta(idMinuta);
            guardaPendiente(pendienteTemp);
            
            
            System.out.println("se crea pendiente");
            
            Stage escenarioActual = (Stage) tfDescripcion.getScene().getWindow();
            escenarioActual.close();
        }else{
            mostrarAlerta("Campo vacio", "Error, campo existente sin completar");
        }
    }
    
    private void cerrarVentana(){
        Stage escenarioActual = (Stage) tfDescripcion.getScene().getWindow();
        escenarioActual.close();
    }
    
    private ButtonBar.ButtonData mostrarAlerta(String titulo, String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
        
        return alert.getResult().getButtonData();
    }
    
    public void inicializarValores(int idReunion){
        idMinuta = idReunion;
        System.out.println("el idReunion recuperado es:" + idReunion);
    } 
    
}
