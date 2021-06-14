/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
