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

/**
 *
 * @author Lenovo
 */
public class IntegranteDAO {
    public static ArrayList<Integrante> getAllIntegrantes(){
        ArrayList<Integrante> integrantes = new ArrayList<>();
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "SELECT * FROM integrante";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    Integrante inte = new Integrante(resultado.getString("nombre"),
                        resultado.getString("programaEducativoImpacto"),
                        resultado.getString("telefono"),
                        resultado.getString("perfilPROMPEP"),
                        resultado.getString("nivelSNI"),
                        resultado.getString("iesGradoMaximo"),
                        resultado.getString("gradoMaximoEstudio"),
                        resultado.getString("curp"),
                        resultado.getString("correoElectronico"),
                        resultado.getString("cargo"),
                        resultado.getString("areaPerteneciente"),
                        resultado.getInt("idIntegrante"),
                        resultado.getString("Tipo"));
                    
                    integrantes.add(inte);
                }
                conn.close();
            }catch(SQLException e){
                System.out.println("ERROR: "+e.getMessage());
                e.printStackTrace();
            }
        }
        return integrantes;
    }
}
