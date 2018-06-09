/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelets;

import buisness.CategoryBusiness;
import buisness.UserBusiness;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Category;
import model.User;

/**
 *
 * @author dell-soncini
 */
@WebServlet(name = "CategoryEdit", urlPatterns = {"/category/edit"})
public class CategoryEdit extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CategoryEdit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CategoryEdit at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        model.User user = (model.User)session.getAttribute("User");
        if(user == null || user.getId() != 1)
        {
            response.sendRedirect("/financeiro/index");
        }
        else {
             int userId = Integer.parseInt(request.getParameter("id"));
             if(userId > 0) {
                 Category c = CategoryBusiness.getById(userId);
                 request.setAttribute("CategoryToEdit", c);
                 request.getRequestDispatcher("/CategoryEdit.jsp").forward(request, response);
             }
             else{
                 response.sendRedirect("/financeiro/user/list");
             }
          
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        model.User user = (model.User)session.getAttribute("User");
        if(user == null || user.getId() != 1)
        {
            response.sendRedirect("/financeiro/index");
        }
        else {
            int userId = Integer.parseInt(request.getParameter("id"));
            if(userId > 0) {
                Category c = CategoryBusiness.getById(userId);
                String name = (String) request.getParameter("name");
                String description = (String) request.getParameter("description");
                boolean entrece = request.getParameter("entrece") == null? false :((String)request.getParameter("entrece")).equals("true");
 
                c.setName(name);
                c.setDescription(description);
                c.setEntrece(entrece);
                CategoryBusiness.update(c);
                request.setAttribute("CategoryToEdit", c);
                request.getRequestDispatcher("/CategoryEdit.jsp").forward(request, response);
            }
            else{
                response.sendRedirect("/financeiro/user");
            }
        }
        
           
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
