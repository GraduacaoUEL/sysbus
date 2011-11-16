<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>::SysBus:: Menu</title>
    </head>
    <body>
        <h1>${Colaborador.nomeColaborador}</h1>

        <ul>
            ${Colaborador.permissaoCargos ? "<li><a href='CargoServlet'>Cargo</a></li>" : ""}            
            ${Colaborador.permissaoCarros ? "<li><a href='CarroServlet'>Carro</a></li>" : ""}
            ${Colaborador.permissaoCargos ? "<li><a href='ColaboradorServlet'>Colaborador</a></li>" : ""}
            ${Colaborador.permissaoCustos ? "<li><a href='CustoServlet'>Custo</a></li>" : ""}
            ${Colaborador.permissaoCustos ? "<li><a href='DemandaServlet'>Demanda</a></li>" : ""}
            ${Colaborador.permissaoItinerarios ? "<li><a href='ItinerarioServlet'>Itinerário</a></li>" : ""}
            ${Colaborador.permissaoItinerarios ? "<li><a href='LinhaServlet'>Linha</a></li>" : ""}
            ${Colaborador.permissaoCustos ? "<li><a href='periodo.jsp'>Período</a></li>" : ""}
            ${Colaborador.permissaoItinerarios ? "<li><a href='trecho.jsp'>Trecho</a></li>" : ""}
            ${Colaborador.permissaoVendas ? "<li><a href='venda.jsp'>Venda no guichê</a></li>" : ""}
        </ul>

    </body>
</html>
