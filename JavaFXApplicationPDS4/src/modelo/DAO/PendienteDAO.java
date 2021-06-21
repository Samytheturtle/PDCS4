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
import modelo.pojo.Nota;
import modelo.pojo.Pendiente;

/**
 *
 * @author Lenovo
 */
public class PendienteDAO {
    public static ArrayList<Pendiente> getPendientesByIdMinuta(int idMinuta){
        ArrayList<Pendiente> pendientes = new ArrayList<>();
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "SELECT * FROM pendiente WHERE idMinuta = ?;";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setInt(1, idMinuta);
                ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    Pendiente pe = new Pendiente();
                    pe.setDescripcion(resultado.getString("descripcion"));
                    pe.setIdMinuta(resultado.getInt("idMinuta"));
                    pe.setIdPendiente(resultado.getInt("idPendiente"));
                    pendientes.add(pe);
                }
                conn.close();
            }catch(SQLException e){
                System.out.println("ERROR: "+e.getMessage());
                e.printStackTrace();
            }
        }
        return pendientes;
    }
    
    public static void guardaPendiente(Pendiente pendiente){
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "INSERT INTO pendiente (descripcion, idMinuta) "
                        +"VALUES (?, ?);";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setString(1, pendiente.getDescripcion());
                ps.setInt(2, pendiente.getIdMinuta());
                
                ps.executeUpdate();
            }catch(SQLException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
}
