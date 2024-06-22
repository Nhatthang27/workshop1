/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nhatthang
 */
public class DispatcherProductServlet extends HttpServlet {

    private final String DASHBOARD_PAGE_ACTION = "dashboard";
    private final String DASHBOARD_PAGE = "dashboard.jsp";
    
    private final String SHOW_PRODUCT_LIST_PAGE_ACTION = "showProductListPage";
    private final String SHOW_PRODUCT_LIST_ACTION = "showProductList";
    private final String SHOW_PRODUCT_LIST_PAGE = "productList.jsp";
    private final String SHOW_PRODUCT_LIST_CONTROLLER = "ShowProductListServlet";
    
    private final String SHOW_CATEGORY_LIST_PAGE_ACTION = "showCategoryListPage";
    private final String SHOW_CATEGORY_LIST_ACTION = "showCategoryList";
    private final String SHOW_CATEGORY_LIST_PAGE = "categoryList.jsp";
    private final String SHOW_CATEGORY_LIST_CONTROLLER = "ShowCategoryListServlet";

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
        String url = DASHBOARD_PAGE;
        String action = request.getParameter("action");
        System.out.println(action);
        try {
            switch (action) {
                case DASHBOARD_PAGE_ACTION:
                    url = DASHBOARD_PAGE;
                    break;
                case SHOW_PRODUCT_LIST_PAGE_ACTION:
                    url = SHOW_PRODUCT_LIST_PAGE;
                    break;
                case SHOW_PRODUCT_LIST_ACTION:
                    url = SHOW_PRODUCT_LIST_CONTROLLER;
                    break;
                case SHOW_CATEGORY_LIST_PAGE_ACTION:
                    url = SHOW_CATEGORY_LIST_PAGE;
                    break;
                case SHOW_CATEGORY_LIST_ACTION:
                    url = SHOW_CATEGORY_LIST_CONTROLLER;
                    break;
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
