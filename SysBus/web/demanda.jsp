<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Demanda</title>
    </head>
    <body>
        <form name="cadastroDemanda" action="DemandaServlet" method="post">
            Nome: <input type="text" name="nomeDemanda"/><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
