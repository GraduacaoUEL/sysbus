<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel=StyleSheet href="estiloDemandaItinerario.css" type="text/css" media=screen/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SysBus: Gerenciamento de demandas</title>
    </head>
    <body>
        <div id="titulo">
            <p>SysBus: Gerenciamento de demandas</p>
        </div>
        <jsp:include page="menu.html" flush="true"/>
        <div id="form">
            <p>Inserção/Atualização</p>
            <form name="cadastroDemanda" action="DemandaServlet" method="post">
                <label>Nome:</label><br/><input type="text" name="nomeDemanda"/><br/><br/>
                <label>Períodos:</label><br/>
                <table>
                    <thead>
                        <tr>
                            <th></th>
                            <th>Início do período</th>
                            <th>Fim do período</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="periodos" items="${Periodos}">
                            <tr>
                                <td><input type="checkbox" name="periodo" value="${periodos.codigoPeriodo}"/></td>
                                <td>${periodos.inicioPeriodo}</td>
                                <td>${periodos.fimPeriodo}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table><br/>
                <input type="submit" value="Salvar"/>
            </form>
        </div>
        <div id="tabela">
            <p>Demandas existentes</p>
            <table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Editar</th>
                        <th>Excluir</th>
                    </tr>
                </thead>
                <tbody>                
                    <c:forEach var="demandas" items="${Demandas}">
                        <tr>
                            <td><c:out value="${demandas.nomeDemanda}"/></td>
                            <td><a href="DemandaServlet?op=editar&id=<c:out value="${demandas.codigoDemanda}"/>">Editar</a></td>
                            <td><a href="DemandaServlet?op=excluir&id=<c:out value="${demandas.codigoDemanda}"/>">Excluir</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
