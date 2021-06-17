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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConexionBD;
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
    public static int getidPlan(){
        int metas=0;
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "SELECT select MAX(idPlanTrabajo) from plantrabajo;";
                //String consulta = "SELECT idAlumno, alumno.nombre, apellidos, matricula, email, alumno.idCarrera,"+" carrera.nombre AS nombreCarrera, carrera.idFacultad,"+" facultad.nombre AS nombreFacultad"+" FROM alumno"+" INNER JOIN carrera ON alumno.idCarrera = carrera.idCarrera"+" INNER JOIN facultad ON carrera.idFacultad = facultad.idFacultad";
                
                PreparedStatement ps = conn.prepareStatement(consulta);
                //String consulta = "SELECT idAlumno, alumno.nombre, apellidos, matricula, email, alumno.idCarrera,"+" carrera.nombre AS nombreCarrera, idFacultad " + "FROM alumno " + "INNER JOIN carrera ON alumno.idCarrera = carrera.idCarrera";
                metas=ps.getResultSetType();
                conn.close();
            }catch(SQLException e){
                System.out.println("ERROR: "+e.getMessage());
                e.printStackTrace();
            }
        }
        return metas;
    }
}
