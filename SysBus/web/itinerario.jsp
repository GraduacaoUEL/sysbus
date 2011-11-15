<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <div>
            <c:forEach var="periodos" items="${Periodos}">
                <table border="1">
                    <thead>
                        <tr>
                            <th></th>
                            <th>Origem do Trecho</th>
                            <th>Destino do Trecho</th>
                            <th>Tempo do Trecho</th>
                            <th>Distancia do Trecho</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><input type="checkbox" name="trecho" value="${trechos.codigoTrecho}"/></td>
                            <td>${trechos.origemTrecho}</td>
                            <td>${trechos.destinoTrecho}</td>
                            <td>${trechos.tempoTrecho}</td>
                            <td>${trechos.distanciaTrecho}</td>
                        </tr>
                    </tbody>
                </table>
                ${trechos.origemTrecho} às ${periodos.fimPeriodo}<br/>
            </c:forEach><br/>
        </div>
    </body>
</html>