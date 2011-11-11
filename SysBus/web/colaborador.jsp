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
            Nome: <input type="text" name="nomeColaborador"/><br/>
            Login: <input type="text" name="loginColaborador"/><br/>
            Senha: <input type="password" name="senhaColaborador"/><br/>
            <!-- Cargo: <input type="text" name="cargoColaborador"/><br/> -->
            
            Cargo: <select name="cargoColaborador">
                <c:forEach var="cargos" items="${Cargos}">
                    <option value ="<c:out value="${cargos.codigoCargo}"/>">
                        <c:out value="${cargos.nomeCargo}" />
                    </option>
                </c:forEach>
            </select>
            
            <input type="submit" value="Enviar"/>
        </form>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Codigo</th>
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
                    <td><c:out value="${colaboradores.codigoColaborador}"/></td>
                    <td><c:out value="${colaboradores.nomeColaborador}"/></td>
                    <td><c:out value="${colaboradores.loginColaborador}"/></td>
                    <td><c:out value="${colaboradores.cargoColaborador}"/></td>
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
