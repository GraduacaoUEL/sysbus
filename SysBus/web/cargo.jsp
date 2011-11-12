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
            <input type="text" name="codigoCargo" value="${CargoEdicao.codigoCargo}" size="3" hidden=/>
            Nome: <input type="text" name="nomeCargo" value="${CargoEdicao.nomeCargo}"/><br/>
            Permissões:
            
            
            
            <input type="checkbox" name="permissaoCargos" value="true" ${CargoEdicao.permissaoCargos ? "CHECKED" : ""}/>Cargos
            <input type="checkbox" name="permissaoCarros" value="true" ${CargoEdicao.permissaoCarros ? "CHECKED" : ""}/>Carros
            <input type="checkbox" name="permissaoItinerarios" value="true" ${CargoEdicao.permissaoItinerarios ? "CHECKED" : ""}/>Itinerários
            <input type="checkbox" name="permissaoVendas" value="true" ${CargoEdicao.permissaoVendas ? "CHECKED" : ""}/>Vendas
            <input type="checkbox" name="permissaoCustos" value="true" ${CargoEdicao.permissaoCustos ? "CHECKED" : ""}/>Custos<br/>
            <input type="submit" value="Salvar"/>
        </form>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Nome do Cargo</th>
                    <th>Cargos</th>
                    <th>Carros</th>
                    <th>Itinerários</th>
                    <th>Vendas</th>
                    <th>Custos</th>
                    <th>Editar</th>
                    <th>Excluir</th>
                </tr>
            </thead>
            <tbody>                
                <c:forEach var="cargos" items="${Cargos}">
                <tr>
                    <td><c:out value="${cargos.nomeCargo}"/></td>
                    <td><c:out value="${cargos.permissaoCargos ? 'sim' : 'não'}"/></td>
                    <td><c:out value="${cargos.permissaoCarros ? 'sim' : 'não'}"/></td>
                    <td><c:out value="${cargos.permissaoItinerarios ? 'sim' : 'não'}"/></td>                    
                    <td><c:out value="${cargos.permissaoVendas ? 'sim' : 'não'}"/></td>
                    <td><c:out value="${cargos.permissaoCustos ? 'sim' : 'não'}"/></td>                    
                    <td><a href="CargoServlet?op=editar&id=<c:out value="${cargos.codigoCargo}"/>">Editar</a></td>
                    <td><a href="CargoServlet?op=excluir&id=<c:out value="${cargos.codigoCargo}"/>">Excluir</a></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <!-- Tentar fazer essa chamada no servlet de forma mais inteligente-->
        <a href="/SysBus/index.jsp">Página Inicial</a>
    </body>
</html>
