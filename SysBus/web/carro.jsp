<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carro</title>
    </head>
    <body>
        <form name="cadastroCarro" action="CarroServlet" method="post">
            Código: <input type="text" name="codigoCarro"/><br/>
            Número de passageiros: <input type="text" name="numeroDePassageiros"/><br/>
            Linha: <input type="text" name="linhaCarro"/><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
