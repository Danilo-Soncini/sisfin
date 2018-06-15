/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelets;

import buisness.CategoryBusiness;
import dao.userBudgetDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Category;
import model.UseBudget;
import model.User;

/**
 *
 * @author dell-soncini
 */
@WebServlet(name = "budget", urlPatterns = {"/user/budget"})
public class UserBudget extends HttpServlet {

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
            out.println("<title>Servlet budget</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet budget at " + request.getContextPath() + "</h1>");
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
        User user = (User)session.getAttribute("User");
        if(user != null)
        {
            String mes = (String) request.getParameter("month");
            String ano = (String)request.getParameter("year");
            if(mes == null || ano == null ){
                Date dNow = new Date();
                SimpleDateFormat ftmes = new SimpleDateFormat("MM");
                 mes = ftmes.format(dNow);
                SimpleDateFormat ftano = new SimpleDateFormat("yyyy");
                 ano = ftano.format(dNow);
               
            }
            userBudgetDAO ubg =new userBudgetDAO();
            ArrayList<UseBudget>Orcamentos = ubg.get(user.getId(), Integer.parseInt(mes), Integer.parseInt(ano));
            request.setAttribute("Mes", mes);
            request.setAttribute("Ano", ano);
            ArrayList<Category> c = CategoryBusiness.getAll();
            request.setAttribute("Categories", c);
            request.setAttribute("Orcamentos", Orcamentos);
            request.getRequestDispatcher("/budget.jsp").forward(request, response);
        }
        else{
            response.sendRedirect("/financeiro/index");
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
        User user = (User)session.getAttribute("User");
        if(user != null)
        {
            Enumeration<String> atributes = request.getParameterNames();
            int month = Integer.parseInt(request.getParameter("month"));
            int year = Integer.parseInt(request.getParameter("year"));
            int idCategory = 0;
            double valor = 0;
            while (atributes.hasMoreElements())
            {
                String name = (String) atributes.nextElement();
                if(name.indexOf("cat") > -1)
                {
                     idCategory = Integer.parseInt(name.replace("cat", ""));
                     valor = Double.parseDouble("0"+(String)request.getParameter(name));
                     UseBudget buget = new UseBudget();
                     buget.setIdUser(user.getId());
                     buget.setIdCategory(idCategory);
                     buget.setBudget(valor);
                     buget.setYear(year);
                     buget.setMonth(month);
                     userBudgetDAO u = new userBudgetDAO();
                     buget = u.upInsert(buget);
                }
            }
            
            response.sendRedirect("/financeiro/user/budget?year="+year+"&month="+month);
        }
        else{
            response.sendRedirect("/financeiro/index");
        }

        /*for(String i : atributes)
        {
        
        }*/
        //request.get
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
