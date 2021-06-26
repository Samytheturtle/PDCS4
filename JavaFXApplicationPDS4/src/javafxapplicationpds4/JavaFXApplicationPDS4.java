/*
Nombre del archivo: nombre del archivo

Nombre del programador: nombre del autor original

Fecha de creación: fecha de creación del código

Fecha de Edición: última fecha de edición del código

Propósito: objetivo del código escrito en el archivo

Descripción de última edición: Descripción de los últimos cambios realizados

 */
package javafxapplicationpds4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author samyt
 */
public class JavaFXApplicationPDS4 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
       //Parent root = FXMLLoader.load(getClass().getResource("vistas/FXMLRegistrarPlanTrabajo.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("vistas/FXMLLogin.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}