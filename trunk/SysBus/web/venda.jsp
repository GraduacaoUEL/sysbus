<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <link rel=StyleSheet href="estilo.css" type="text/css" media=screen/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SysBus: Gerenciamento de vendas</title>
    </head>
    <body>
        <div id="titulo">
            <p>SysBus: Gerenciamento de vendas</p>
        </div>
        <jsp:include page="menu.html" flush="true"/>
        <div id="form">
            <p>Inserção/Atualização</p>
            <form name="cadastroVenda" action="VendaServlet" method="post">
                <input type="text" name="codigoVenda" value="${VendaEdicao.codigoVenda}" size="3" hidden/>
                <label>Data e hora:</label><br/><input type="text" name="dataHoraVenda" value="${VendaEdicao.dataHoraVenda}"/><br/><br/>
                <label>Tipo de pagamento:</label><br/>
                <select name="tipoPagamento">
                    <option value="Dinheiro">Dinheiro</option>
                    <option value="Cartão">Cartão</option>
                </select><br/><br/>
                <label>Valor:</label><br/><input type="text" name="valorVenda" value="${VendaEdicao.valorVenda}"/><br/><br/>
                <label>Vendedor:</label><br/><input type="text" name="vendedor" value="${VendaEdicao.vendedor}"/><br/><br/>
                <label>Carro:</label><br/><input type="text" name="carroVenda" value="${VendaEdicao.carroVenda}"/><br/><br/>
                <input type="checkbox" name="passagemEntregue" value="true" ${VendaEdicao.passagemEntregue ? "CHECKED" : ""}/><label>Passagem entregue</label><br/><br/>
                <input type="checkbox" name="viaWeb" value="true" ${VendaEdicao.viaWeb ? "CHECKED" : ""}/><label>Via web</label><br/><br/>
                <input type="submit" value="Salvar"/>
            </form>
        </div>
        <div id="tabela">
            <p>Vendas existentes</p>
            <table>
                <thead>
                    <tr>
                        <th>Data e hora</th>
                        <th>Tipo</th>
                        <th>Valor</th>
                        <th>Vendedor</th>
                        <th>Carro</th>
                        <th>Passagem entregue</th>
                        <th>Via web</th>
                        <th>Editar</th>
                        <th>Excluir</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="vendas" items="${Vendas}">
                        <tr>
                            <td><c:out value="${vendas.dataHoraVenda}"/></td>
                            <td><c:out value="${vendas.tipoPagamento}"/></td>
                            <td><c:out value="${vendas.valorVenda}"/></td>
                            <td><c:out value="${vendas.vendedor}"/></td>
                            <td><c:out value="${vendas.carroVenda}"/></td>
                            <td><c:out value="${vendas.passagemEntregue ? 'sim' : 'não'}"/></td>
                            <td><c:out value="${vendas.viaWeb ? 'sim' : 'não'}"/></td>
                            <td><a href="VendaServlet?op=editar&id=<c:out value="${vendas.codigoVenda}"/>">Editar</a></td>
                            <td><a href="VendaServlet?op=excluir&id=<c:out value="${vendas.codigoVenda}"/>">Excluir</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
