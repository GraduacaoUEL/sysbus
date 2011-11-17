package servlets;

import DAO.CargoDAO;
import DAO.ColaboradorDAO;
import beans.Cargo;
import beans.Colaborador;
import beans.ColaboradorIJCargo;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ColaboradorServlet extends HttpServlet {

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Cargo> cargos = new ArrayList<Cargo>();
        CargoDAO cargoDAO = new CargoDAO();
        cargos = cargoDAO.selectAll();
        request.setAttribute("Cargos", cargos);

        ArrayList<ColaboradorIJCargo> colaboradoresInnerJoinCargos = new ArrayList<ColaboradorIJCargo>();

        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();

        String opcao = request.getParameter("op");
        Integer id;

        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException n) {
            id = 0;
        }

        if ("excluir".equals(opcao)) {
            colaboradorDAO.delete(id);
        } else if ("editar".equals(opcao)) {
            Colaborador colaboradorParaEdicao = new Colaborador();
            colaboradorParaEdicao = colaboradorDAO.selectForId(id);

            request.setAttribute("ColaboradorEdicao", colaboradorParaEdicao);
        }

        colaboradoresInnerJoinCargos = colaboradorDAO.selectAllWithJoin();
        request.setAttribute("Colaboradores", colaboradoresInnerJoinCargos);


        request.getRequestDispatcher("/colaborador.jsp").forward(request, response);
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

        ArrayList<Cargo> cargos = new ArrayList<Cargo>();
        CargoDAO cargoDAO = new CargoDAO();

        cargos = cargoDAO.selectAll();

        request.setAttribute("Cargos", cargos);

        Colaborador colaborador = new Colaborador();

        try {
            colaborador.setCodigoColaborador(Integer.parseInt(request.getParameter("codigoColaborador")));
        } catch (NumberFormatException n) {
            colaborador.setCodigoColaborador(0);
        }

        colaborador.setNomeColaborador(request.getParameter("nomeColaborador"));
        colaborador.setLoginColaborador(request.getParameter("loginColaborador"));
        colaborador.setSenhaColaborador(request.getParameter("senhaColaborador"));
        colaborador.setCargoColaborador(Integer.parseInt(request.getParameter("cargoColaborador")));

        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();

        colaboradorDAO.save(colaborador);

        doGet(request, response);
    }
}
