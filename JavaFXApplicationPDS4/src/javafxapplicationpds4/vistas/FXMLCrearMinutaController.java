/*
Nombre del archivo: FXMLCrearMinutaController.java

Nombre del programador: Kevin Moncayo

Fecha de creación: 7 de junio del 2021

Fecha de Edición: 17 de junio del 2021

Propósito: controlador que contiene el codigo con la informacion para crear una minuta y almancenarla en una
base de datos

Descripción de última edición: Se optimizo y redujo el tiempo de respuesta.

 */
package javafxapplicationpds4.vistas;

import interfaz.NotificaCambios;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
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
import static modelo.DAO.AcuerdoDAO.cancelarAcuerdos;
import static modelo.DAO.AcuerdoDAO.guardarAcuerdo;
import modelo.DAO.IntegranteDAO;
import modelo.DAO.NotaDAO;
import static modelo.DAO.NotaDAO.cancelarNotas;
import modelo.DAO.PendienteDAO;
import static modelo.DAO.PendienteDAO.cancelarPendientes;
import modelo.DAO.ReunionDAO;
import static modelo.DAO.ReunionDAO.actualizarReunion;
import modelo.pojo.Acuerdo;
import modelo.pojo.Integrante;
import modelo.pojo.Nota;
import modelo.pojo.Pendiente;
import modelo.pojo.Reunion;


public class FXMLCrearMinutaController implements Initializable, NotificaCambios {

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
    public int idReunion;
    
    @FXML
    private Button btnRegistrarNota;
    @FXML
    private Button btnQuitarNota;
    @FXML
    private Button btnRegistrarAcuerdo;
    @FXML
    private Button btnQuitarAcuerdo;
    @FXML
    private Button btnRegistrarPendiente;
    @FXML
    private Button btnQuitarPendiente;
    @FXML
    private Button btnAceptar;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        integrantes = FXCollections.observableArrayList(); //Un array para mostrar en ComboBox
        reuniones = FXCollections.observableArrayList();
        acuerdos = FXCollections.observableArrayList();
        notas = FXCollections.observableArrayList();
        pendientes = FXCollections.observableArrayList();
        
        cargaReuniones();
        cargaIntegrantes();
        
        this.colAcuerdoDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion")); //
        this.colAcuerdoFecha.setCellValueFactory(new PropertyValueFactory("fecha"));
        this.colAcuerdoResponsable.setCellValueFactory(new PropertyValueFactory("responsable"));
        
