<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel=StyleSheet href="estiloCustoLogin.css" type="text/css" media=screen/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SysBus: Login</title>
    </head>
    <body>
        <div id="titulo">
            <p>SysBus: Login</p>
        </div>
        <jsp:include page="menu.html" flush="true"/>
        <div id="form">
            <form action="LoginServlet" method="POST">
                <label>Login:</label><br/><input type="text" name="login"/><br/><br/>
                <label>Senha:</label><br/><input type="password" name="senha"/><br/><br/>
                <input type="submit" value="Acessar"/>
            </form>
        </div>
    </body>
</html>
