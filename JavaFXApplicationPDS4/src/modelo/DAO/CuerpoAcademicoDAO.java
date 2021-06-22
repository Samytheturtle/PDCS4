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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConexionBD;
import modelo.pojo.CuerpoAcademico;

/**
 *
 * @author Lenovo
 */
public class CuerpoAcademicoDAO {
    public static int insert(CuerpoAcademico ca){
        int lastId = 0;
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String query = "insert into cuerpoacademico(nombre, area, disciplina, gradoConsolidacion, ies, clave)"
                     + " values(?, ?, ?, ?, ?, ?);";
                PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, ca.getNombre());
                preparedStatement.setString(2, ca.getArea());
                preparedStatement.setString(3, ca.getDisciplina());
                preparedStatement.setString(4, ca.getGradoConsolidacion());
                preparedStatement.setString(5, ca.getIes());
                preparedStatement.setString(6, ca.getClave());
                 
                preparedStatement.executeUpdate();
                ResultSet resultado = preparedStatement.getGeneratedKeys();
                if(resultado.next()){
                    lastId = resultado.getInt(1);
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
        
        return lastId;
    }
}

