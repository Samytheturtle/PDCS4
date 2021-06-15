/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationpds4.vistas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
        integrantes.addAll();
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
    }
    
}
