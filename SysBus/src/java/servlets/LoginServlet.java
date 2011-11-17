package servlets;

import DAO.ColaboradorDAO;
import beans.Colaborador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/menu.jsp").forward(request, response);
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
        
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        Colaborador colaborador = new Colaborador();
        
        colaborador = colaboradorDAO.selectForLogin(request.getParameter("login"));
        
        String senhaBanco = colaborador.getSenhaColaborador();
        senhaBanco = senhaBanco.toString();
        
        String senhaForm = request.getParameter("senha");
        senhaForm = senhaForm.toString();
        
        System.out.println("Senha do Banco: " + senhaBanco);
        System.out.println("Senha do Form: " + senhaForm);
        
//      Esse if/else não tem sentido, mas só funciona assim
//      if(senhaForm.toString().equals(senhaBanco.toString())){
//          ColaboradorIJCargo colaboradorInnerJoinCargo = new ColaboradorIJCargo();
//          colaboradorInnerJoinCargo = colaboradorDAO.selectWithJoin(request.getParameter("login"));
//          request.setAttribute("Colaborador", colaboradorInnerJoinCargo);
//          
//          doGet(request, response);
//      
//      } else {
//          System.out.println("Volta pro login");
//      }
        
        if(senhaBanco.equals(senhaForm))
            System.out.println("É igual");
        else
            System.out.println("não igual");
    }
}