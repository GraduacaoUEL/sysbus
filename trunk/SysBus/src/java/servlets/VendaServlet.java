package servlets;

import DAO.VendaDAO;
import beans.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VendaServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VendaServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VendaServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        Venda venda = new Venda();
        
        venda.setDataHoraVenda(Timestamp.valueOf(request.getParameter("dataHoraVenda")));
        venda.setTipoPagamento(request.getParameter("tipoPagamento"));
        venda.setValorVenda(Float.parseFloat(request.getParameter("valorVenda")));
        venda.setVendedor(Integer.parseInt(request.getParameter("vendedor")));
        venda.setCarroVenda(Integer.parseInt(request.getParameter("carroVenda")));
        venda.setPassagemEntregue(Boolean.valueOf(request.getParameter("passagemEntregue")));
        venda.setViaWeb(Boolean.valueOf(request.getParameter("viaWeb")));
        
        VendaDAO vendaDAO = new VendaDAO();
        
        vendaDAO.insert(venda);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
