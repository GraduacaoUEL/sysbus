<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Período</title>
    </head>
    <body>
        <form name="cadastroPeriodo" action="PeriodoServlet" method="post">
            Início: <input type="text" name="inicioPeriodo"/><br/>
            Fim: <input type="text" name="fimPeriodo"/><br/>
            Fator de multiplicação: <input type="text" name="fatorMultiplicacao"/><br/>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
