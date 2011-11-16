<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel=StyleSheet href="estilo.css" type="text/css" media=screen/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SysBus: Gerenciamento de períodos</title>
    </head>
    <body>
        <div id="titulo">
            <p>SysBus: Gerenciamento de períodos</p>
        </div>
        <jsp:include page="menu.html" flush="true"/>
        <div id="form">
            <p>Inserção/Atualização</p>
            <form name="cadastroPeriodo" action="PeriodoServlet" method="post">
                <input type="text" name="codigoPeriodo" value="${PeriodoEdicao.codigoPeriodo}" hidden/>
                <label>Início:</label><br/><input type="text" name="inicioPeriodo" value="${PeriodoEdicao.inicioPeriodo}"/><br/><br/>
                <label>Fim:</label><br/><input type="text" name="fimPeriodo" value="${PeriodoEdicao.fimPeriodo}"/><br/><br/>
                <label>Fator de multiplicação:</label><br/><input type="text" name="fatorMultiplicacao" value="${PeriodoEdicao.fatorMultiplicacao}"/><br/><br/>
                <input type="submit" value="Salvar"/>
            </form>
        </div>
        <div id="tabela">
            <p>Períodos existentes</p>
            <table>
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
        </div>
    </body>
</html>