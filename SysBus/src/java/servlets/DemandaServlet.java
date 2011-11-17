package servlets;

import DAO.DemandaDAO;
import DAO.PeriodoDAO;
import beans.Demanda;
import beans.Periodo;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemandaServlet extends HttpServlet {

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        DemandaDAO demandaDAO = new DemandaDAO();

        Demanda demanda = new Demanda();

        try {
            demanda.setCodigoDemanda(Integer.parseInt(request.getParameter("codigoDemanda")));
        } catch (NumberFormatException n) {
            demanda.setCodigoDemanda(0);
        }

        String periodoForm[] = request.getParameterValues("periodo");

        ArrayList<Periodo> periodosDemanda = new ArrayList<Periodo>();

        for (int i = 0; i < periodoForm.length; i++) {
            Periodo periodo = new Periodo();
            periodo.setCodigoPeriodo(Integer.parseInt(periodoForm[i]));
            periodosDemanda.add(periodo);
        }

        demanda.setNomeDemanda(request.getParameter("nomeDemanda"));
        demanda.setPeriodosDemanda(periodosDemanda);

        demandaDAO.insert(demanda);

        doGet(request, response);
    }
}
