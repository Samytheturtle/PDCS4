/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationpds4.vistas;

import static java.awt.PageAttributes.MediaType.C;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.pojo.Accion;
import modelo.pojo.Meta;
import modelo.pojo.Plantrabajo;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLRegistrarPlanTrabajoController implements Initializable {

    @FXML
    private TextField ltxObjetivo;
    @FXML
    private TextField ltxPlaneacion;
    @FXML
    private TextField ltxNombremeta;
    @FXML
    private Button btmGuardarmeta;
    @FXML
    private TitledPane titlePanelAccion;
    @FXML
    private TextField ltxNombreAccion;
    @FXML
    private TextField ltxFechaConclucionAccion;
    @FXML
    private TextField ltxResponsableaccion;
    @FXML
    private TextField ltxRecursoaccion;
    @FXML
    private Button btmGuardarAccion;
    @FXML
    private Button btmCancelarAccion;
    @FXML
    private TableView<Meta> tbMetas;
    @FXML
    private Button btmBorrarMeta;
    @FXML
    private TableView<Accion> tbAcciones;
    @FXML
    private Button btmBorrarAccion;
    @FXML
    private Button btmTerminarPlan;
    @FXML
    private Button btmCancelarPlan;
    
    private Plantrabajo plan;

    private int banderaplanregister = 0;
    
    private ObservableList<Meta> metasAdd; 
    private ObservableList<Accion> accionAdd;
    @FXML
    private TableColumn colnombre;
    @FXML
    private TableColumn colnombreAccion;
    @FXML
    private TableColumn colfechaAccion;
    @FXML
    private TableColumn colresponsableAccion;
    @FXML
    private TableColumn colrecursoAccion;
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        metasAdd=FXCollections.observableArrayList();
        accionAdd=FXCollections.observableArrayList();
        
        this.colnombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
        this.colnombreAccion.setCellValueFactory(new PropertyValueFactory("Nombre"));
        this.colfechaAccion.setCellValueFactory(new PropertyValueFactory("Fecha conclusion"));
        this.colresponsableAccion.setCellValueFactory(new PropertyValueFactory("responsable"));
        this.colrecursoAccion.setCellValueFactory(new PropertyValueFactory("recurso"));
    }    

    @FXML
    private void ClicguardarMeta(ActionEvent event) {
    String txObjetivo =ltxObjetivo.getText();
    String txPlaneacion = ltxPlaneacion.getText();
    boolean estaVacio=false;
    if(txObjetivo.isEmpty()||txPlaneacion.isEmpty()){
        mostrarAlerta("Error", "Campos Vacios en planeacion o Objetivo");
        estaVacio=true;
    }  
    if(!estaVacio){
        String txnombremeta =ltxNombremeta.getText();
        if(!txnombremeta.isEmpty()){
            Meta metanew = new Meta(txnombremeta);
            if(banderaplanregister==0){
                plan= new Plantrabajo(txObjetivo,txPlaneacion,metanew);
                banderaplanregister++;
                cargarMetas();
            }else{
                plan.setMetas(txnombremeta);
                cargarMetas();
            }            
        }else{
          mostrarAlerta("Error", "Cree una meta para continuar");  
        }   
        
    }  

    }
    private void cargarMetas(){
        ArrayList<Meta> metas = new ArrayList<>();
        tbMetas.getItems().clear();
        for(int i=0;i<plan.getsize();i++){
            System.out.print(plan.getMetas(i)+"_"+i+"\n");
            //tbMetas.getItems().addAll(plan.getMetas(i));
            metas.add(plan.getMetas(i));  
        }
        ArrayList<Meta> metasrecu = metas;
        metasAdd.addAll(metasrecu);
        tbMetas.setItems(metasAdd);
        limpiarcampoMeta();
    }
    private void limpiarcampoMeta(){
        ltxNombremeta.setText("");
    }
    private void cargarAcciones(int seleccion){
        ArrayList<Accion> acciones = new ArrayList<>();
        tbAcciones.getItems().clear();
        for(int i=0;i<plan.getMetas(seleccion).getsize();i++){
            System.out.print(plan.getMetas(seleccion).getAccion(i)+"_"+i+"\n");
            //tbMetas.getItems().addAll(plan.getMetas(i));
            acciones.add(plan.getMetas(seleccion).getAccion(i));  
        }
        ArrayList<Accion> accionrecu = acciones;
        accionAdd.addAll(accionrecu);
        tbAcciones.setItems(accionAdd);
        limpiarcamposAccion();        
    }
    @FXML
    private void ClicguardarAccion(ActionEvent event) {
       String txnombre =ltxNombreAccion.getText();
       String txfechaconclusion = ltxFechaConclucionAccion.getText();
       String txresponsable= ltxResponsableaccion.getText();
       String txrecurso=ltxRecursoaccion.getText();
       boolean estaVacio=false;
       if(txnombre.isEmpty()||txfechaconclusion.isEmpty()||txresponsable.isEmpty()||txrecurso.isEmpty()){
            mostrarAlerta("Error", "Campos Vacios en Agregar Acciones");
           estaVacio=true;
       }else if(!estaVacio){
           int seleccion =tbMetas.getSelectionModel().getSelectedIndex();
           if(seleccion >=0){
               //Meta meta=tbMetas.getItems().get(seleccion);
              Accion accion= new Accion(txnombre, txfechaconclusion, txrecurso, txrecurso);
              plan.getMetas(seleccion).setAccion(accion);   
              limpiarcamposAccion();
              cargarAcciones(seleccion);
          }else{
              mostrarAlerta("Error", "Selecciona una meta para continuar");
           }        
       }        
    }
    private void limpiarcamposAccion(){
        ltxNombreAccion.setText("");
        ltxFechaConclucionAccion.setText("");
        ltxResponsableaccion.setText("");
        ltxRecursoaccion.setText("");
    }

    @FXML
    private void ClicCancelarAccion(ActionEvent event) {
        limpiarcamposAccion();
    }

    @FXML
    private void ClicBorrarMeta(ActionEvent event) {
    }

    @FXML
    private void ClicborrarAccion(ActionEvent event) {
    }

    @FXML
    private void ClicterminarPlandetrabajo(ActionEvent event) {
     mostrarAlerta("Se ha guardado el plan de trabajo", "Se ha guardado el Plan de trabajo");
    }

    @FXML
    private void CliccancelarPlan(ActionEvent event) {
        if("OK_DONE".equals(confirmarAlerta("Confirmación", "¿Está seguro que desea cancelar el registro?").toString())){
            //changeWindow("FXMLPrincipal.fxml", event);
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

    @FXML
    private void clicActualizarAcciones(ActionEvent event) {
        int seleccion =tbMetas.getSelectionModel().getSelectedIndex();
        if(seleccion>=0){
            cargarAcciones(seleccion);
        }else{
            mostrarAlerta("Error", "Selecciona una meta para continuar");
        }
            
    }
}
