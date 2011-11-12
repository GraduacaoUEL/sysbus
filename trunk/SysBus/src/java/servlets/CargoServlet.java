package servlets;

import DAO.CargoDAO;
import beans.Cargo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CargoServlet extends HttpServlet {

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
            out.println("<title>Servlet CargoServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CargoServlet at " + request.getContextPath () + "</h1>");
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
    
        String opcao = request.getParameter("op");
        Integer id;
        
        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException n) {
            id = 0;
        }
        
        CargoDAO cargoDAO = new CargoDAO();
        
        
        if("excluir".equals(opcao))
        {
            cargoDAO.delete(id);
        }
        else if("editar".equals(opcao))
        {
            Cargo cargoParaEdicao = new Cargo();
            cargoParaEdicao = cargoDAO.selectForId(id);
            
            request.setAttribute("CargoEdicao", cargoParaEdicao);
        }
        
        ArrayList<Cargo> cargos = new ArrayList<Cargo>();
                
        /*A variável cargos recebe todos os cargos que estão no banco de dados*/        
        cargos = cargoDAO.selectAll();

        request.setAttribute("Cargos", cargos);
        
        request.getRequestDispatcher("/cargo.jsp").forward(request, response);

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
        
        CargoDAO cargoDAO = new CargoDAO();
        
        Cargo cargo = new Cargo();
        
        cargo.setCodigoCargo(Integer.parseInt((request.getParameter("codigoCargo").equals("") ? "0" : request.getParameter("codigoCargo"))));
        cargo.setNomeCargo(request.getParameter("nomeCargo"));
        cargo.setPermissaoCargos(Boolean.valueOf(request.getParameter("permissaoCargos")));
        cargo.setPermissaoCarros(Boolean.valueOf(request.getParameter("permissaoCarros")));
        cargo.setPermissaoCustos(Boolean.valueOf(request.getParameter("permissaoCustos")));
        cargo.setPermissaoItinerarios(Boolean.valueOf(request.getParameter("permissaoItinerarios")));
        cargo.setPermissaoVendas(Boolean.valueOf(request.getParameter("permissaoVendas")));

        cargoDAO.save(cargo);
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