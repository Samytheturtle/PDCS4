/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplicationpds4.vistas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
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
    private TextField tfEstadoActual;
    @FXML
    private TextField tfPais;
    @FXML
    private ListView<?> listLGAC;
    @FXML
    private ListView<?> listProyecto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
