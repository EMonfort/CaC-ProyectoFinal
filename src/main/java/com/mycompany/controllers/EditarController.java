package com.mycompany.controllers;

import com.mycompany.daos.OradorDAO;
import com.mycompany.dto.Orador;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/api/editarorador")
public class EditarController extends HttpServlet {
	
	@Override
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
		getServletContext().getRequestDispatcher("/editar.jsp").forward(req, resp);
	}
	
        
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String mail = req.getParameter("mail");
		String tema = req.getParameter("tema");
		Long id = Long.valueOf(req.getParameter("id_orador"));
                
		
		//Crear ProductoDAO
		OradorDAO dao = new OradorDAO();
		
		//invocar actualizarProducto(params)
		dao.actualizarOrador(nombre, apellido, mail, tema, id);

		//ir a la siguiente pagina
		resp.sendRedirect(req.getContextPath()+"/api/oradores");
	}
}

