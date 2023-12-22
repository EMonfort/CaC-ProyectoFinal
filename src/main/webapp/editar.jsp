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
                <section>
                    <% 
                        Orador orador = (Orador)request.getAttribute("orador");
                    %>
                    <h2>Editar orador ID=<%=orador.getId()%></h2>
                    <!--  JSP -->
                    <form method="POST"
                            action="<%=request.getContextPath()%>/api/editarorador">
                            <div class="mb-3">
                              <label for="exampleFormControlInput1" class="form-label">Id</label>
                              <input name="id_orador"
                                     readonly="readonly"
                                    value="<%=orador.getId()%>"
                                    type="text" class="form-control" id="exampleFormControlInput1" placeholder="Id" maxlength="50" required>
                            </div>
                            <div class="mb-3">
                              <label for="exampleFormControlInput1" class="form-label">Nombre</label>
                              <input name="nombre"
                                    value="<%=orador.getNombre()%>"  
                                    type="text" class="form-control" id="exampleFormControlInput1" placeholder="Nombre" maxlength="50" required>
                            </div>
                            <div class="mb-3">
                              <label for="exampleFormControlTextarea1" class="form-label">Apellido</label>
                              <input name="apellido"
                                    value="<%=orador.getApellido()%>" 
                                    type="text" class="form-control" id="exampleFormControlTextarea1" required>
                            </div>
                            <div class="mb-3">
                              <label for="exampleFormControlTextarea1" class="form-label">Mail</label>
                              <input name="mail"
                                    value="<%=orador.getMail()%>" 
                                    type="email" class="form-control" id="exampleFormControlTextarea1" required>
                            </div>
                            <div class="mb-3">
                              <label for="exampleFormControlTextarea1" class="form-label">Tema</label>
                              <input name="tema"
                                    value="<%=orador.getTema()%>" 
                                    type="text" class="form-control" id="exampleFormControlTextarea1" maxlength="7" required>
                            </div>
                            <a class="btn btn-secondary m-2" href="<%=request.getContextPath()%>/api/oradores" role="button">Cancelar</a>
                            <button class="btn btn-primary">
                                Guardar
                            </button>
                    </form>
                </section>
            </div>
        </main>
    </body>	
</html>