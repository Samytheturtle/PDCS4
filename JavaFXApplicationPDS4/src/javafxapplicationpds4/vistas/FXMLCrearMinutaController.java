/*
Nombre del archivo: nombre del archivo

Nombre del programador: KevinMoncayo

Fecha de creación: 7 de junio del 2021

Fecha de Edición: 17 de junio del 2021

Propósito: controlador que contiene el codigo con la informacion para crear una minuta y almancenarla en una
base de datos

Descripción de última edición: 

 */
package javafxapplicationpds4.vistas;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.DAO.AcuerdoDAO;
import static modelo.DAO.AcuerdoDAO.guardarAcuerdo;
import modelo.DAO.IntegranteDAO;
import modelo.DAO.MinutaDAO;
import static modelo.DAO.MinutaDAO.guardarMinuta;
import modelo.DAO.ReunionDAO;
import modelo.pojo.Acuerdo;
import modelo.pojo.Integrante;
import modelo.pojo.Minuta;
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
    private ObservableList<Minuta> minutas;
    private ObservableList<Acuerdo> acuerdos;
    int idMinu;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        integrantes = FXCollections.observableArrayList(); //Un array para mostrar en ComboBox
        reuniones = FXCollections.observableArrayList();
        minutas = FXCollections.observableArrayList();
        acuerdos = FXCollections.observableArrayList();
        cargaReuniones();
        cargaIntegrantes();
        this.colAcuerdoId.setCellValueFactory(new PropertyValueFactory("numAcuerdo"));
        this.colAcuerdoDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.colAcuerdoFecha.setCellValueFactory(new PropertyValueFactory("fecha"));
        this.colAcuerdoResponsable.setCellValueFactory(new PropertyValueFactory("responsable"));
        
        cbReunion.valueProperty().addListener(new ChangeListener<Reunion>(){
            
            @Override 
            public void changed(ObservableValue<? extends Reunion> observable, Reunion oldValue, Reunion newValue){
                if(newValue != null){
                    //System.out.println("La facultad seleccionada es: ID "+newValue.getIdFacultad()+" Nombre: "+newValue.getNombre());
                    minutaTest();
                    cargaMinutas();
                    //cargaAcuerdos();
                }
            }
        });
        
        
    }

    private void cargaReuniones(){
        reuniones.addAll(ReunionDAO.getAllReuniones());
        cbReunion.setItems(reuniones);
    }
    private void cargaIntegrantes(){
        integrantes.addAll(IntegranteDAO.getAllIntegrantes());
        cbResponsable.setItems(integrantes);
    }
    private void cargaMinutas(){
        minutas.addAll(MinutaDAO.getAllMinutas());
        idMinu = minutas.size();
    }
    private void cargaAcuerdos(){
        ArrayList<Acuerdo> acuerdosResp = AcuerdoDAO.getAcuerdosByIdMinuta(idMinu);
        acuerdos.addAll(acuerdosResp);
        tbAcuerdos.setItems(acuerdos);
    }
    
    public void actualizarTabla() {
        //se actualizan valores de la tabla
        tbAcuerdos.getItems().clear();
        cargaAcuerdos();
    }

    private void minutaTest(){
        int idReunion = cbReunion.getValue().getIdReunion();
        Minuta minTemporal = new Minuta();
        //Minuta minAux = new Minuta();
        minTemporal.setIdReunion(idReunion);
        guardarMinuta(minTemporal); //Aqui creamos la minuta temporal
        System.out.println(idReunion);
        
    }

    @FXML
    private void clicBtnRegistrarAcuerdo(ActionEvent event) {
        //minutaTest();
        System.out.println(cbReunion.getValue().getIdReunion());
        String descripcion = tfDescripcion.getText();
        String fecha = dpFecha.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String responsable = cbResponsable.getValue().getNombre();
        //int idMinuta = test.getIdMinuta();
        Acuerdo acuTemporal = new Acuerdo();
        acuTemporal.setDescripcion(descripcion);
        acuTemporal.setFecha(fecha);
        acuTemporal.setResponsable(responsable);
        acuTemporal.setIdMinuta(idMinu);
        guardarAcuerdo(acuTemporal);
        System.out.println("si entra"+descripcion+fecha+responsable+idMinu);
        cargaAcuerdos();
        actualizarTabla();
    }

    @FXML
    private void clicBtnQuitarAcuerdo(ActionEvent event) {
    }


    @FXML
    private void clicBtnAceptar(ActionEvent event) {
        
        
        
        
    } 

    @FXML
    private void clicBtnCancelar(ActionEvent event) {
        if(confirmarAlerta("Confirmación", "¿Está seguro que desea cancelar la Minuta?").toString() == "OK_DONE"){
            //Aqui debe ir un delet
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
