<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Colaborador</title>
    </head>
    <body>
        <h1>${Colaborador.nomeColaborador}</h1>
        <form name="cadastroColaborador" action="ColaboradorServlet" method="post">
            <input type="text" name="codigoColaborador" value="${ColaboradorEdicao.codigoColaborador}" hidden/>
            Nome: <input type="text" name="nomeColaborador" value="${ColaboradorEdicao.nomeColaborador}"/><br/>
            Login: <input type="text" name="loginColaborador" value="${ColaboradorEdicao.loginColaborador}"/><br/>
            Senha: <input type="password" name="senhaColaborador"/><br/>
            
            Cargo: <select name="cargoColaborador">
                <c:forEach var="cargos" items="${Cargos}">
                    <option value ="<c:out value="${cargos.codigoCargo}"/>"><c:out value="${cargos.nomeCargo}"/></option>
                </c:forEach>
            </select>
            
            <input type="submit" value="Salvar"/>
        </form>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Numero do Colaborador</th>
                    <th>Login do Colaborador</th>
                    <th>Cargo do Colaborador</th>
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
        <!-- Tentar fazer essa chamada no servlet de forma mais inteligente-->
        <a href="/SysBus/index.jsp">Página Inicial</a>
    </body>
</html>
