package servlets;

import DAO.CarroDAO;
import DAO.LinhaDAO;
import beans.Carro;
import beans.CarroIJLinha;
import beans.Linha;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarroServlet extends HttpServlet {

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
        
        ArrayList<Linha> linhas = new ArrayList<Linha>();
        LinhaDAO linhaDAO = new LinhaDAO();
        linhas = linhaDAO.selectAll();
        CarroDAO carroDAO = new CarroDAO();
        
        request.setAttribute("Linhas", linhas);
        
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException n) {
            id = 0;
        }

        if ("excluir".equals(opcao)) {
            carroDAO.delete(id);
        } else if ("editar".equals(opcao)) {
            Carro carroParaEdicao = new Carro();
            carroParaEdicao = carroDAO.selectForId(id);

            request.setAttribute("CarroEdicao", carroParaEdicao);
        }

        ArrayList<CarroIJLinha> carros = new ArrayList<CarroIJLinha>();
        carros = carroDAO.selectAllWithJoin();
        
        request.setAttribute("Carros", carros);
        request.getRequestDispatcher("/carro.jsp").forward(request, response);
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
        
        CarroDAO carroDAO = new CarroDAO();
        Carro carro = new Carro();

        carro.setCodigoCarro(Integer.parseInt(request.getParameter("codigoCarro")));
        carro.setNumeroDePassageiros(Integer.parseInt(request.getParameter("numeroDePassageiros")));
        carro.setLinhaCarro(Integer.parseInt(request.getParameter("linhaCarro")));

        carroDAO.save(carro);

        doGet(request, response);
    }
}
