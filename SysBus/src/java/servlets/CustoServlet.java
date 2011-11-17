package servlets;

import DAO.CustoDAO;
import beans.Custo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustoServlet extends HttpServlet {

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Custo custo = new Custo();    
        CustoDAO custoDAO = new CustoDAO();
        custo = custoDAO.selectCusto();
        request.setAttribute("Custo", custo);
        
        request.getRequestDispatcher("/custo.jsp").forward(request, response);
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
        
        Custo custo = new Custo();
        
        custo.setPrecoQuilometro(Float.parseFloat(request.getParameter("precoQuilometro")));
        custo.setCodigoCusto(1);
        CustoDAO custoDAO = new CustoDAO();
      
        custoDAO.update(custo);
        
        doGet(request, response);
    }
}
