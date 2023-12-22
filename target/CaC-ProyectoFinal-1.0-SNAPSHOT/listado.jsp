<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.dto.Orador"%>
<html lang="es-ar" data-bs-theme="light">
    <head>
        <%@include file="head.jsp" %>
        <title>
          Oradores
        </title>	
    </head>
	
    <body>
        <!-- ACA VA EL NAVBAR  -->
        <%@include file="navbar.jsp" %>
        <main>
            <div class="container">
                <section class="bg-secondary-subtle border rounded-5 m-4 px-2 pt-2 pb-2 col-12 mx-auto text-center">
                    <form class="d-flex justify-content-around g-1 gx-5"
                        action="<%=request.getContextPath()%>/api/BuscarController"
                        method="get">
                        <div class="col-md-4 ml-3"> 
                            <select name="searchBy" class="form-control me-2" type="search" placeholder="SearchBy" aria-label="Search">
                                <option value="nombre" selected="selected">Nombre</option>
                                <option value="apellido">Apellido</option>
                                <option value="mail" >Mail</option>
                                <option value="tema" >Tema</option>
                            </select>
                        </div>
                        <div class="col-md-4"> 
                            <input name="searchString" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">                            
                        </div>
                        <div class="col-md-2">
                            <button class="btn btn-primary" type="submit">Buscar</button>
                        </div>                            
                      </form>
                </section>
            </div>
            
            <div class="container">                
                <section class="bg-secondary-subtle border rounded-5 m-4 px-2 pt-2 pb-3 col-12 mx-auto text-center">
                <h2 class="my-4">Oradores</h2>
                <table class="table table-sm table-striped table-hover border border-success">
                                <thead>
                                  <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">NOMBRE</th>
                                    <th scope="col">APELLIDO</th>
                                    <th scope="col">MAIL</th>
                                    <th scope="col">TEMA</th>
                                    <th scope="col">FECHA ALTA</th>
                                    <th scope="col">ACCIONES</th>
                                  </tr>
                                </thead>
                    <% 
                          //codigo java
                          //obtener el listado desde el request
                          //se guardo bajo el nombre de "listado"
                      List<Orador> listado = (List<Orador>)request.getAttribute("listado");
                    %>
                  <tbody>
                      <%
                           for( Orador  unOrador : listado) {
                      %>

                       <tr>
                          <th scope="row"> <%=unOrador.getId()%> </th>
                          <td><%=unOrador.getNombre() %></td>
                          <td><%=unOrador.getApellido() %></td>
                          <td><%=unOrador.getMail() %></td>
                          <td><%=unOrador.getTema() %></td>
                          <td><%=unOrador.getFechaAlta() %></td>

                          <td>
                            <a class="btn btn-info" href="<%=request.getContextPath()%>/api/orador?id=<%=unOrador.getId()%>" role="button">Ver</a> |
                            <a class="btn btn-primary" href="<%=request.getContextPath()%>/api/editarorador?id=<%=unOrador.getId()%>" role="button">Editar</a> |
                            <a class="btn btn-danger" href="<%=request.getContextPath()%>/api/eliminarorador?id=<%=unOrador.getId()%>" onclick="return confirm('¿Desea eliminar a <%=unOrador.getNombre()%> <%=unOrador.getApellido()%>?');" role="button">Eliminar</a>                           
                          </td>
                        </tr>
                       <%
                            }
                       %>

                  </tbody>
                </table>                      
 
              </section>

                      
            </div>
        </main>
    </body>	
</html>