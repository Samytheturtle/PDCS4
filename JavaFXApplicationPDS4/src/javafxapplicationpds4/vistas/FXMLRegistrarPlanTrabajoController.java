/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationpds4.vistas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modelo.DAO.IntegranteDAO;
import modelo.DAO.LGAC_DAO;
import modelo.DAO.MetaDAO;
import modelo.DAO.PlantrabajoDAO;
import modelo.DAO.PrototipoDAO;
import modelo.DAO.ProyectoDeInvestigacionDAO;
import modelo.pojo.Integrante;
import modelo.pojo.LGAC;
import modelo.pojo.Meta;
import modelo.pojo.Plantrabajo;
import modelo.pojo.Prototipo;


/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLRegistrarPlanTrabajoController implements Initializable {

    @FXML
    private TextField ltobjetivo;
    @FXML
    private TextField ltplaneacion;
    @FXML
    private TextField ltmeta;
    @FXML
    private TextField ltacciones;
    @FXML
    private TextField ltfechaconclucion;
    @FXML
    private TextField ltresponsable;
    @FXML
    private TextField ltrecurso;
    @FXML
    private TableView<Meta> tbmetascreadas;
    @FXML
    private TableView<?> tbaccionescreadas;
    
    private ObservableList<Meta> vimetas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   /* private boolean validarCampos() {     

    }*/
    @FXML
    private void clicGuardarTodo(ActionEvent event) {
 
      
    }

    @FXML
    private void clicCancelarTodo(ActionEvent event) {
        changeWindow("FXMLPrincipal.fxml", event);
    }
    @FXML
    private void clicGuardarAcciones(ActionEvent event) {
    }
    @FXML
    private void clicBorrarAccion(ActionEvent event) {
    }
    @FXML
    private void clicguardarMeta(ActionEvent event) {
 
    }
   /* private void clicBorrarMeta(ActionEvent event) {
        int filaSeleccion=tbmetascreadas.getSelectionModel().getSelectedIndex();
        if(filaSeleccion >=0){
            Meta meta = vimetas.get(filaSeleccion);
            Optional<ButtonType> respDialogo = muestramuestraDialogo("Eliminar registro","Estas seguro de Eliminar la meta: "+meta.getnombre()+" ",Alert.AlertType.CONFIRMATION);
            if()
        }else{
            muestraDialogo("Sin seleccion","Para eliminar una meta debes de seleccionarlo de la tabla...",Alert.AlertType.NONE);
        }
        
    }*/
    private void muestraDialogo(String titulo, String mensaje, Alert.AlertType tipo){
        Alert dialogo = new Alert(tipo);
        dialogo.setTitle(titulo);
        dialogo.setHeaderText(null);
        dialogo.setContentText(mensaje);
        dialogo.showAndWait();
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
    
      private void mostrarAlert(String titulo, String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
     }

    @FXML
    private void clicCancelarMeta(ActionEvent event) {
    }

    @FXML
    private void clicAsociarAcciones(ActionEvent event) {
        String objetivo = ltobjetivo.getText();
        String planeacion = ltplaneacion.getText(); 
        boolean validarcampos=true;
        if(ltobjetivo.getText().equals(""))
            validarcampos=false;
        if(ltplaneacion.getText().equals(""))
            validarcampos=false;
        
        if(validarcampos){
            Plantrabajo plan = new Plantrabajo(objetivo,planeacion);
            PlantrabajoDAO.insert(plan);
        }else{          
            mostrarAlert("Error campos vacios en plan de trabajo", "reintentar", Alert.AlertType.ERROR);
        }
        

        //meta
        String nombre = ltmeta.getText();
    
        //int idPlantrabajo=PlantrabajoDAO.getidPlan();
        //aqui validacion si es diferente a -1 el get selected index
        //ValidacionCampos()     
        if(ltmeta.getText().equals(""))
           validarcampos=false;
        if(ltobjetivo.getText().equals(""))
            validarcampos=false;
        if(ltplaneacion.getText().equals(""))
            validarcampos=false;
        if(validarcampos){
            Meta meta = new Meta(nombre,1);
            MetaDAO.insert(meta);
        }else{
            mostrarAlert("Error campos vacios en plan de trabajo", "reintentar", Alert.AlertType.ERROR);
        }  
        if(validarcampos){
         ArrayList<Meta> metas = MetaDAO.getAllMetas();
         vimetas.addAll(metas);
         tbmetascreadas.setItems(vimetas);
        }
        

    }

    @FXML
    private void clicBorrarMeta(ActionEvent event) {
    }
}
