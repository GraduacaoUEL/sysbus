<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel=StyleSheet href="colaborador.css" type="text/css" media=screen/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SysBus: Gerenciamento de colaboradores</title>
    </head>
    <body>
        <div id="titulo">
            <p>SysBus: Gerenciamento de colaboradores</p>
        </div>
        <jsp:include page="menu.html" flush="true"/>
        <div id="form">
            <p>Inserção/Atualização</p>
            <form name="cadastroColaborador" action="ColaboradorServlet" method="post">
                <input type="text" name="codigoColaborador" value="${ColaboradorEdicao.codigoColaborador}" hidden/>
                <label>Nome:</label><br/><input type="text" name="nomeColaborador" value="${ColaboradorEdicao.nomeColaborador}"/><br/><br/>
                <label>Login:</label><br/><input type="text" name="loginColaborador" value="${ColaboradorEdicao.loginColaborador}"/><br/><br/>
                <label>Senha:</label><br/><input type="password" name="senhaColaborador"/><br/><br/>
                <label>Cargo:</label><br/><select name="cargoColaborador">
                    <c:forEach var="cargos" items="${Cargos}">
                        <option value ="<c:out value="${cargos.codigoCargo}"/>"><c:out value="${cargos.nomeCargo}"/></option>
                    </c:forEach>
                </select><br/><br/>
                <input type="submit" value="Salvar"/>
            </form>
        </div>
        <div id="tabela">
            <p>Colaboradores existentes</p>
            <table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Login</th>
                        <th>Cargo</th>
                        <th>Editar</th>
                        <th>Excluir</th>                    
                    </tr>
                </thead>
                <tbody>                
                    <c:forEach var="colaboradores" items="${Colaboradores}">
                        <tr>
                            <td><c:out value="${colaboradores.nomeColaborador}"/></td>
                            <td><c:out value="${colaboradores.loginColaborador}"/></td>
                            <td><c:out value="${colaboradores.nomeCargo}"/></td>
                            <td><a href="ColaboradorServlet?op=editar&id=<c:out value="${colaboradores.codigoColaborador}"/>">Editar</a></td>
                            <td><a href="ColaboradorServlet?op=excluir&id=<c:out value="${colaboradores.codigoColaborador}"/>">Excluir</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
