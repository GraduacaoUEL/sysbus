<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Demanda</title>
    </head>
    <body>
        <form name="cadastroDemanda" action="DemandaServlet" method="post">
            Nome: <input type="text" name="nomeDemanda"/><br/>
            <input type="submit" value="Enviar"/>
        </form>
        
                <table border="1">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nome da Demanda</th>
                    <th>Editar</th>
                    <th>Excluir</th>
                </tr>
            </thead>
            <tbody>                
                <c:forEach var="demandas" items="${Demandas}">
                <tr>
                    <td><c:out value="${demandas.codigoDemanda}"/></td>
                    <td><c:out value="${demandas.nomeDemanda}"/></td>
                    <td>TODO</td>
                    <td>TODO</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <!-- Tentar fazer essa chamada no servlet de forma mais inteligente-->
        <a href="/SysBus/index.jsp">Página Inicial</a>

    </body>
</html>
