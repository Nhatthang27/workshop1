/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.CategoryDao;
import model.dto.Category;

/**
 *
 * @author Nhatthang
 */
public class UpdateCategoryServlet extends HttpServlet {

    private final String SHOW_CATEGORY_LIST_ACTION = "showCategoryList";
    private final String UPDATE_CATEGORY_PAGE_ACTION = "updateCategoryPage";

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
        request.setCharacterEncoding("UTF-8");

        String action = SHOW_CATEGORY_LIST_ACTION;
        String categoryId = request.getParameter("categoryId");
        String categoryName = request.getParameter("categoryName");
        String categoryNote = request.getParameter("categoryNote");

        CategoryDao cateDao = new CategoryDao(getServletContext());
        Category cate = new Category(categoryName, categoryNote);
        try {
            System.err.println("id in UpdateServlet: " + categoryId);
            cateDao.update(categoryId, cate);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            request.setAttribute("errorCategoryName", "Category name already existed");
            action = UPDATE_CATEGORY_PAGE_ACTION;
        }
        RequestDispatcher rd = request.getRequestDispatcher("DispatcherProductServlet?action=" + action);
        rd.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
