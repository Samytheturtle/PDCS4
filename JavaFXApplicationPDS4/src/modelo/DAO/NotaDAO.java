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

/**
 *
 * @author Lenovo
 */
public class NotaDAO {
    public static ArrayList<Nota> getNotasByIdMinuta(int idMinuta){
        ArrayList<Nota> notas = new ArrayList<>();
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "SELECT * FROM nota WHERE idMinuta = ?;";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setInt(1, idMinuta);
                ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    Nota no = new Nota();
                    no.setDescripcion(resultado.getString("descripcion"));
                    no.setIdMinuta(resultado.getInt("idMinuta"));
                    no.setIdNota(resultado.getInt("idNota"));
                    notas.add(no);
                }
                conn.close();
            }catch(SQLException e){
                System.out.println("ERROR: "+e.getMessage());
                e.printStackTrace();
            }
        }
        return notas;
    }
    
    public static void guardaNota(Nota nota){
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "INSERT INTO nota (descripcion, idMinuta) "
                        +"VALUES (?, ?);";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setString(1, nota.getDescripcion());
                ps.setInt(2, nota.getIdMinuta());
                
                ps.executeUpdate();
                
                
            }catch(SQLException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
    
    public static void eliminarNota(int idNota){
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "DELETE FROM nota WHERE idNota = ?; ";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setInt(1, idNota);
                ps.executeUpdate();
               
                conn.close();
            }catch(SQLException e){
                System.out.println("Error: "+e.getMessage());
            }
        
        }
        
    }
}
