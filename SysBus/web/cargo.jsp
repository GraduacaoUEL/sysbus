<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cargo</title>
    </head>
    <body>
        <form name="cadastroCargo" action="CargoServlet" method="post">
            Nome: <input type="text" name="nomeCargo"/><br/>
            Permissões:
            <input type="checkbox" name="permissaoCargos" value="true"/>Cargos
            <input type="checkbox" name="permissaoCarros" value="true"/>Carros
            <input type="checkbox" name="permissaoItinerarios" value="true"/>Itinerários
            <input type="checkbox" name="permissaoVendas" value="true"/>Vendas
            <input type="checkbox" name="permissaoCustos" value="true"/>Custos<br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
