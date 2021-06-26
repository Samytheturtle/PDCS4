/*
Nombre del archivo: nombre del archivo

Nombre del programador: nombre del autor original

Fecha de creación: fecha de creación del código

Fecha de Edición: última fecha de edición del código

Propósito: objetivo del código escrito en el archivo

Descripción de última edición: Descripción de los últimos cambios realizados

 */
package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public class ConexionBD {
    private static String driver ="com.mysql.jdbc.Driver";
    private static String database = "guest";
    private static String hostname = "pds4-sistema-gestor.mysql.database.azure.com";
    private static String port = "3306";
    private static String url = "jdbc:mysql://"+hostname+":"+port+"/"+database+"?allowPublicKeyRetrieval";
    private static String username = "PDS4@pds4-sistema-gestor";
    private static String password = "15W30e45r1";

    public static Connection abrirConexionBD() {
        Connection conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: ¡Perdida de conexión con la base de datos");
            e.printStackTrace();
        }
        return conn;
    }

}
