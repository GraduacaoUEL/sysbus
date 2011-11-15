package servlets;

import DAO.CargoDAO;
import DAO.ColaboradorDAO;
import beans.Cargo;
import beans.Colaborador;
import beans.ColaboradorInnerJoinCargo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ColaboradorServlet extends HttpServlet {

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
            out.println("<title>Servlet ColaboradorServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ColaboradorServlet at " + request.getContextPath () + "</h1>");
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

        ArrayList<Cargo> cargos = new ArrayList<Cargo>();
        CargoDAO cargoDAO = new CargoDAO();
        cargos = cargoDAO.selectAll();
        request.setAttribute("Cargos", cargos);
    
        ArrayList<ColaboradorInnerJoinCargo> colaboradoresInnerJoinCargos = 
                new ArrayList<ColaboradorInnerJoinCargo>();
        
        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
        
        String opcao = request.getParameter("op");
        Integer id;
                
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException n) {
            id = 0;
        }
        
        if("excluir".equals(opcao))
        {
            colaboradorDAO.delete(id);
        }
        else if("editar".equals(opcao))
        {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
    
        ArrayList<Cargo> cargos = new ArrayList<Cargo>();

        CargoDAO cargoDAO = new CargoDAO();

        /* A variável cargos recebe todos os cargos que estão no banco de dados. */
        cargos = cargoDAO.selectAll();

        request.setAttribute("Cargos", cargos);

        /* Pôr um try/catch. */
        Colaborador colaborador = new Colaborador();

        colaborador.setCodigoColaborador(Integer.parseInt(request.getParameter("codigoColaborador")));
        colaborador.setNomeColaborador(request.getParameter("nomeColaborador"));
        colaborador.setLoginColaborador(request.getParameter("loginColaborador"));
        colaborador.setSenhaColaborador(request.getParameter("senhaColaborador"));
        colaborador.setCargoColaborador(Integer.parseInt(request.getParameter("cargoColaborador")));

        ColaboradorDAO colaboradorDAO = new ColaboradorDAO();

        colaboradorDAO.save(colaborador);

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
