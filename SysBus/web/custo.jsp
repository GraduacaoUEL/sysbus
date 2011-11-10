<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Custo</title>
    </head>
    <body>
        <form name="cadastroCusto" action="CustoServlet" method="post">
            Preço do quilômetro: <input type="text" name="precoQuilometro"/><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
