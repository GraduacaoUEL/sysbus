<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel=StyleSheet href="estilo.css" type="text/css" media=screen/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SysBus: Gerenciamento de cargos</title>
    </head>
    <body>
        <div id="titulo">
            <p>SysBus: Gerenciamento de cargos</p>
        </div>
        <jsp:include page="menu.html" flush="true"/>
        <div id="form">
            <p>Inserção/Atualização</p>
            <form name="cadastroCargo" action="CargoServlet" method="post">
                <input type="text" name="codigoCargo" value="${CargoEdicao.codigoCargo}" size="3" hidden/>
                <label>Nome:</label><br/><input type="text" name="nomeCargo" value="${CargoEdicao.nomeCargo}"/><br/><br/>
                <label>Permissões:</label><br/>
                <input type="checkbox" name="permissaoCargos" value="true" ${CargoEdicao.permissaoCargos ? "CHECKED" : ""}/>Cargos<br/>
                <input type="checkbox" name="permissaoCarros" value="true" ${CargoEdicao.permissaoCarros ? "CHECKED" : ""}/>Carros<br/>
                <input type="checkbox" name="permissaoItinerarios" value="true" ${CargoEdicao.permissaoItinerarios ? "CHECKED" : ""}/>Itinerários<br/>
                <input type="checkbox" name="permissaoVendas" value="true" ${CargoEdicao.permissaoVendas ? "CHECKED" : ""}/>Vendas<br/>
                <input type="checkbox" name="permissaoCustos" value="true" ${CargoEdicao.permissaoCustos ? "CHECKED" : ""}/>Custos<br/><br/>
                <input type="submit" value="Salvar"/>
            </form>
        </div>
        <div id="tabela">
            <p>Cargos existentes</p>
            <table>
                <thead>
                    <tr>
                        <th>Nome</th>
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
        </div>
    </body>
</html>
