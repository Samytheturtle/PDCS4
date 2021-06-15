/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationpds4.vistas;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.DAO.IntegranteDAO;
import modelo.DAO.ReunionDAO;
import modelo.pojo.Acuerdo;
import modelo.pojo.Integrante;
import modelo.pojo.Nota;
import modelo.pojo.Pendiente;
import modelo.pojo.Reunion;

/**
 * FXML Controller class
 *
 * @author Lenovo kevin Luisa
 */
public class FXMLCrearMinutaController implements Initializable {

    @FXML
    private ComboBox<Reunion> cbReunion;
    @FXML
    private TextField tfDescripcion;
    @FXML
    private DatePicker dpFecha;
    @FXML
    private ComboBox<Integrante> cbResponsable;
    @FXML
    private TableView<Nota> tbNotas;
    @FXML
    private TableColumn colNotaId;
    @FXML
    private TableColumn colNotaDescripcion;
    @FXML
    private TableView<Pendiente> tbPendientes;
    @FXML
    private TableColumn colPendienteId;
    @FXML
    private TableColumn colPendienteDescripcion;
    @FXML
    private TableView<Acuerdo> tbAcuerdos;
    @FXML
    private TableColumn colAcuerdoId;
    @FXML
    private TableColumn colAcuerdoDescripcion;
    @FXML
    private TableColumn colAcuerdoFecha;
    @FXML
    private TableColumn colAcuerdoResponsable;

    private ObservableList<Integrante> integrantes;
    private ObservableList<Reunion> reuniones;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        integrantes = FXCollections.observableArrayList(); //Un array para mostrar en ComboBox
        reuniones = FXCollections.observableArrayList();
        cargaReuniones();
    }

    private void cargaReuniones(){
        reuniones.addAll(ReunionDAO.getAllReuniones());
        cbReunion.setItems(reuniones);
    }
    private void cargaIntegrantes(){
        integrantes.addAll(IntegranteDAO.getAllIntegrantes());
        cbResponsable.setItems(integrantes);
    }

    @FXML
    private void clicRegistrarNota(ActionEvent event) {
    }

    @FXML
    private void clicBtnQuitarNota(ActionEvent event) {
    }

    @FXML
    private void clicBtnRegistrarAcuerdo(ActionEvent event) {
    }

    @FXML
    private void clicBtnQuitarAcuerdo(ActionEvent event) {
    }

    @FXML
    private void clicBtnRegistrarPendiente(ActionEvent event) {
    }

    @FXML
    private void clicBtnQuitarPendiente(ActionEvent event) {
    }

    @FXML
    private void clicBtnAceptar(ActionEvent event) {
    }

    @FXML
    private void clicBtnCancelar(ActionEvent event) {
        if(confirmarAlerta("Confirmación", "¿Está seguro que desea cancelar la Minuta?").toString() == "OK_DONE"){
          changeWindow("FXMLPrincipal.fxml", event);
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
