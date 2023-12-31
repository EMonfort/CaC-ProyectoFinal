<html>
    <head>
            <%@include file="head.jsp" %>
    </head>

    <body>
        <main>
            <!-- ACA VA EL NAVBAR  -->
            <%@include file="navbar.jsp" %>
            <div class="container">
                <section class="border border-primary rounded-4 col-6 mx-auto text-center" style="background-color: lightblue">
                    <h1 class="text-center my-4">Alta</h1>
                    <!--  JSP -->
                    <form method="post"
                        action="<%=request.getContextPath()%>/CreateController">
                        <div class="my-3 mx-3">
                          <input name="nombre"  type="text" class="form-control" id="nombreTextarea" placeholder="Nombre" maxlength="50" required>
                        </div>
                        <div class="my-3 mx-3">
                          <input name="apellido" type="text" class="form-control" id="apellidoTextarea" placeholder="Apellido" required>
                        </div>
                        <div class="my-3 mx-3">
                          <input name="mail" type="email" class="form-control" id="mailTextarea" placeholder="Mail" maxlength="50" required>
                        </div>
                        <div class="my-3 mx-3">
                          <input name="tema" type="text" class="form-control" id="temaTextarea" maxlength="200" placeholder="Tema" required>
                        </div>
                        <a class="btn btn-secondary m-2" href="<%=request.getContextPath()%>/api/oradores" role="button">Cancelar</a>
                        <button class="btn btn-primary my-3">
                            Dar de alta
                        </button>
                    </form>
                </section>
            </div>
        </main>
    </body>	
</html>