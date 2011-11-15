<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trecho</title>
    </head>
    <body>
        <form name="cadastroTrecho" action="TrechoServlet" method="post">
            <input type="text" name="codigoTrecho" value="${TrechoEdicao.codigoTrecho}" hidden/>
            Origem: <input type="text" name="origemTrecho" value="${TrechoEdicao.origemTrecho}"/><br/>
            Destino: <input type="text" name="destinoTrecho" value="${TrechoEdicao.destinoTrecho}"/><br/>
            Tempo: <input type="text" name="tempoTrecho" value="${TrechoEdicao.tempoTrecho}"/><br/>
            Distância: <input type="text" name="distanciaTrecho" value="${TrechoEdicao.distanciaTrecho}"/><br/>
            <input type="submit" value="Salva"/>
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>Origem</th>
                    <th>Destino</th>
                    <th>Tempo</th>
                    <th>Distância</th>
                    <th>Editar</th>
                    <th>Excluir</th>
                </tr>
            </thead>
            <tbody>                
                <c:forEach var="trechos" items="${Trechos}">
                <tr>
                    <td><c:out value="${trechos.origemTrecho}"/></td>
                    <td><c:out value="${trechos.destinoTrecho}"/></td>
                    <td><c:out value="${trechos.tempoTrecho}"/></td>
                    <td><c:out value="${trechos.distanciaTrecho}"/></td>                    
                    <td><a href="TrechoServlet?op=editar&id=<c:out value="${trechos.codigoTrecho}"/>">Editar</a></td>
                    <td><a href="TrechoServlet?op=excluir&id=<c:out value="${trechos.codigoTrecho}"/>">Excluir</a></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <!-- Tentar fazer essa chamada no servlet de forma mais inteligente. -->
        <a href="/SysBus/index.jsp">Página Inicial</a>        
    </body>
</html>
