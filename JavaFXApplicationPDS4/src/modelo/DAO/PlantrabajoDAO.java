/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

/**
 *
 * @author samyt
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConexionBD;
import modelo.pojo.LGAC;
import modelo.pojo.Plantrabajo;

public class PlantrabajoDAO {
        public static void insert(Plantrabajo pt){
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String query = "insert into plantrabajo(planeacion, objetivo)"
                     + " values(?, ?);";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, pt.getPlaneacion());
                preparedStatement.setString(2, pt.getobjetivo());
                 
                preparedStatement.executeUpdate();
            }
            catch(SQLException e){
                System.out.println("ERROR: "+e.getMessage());
                e.printStackTrace();
            }
            finally{
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LGAC_DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static ArrayList<Plantrabajo> getidPlan(){
        ArrayList<Plantrabajo> lista = new ArrayList<>();
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "SELECT * FROM plantrabajo";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    Plantrabajo lgac = new Plantrabajo(resultado.getString("objetivo"),
                        resultado.getString("planeacion"),
                        resultado.getInt("idplanTrabajo"));
                    
                    lista.add(lgac);
                }
            }
            catch(SQLException e){
                System.out.println("ERROR: "+e.getMessage());
                e.printStackTrace();
            }
            finally{
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(LGAC_DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }
}