        this.colNotaDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        this.colPendienteDescripcion.setCellValueFactory(new PropertyValueFactory("descripcion"));
        
        
        cbReunion.valueProperty().addListener(new ChangeListener<Reunion>(){
            
            @Override 
            public void changed(ObservableValue<? extends Reunion> observable, Reunion oldValue, Reunion newValue){
                if(newValue != null){
                    habilitarFunciones(); //Habilitamos los campos y botones que estan desabilitados hasta seleccionar una reunion.
                    idReunion = cbReunion.getValue().getIdReunion();
                    cbReunion.setDisable(true);
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
        integrantes.clear();
        integrantes.addAll(IntegranteDAO.getAllIntegrantes());
        cbResponsable.setItems(integrantes);
        System.out.println("Cargamos integrantes");
    }
    
    private void cargaAcuerdos(){
        tbAcuerdos.getItems().clear();
        ArrayList<Acuerdo> acuerdosResp = AcuerdoDAO.getAcuerdosByIdMinuta(idReunion);
        acuerdos.addAll(acuerdosResp);
        tbAcuerdos.setItems(acuerdos);
    }
    private void cargaNotas(){
        tbNotas.getItems().clear();
        ArrayList<Nota> notasResp = NotaDAO.getNotasByIdMinuta(idReunion);
        notas.addAll(notasResp);
        tbNotas.setItems(notas);
    }
    private void cargaPendientes(){
        tbPendientes.getItems().clear();
        ArrayList<Pendiente> pendienteResp = PendienteDAO.getPendientesByIdMinuta(idReunion);
        pendientes.addAll(pendienteResp);
        tbPendientes.setItems(pendientes);
    }
    
    
    public void actualizarTabla() {
        cargaAcuerdos();
        cargaNotas();
        cargaPendientes();
        System.out.println("actualizamos tabla");
    }

    

    @FXML
    private void clicBtnRegistrarAcuerdo(ActionEvent event) {
        if(validarReunion()){
            if(validarCampos()){
                String descripcion = tfDescripcion.getText();
                String fecha = dpFecha.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String responsable = cbResponsable.getValue().getNombre();
                
                
                Acuerdo acuTemporal = new Acuerdo();
                acuTemporal.setDescripcion(descripcion);
                acuTemporal.setFecha(fecha);
                acuTemporal.setResponsable(responsable);
                acuTemporal.setIdMinuta(idReunion);
                guardarAcuerdo(acuTemporal);
                System.out.println("creamos un acuerdo");
                limpiarCampos();
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
        
        if(confirmarAlerta("Confirmación", "¿Se creara la minuta y no podra agregar mas, esta seguro?").toString() == "OK_DONE"){
            actualizarReunion(idReunion);
            Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            currentStage.close();
          
        }
    } 

    @FXML
    private void clicBtnCancelar(ActionEvent event) {
        if(confirmarAlerta("Confirmación", "¿Está seguro que desea cancelar la Minuta?").toString() == "OK_DONE"){
          limpiarMinuta();
          Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
          currentStage.close();
          
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
    private void habilitarFunciones(){
        btnAceptar.setDisable(false);
        tfDescripcion.setDisable(false);
        dpFecha.setDisable(false);
        cbResponsable.setDisable(false);
        btnRegistrarAcuerdo.setDisable(false);
        btnRegistrarNota.setDisable(false);
        btnRegistrarPendiente.setDisable(false);
        btnQuitarAcuerdo.setDisable(false);
        btnQuitarNota.setDisable(false);
        btnQuitarPendiente.setDisable(false);
    }
    private void limpiarCampos(){
        tfDescripcion.setText("");
        dpFecha.setValue(null);
        cargaIntegrantes();
        
    }
    private void limpiarMinuta(){
        cancelarAcuerdos(idReunion);
        cancelarNotas(idReunion);
        cancelarPendientes(idReunion);
    }

    @FXML
    private void clicBtnRegistrarNota(ActionEvent event) {
        irPantallaNota(idReunion);
        System.out.println("entra al boton");
    }

    @FXML
    private void clicBtnQuitarNota(ActionEvent event) {
        if(confirmarAlerta("Confirmación", "¿Está seguro que desea quitar la nota?").toString() == "OK_DONE"){
            //Aqui debe ir un delet
            int filaSeleccion = tbNotas.getSelectionModel().getSelectedIndex();
            if(filaSeleccion >=0){
                Nota notaSeleccion = notas.get(filaSeleccion);
                NotaDAO.eliminarNota(notaSeleccion.getIdNota());
                actualizarTabla();
            }else{
                mostrarAlerta("Sin seleccion", "Error, seleccione una nota de la tabla");
            }
         }
    }

    @FXML
    private void clicBtnRegistrarPendiente(ActionEvent event) {
        irPantallaPendiente(idReunion);
    }

    @FXML
    private void clicBtnQuitarPendiente(ActionEvent event) {
        if(confirmarAlerta("Confirmación", "¿Está seguro que desea quitar el pendiente?").toString() == "OK_DONE"){
            int filaSeleccion = tbPendientes.getSelectionModel().getSelectedIndex();
            if(filaSeleccion >=0){
                Pendiente pendienteSeleccion = pendientes.get(filaSeleccion);
                PendienteDAO.eliminarPendiente(pendienteSeleccion.getIdPendiente());
                actualizarTabla();
            }else{
                mostrarAlerta("Sin seleccion", "Error, seleccione una nota de la tabla");
            }
         }
    }
    
    private void irPantallaNota(int idReunion){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRegistrarNota.fxml"));
            Parent root = loader.load();
            
            //
            FXMLRegistrarNotaController controladorFormulario = loader.getController();
            controladorFormulario.inicializarValores(this, idReunion); //envia el idReunion y la interfaz al controller
            //
            
            Scene sceneForm = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(sceneForm);
            stage.show();
            
            Stage myStage = (Stage) this.btnRegistrarNota.getScene().getWindow();
            stage.initModality(Modality.APPLICATION_MODAL);
            myStage.close();
            
        }catch (IOException ex){
            System.out.println("Error "+ex.getMessage());
        }
    }
    private void irPantallaPendiente(int idReunion){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRegistrarPendiente.fxml"));
            Parent root = loader.load();
            
            //
            FXMLRegistrarPendienteController controladorFormulario = loader.getController();
            controladorFormulario.inicializarValores(this, idReunion); //envia el idReunion y la interfaz al controller
            //
            
            Scene sceneForm = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(sceneForm);
            stage.show();
            
            Stage myStage = (Stage) this.btnRegistrarPendiente.getScene().getWindow();
            stage.initModality(Modality.APPLICATION_MODAL);
            myStage.close();
        }catch(IOException ex){
            System.out.println("Error "+ex.getMessage());
        }
    }

    
}
