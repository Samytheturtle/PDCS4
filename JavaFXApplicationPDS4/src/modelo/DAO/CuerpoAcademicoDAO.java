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
    
    public static CuerpoAcademico getCA(String nombre){
        CuerpoAcademico ca = new CuerpoAcademico();
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String consulta = "SELECT * FROM cuerpoacademico where nombre = ?";
                PreparedStatement ps = conn.prepareStatement(consulta);
                ps.setString(1, nombre);
                ResultSet resultado = ps.executeQuery();
                while(resultado.next()){
                    ca.setNombre(resultado.getString("nombre"));
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
        return ca;
    }
}

