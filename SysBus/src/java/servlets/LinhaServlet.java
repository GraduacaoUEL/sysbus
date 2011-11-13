package servlets;

import DAO.DemandaDAO;
import DAO.LinhaDAO;
import beans.Demanda;
import beans.Linha;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinhaServlet extends HttpServlet {

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
            out.println("<title>Servlet LinhaServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LinhaServlet at " + request.getContextPath () + "</h1>");
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
        //processRequest(request, response);

        
        ArrayList<Demanda> demandas = new ArrayList<Demanda>();
        DemandaDAO demandaDAO = new DemandaDAO();
        demandas = demandaDAO.selectAll();
        request.setAttribute("Demandas", demandas);
    
        ArrayList<Linha> linhas = new ArrayList<Linha>();
        LinhaDAO linhasDAO = new LinhaDAO();
        linhas = linhasDAO.selectAll();
        request.setAttribute("Linhas", linhas);
        
        request.getRequestDispatcher("/linha.jsp").forward(request, response);
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
        
        Linha linha = new Linha();
        
        linha.setNomeLinha(request.getParameter("nomeLinha"));
        linha.setHoraInicioLinha(Time.valueOf(request.getParameter("horaInicioLinha")));
        linha.setDemandaLinha(Integer.parseInt(request.getParameter("demandaLinha")));
        
        LinhaDAO linhaDAO = new LinhaDAO();
        
        linhaDAO.insert(linha);
        
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
