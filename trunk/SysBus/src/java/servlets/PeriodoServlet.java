package servlets;

import DAO.PeriodoDAO;
import beans.Periodo;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PeriodoServlet extends HttpServlet {

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

        PeriodoDAO periodoDAO = new PeriodoDAO();

        if ("excluir".equals(opcao)) {
            periodoDAO.delete(id);
        } else if ("editar".equals(opcao)) {
            Periodo periodoParaEdicao = new Periodo();
            periodoParaEdicao = periodoDAO.selectForId(id);

            request.setAttribute("PeriodoEdicao", periodoParaEdicao);
        }

        ArrayList<Periodo> periodos = new ArrayList<Periodo>();
        periodos = periodoDAO.selectAll();
        request.setAttribute("Periodos", periodos);

        request.getRequestDispatcher("/periodo.jsp").forward(request, response);
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
        
        Periodo periodo = new Periodo();

        try {
            periodo.setCodigoPeriodo(Integer.parseInt(request.getParameter("codigoPeriodo")));
        } catch (NumberFormatException n) {
            periodo.setCodigoPeriodo(0);
        }
        
        periodo.setInicioPeriodo(Time.valueOf(request.getParameter("inicioPeriodo")));
        periodo.setFimPeriodo(Time.valueOf(request.getParameter("fimPeriodo")));
        periodo.setFatorMultiplicacao(Float.parseFloat(request.getParameter("fatorMultiplicacao")));

        PeriodoDAO periodoDAO = new PeriodoDAO();

        periodoDAO.save(periodo);

        doGet(request, response);
    }
}