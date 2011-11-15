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
                <label>Data e hora:</label><br/><input type="text" name="dataHoraVenda"/><br/><br/>
                <label>Tipo de pagamento:</label><br/><input type="text" name="tipoPagamento"/><br/><br/>
                <label>Valor:</label><br/><input type="text" name="valorVenda"/><br/><br/>
                <label>Vendedor:</label><br/><input type="text" name="vendedor"/><br/><br/>
                <label>Carro:</label><br/><input type="text" name="carroVenda"/><br/><br/>
                <input type="checkbox" name="passagemEntregue" value="true"/><label>Passagem entregue</label><br/><br/>
                <input type="checkbox" name="viaWeb" value="true"/><label>Via web</label><br/><br/>
                <input type="submit" value="Salvar"/>
            </form>
        </div>
    </body>
</html>
