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
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.DAO.CuerpoAcademicoDAO;
import modelo.DAO.LGAC_DAO;
import modelo.pojo.CuerpoAcademico;
import modelo.pojo.LGAC;

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
    private ComboBox<LGAC> cbLGAC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbLGAC.getItems().addAll(LGAC_DAO.getAll());
        
    }    

    @FXML
    private void clicBtnGuardar(ActionEvent event) {
        String nombre = tfNombre.getText();
        String area = tfArea.getText();
        String disciplina = tfDisciplina.getText();
        String gradoConsolidacion = tfGradoConsol.getText();
        String ies = tfIES.getText();
        String clave = tfClave.getText();
        
        if(cbLGAC.getValue() == null){
            mostrarAlerta("Campo vacio", "Error, campos existentes sin completar");
        }
        else {
            int lgac = cbLGAC.getValue().getId();

            if(validarCampos()){
                CuerpoAcademico ca = new CuerpoAcademico(nombre, area, lgac, disciplina, gradoConsolidacion, ies, clave);
                CuerpoAcademicoDAO.insert(ca);
                System.out.println(ca);
                
                mostrarAlerta("Se ha guardado el Cuerpo Academico", "Se ha guardado el Cuerpo Academico");
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
    
    private boolean validarCampos(){
        if(tfNombre.getText().equals(""))
            return false;
        if(tfArea.getText().equals(""))
            return false;
        if(tfDisciplina.getText().equals(""))
            return false;
        if(tfGradoConsol.getText().equals(""))
            return false;
        if(tfIES.getText().equals(""))
            return false;
        if(tfClave.getText().equals(""))
            return false;

        return true;
    }
}

