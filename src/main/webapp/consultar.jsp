<%@page import="com.mycompany.dto.Orador"%>
<html>
    <head>
            <%@include file="head.jsp" %>	
    </head>

    <body>
        <main>
            <!-- ACA VA EL NAVBAR  -->
            <%@include file="navbar.jsp" %>
            <div class="container">
                <section class="border border-primary rounded-4 col-6 mx-auto text-center mt-5" style="background-color: lightblue">
                    <% 
                        Orador orador = (Orador)request.getAttribute("orador");
                    %>
                    <h2><%=orador.getNombre()%> <%=orador.getApellido()%></h2>
                    <!--  JSP -->                    
                    <div class="my-3 mx-3">
                      <label for="exampleFormControlInput1" class="col-md-2">Id</label>
                      <input name="id_orador"
                             readonly="readonly"
                            value="<%=orador.getId()%>"  
                            type="text" class="col-md-6" id="exampleFormControlInput1" placeholder="Id" maxlength="50">
                    </div>
                    <div class="my-3 mx-3">
                      <label for="exampleFormControlInput1" class="col-md-2">Nombre</label>
                      <input name="nombre"
                             readonly="readonly"
                            value="<%=orador.getNombre()%>"  
                            type="text" class="col-md-6" id="exampleFormControlInput1" placeholder="Nombre" maxlength="50">
                    </div>
                    <div class="my-3 mx-3">
                      <label for="exampleFormControlTextarea1" class="col-md-2">Apellido</label>
                      <input name="apellido"
                             readonly="readonly"
                            value="<%=orador.getApellido()%>" 
                            type="text" class="col-md-6" id="exampleFormControlTextarea1">
                    </div>
                    <div class="my-3 mx-3">
                      <label for="exampleFormControlTextarea1" class="col-md-2">Mail</label>
                      <input name="mail"
                             readonly="readonly"
                            value="<%=orador.getMail()%>" 
                            type="text" class="col-md-6" id="exampleFormControlTextarea1">
                    </div>
                    <div class="my-3 mx-3">
                      <label for="exampleFormControlTextarea1" class="col-md-2">Tema</label>
                      <input name="tema"
                             readonly="readonly"
                            value="<%=orador.getTema()%>" 
                            type="text" class="col-md-6" id="exampleFormControlTextarea1" maxlength="7">
                    </div>
                    <div class="my-3 mx-3">
                      <label for="exampleFormControlTextarea1" class="col-md-2">Fecha de Alta</label>
                      <input name="tema"
                             readonly="readonly"
                            value="<%=orador.getFechaAlta()%>" 
                            type="text" class="col-md-6" id="exampleFormControlTextarea1" maxlength="7">
                    </div>
                    <div class="d-flex bd-highlight mb-3">
                        <div class="me-auto">
                            <a class="btn btn-secondary m-2" href="<%=request.getContextPath()%>/api/oradores" role="button">Volver</a>
                        </div>
                        <div class="">
                            <a class="btn btn-primary m-2" href="<%=request.getContextPath()%>/api/editarorador?id=<%=orador.getId()%>" role="button">Editar</a>
                            <a class="btn btn-danger m-2" href="<%=request.getContextPath()%>/api/eliminarorador?id=<%=orador.getId()%>" onclick="return confirm('¿Desea eliminar al orador?');" role="button">Eliminar</a>                         
                        </div>
                        
                    </div>
                </section>
            </div>
        </main>
    </body>	
</html>