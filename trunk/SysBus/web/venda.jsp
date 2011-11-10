<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda</title>
    </head>
    <body>
        <form name="cadastroItinerario" action="servletItinerario" method="post">
            Data e hora: <input type="text" name="nomeItinerario"/><br/>
            Tipo de pagamento: <input type="text" name="codigoCarro"/><br/>
            Valor: <input type="text" name="codigoCarro"/><br/>
            Vendedor: <input type="text" name="codigoCarro"/><br/>
            Carro: <input type="text" name="codigoCarro"/><br/>
            <input type="checkbox" name="passagemEntregue" value="passagemEntregue"/>Passagem entregue
            <input type="checkbox" name="viaWeb" value="viaWeb"/>Via Web<br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
