<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel=StyleSheet href="estilo.css" type="text/css" media=screen/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SysBus: Gerenciamento de itinerários</title>
    </head>
    <body>
        <div id="titulo">
            <p>SysBus: Gerenciamento de itinerários</p>
        </div>
        <jsp:include page="menu.html" flush="true"/>
        <div id="form">
            <p>Inserção/Atualização</p>
            <form name="cadastroItinerario" action="ItinerarioServlet" method="post">
                <label>Nome:</label><br/><input type="text" name="nomeItinerario"/><br/><br/>
                <input type="submit" value="Salvar"/>
            </form>
        </div>
    </body>
</html>
