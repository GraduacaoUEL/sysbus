<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Custo</title>
    </head>
    <body>
        <form name="cadastroCusto" action="CustoServlet" method="post">
            Preço do quilômetro: <input type="text" name="precoQuilometro" value="${Custo.precoQuilometro}"/><br/>
            <input type="submit" value="Atualizar Custo"/>
        </form>
        <!-- Tentar fazer essa chamada no servlet de forma mais inteligente-->
        <a href="/SysBus/index.jsp">Página Inicial</a>                
    </body>
</html>
