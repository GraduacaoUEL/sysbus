<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        
        <table border="1">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nome do Cargo</th>
                    <th>Cargos</th>
                    <th>Carros</th>
                    <th>Itinerários</th>
                    <th>Vendas</th>
                    <th>Custos</th>
                </tr>
            </thead>
            <tbody>                
                <c:forEach var="cargos" items="${Cargos}">
                <tr>
                    <td><c:out value="${cargos.codigoCargo}"/></td>
                    <td><c:out value="${cargos.nomeCargo}"/></td>
                    <td><c:out value="${cargos.permissaoCargos ? 'sim' : 'não'}"/></td>
                    <td><c:out value="${cargos.permissaoCarros ? 'sim' : 'não'}"/></td>
                    <td><c:out value="${cargos.permissaoCustos ? 'sim' : 'não'}"/></td>
                    <td><c:out value="${cargos.permissaoItinerarios ? 'sim' : 'não'}"/></td>
                    <td><c:out value="${cargos.permissaoVendas ? 'sim' : 'não'}"/></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <!-- Tentar fazer essa chamada no servlet de forma mais inteligente-->
        <a href="/SysBus/index.jsp">Página Inicial</a>
    </body>
</html>
