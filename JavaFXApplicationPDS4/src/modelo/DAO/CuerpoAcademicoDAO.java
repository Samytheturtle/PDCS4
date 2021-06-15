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
import modelo.pojo.CuerpoAcademico;

/**
 *
 * @author Lenovo
 */
public class CuerpoAcademicoDAO {
    public static void insert(CuerpoAcademico ca){
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String query = "insert into cuerpoacademico(nombre, area, idLGAC, disciplina, gradoConsolidacion, ies, clave)"
                     + " values(?, ?, ?, ?, ?, ?, ?);";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, ca.getNombre());
                preparedStatement.setString(2, ca.getArea());
                preparedStatement.setInt(3, ca.getIdLGAC());
                preparedStatement.setString(4, ca.getDisciplina());
                preparedStatement.setString(5, ca.getGradoConsolidacion());
                preparedStatement.setString(6, ca.getIes());
                preparedStatement.setString(7, ca.getClave());
                 
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
