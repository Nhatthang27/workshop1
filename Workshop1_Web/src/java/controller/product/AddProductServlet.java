/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.CategoryDao;
import model.dao.ProductDao;
import model.dto.Account;
import model.dto.Category;
import model.dto.Product;

/**
 *
 * @author Nhatthang
 */
public class AddProductServlet extends HttpServlet {

    private final String SHOW_PRODUCT_LIST_ACTION = "showProductList";

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

        String action = SHOW_PRODUCT_LIST_ACTION;
        try {
            String productId = request.getParameter("productId");
            String productName = request.getParameter("productName");
            String productImage = request.getParameter("productImage");
            String productBrief = request.getParameter("brief");
            Date postedDate = new Date(new java.util.Date().getTime());
            Category category = new CategoryDao(getServletContext()).getObjectByID(request.getParameter("category"));
            Account account = (Account) request.getSession().getAttribute("account");
            int price = Integer.parseInt(request.getParameter("price"));
            int discount = Integer.parseInt(request.getParameter("discount"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            Product newPrd = new Product(productId, productName, productImage, productBrief, postedDate, category, account, price, discount, quantity);
            ProductDao prdDao = new ProductDao(getServletContext());
            prdDao.insert(newPrd);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateProductServlet.class.getName()).log(Level.SEVERE, null, ex);
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
