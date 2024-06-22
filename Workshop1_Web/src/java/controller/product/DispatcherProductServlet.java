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

    private final String DASHBOARD_ACTION = "showDashboard";

    private final String SHOW_PRODUCT_LIST_PAGE_ACTION = "showProductListPage";
    private final String SHOW_PRODUCT_LIST_ACTION = "showProductList";
    private final String SHOW_PRODUCT_LIST_PAGE = "productList.jsp";
    private final String SHOW_PRODUCT_LIST_CONTROLLER = "ShowProductListServlet";

    private final String SHOW_CATEGORY_LIST_PAGE_ACTION = "showCategoryListPage";
    private final String SHOW_CATEGORY_LIST_ACTION = "showCategoryList";
    private final String SHOW_CATEGORY_LIST_PAGE = "categoryList.jsp";
    private final String SHOW_CATEGORY_LIST_CONTROLLER = "ShowCategoryListServlet";

    private final String ADD_CATEGORY_PAGE_ACTION = "addCategoryPage";
    private final String ADD_CATEGORY_ACTION = "addCategory";
    private final String ADD_CATEGORY_PAGE = "addCategory.jsp";
    private final String ADD_CATEGORY_CONTROLLER = "AddCategoryServlet";

    private final String DELETE_CATEGORY_ACTION = "deleteCategory";
    private final String DELETE_CATEGORY_CONTROLLER = "DeleteCategoryServlet";

    private final String UPDATE_CATEGORY_PAGE_ACTION = "updateCategoryPage";
    private final String UPDATE_CATEGORY_ACTION = "updateCategory";
    private final String UPDATE_CATEGORY_PAGE = "updateCategory.jsp";
    private final String UPDATE_CATEGORY_CONTROLLER = "UpdateCategoryServlet";

    private final String GET_PRODUCT_DETAIL_PAGE_ACTION = "getProductDetailPage";
    private final String GET_PRODUCT_DETAIL_ACTION = "getProductDetail";
    private final String GET_PRODUCT_DETAIL_PAGE = "productDetail.jsp";
    private final String GET_PRODUCT_DETAIL_CONTROLLER = "GetProductDetailServlet";

    private final String UPDATE_PRODUCT_PAGE_ACTION = "updateProductPage";
    private final String UPDATE_PRODUCT_ACTION = "updateProduct";
    private final String UPDATE_PRODUCT_PAGE = "updateProduct.jsp";
    private final String UPDATE_PRODUCT_CONTROLLER = "UpdateProductServlet";
    
    private final String ADD_PRODUCT_PAGE_ACTION = "addProductPage";
    private final String ADD_PRODUCT_ACTION = "addProduct";
    private final String ADD_PRODUCT_PAGE = "addProduct.jsp";
    private final String ADD_PRODUCT_CONTROLLER = "AddProductServlet";
    
    private final String DELETE_PRODUCT_ACTION = "deleteProduct";
    private final String DELETE_PRODUCT_CONTROLLER = "DeleteProductServlet";

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
        String url = SHOW_PRODUCT_LIST_CONTROLLER;
        String action = request.getParameter("action");
        
        System.out.println(request.getAttribute("categories"));
        System.out.println("Dispatcher: " + action);
        try {
            switch (action) {
                case DASHBOARD_ACTION:
                    url = SHOW_PRODUCT_LIST_CONTROLLER;
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
                    
                case ADD_CATEGORY_PAGE_ACTION:
                    url = ADD_CATEGORY_PAGE;
                    break;
                case ADD_CATEGORY_ACTION:
                    url = ADD_CATEGORY_CONTROLLER;
                    break;
                    
                case DELETE_CATEGORY_ACTION:
                    url = DELETE_CATEGORY_CONTROLLER;
                    break;
                    
                case UPDATE_CATEGORY_PAGE_ACTION: {
                    url = UPDATE_CATEGORY_PAGE;
                    break;
                }
                case UPDATE_CATEGORY_ACTION:
                    url = UPDATE_CATEGORY_CONTROLLER;
                    break;
                    
                case GET_PRODUCT_DETAIL_PAGE_ACTION:
                    url = GET_PRODUCT_DETAIL_PAGE;
                    break;
                case GET_PRODUCT_DETAIL_ACTION: {
                    System.out.println(request.getParameter("add_update_detail"));
                    url = GET_PRODUCT_DETAIL_CONTROLLER;
                    break;
                }
                case UPDATE_PRODUCT_PAGE_ACTION:
                    url = UPDATE_PRODUCT_PAGE;
                    break;
                case UPDATE_PRODUCT_ACTION:
                    url = UPDATE_PRODUCT_CONTROLLER;
                    break;
                    
                case ADD_PRODUCT_PAGE_ACTION:
                    url = ADD_PRODUCT_PAGE;
                    break;
                case ADD_PRODUCT_ACTION:
                    url = ADD_PRODUCT_CONTROLLER;
                    break;
                    
                case DELETE_PRODUCT_ACTION:
                    url = DELETE_PRODUCT_CONTROLLER;
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
