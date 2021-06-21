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
import java.util.Optional;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
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
    private TableView<Acuerdo> tbAcuerdos;
    @FXML
    private TableColumn colAcuerdoDescripcion;
    @FXML
    private TableColumn colAcuerdoFecha;
    @FXML
    private TableColumn colAcuerdoResponsable;

    @FXML
    private TableColumn colNotaDescripcion;
    @FXML
    private TableColumn colPendienteDescripcion;
    @FXML
    private TableView<Nota> tbNotas;
    @FXML
    private TableView<Pendiente> tbPendientes;
    
    private ObservableList<Integrante> integrantes;
    private ObservableList<Reunion> reuniones;
    private ObservableList<Acuerdo> acuerdos;
    private ObservableList<Nota> notas;
    private ObservableList<Pendiente> pendientes;
    
    private int idReunion;
    @FXML
    private Button btnRegistrarNota;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        integrantes = FXCollections.observableArrayList(); //Un array para mostrar en ComboBox
        reuniones = FXCollections.observableArrayList();
        acuerdos = FXCollections.observableArrayList();
        
        cargaReuniones();
        cargaIntegrantes();
        
        this.colAcuerdoDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.colAcuerdoFecha.setCellValueFactory(new PropertyValueFactory("fecha"));
        this.colAcuerdoResponsable.setCellValueFactory(new PropertyValueFactory("responsable"));
        
        cbReunion.valueProperty().addListener(new ChangeListener<Reunion>(){
            
            @Override 
            public void changed(ObservableValue<? extends Reunion> observable, Reunion oldValue, Reunion newValue){
                if(newValue != null){
                    tfDescripcion.setDisable(false);
                    dpFecha.setDisable(false);
                    cbResponsable.setDisable(false);
                    
                }
            }
        });
        
        
    }

    private void cargaReuniones(){
        reuniones.addAll(ReunionDAO.getAllReuniones());
        cbReunion.setItems(reuniones);
        System.out.println("Cargamos reuniones");
    }
    private void cargaIntegrantes(){
        integrantes.addAll(IntegranteDAO.getAllIntegrantes());
        cbResponsable.setItems(integrantes);
        System.out.println("Cargamos integrantes");
       
    }
    
    private void cargaAcuerdos(){
        ArrayList<Acuerdo> acuerdosResp = AcuerdoDAO.getAcuerdosByIdMinuta(idReunion);
        acuerdos.addAll(acuerdosResp);
        tbAcuerdos.setItems(acuerdos);
    }
    
    public void actualizarTabla() {
        //se actualizan valores de la tabla
        tbAcuerdos.getItems().clear();
        cargaAcuerdos();
        System.out.println("actualizamos tabla");
    }

    

    @FXML
    private void clicBtnRegistrarAcuerdo(ActionEvent event) {
        if(validarReunion()){
            if(validarCampos()){
                String descripcion = tfDescripcion.getText();
                String fecha = dpFecha.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String responsable = cbResponsable.getValue().getNombre();
                idReunion = cbReunion.getValue().getIdReunion();
                
                Acuerdo acuTemporal = new Acuerdo();
                acuTemporal.setDescripcion(descripcion);
                acuTemporal.setFecha(fecha);
                acuTemporal.setResponsable(responsable);
                acuTemporal.setIdMinuta(idReunion);
                guardarAcuerdo(acuTemporal);
                System.out.println("creamos un acuerdo");
                
                //cargaAcuerdos();
                actualizarTabla();
            }else{
                mostrarAlerta("Campo vacio", "Error, campos existentes sin completar");
            }
        }else{
            mostrarAlerta("Reunion vacia", "Error, seleccione una reunion para continuar");
        }
       
    }

    @FXML
    private void clicBtnQuitarAcuerdo(ActionEvent event) {
        if(confirmarAlerta("Confirmación", "¿Está seguro que desea quitar el acuerdo?").toString() == "OK_DONE"){
            //Aqui debe ir un delet
            int filaSeleccion = tbAcuerdos.getSelectionModel().getSelectedIndex();
            if(filaSeleccion >=0){
                Acuerdo acuerdoSeleccion = acuerdos.get(filaSeleccion); //recupera el alumno de la tb
                AcuerdoDAO.eliminarAcuerdo(acuerdoSeleccion.getIdAcuerdo());
                actualizarTabla();
            }else{
                mostrarAlerta("Sin seleccion", "Error, seleccione un acuerdo de la tabla");
            }
    }
        
           
    }


    @FXML
    private void clicBtnAceptar(ActionEvent event) {
        changeWindow("FXMLPrincipal.fxml", event);           
    } 

    @FXML
    private void clicBtnCancelar(ActionEvent event) {
        if(confirmarAlerta("Confirmación", "¿Está seguro que desea cancelar la Minuta?").toString() == "OK_DONE"){
          changeWindow("FXMLPrincipal.fxml", event);
        }
    }
    
    private ButtonBar.ButtonData mostrarAlerta(String titulo, String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
        
        return alert.getResult().getButtonData();
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
    
    private boolean validarCampos() {     
        if(tfDescripcion.getText().equals(""))
            return false;
        if(dpFecha.getValue() == null)
            return false;
        if(cbResponsable.getValue() == null)
            return false;
        
        return true;
    }
    private boolean validarReunion(){
        if(cbReunion.getValue() == null){
            return false;
        }
        return true;
    }

    @FXML
    private void clicBtnRegistrarNota(ActionEvent event) {
        //irPantallaNota();
        System.out.println("entra al boton");
        changeWindow("FXMLRegistrarNota.fxml", event);
       
    }

    @FXML
    private void clicBtnQuitarNota(ActionEvent event) {
    }

    @FXML
    private void clicBtnRegistrarPendiente(ActionEvent event) {
    }

    @FXML
    private void clicBtnQuitarPendiente(ActionEvent event) {
    }
    
    private void irPantallaNota(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRegistrarNota.fxml"));
            Parent root = loader.load();
            
       
            //FXMLRegistrarNotaController controladorFormulario = loader.getController();
            //controladorFormulario.inicializarValores(this); //esto es clave
            
            Scene sceneForm = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(sceneForm);
            stage.show();
            //stage.initModality(Modality.APPLICATION_MODAL);
            Stage myStage = (Stage) this.btnRegistrarNota.getScene().getWindow();
            myStage.close();
            
        }catch (IOException ex){
            System.out.println("Error "+ex.getMessage());
        }
    }
}
