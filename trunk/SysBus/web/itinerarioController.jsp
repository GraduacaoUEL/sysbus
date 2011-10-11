<%-- 
    Document   : itinerarioController
    Created on : 11/10/2011, 16:31:07
    Author     : helioalb
--%>


<jsp:useBean id="itinerario" scope="session" class="beans.Itinerario" />
<jsp:setProperty name="itinerario" property="nomeItinerario" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        Nome do Itinerario: <%= itinerario.getNomeItinerario() %>
        
        <%
            DAO.ItinerarioDAO iuds = new DAO.ItinerarioDAO();
            iuds.add(itinerario);
        %>
        
    </body>
</html>
