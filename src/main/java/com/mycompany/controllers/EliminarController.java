package com.mycompany.controllers;

import com.mycompany.daos.OradorDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/eliminarorador")
public class EliminarController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String id = req.getParameter("id");
                
                OradorDAO dao = new OradorDAO();
                
                dao.eliminarOrador(Long.valueOf(id));
		
                resp.sendRedirect(req.getContextPath()+"/api/oradores");

	}
}