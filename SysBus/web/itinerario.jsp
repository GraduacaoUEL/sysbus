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

                <div>
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

                            <c:forEach var="trechos" items="${Trechos}">
                                <tr>
                                    <td><input type="checkbox" name="trecho" value="${trechos.codigoTrecho}"/></td>
                                    <td>${trechos.origemTrecho}</td>
                                    <td>${trechos.destinoTrecho}</td>
                                    <td>${trechos.tempoTrecho}</td>
                                    <td>${trechos.distanciaTrecho}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>                    
                </div>
                <input type="submit" value="Salvar"/>
            </form>
        </div>

        <div id="tabela">
            <p>Itinerarios existentes</p>
            <table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Editar</th>
                        <th>Excluir</th>
                    </tr>
                </thead>
                <tbody>                
                    <c:forEach var="itinerarios" items="${Itinerarios}">
                        <tr>
                            <td><c:out value="${itinerarios.nomeItinerario}"/></td>
                            <td>TODO</td>
                            <td>TODO</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </body>
</html>
