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
import modelo.pojo.Acuerdo;

/**
 *
 * @author Lenovo
 */
public class AcuerdoDAO {
    public static ArrayList<Acuerdo> getAllReuniones(){
        ArrayList<Acuerdo> acuerdos = new ArrayList<>();
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "SELECT * FROM acuerdo";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    Acuerdo acu = new Acuerdo();
                    acu.setDescripcion(resultado.getString("descripcion"));
                    acu.setFecha(resultado.getString("fecha"));
                    acu.setResponsable(resultado.getString("responsable"));
                    acu.setIdMinuta(resultado.getInt("idMinuta"));
                    acu.setNumAcuerdo(resultado.getInt("numAcuerdo"));
                    acuerdos.add(acu);
                }
                conn.close();
            }catch(SQLException e){
                System.out.println("ERROR: "+e.getMessage());
                e.printStackTrace();
            }
        }
        return acuerdos;
    }
    
    public static void guardarAcuerdo(Acuerdo acuerdo){
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "INSERT INTO acuerdo (descripcion, fechaAcuerdo, responsable, idMinuta) "
                        +"VALUES (?, ?, ?, ?);";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setString(1, acuerdo.getDescripcion());
                ps.setString(2, acuerdo.getFecha());
                ps.setString(3, acuerdo.getResponsable());
                ps.setInt(4, acuerdo.getIdMinuta());
                ps.executeUpdate();
            }catch(SQLException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
}
