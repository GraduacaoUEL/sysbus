<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Linha</title>
    </head>
    <body>
        <form name="cadastroLinha" action="LinhaServlet" method="post">
            Nome: <input type="text" name="nomeLinha"/><br/>
            Hora de início: <input type="text" name="horaInicioLinha"/><br/>
            Demanda: <input type="text" name="demandaLinha"/><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
