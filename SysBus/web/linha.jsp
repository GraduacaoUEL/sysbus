<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel=StyleSheet href="estilo.css" type="text/css" media=screen/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SysBus: Gerenciamento de linhas</title>
    </head>
    <body>
        <div id="titulo">
            <p>SysBus: Gerenciamento de linhas</p>
        </div>
        <jsp:include page="menu.html" flush="true"/>
        <div id="form">
            <p>Inserção/Atualização</p>
            <form name="cadastroLinha" action="LinhaServlet" method="post">
                <label>Nome:</label><br/><input type="text" name="nomeLinha"/><br/><br/>
                <label>Hora de início:</label><br/><input type="text" name="horaInicioLinha"/><br/><br/>
                <label>Demanda:</label><br/><select name="demandaLinha">
                    <c:forEach var="demandas" items="${Demandas}">
                        <option value ="<c:out value="${demandas.codigoDemanda}"/>">
                            <c:out value="${demandas.nomeDemanda}" />
                        </option>
                    </c:forEach>
                </select><br/><br/>

                <label>Itinerário:</label><br/><select name="itinerarioLinha">
                    <c:forEach var="itinerarios" items="${Itinerarios}">
                        <option value ="<c:out value="${itinerarios.codigoItinerario}"/>">
                            <c:out value="${itinerarios.nomeItinerario}" />
                        </option>
                    </c:forEach>
                </select><br/><br/>
                <input type="submit" value="Salvar"/>
            </form>
        </div>
        <div id="tabela">
            <p>Linhas existentes</p>
            <table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Hora de início</th>
                        <th>Demanda</th>
                        <th>Itinerário</th>
                        <th>Editar</th>
                        <th>Excluir</th>                    
                    </tr>
                </thead>
                <tbody>                
                    <c:forEach var="linhas" items="${Linhas}">
                        <tr>
                            <td><c:out value="${linhas.nomeLinha}"/></td>
                            <td><c:out value="${linhas.horaInicioLinha}"/></td>
                            <td><c:out value="${linhas.nomeDemanda}"/></td>
                            <td><c:out value="${linhas.nomeItinerario}"/></td>
                            <td><a href="LinhaServlet?op=editar&id=<c:out value="${linhas.codigoLinha}"/>">Editar</a></td>
                            <td><a href="LinhaServletServlet?op=excluir&id=<c:out value="${linhas.codigoLinha}"/>">Excluir</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>    
    </body>
</html>
