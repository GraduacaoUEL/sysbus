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
            <input type="checkbox" name="permissoes" value="cargos"/>Cargos
            <input type="checkbox" name="permissoes" value="carros"/>Carros
            <input type="checkbox" name="permissoes" value="itinerarios"/>Itinerários
            <input type="checkbox" name="permissoes" value="vendas"/>Vendas
            <input type="checkbox" name="permissoes" value="custos"/>Custos<br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
