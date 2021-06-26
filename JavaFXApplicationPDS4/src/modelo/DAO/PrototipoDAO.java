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
import modelo.pojo.Prototipo;

/**
 *
 * @author Lenovo
 */
public class PrototipoDAO {
    public static int insert(Prototipo proto){
        int lastId = 0;
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                String query = "insert into prototipo(anio, autor, caracteristicas, estadoActual, institucionCreacion, nombrePrototipo, objetivo, pais, proposito, idProyecto, idLGAC)"
                     + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, proto.getAnio());
                preparedStatement.setString(2, proto.getAutor());
                preparedStatement.setString(3, proto.getCaracteristicas());
                preparedStatement.setString(4, proto.getEstadoActual());
                preparedStatement.setString(5, proto.getInstitucion());
                preparedStatement.setString(6, proto.getNompre());
                preparedStatement.setString(7, proto.getObjetivo());
                preparedStatement.setString(8, proto.getPais());
                preparedStatement.setString(9, proto.getProposito());
                preparedStatement.setInt(10, proto.getIdProyecto());
                preparedStatement.setInt(11, proto.getIdLgac());

                 
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
                    Logger.getLogger(PrototipoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return lastId;
    }
}
