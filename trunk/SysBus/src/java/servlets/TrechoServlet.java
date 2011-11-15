package servlets;

import DAO.TrechoDAO;
import beans.Trecho;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TrechoServlet extends HttpServlet {

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
            out.println("<title>Servlet TrechoServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TrechoServlet at " + request.getContextPath () + "</h1>");
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
        
        String opcao = request.getParameter("op");
        Integer id;

        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException n) {
            id = 0;
        }

        TrechoDAO trechoDAO = new TrechoDAO();

        if ("excluir".equals(opcao)) {
            trechoDAO.delete(id);
        } else if ("editar".equals(opcao)) {
            Trecho trechoParaEdicao = new Trecho();
            trechoParaEdicao = trechoDAO.selectForId(id);

            request.setAttribute("TrechoEdicao", trechoParaEdicao);
        }

        ArrayList<Trecho> trechos = new ArrayList<Trecho>();
        
        trechos = trechoDAO.selectAll();
        request.setAttribute("Trechos", trechos);
        request.getRequestDispatcher("/trecho.jsp").forward(request, response);
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
        
        Trecho trecho = new Trecho();
        
        try{
            trecho.setCodigoTrecho(Integer.parseInt(request.getParameter("codigoTrecho")));
        }catch(NumberFormatException n){
            trecho.setCodigoTrecho(0);
        }

        trecho.setOrigemTrecho(request.getParameter("origemTrecho"));
        trecho.setDestinoTrecho(request.getParameter("destinoTrecho"));
        trecho.setTempoTrecho(Time.valueOf(request.getParameter("tempoTrecho")));
        trecho.setDistanciaTrecho(Float.parseFloat(request.getParameter("distanciaTrecho")));
        
        TrechoDAO trechoDAO = new TrechoDAO();
        
        trechoDAO.save(trecho);
        
        doGet(request, response);
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
