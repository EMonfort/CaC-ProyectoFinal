package com.mycompany.daos;

import com.mycompany.connection.AdministradorDeConexiones;
import com.mycompany.dto.Orador;
import java.sql.Connection;
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
    	public List<Orador> listarProductos() {
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
}
