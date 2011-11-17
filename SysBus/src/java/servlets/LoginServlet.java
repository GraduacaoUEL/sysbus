/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.ColaboradorDAO;
import beans.Colaborador;
import beans.ColaboradorIJCargo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author helioalb
 */
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath () + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        Colaborador colaborador = new Colaborador();
        
        colaborador = colaboradorDAO.selectForLogin(request.getParameter("login"));
        
        String senhaBanco = colaborador.getSenhaColaborador();
        senhaBanco = senhaBanco.toString();
        
        String senhaForm = request.getParameter("senha");
        senhaForm = senhaForm.toString();
        
        System.out.println("Senha do Banco: " + senhaBanco);
        System.out.println("Senha do Form: " + senhaForm);
        
    //Esse if/else não tem sentido, mas funciona só funciona assim
//        if(senhaForm.toString().equals(senhaBanco.toString())){
//            ColaboradorIJCargo colaboradorInnerJoinCargo = new ColaboradorIJCargo();
//            colaboradorInnerJoinCargo = colaboradorDAO.selectWithJoin(request.getParameter("login"));
//            request.setAttribute("Colaborador", colaboradorInnerJoinCargo);
//            
//            doGet(request, response);
//            
//        } else {
//            System.out.println("Volta pro login");
//        }
                
        if(senhaBanco.equals(senhaForm))
            System.out.println("É igual");
        else
            System.out.println("não igual");
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
