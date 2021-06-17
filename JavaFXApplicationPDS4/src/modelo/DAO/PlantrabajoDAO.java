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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConexionBD;
import modelo.pojo.Plantrabajo;

public class PlantrabajoDAO {
        public static void insert(Plantrabajo pt){
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String query = "insert into plantrabajo(planeacion, objetivo, idplantrabajo)"
                     + " values(?, ?, ?, ?, ?, ?, ?);";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, pt.getPlaneacion());
                preparedStatement.setString(2, pt.getobjetivo());
                preparedStatement.setInt(3, pt.getIdPlanTrabajo());
                 
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
}
