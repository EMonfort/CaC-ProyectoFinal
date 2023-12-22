package com.mycompany.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.daos.OradorDAO;
import com.mycompany.dto.Orador;

@WebServlet("/api/orador")
public class ConsultarController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		//Crear ProductoDAO
		OradorDAO dao = new OradorDAO();
		
		//invocar el metodo obtenerPorId(id)
                Long idLong = Long.valueOf(id);
		Orador oradorFromDb = dao.obtenerPorId(idLong);
		
		//guardar en el request el orador
		req.setAttribute("orador", oradorFromDb);
		
		//ir a la siguiente pagina
		getServletContext().getRequestDispatcher("/consultar.jsp").forward(req, resp);
	}
}

