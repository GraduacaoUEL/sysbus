<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venda</title>
    </head>
    <body>
        <form name="cadastroItinerario" action="VendaServlet" method="post">
            Data e hora: <input type="text" name="dataHoraVenda"/><br/>
            Tipo de pagamento: <input type="text" name="tipoPagamento"/><br/>
            Valor: <input type="text" name="valorVenda"/><br/>
            Vendedor: <input type="text" name="vendedor"/><br/>
            Carro: <input type="text" name="carroVenda"/><br/>
            <input type="checkbox" name="passagemEntregue" value="true"/>Passagem entregue
            <input type="checkbox" name="viaWeb" value="true"/>Via Web<br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
