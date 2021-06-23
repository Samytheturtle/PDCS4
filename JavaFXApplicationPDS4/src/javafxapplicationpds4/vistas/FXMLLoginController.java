    /*
Nombre del archivo: LOGINController.java

Nombre del programador: Samuel Suarez Colin

Fecha de creación: 11/junio/2021

Fecha de Edición: 21/junio/2021

Propósito: Controlador para la navegacion por todos las interfases,

Descripción de última edición: Creacion del clicenven para detectar el tipo de acceso e
inhabilitar los botones por tipo de usuario *Sigue en desarrollo*


 */
package javafxapplicationpds4.vistas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.DAO.UsuarioDAO;
import modelo.pojo.Usuario;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private PasswordField tfPassword;
    @FXML
    private  TextField tfUsuario;
    @FXML
    private Label lbErrorUsuario;
    @FXML
    private Label lbErrorPassword;
    
    FXMLLoginController logincontroler;    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        logincontroler=this;
    }    
    @FXML
    private void clicBtnIniciar(ActionEvent event) throws IOException {
        lbErrorPassword.setText("");
        lbErrorUsuario.setText("");
        String  txUsuario =tfUsuario.getText();
        String  txPassword=tfPassword.getText();
    
        boolean isCorrecto = true;
        if(txUsuario.isEmpty()){
             lbErrorUsuario.setText("Campo requerido");
             isCorrecto = false;
        }
   
        if(txPassword.isEmpty()){
            lbErrorPassword.setText("Campo requerido");
            isCorrecto = false;
        }  
        if(isCorrecto){
            verificaUsuario(txUsuario, txPassword,event);
            
      }
    }
    
    private void verificaUsuario(String user, String password,Event event) throws IOException{
       Usuario userLogin = UsuarioDAO.getLogin(user, password);
        if(userLogin != null){
            String nombre = userLogin.getNombre();
            String tipo = userLogin.getTipo();
            mostrarAlert("Usuario encontrado", "Bienvenido "+tipo+" "+nombre+"  al sistema", Alert.AlertType.INFORMATION );
            PantallaPrincipal(event);    
        }else{
            mostrarAlert("Credenciales incorrectas","No existe el usuario, con las credenciales proporcionadas", Alert.AlertType.ERROR);
        }
    }

    private void mostrarAlert(String titulo, String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    private void PantallaPrincipal(Event event) throws IOException{
        Stage stageprincipal=new Stage();
        FXMLLoader loader =new FXMLLoader();
        System.out.println("PRUEBa");

  
        AnchorPane root = (AnchorPane)loader.load(getClass().getResource("FXMLPrincipal.fxml").openStream());
        FXMLPrincipalController instanciaPrincipal =(FXMLPrincipalController)loader.getController();
        instanciaPrincipal.recibirdatos(logincontroler,tfUsuario.getText());
        Scene scene=new Scene(root);
        stageprincipal.setScene(scene);
        stageprincipal.alwaysOnTopProperty();
        stageprincipal.initModality(Modality.APPLICATION_MODAL);
        stageprincipal.show();
        

        Stage currentStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        currentStage.close();
    }
    
}
