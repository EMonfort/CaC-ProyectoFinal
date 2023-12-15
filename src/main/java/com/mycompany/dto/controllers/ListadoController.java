package com.mycompany.dto.controllers;

import com.mycompany.daos.OradorDAO;
import com.mycompany.dto.Orador;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author emonfort
 */
@WebServlet("/api/oradores")
public class ListadoController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//crear la instancia de OradorDAO
		OradorDAO dao = new OradorDAO();		

		//invocar al metodo listarOradores()
		List<Orador> listado = dao.listarOradores();
		
		//grabar el listado en el request para que lo vea la siguiente pagina
		req.setAttribute("listado", listado);
		
		//ir a la siguiente pagina
		getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
	}
}
