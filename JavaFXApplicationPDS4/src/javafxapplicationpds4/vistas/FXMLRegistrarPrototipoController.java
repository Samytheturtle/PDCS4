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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.DAO.IntegranteDAO;
import modelo.DAO.LGAC_DAO;
import modelo.DAO.ColaboradorDAO;
import modelo.DAO.PrototipoDAO;
import modelo.DAO.Prototipo_integrantes;
import modelo.DAO.Prototipo_colaborador;
import modelo.DAO.ProyectoDeInvestigacionDAO;
import modelo.pojo.Integrante;
import modelo.pojo.LGAC;
import modelo.pojo.Colaborador;
import modelo.pojo.Prototipo;
import modelo.pojo.ProyectoDeInvestigacion;

/**
 *
 * @author Lenovo
 */
public class FXMLRegistrarPrototipoController implements Initializable {

    @FXML
    private TextField tfTitulo;
    @FXML
    private TextField tfAnio;
    @FXML
    private TextField tfAutor;
    @FXML
    private TextField tfCaracteristicas;
    @FXML
    private TextField tfInstitucion;
    @FXML
    private TextField tfObjetivo;
    @FXML
    private TextField tfProposito;
    @FXML
    private TextField tfPais;
    @FXML
    private ComboBox<LGAC> cboxLgac;
    @FXML
    private ComboBox<ProyectoDeInvestigacion> cboxProyecto;
    @FXML
    private ComboBox<String> cboxEstado;
    @FXML
    private TableView<Integrante> tbIntegrantes;
    @FXML
    private TableView<Colaborador> tbColaboradores;
    @FXML
    private TableColumn<Integrante, String> cNombreInt;
    @FXML
    private TableColumn<Integrante, String> cTipoInt;
    @FXML
    private TableColumn<Colaborador, String> cNombreCol;
    @FXML
    private TableColumn<Colaborador, String> cTipoCol;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    
    private ObservableList<Integrante> obsIntegrantes;
    private ObservableList<Colaborador> obsColaboradores;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        obsIntegrantes = FXCollections.observableArrayList();
        obsColaboradores = FXCollections.observableArrayList();;
        
        cboxEstado.getItems().addAll("Publicado", "Sin publicar", "Otro");
        cboxLgac.getItems().addAll(LGAC_DAO.getAll());
        cboxProyecto.getItems().addAll(ProyectoDeInvestigacionDAO.getAll());
        
        cNombreInt.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cTipoInt.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        obsIntegrantes.addAll(IntegranteDAO.getAllIntegrantes());
        tbIntegrantes.setItems(obsIntegrantes);
        tbIntegrantes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        cNombreCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));        
        cTipoCol.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        obsColaboradores.addAll(ColaboradorDAO.getAll());
        tbColaboradores.setItems(obsColaboradores);
        tbColaboradores.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
    }    

    @FXML
    private void clicBtnGuardar(ActionEvent event) { 
        String anio = tfAnio.getText();
        String autor = tfAutor.getText();
        String caracteristicas = tfCaracteristicas.getText();
        String institucion = tfInstitucion.getText();
        String nombre = tfTitulo.getText();
        String objetivo = tfObjetivo.getText();
        String pais = tfPais.getText();
        String proposito = tfProposito.getText();
        
        if(cboxLgac.getValue() == null || cboxProyecto.getValue() == null || cboxEstado == null){
            mostrarAlerta("Campo vacio", "Error, campos existentes sin completar");
        }
        else {
            int lgac = cboxLgac.getValue().getId();
            int proyecto = cboxProyecto.getValue().getId();
            String estado = cboxEstado.getValue().toString();
            
            List<Integrante> integranteSelec = tbIntegrantes.getSelectionModel().getSelectedItems();
            List<Colaborador> colaboradoresSelec = tbColaboradores.getSelectionModel().getSelectedItems();

            if(integranteSelec.isEmpty() || colaboradoresSelec.isEmpty()){
                mostrarAlerta("Falta seleccion", "Por favor, seleccione al menos un integrante y un colaborador");
            }
            else{
                if(validarCampos()){
                    if(tfAnio.getText().matches("^[0-9]*$")){
                        Prototipo proto = new Prototipo(anio, autor, caracteristicas, estado, institucion, nombre, objetivo, pais, proposito, lgac, proyecto);
                        int idProto = PrototipoDAO.insert(proto);
                        Prototipo_integrantes.insert(idProto, integranteSelec);
                        Prototipo_colaborador.insert(idProto, colaboradoresSelec);

                        mostrarAlerta("Se ha guardado el prototipo", "Se ha guardado el prototipo");
                        changeWindow("FXMLPrincipal.fxml", event);
                    }
                    else{
                        mostrarAlerta("Error", "El atributo año acepta solo numeros");
                    }
                }
                else{
                    mostrarAlerta("Campo vacio", "Error, campos existentes sin completar");
                } 
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

    private boolean validarCampos() {     
        if(tfTitulo.getText().equals("") || tfTitulo.getText().length() > 149)
            return false;
        if(tfAnio.getText().equals("")  || tfAnio.getText().length() > 99)
            return false;
        if(tfAutor.getText().equals("")  || tfAutor.getText().length() > 99)
            return false;
        if(tfCaracteristicas.getText().equals("")  || tfCaracteristicas.getText().length() > 249)
            return false;
        if(tfInstitucion.getText().equals("") || tfInstitucion.getText().length() > 149)
            return false;
        if(tfObjetivo.getText().equals("") || tfObjetivo.getText().length() > 249)
            return false;
        if(tfProposito.getText().equals("") || tfProposito.getText().length() > 249)
            return false;
        if(tfPais.getText().equals("") || tfPais.getText().length() > 99)
            return false;
        
        return true;
    }
    
}

