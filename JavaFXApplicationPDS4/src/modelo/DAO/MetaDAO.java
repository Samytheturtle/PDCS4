/*
Nombre del archivo: nombre del archivo

Nombre del programador: nombre del autor original

Fecha de creación: fecha de creación del código

Fecha de Edición: última fecha de edición del código

Propósito: objetivo del código escrito en el archivo

Descripción de última edición: Descripción de los últimos cambios realizados

 */
package modelo.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConexionBD;
import modelo.pojo.Meta;

/**
 *
 * @author Lenovo
 */
public class MetaDAO {
    public static int insert(Meta me){
        int lastId=0; 
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String query = "insert into meta(nombre,idPlanTrabajo)"
                     + " values(?,?);";
                PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, me.getNombre());  
                preparedStatement.setInt(2, me.getIdPlanTrabajo()); 
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
    public static ArrayList<Meta> getAllMetas(){
        ArrayList<Meta> metas = new ArrayList<>();
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "SELECT * FROM meta";
                //String consulta = "SELECT idAlumno, alumno.nombre, apellidos, matricula, email, alumno.idCarrera,"+" carrera.nombre AS nombreCarrera, carrera.idFacultad,"+" facultad.nombre AS nombreFacultad"+" FROM alumno"+" INNER JOIN carrera ON alumno.idCarrera = carrera.idCarrera"+" INNER JOIN facultad ON carrera.idFacultad = facultad.idFacultad";
                
                PreparedStatement ps = conn.prepareStatement(consulta);
                //String consulta = "SELECT idAlumno, alumno.nombre, apellidos, matricula, email, alumno.idCarrera,"+" carrera.nombre AS nombreCarrera, idFacultad " + "FROM alumno " + "INNER JOIN carrera ON alumno.idCarrera = carrera.idCarrera";
                
                ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    Meta meta = new Meta();
                    meta.setnombre(resultado.getString("nombre"));
                    meta.setIdMeta(resultado.getInt("idMeta"));
                    meta.setIdPlanTrabajo(resultado.getInt("idPlanTrabajo"));
                    //System.out.print(alumno);
                    metas.add(meta);
                }
                conn.close();
            }catch(SQLException e){
                System.out.println("ERROR: "+e.getMessage());
                e.printStackTrace();
            }
        }
        return metas;
    }
    public static boolean actualizarAccion(Meta metas){
        boolean respuesta = true;
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
           
        }else{
            respuesta = false;
        }
        return respuesta;
    }
}
