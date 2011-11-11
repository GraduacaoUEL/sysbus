<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Linha</title>
    </head>
    <body>
        <form name="cadastroLinha" action="LinhaServlet" method="post">
            Nome: <input type="text" name="nomeLinha"/><br/>
            Hora de início: <input type="text" name="horaInicioLinha"/><br/>
            <!-- Demanda: <input type="text" name="demandaLinha"/><br/> -->
            
            
            Demanda: <select name="demandaLinha">
                <c:forEach var="demandas" items="${Demandas}">
                    <option value ="<c:out value="${demandas.codigoDemanda}"/>">
                        <c:out value="${demandas.nomeDemanda}" />
                    </option>
                </c:forEach>
            </select>

            <input type="submit" value="Enviar"/>
        </form>
        
        <!-- Tentar fazer essa chamada no servlet de forma mais inteligente-->
        <a href="/SysBus/index.jsp">Página Inicial</a>
    </body>
</html>
