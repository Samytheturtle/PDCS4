/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationpds4.vistas;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.DAO.Ca_Lgac;
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
    private ComboBox tfGradoConsol;
    @FXML
    private TextField tfIES;
    @FXML
    private TextField tfArea;
    @FXML
    private TableView<LGAC> tabla = new TableView<LGAC>();
    @FXML
    private TableColumn<LGAC, String> cLgac;
    private ObservableList<LGAC> LgcaObservable;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LgcaObservable = FXCollections.observableArrayList();
        
        cLgac.setCellValueFactory(new PropertyValueFactory<>("nombreLgca"));
        LgcaObservable.addAll(LGAC_DAO.getAll());
        tabla.setItems(LgcaObservable);
        tabla.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        tfGradoConsol.getItems().addAll("Consolidado", "En consolidacion","Sin consolidar");
    }    

    @FXML
    private void clicBtnGuardar(ActionEvent event) {
        String nombre = tfNombre.getText();
        String area = tfArea.getText();
        String disciplina = tfDisciplina.getText();
        String ies = tfIES.getText();
        String clave = tfClave.getText();
        
        if(tfGradoConsol.getValue() == null){
            mostrarAlerta("Campo vacio", "Error, campos existentes sin completar");
        }
        else{
            List<LGAC> selecciones = tabla.getSelectionModel().getSelectedItems();
            if(selecciones.isEmpty()){
                mostrarAlerta("Campo vacio", "Error, campos existentes sin completar");
            }
            else {
                String gradoConsolidacion = tfGradoConsol.getValue().toString();
                if(validarCampos()){
                    CuerpoAcademico ca = new CuerpoAcademico(nombre, area, disciplina, gradoConsolidacion, ies, clave);
                    Ca_Lgac.insert(CuerpoAcademicoDAO.insert(ca), selecciones);

                    mostrarAlerta("Se ha guardado el Cuerpo Academico", "Se ha guardado el Cuerpo Academico");
                    //changeWindow("FXMLPrincipal.fxml", event);
                      Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                      currentStage.close();                    
                    
                }
                else{
                    mostrarAlerta("Campo vacio", "Error, campos existentes sin completar o demaciado largos");
                }
            }
        }
    }

    @FXML
    private void clicBtnCancelar(ActionEvent event) {
        if("OK_DONE".equals(confirmarAlerta("Confirmación", "¿Está seguro que desea cancelar el registro?").toString())){
          //changeWindow("FXMLPrincipal.fxml", event);
        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        currentStage.close();        
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
        if(tfNombre.getText().equals("") || tfNombre.getText().length() > 149)
            return false;
        if(tfArea.getText().equals("") || tfNombre.getText().length() > 149)
            return false;
        if(tfDisciplina.getText().equals("") || tfNombre.getText().length() > 149)
            return false;
        if(tfIES.getText().equals("") || tfNombre.getText().length() > 149)
            return false;
        if(tfClave.getText().equals("") || tfNombre.getText().length() > 44)
            return false;

        return true;
    }
}

