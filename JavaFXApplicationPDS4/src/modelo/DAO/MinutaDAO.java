/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ConexionBD;
import modelo.pojo.Minuta;

/**
 *
 * @author Lenovo
 */
public class MinutaDAO {
    public static ArrayList<Minuta> getAllMinutas(){
        ArrayList<Minuta> minutas = new ArrayList<>();
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "SELECT * FROM minuta";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    Minuta min = new Minuta();
                    min.setIdReunion(resultado.getInt("idReunion"));
                    min.setIdMinuta(resultado.getInt("idMinuta"));
                    
                    minutas.add(min);
                }
                conn.close();
            }catch(SQLException e){
                System.out.println("ERROR: "+e.getMessage());
                e.printStackTrace();
            }
        }
        return minutas;
    }
    
    public static Minuta guardarMinuta(Minuta minuta){
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "INSERT INTO minuta (idReunion) "
                        +"VALUES (?)";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setInt(1, minuta.getIdReunion());
                ps.executeUpdate();
            }catch(SQLException e){
                System.out.println("Error: "+e.getMessage());
                e.printStackTrace();
            }
        }
        return minuta;
    }
}
