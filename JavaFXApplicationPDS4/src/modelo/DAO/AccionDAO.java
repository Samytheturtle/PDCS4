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
import modelo.pojo.Accion;
/**
 *
 * @author samyt
 */
public class AccionDAO {
    public static void insert(Accion ac){
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String query = "insert into accion(nombre, fechaConclusion, recurso, representante,idMeta)"
                     + " values(?, ?, ?, ?, ?);";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, ac.getNombre());
                preparedStatement.setString(2, ac.getFechaconclusion());
                preparedStatement.setString(3, ac.getRecurso());
                preparedStatement.setString(4, ac.getRepresentante());
                preparedStatement.setInt(5, ac.getIdMeta());
                 
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
    public static ArrayList<Accion> getAllAccion(){
        ArrayList<Accion> acciones = new ArrayList<>();
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "SELECT * FROM accion";
                //String consulta = "SELECT idAlumno, alumno.nombre, apellidos, matricula, email, alumno.idCarrera,"+" carrera.nombre AS nombreCarrera, carrera.idFacultad,"+" facultad.nombre AS nombreFacultad"+" FROM alumno"+" INNER JOIN carrera ON alumno.idCarrera = carrera.idCarrera"+" INNER JOIN facultad ON carrera.idFacultad = facultad.idFacultad";
                
                PreparedStatement ps = conn.prepareStatement(consulta);
                //String consulta = "SELECT idAlumno, alumno.nombre, apellidos, matricula, email, alumno.idCarrera,"+" carrera.nombre AS nombreCarrera, idFacultad " + "FROM alumno " + "INNER JOIN carrera ON alumno.idCarrera = carrera.idCarrera";
                
                ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    Accion accion = new Accion();
                    accion.setrepresentante(resultado.getString("representante"));
                    accion.setfechaconclusion(resultado.getString("fechaConclusion"));
                    accion.setIdMeta(resultado.getInt("idMeta"));
                    accion.setrecurso(resultado.getString("recurso"));
                    accion.setnombre(resultado.getString("nombre"));
                    //System.out.print(alumno);
                    acciones.add(accion);
                }
                conn.close();
            }catch(SQLException e){
                System.out.println("ERROR: "+e.getMessage());
                e.printStackTrace();
            }
        }
        return acciones;
    }
    public static boolean actualizarAccion(Accion accion){
        boolean respuesta = true;
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
           
        }else{
            respuesta = false;
        }
        return respuesta;
    }
}
