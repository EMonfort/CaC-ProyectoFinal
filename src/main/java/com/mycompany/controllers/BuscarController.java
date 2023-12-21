package com.mycompany.controllers;

import com.mycompany.daos.OradorDAO;
import com.mycompany.dto.Orador;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/api/BuscarController")
public class BuscarController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
            String searchBy = req.getParameter("searchBy");
            String searchString = req.getParameter("searchString");


            //Crear ProductoDAO
            OradorDAO dao = new OradorDAO();

            //invocar el metodo buscar(clave)
            List<Orador> listado = dao.buscar(searchBy, searchString);

            //guardar en el request el producto
            req.setAttribute("listado", listado);

            //ir a la siguiente pagina
            getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
	}
}

