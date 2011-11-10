<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Itinerário</title>
    </head>
    <body>
        <form name="cadastroItinerario" action="servletItinerario"
              method="post">
            Nome do itinerário: <input type="text" name="nomeItinerario"/><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
