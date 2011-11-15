<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel=StyleSheet href="custo.css" type="text/css" media=screen/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SysBus: Gerenciamento de custo</title>
    </head>
    <body>
        <div id="titulo">
            <p>SysBus: Gerenciamento de custo</p>
        </div>
        <jsp:include page="menu.html" flush="true"/>
        <div id="form">
            <p>Inserção/Atualização</p>
            <form name="cadastroCusto" action="CustoServlet" method="post">
                <label>Preço do quilômetro:</label><br/><input type="text" name="precoQuilometro" value="${Custo.precoQuilometro}"/><br/><br/>
                <input type="submit" value="Salvar"/>
            </form>
        </div>
    </body>
</html>
