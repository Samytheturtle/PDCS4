/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConexionBD;
import modelo.pojo.Prototipo;

/**
 *
 * @author Lenovo
 */
public class PrototipoDAO {
    public static void insert(Prototipo proto){
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String query = "insert into prototipo(anio, autor, caracteristicas, estadoActual, institucionCreacion, nombrePrototipo, objetivo, pais, proposito, idProyecto, idLGAC)"
                     + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, proto.getAnio());
                preparedStatement.setString(2, proto.getAutor());
                preparedStatement.setString(3, proto.getCaracteristicas());
                preparedStatement.setString(4, proto.getEstadoActual());
                preparedStatement.setString(5, proto.getInstitucion());
                preparedStatement.setString(6, proto.getNompre());
                preparedStatement.setString(7, proto.getObjetivo());
                preparedStatement.setString(8, proto.getPais());
                preparedStatement.setString(9, proto.getProposito());
                preparedStatement.setInt(10, proto.getIdProyecto());
                preparedStatement.setInt(11, proto.getIdLgac());

                 
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
                    Logger.getLogger(PrototipoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
