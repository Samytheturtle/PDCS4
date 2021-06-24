/*
Nombre del archivo: AcuerdoDAO.java

Nombre del programador: Kevin Moncayo

Fecha de creación: 7 de junio del 2021

Fecha de Edición: 17 de junio del 2021

Propósito: este DAO prepara los metodos para recuperar los acuerdos, guardar, eliminar y cancelar.

Descripción de última edición: 

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
    public static ArrayList<Acuerdo> getAcuerdosByIdMinuta(int idMinuta){
        ArrayList<Acuerdo> acuerdos = new ArrayList<>();
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "SELECT * FROM acuerdo WHERE idMinuta = ?;";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setInt(1, idMinuta);
                ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    Acuerdo acu = new Acuerdo();
                    acu.setDescripcion(resultado.getString("descripcion"));
                    acu.setFecha(resultado.getString("fechaAcuerdo"));
                    acu.setResponsable(resultado.getString("responsable"));
                    acu.setIdMinuta(resultado.getInt("idMinuta"));
                    acu.setIdAcuerdo(resultado.getInt("idAcuerdo"));
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
    public static void eliminarAcuerdo(int idAcuerdo){
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "DELETE FROM acuerdo WHERE idAcuerdo = ?; ";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setInt(1, idAcuerdo);
                ps.executeUpdate();
               
                conn.close();
            }catch(SQLException e){
                System.out.println("Error: "+e.getMessage());
                
            }
        
        }
        
    }
    public static void cancelarAcuerdos(int idMinuta){
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "DELETE FROM acuerdo WHERE idMinuta = ?; ";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setInt(1, idMinuta);
                ps.executeUpdate();
               
                conn.close();
            }catch(SQLException e){
                System.out.println("Error: "+e.getMessage());
                
            }
        
        }
    }
  
    
}
