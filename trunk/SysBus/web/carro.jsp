<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel=StyleSheet href="estilo.css" type="text/css" media=screen/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SysBus: Gerenciamento de carros</title>
    </head>
    <body>
        <div id="titulo">
            <p>SysBus: Gerenciamento de carros</p>
        </div>
        <jsp:include page="menu.html" flush="true"/>
        <div id="form">
            <p>Inserção/Atualização</p>
            <form name="cadastroCarro" action="CarroServlet" method="post">
                <label>Código:</label><br/><input type="text" name="codigoCarro" value="${CarroEdicao.codigoCarro}"/><br/><br/>
                <label>Número de passageiros:<br/></label><input type="text" name="numeroDePassageiros" value="${CarroEdicao.numeroDePassageiros}"/><br/><br/>
                <label>Linha:<br/></label><select name="linhaCarro">
                    <c:forEach var="linhas" items="${Linhas}">
                        <option value ="<c:out value="${linhas.codigoLinha}"/>"><c:out value="${linhas.nomeLinha}"/></option>
                    </c:forEach>
                </select><br/><br/>
                <input type="submit" value="Salvar"/>
            </form>
        </div>

        <div id="tabela">
            <p>Carros existentes</p>
            <table>
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Número de passageiros</th>
                        <th>Linha</th>
                        <th>Editar</th>
                        <th>Excluir</th>
                    </tr>
                </thead>
                <tbody>                
                    <c:forEach var="carros" items="${Carros}">
                    <tr>
                        <td><c:out value="${carros.codigoCarro}"/></td>
                        <td><c:out value="${carros.numeroDePassageiros}"/></td>
                        <td><c:out value="${carros.nomeLinha}"/></td>
                        <td><a href="CarroServlet?op=editar&id=<c:out value="${carros.codigoCarro}"/>">Editar</a></td>
                        <td><a href="CarroServlet?op=excluir&id=<c:out value="${carros.codigoCarro}"/>">Excluir</a></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>