package servlets;

import DAO.VendaDAO;
import beans.Venda;
import beans.VendaIJColaborador;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VendaServlet extends HttpServlet {

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcao = request.getParameter("op");
        Integer id;

        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException n) {
            id = 0;
        }

        VendaDAO vendaDAO = new VendaDAO();

        if ("excluir".equals(opcao)) {
            vendaDAO.delete(id);
        } else if ("editar".equals(opcao)) {
            Venda vendaParaEdicao = new Venda();
            vendaParaEdicao = vendaDAO.selectForId(id);

            request.setAttribute("VendaEdicao", vendaParaEdicao);
        }

        ArrayList<VendaIJColaborador> vendas = new ArrayList<VendaIJColaborador>();
        vendas = vendaDAO.selectAllWithJoin();
        request.setAttribute("Vendas", vendas);
        request.getRequestDispatcher("/venda.jsp").forward(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Venda venda = new Venda();
        
        venda.setCodigoVenda(Integer.parseInt((request.getParameter("codigoVenda").equals("") ? "0" : request.getParameter("codigoCargo"))));
        venda.setDataHoraVenda(Timestamp.valueOf(request.getParameter("dataHoraVenda")));
        venda.setTipoPagamento(request.getParameter("tipoPagamento"));
        venda.setValorVenda(Float.parseFloat(request.getParameter("valorVenda")));
        venda.setVendedor(Integer.parseInt(request.getParameter("vendedor")));
        venda.setCarroVenda(Integer.parseInt(request.getParameter("carroVenda")));
        venda.setPassagemEntregue(Boolean.valueOf(request.getParameter("passagemEntregue")));
        venda.setViaWeb(Boolean.valueOf(request.getParameter("viaWeb")));
        
        VendaDAO vendaDAO = new VendaDAO();
        
        vendaDAO.save(venda);
        doGet(request, response);
    }
}