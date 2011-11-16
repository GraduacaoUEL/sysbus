package servlets;

import DAO.ItinerarioDAO;
import DAO.TrechoDAO;
import beans.Itinerario;
import beans.Trecho;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ItinerarioServlet extends HttpServlet {

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
            out.println("<title>Servlet ItinerarioServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ItinerarioServlet at " + request.getContextPath () + "</h1>");
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
        
        ArrayList<Trecho> trechos = new ArrayList<Trecho>();
        TrechoDAO trechoDAO = new TrechoDAO();
        trechos = trechoDAO.selectAll();
        request.setAttribute("Trechos", trechos);
        
        ArrayList<Itinerario> itinerarios = new ArrayList<Itinerario>();
        ItinerarioDAO itinerarioDAO = new ItinerarioDAO();
        itinerarios = itinerarioDAO.selectAll();
        request.setAttribute("Itinerarios", itinerarios);
        
        request.getRequestDispatcher("/itinerario.jsp").forward(request, response);

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

        ItinerarioDAO itinerarioDAO = new ItinerarioDAO();      
        
        Itinerario itinerario = new Itinerario();
        
        try{
            itinerario.setCodigoItinerario(Integer.parseInt(request.getParameter("codigoItinerario")));
        } catch (NumberFormatException n){
            itinerario.setCodigoItinerario(0);
        }
        
        
        String trechoForm[] = request.getParameterValues("trecho");        

        ArrayList<Trecho> trechosItinerario = 
                new ArrayList<Trecho>();
        
        for(int i = 0; i < trechoForm.length; i++){
            Trecho trecho = new Trecho();
            trecho.setCodigoTrecho(Integer.parseInt(trechoForm[i]));
            trechosItinerario.add(trecho);
        }

        itinerario.setNomeItinerario(request.getParameter("nomeItinerario"));
        itinerario.setTrechosItinerario(trechosItinerario);
        
        itinerarioDAO.insert(itinerario);
        
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