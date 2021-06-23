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
import modelo.pojo.Integrante;
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
                String consulta = "SELECT usuario.*,integrante.Tipo FROM usuario Inner join integrante on usuario.idIntegrante = integrante.idIntegrante WHERE  username = ? AND PASSWORD = ?";
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
    public static Usuario getAllIntegrantes(String username){
        Usuario userLogin = null;
        Connection conn =  ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "SELECT usuario.*,integrante.Tipo FROM usuario  INNER JOIN integrante ON usuario.idIntegrante = integrante.idIntegrante WHERE username = ?";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setString(1, username);
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
                System.err.println("ERROR AQui");
                ex.printStackTrace();
                
            }
        }
        return userLogin;
    }
}
