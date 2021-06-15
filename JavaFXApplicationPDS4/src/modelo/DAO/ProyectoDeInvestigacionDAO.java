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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConexionBD;
import modelo.pojo.ProyectoDeInvestigacion;

/**
 *
 * @author Lenovo
 */
public class ProyectoDeInvestigacionDAO {
    public static ArrayList<ProyectoDeInvestigacion> getAll(){
        ArrayList<ProyectoDeInvestigacion> lista = new ArrayList<>();
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "SELECT * FROM proyectodeinvestigacion";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    ProyectoDeInvestigacion proyecto = new ProyectoDeInvestigacion(resultado.getInt("idProyecto"),
                        resultado.getString("nombrePatrocinador"),
                        resultado.getString("tipoPatrocinador"),
                        resultado.getString("fechaInicio"),
                        resultado.getString("fechaFin"),
                        resultado.getString("nombreProyecto"));
                    
                    lista.add(proyecto);
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
                    Logger.getLogger(ProyectoDeInvestigacion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lista;
    }
}
