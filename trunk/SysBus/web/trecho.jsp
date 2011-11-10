<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trecho</title>
    </head>
    <body>
        <form name="cadastroTrecho" action="TrechoServlet" method="post">
            Origem: <input type="text" name="origemTrecho"/><br/>
            Destino: <input type="text" name="destinoTrecho"/><br/>
            Tempo: <input type="text" name="tempoTrecho"/><br/>
            Distância: <input type="text" name="distanciaTrecho"/><br/>
            Custo: <input type="text" name="custoTrecho"/><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
