<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Período</title>
    </head>
    <body>
        <form name="cadastroPeriodo" action="PeriodoServlet" method="post">
            <input type="text" name="codigoPeriodo" value="${PeriodoEdicao.codigoPeriodo}" hidden/>
            Início: <input type="text" name="inicioPeriodo" value="${PeriodoEdicao.inicioPeriodo}"/><br/>
            Fim: <input type="text" name="fimPeriodo" value="${PeriodoEdicao.fimPeriodo}"/><br/>
            Fator de multiplicação: <input type="text" name="fatorMultiplicacao" value="${PeriodoEdicao.fatorMultiplicacao}"/><br/>
            <input type="submit" value="Salvar"/>
        </form>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Hora de início</th>
                    <th>Hora de fim</th>
                    <th>Fator de multiplicação</th>
                    <th>Editar</th>                    
                    <th>Excluir</th>
                </tr>
            </thead>
            <tbody>                
                <c:forEach var="periodos" items="${Periodos}">
                <tr>
                    <td><c:out value="${periodos.codigoPeriodo}"/></td>
                    <td><c:out value="${periodos.inicioPeriodo}"/></td>
                    <td><c:out value="${periodos.fimPeriodo}"/></td>
                    <td><c:out value="${periodos.fatorMultiplicacao}"/></td>
                    <td><a href="PeriodoServlet?op=editar&id=<c:out value="${periodos.codigoPeriodo}"/>">Editar</a></td>
                    <td><a href="PeriodoServlet?op=excluir&id=<c:out value="${periodos.codigoPeriodo}"/>">Excluir</a></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>        
        <!-- Tentar fazer essa chamada no servlet de forma mais inteligente-->
        <a href="/SysBus/index.jsp">Página Inicial</a>                

    </body>
</html>
