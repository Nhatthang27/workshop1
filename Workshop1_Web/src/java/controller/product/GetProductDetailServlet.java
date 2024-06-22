/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.CategoryDao;
import model.dao.ProductDao;
import model.dto.Category;
import model.dto.Product;

/**
 *
 * @author Nhatthang
 */
public class GetProductDetailServlet extends HttpServlet {

    private final String GET_PRODUCT_DETAIL_PAGE_ACTION = "getProductDetailPage";
    private final String UPDATE_PRODUCT_PAGE_ACTION = "updateProductPage";
    private final String ADD_PRODUCT_PAGE_ACTION = "addProductPage";

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

        String add_update_detail = request.getParameter("add_update_detail");

        ProductDao prdDao = new ProductDao(getServletContext());
        CategoryDao cateDao = new CategoryDao(getServletContext());

        String productId = request.getParameter("productId");

        String action = null;
        if (add_update_detail.equals("add")) {
            action = ADD_PRODUCT_PAGE_ACTION;
        } else if (add_update_detail.equals("update")) {
            action = UPDATE_PRODUCT_PAGE_ACTION;
        } else {
            action = GET_PRODUCT_DETAIL_PAGE_ACTION;
        }
        try {
            if (productId != null) {
                Product prd = prdDao.getObjectByID(productId);
                request.setAttribute("prd", prd);
            }
            List<Category> categories = cateDao.getAllCategories();
            request.setAttribute("categories", categories);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetProductDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GetProductDetailServlet.class.getName()).log(Level.SEVERE, null, ex);
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
