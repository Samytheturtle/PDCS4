/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConexionBD;

import modelo.pojo.LGAC;

/**
 *
 * @author Lenovo
 */
public class Ca_Lgac {
     public static void insert(int idCA,List<LGAC> lgacs){
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                int cont = 0;
                while(cont < lgacs.size()){
                    LGAC aux = lgacs.get(cont);
                    System.out.println(aux);
                    String query = "insert into ca_lgac(idCa, idLgac) values(?, ?);";
                    
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setInt(1, idCA);
                    preparedStatement.setInt(2, aux.getId());
                    preparedStatement.executeUpdate();
                    
                    cont++;
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
    }
}
