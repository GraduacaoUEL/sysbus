<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel=StyleSheet href="estilo.css" type="text/css" media=screen/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SysBus: Gerenciamento de trechos</title>
    </head>
    <body>
        <div id="titulo">
            <p>SysBus: Gerenciamento de trechos</p>
        </div>
        <jsp:include page="menu.html" flush="true"/>
        <div id="form">
            <p>Inserção/Atualização</p>
            <form name="cadastroTrecho" action="TrechoServlet" method="post">
                <input type="text" name="codigoTrecho" value="${TrechoEdicao.codigoTrecho}" hidden/>
                <label>Origem:</label><br/><input type="text" name="origemTrecho" value="${TrechoEdicao.origemTrecho}"/><br/><br/>
                <label>Destino:</label><br/><input type="text" name="destinoTrecho" value="${TrechoEdicao.destinoTrecho}"/><br/><br/>
                <label>Tempo:</label><br/><input type="text" name="tempoTrecho" value="${TrechoEdicao.tempoTrecho}"/><br/><br/>
                <label>Distância:</label><br/><input type="text" name="distanciaTrecho" value="${TrechoEdicao.distanciaTrecho}"/><br/><br/>
                <input type="submit" value="Salvar"/>
            </form>
        </div>
        <div id="tabela">
            <p>Linhas existentes</p>
            <table>
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
        </div>      
    </body>
</html>