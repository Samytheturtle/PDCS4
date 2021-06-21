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
import modelo.pojo.Reunion;

/**
 *
 * @author Lenovo
 */
public class ReunionDAO {
    public static ArrayList<Reunion> getAllReuniones(){
        ArrayList<Reunion> reuniones = new ArrayList<>();
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "SELECT * FROM reunion WHERE idMinuta IS null";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    Reunion reu = new Reunion();
                    reu.setIdReunion(resultado.getInt("idReunion"));
                    reu.setAsunto(resultado.getString("asunto"));
                    reu.setIdMinuta(resultado.getInt("idMinuta"));
                    //System.out.println("Asunto reunion: "+reu.getAsunto());
                    reuniones.add(reu);
                }
                conn.close();
            }catch(SQLException e){
                System.out.println("ERROR: "+e.getMessage());
                e.printStackTrace();
            }
        }
        return reuniones;
    }
    
    public static void actualizarReunion(Reunion reunion){
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "UPDATE acuerdo SET idMinuta = ?;";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setInt(1, reunion.getIdMinuta());
                
                ps.executeUpdate();
                conn.close();
            }catch(SQLException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
}
