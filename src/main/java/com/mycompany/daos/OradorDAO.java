package com.mycompany.daos;

import com.mycompany.connection.AdministradorDeConexiones;
import com.mycompany.dto.Orador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author emonfort
 */
public class OradorDAO {
    public List<Orador> listarOradores() {
	String sql = "SELECT * FROM ORADORES ";
	
	//Connection
	Connection con = AdministradorDeConexiones.getConnection();

	List<Orador> list = new ArrayList<>();
	
	//Statement
	try {
		Statement st = con.createStatement();
		
		//resultset
		ResultSet rs = st.executeQuery(sql);
		
		//VIENE UN SOLO REGISTRO!!!
		
		while(rs.next()) {//
			// rs > sacando los datos
			Long idOrador = rs.getLong(1);//tomar la primer columna
			String nombre = rs.getString(2);
			String apellido = rs.getString(3);
			String mail = rs.getString(4);
                        String tema = rs.getString(5);
                        Timestamp fechaAlta = rs.getTimestamp(6);
				
			//campos crear un objeto????
			Orador oradorFromDb = new Orador(idOrador,nombre,apellido,mail,tema,fechaAlta);
			
			//agrego a la lista 
			list.add(oradorFromDb);
		}			
			
		//cierro la conexion
		con.close();
	} catch (SQLException e) {
            // ERRORES
            e.printStackTrace();
	}
	return list;
    }
        
    public void crearOrador(String nombre, String apellido, String mail, String tema) {

            Connection con = AdministradorDeConexiones.getConnection();

            if(con != null) { 
                    // insert en la db > SQL: INSERT INTO....
                    String sql = "INSERT INTO oradores (nombre, apellido,fecha_alta,tema,mail) ";
                    sql += "VALUES('"+nombre+"','"+apellido+"',CURRENT_DATE,'"+tema+"','"+mail+"')";

                    //control de errores
                    try {
                            Statement st = con.createStatement();			
                            st.execute(sql);

                            //cierre de conexion
                            con.close();

                    }catch (Exception e) {
                            e.printStackTrace();
                    }
            }
    }
        
    public Orador obtenerPorId(Long id) {
            String sql = "SELECT * FROM oradores WHERE id_orador="+id;

            //Connection
            Connection con = AdministradorDeConexiones.getConnection();

            Orador oradorFromDb = null;

            //Statement
            try {
                    Statement st = con.createStatement();

                    //resultset
                    ResultSet rs = st.executeQuery(sql);

                    //VIENE UN SOLO REGISTRO!!!

                    if(rs.next()) {//si existe, hay uno solo
                            // rs > sacando los datos
                            Long idOrador = rs.getLong(1);//tomar la primer columna
                            String nombre = rs.getString(2);
                            String apellido = rs.getString(3);
                            String mail = rs.getString(4);
                            String tema = rs.getString(5);
                            Timestamp fechaAlta = rs.getTimestamp(6);

                            oradorFromDb = new Orador(idOrador,nombre,apellido,mail,tema,fechaAlta);
                    }			
            } catch (SQLException e) {
                    // ERRORES
                    e.printStackTrace();
            }
            return oradorFromDb;
    }

    public void actualizarOrador(String nombre, String apellido, String mail, String tema, Long id) {
        Connection con = AdministradorDeConexiones.getConnection();
            if(con != null) { 
                    String sql = "UPDATE oradores "
                                    + " set nombre='"+nombre+"',"
                                    + " apellido='"+apellido+"',"
                                    + " mail='"+mail+"',"
                                    + " tema='"+tema+"'"
                                    + " WHERE id_orador = '"+id+"'";		

                    try {
                            Statement st = con.createStatement();			
                            st.executeUpdate(sql);
                            con.close();
                    }catch (Exception e) {
                            e.printStackTrace();
                    }
            }
    }
        
    public int eliminarOrador(Long id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try{
            conn = AdministradorDeConexiones.getConnection();
            stmt = conn.prepareStatement("DELETE FROM oradores WHERE id_orador = ?");
            //stmt.setInt(1, id);
            stmt.setLong(1, id);
            registros = stmt.executeUpdate();
        } catch(SQLException | NullPointerException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch(SQLException | NullPointerException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }
        
    public List<Orador> buscar(String searchBy, String SearchString) {
        String sql = "SELECT * FROM oradores WHERE " +searchBy+ " LIKE '%"+SearchString+"%' ";

        //Connection
        Connection con = AdministradorDeConexiones.getConnection();

        List<Orador> listado = new ArrayList<Orador>();

        //Statement
        try {
            Statement st = con.createStatement();

            //resultset
            ResultSet rs = st.executeQuery(sql);

            //VIENE UN SOLO REGISTRO!!!

            while(rs.next()) {//si existe, hay uno solo
                    // rs > sacando los datos
                    Long idOrador = rs.getLong(1);//tomar la primer columna
                    String nombre = rs.getString(2);
                    String apellido = rs.getString(3);
                    String mail = rs.getString(4);
                    String tema = rs.getString(5);
                    Timestamp fechaAlta = rs.getTimestamp(6);

                    //campos crear un objeto????
                    Orador prodFromDb = new Orador(idOrador,nombre,apellido,mail,tema,fechaAlta);

                    listado.add(prodFromDb);
            }	
        } catch (SQLException e) {
                // ERRORES
                e.printStackTrace();
        }

        return listado;
    }
}
