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
import modelo.ConexionBD;
import modelo.pojo.Usuario;

/**
 *
 * @author Lenovo
 */
public class UsuarioDAO {
        public static Usuario getLogin(String username, String password){
        Usuario userLogin = null;
        Connection conn =  ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "SELECT * FROM usuario WHERE username = ? AND password = ?";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet resultado = ps.executeQuery();
                if(resultado.next()){
                    userLogin = new Usuario();
                    userLogin.setIdUsuario(resultado.getInt("idUsuario"));
                    userLogin.setNombre(resultado.getString("nombre"));
                    userLogin.setUsername(resultado.getString("username"));
                    userLogin.setTipo(resultado.getString("Tipo"));
                }
                conn.close();
            }catch(SQLException ex){
                ex.printStackTrace();
                
            }
        }
        return userLogin;
    }
}
