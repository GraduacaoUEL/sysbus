<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Colaborador</title>
    </head>
    <body>
        <form name="cadastroColaborador" action="ColaboradorServlet" method="post">
            Nome: <input type="text" name="nomeColaborador"/><br/>
            Login: <input type="text" name="loginColaborador"/><br/>
            Senha: <input type="password" name="senhaColaborador"/><br/>
            Cargo: <input type="text" name="cargoColaborador"/><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
