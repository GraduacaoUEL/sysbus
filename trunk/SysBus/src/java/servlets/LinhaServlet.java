package servlets;

import DAO.DemandaDAO;
import DAO.ItinerarioDAO;
import DAO.LinhaDAO;
import beans.Demanda;
import beans.Itinerario;
import beans.Linha;
import beans.LinhaIJDemandaIJPercorreIJItinerario;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinhaServlet extends HttpServlet {

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Demanda> demandas = new ArrayList<Demanda>();
        DemandaDAO demandaDAO = new DemandaDAO();
        demandas = demandaDAO.selectAll();
        request.setAttribute("Demandas", demandas);
        
        ArrayList<Itinerario> itinerarios = new ArrayList<Itinerario>();
        ItinerarioDAO itinerarioDAO = new ItinerarioDAO();
        itinerarios = itinerarioDAO.selectAll();
        request.setAttribute("Itinerarios", itinerarios);
    
        ArrayList<LinhaIJDemandaIJPercorreIJItinerario> linhas = new ArrayList<LinhaIJDemandaIJPercorreIJItinerario>();
        LinhaDAO linhasDAO = new LinhaDAO();
        linhas = linhasDAO.selectAllWithJoin();
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
        Linha linha = new Linha();
        
        linha.setNomeLinha(request.getParameter("nomeLinha"));
        linha.setHoraInicioLinha(Time.valueOf(request.getParameter("horaInicioLinha")));
        linha.setDemandaLinha(Integer.parseInt(request.getParameter("demandaLinha")));
        linha.setItinerarioLinha(Integer.parseInt(request.getParameter("itinerarioLinha")));
        
        LinhaDAO linhaDAO = new LinhaDAO();
        linhaDAO.insert(linha);
        
        doGet(request, response);
    }
}