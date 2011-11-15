package servlets;

import DAO.DemandaDAO;
import DAO.PeriodoDAO;
import beans.Demanda;
import beans.Periodo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemandaServlet extends HttpServlet {

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
            out.println("<title>Servlet DemandaServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DemandaServlet at " + request.getContextPath () + "</h1>");
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

    
        ArrayList<Periodo> periodos = new ArrayList<Periodo>();     
        PeriodoDAO periodoDAO = new PeriodoDAO();
        periodos = periodoDAO.selectAll();
        request.setAttribute("Periodos", periodos);
        
        ArrayList<Demanda> demandas = new ArrayList<Demanda>();
        DemandaDAO demandaDAO = new DemandaDAO();
        demandas = demandaDAO.selectAll();
        request.setAttribute("Demandas", demandas);
        
        request.getRequestDispatcher("/demanda.jsp").forward(request, response);
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
            
        DemandaDAO demandaDAO = new DemandaDAO();
        
        Demanda demanda = new Demanda();
        
        try{
            demanda.setCodigoDemanda(Integer.parseInt(request.getParameter("codigoDemanda")));
        }catch(NumberFormatException n){
            demanda.setCodigoDemanda(0);
        }
        
        /*Carrega todos os periodos no bean Demanda*/
        //Captura todos os checbox marcados no formulario
        String periodoForm[] = request.getParameterValues("periodo[]");
        
        //Esse array irá guardar todos os períodos pertencentes à essa demanda.
        ArrayList<Periodo> periodosDemanda = 
                new ArrayList<Periodo>();
        
        for(int i = 0; i < periodoForm.length; i++){
            Periodo periodo = new Periodo();
            periodo.setCodigoPeriodo(Integer.parseInt(periodoForm[i]));
            periodosDemanda.add(periodo);
        }

        demanda.setNomeDemanda(request.getParameter("nomeDemanda"));
        demanda.setPeriodosDemanda(periodosDemanda);
        
        demandaDAO.insert(demanda);
        
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
