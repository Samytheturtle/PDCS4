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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ConexionBD;;
import modelo.pojo.Colaborador;

/**
 *
 * @author Lenovo
 */
public class Prototipo_colaborador {
    public static void insert(int idProto, List<Colaborador> profesores){
        Connection conn = ConexionBD.abrirConexionBD();
        if(conn != null){
            try{
                int cont = 0;
                while(cont < profesores.size()){
                    Colaborador aux = profesores.get(cont);
                    String query = "insert into prototipo_colaborador(idPrototipo, colaborador) values(?, ?);";
                    
                    PreparedStatement preparedStatement = conn.prepareStatement(query);
                    preparedStatement.setInt(1, idProto);
                    preparedStatement.setString(2, aux.getNombre());
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
