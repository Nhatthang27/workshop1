/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.account;

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
public class DispatcherAccountServlet extends HttpServlet {
    
    private final String SHOW_ACCOUNT_LIST_ACTION = "showAccountList";
    private final String SHOW_ACCOUNT_LIST_CONTROLLER = "ShowAccountListServlet";
    private final String ACCOUNT_LIST_PAGE = "accountList.jsp";
    
    private final String LOGIN_ACTION = "login";
    private final String LOGIN_PAGE_ACTION = "loginPage";
    private final String LOGIN_PAGE = "login.jsp";
    private final String LOGIN_CONTROLLER = "LoginServlet";
    
    private final String LOGOUT_ACTION = "logout";
    private final String LOGOUT_CONTROLLER = "LogoutServlet";
    
    private final String ADD_ACCOUNT_ACTION = "addAccount";
    private final String ADD_ACCOUNT_PAGE_ACTION = "addAccountPage";
    private final String ADD_ACCOUNT_CONTROLLER = "AddAccountServlet";
    private final String ADD_ACCOUNT_PAGE = "addAccount.jsp";
    
    private final String GET_ACCOUNT_INFO_ACTION = "getAccountInfo";
    private final String GET_ACCOUNT_INFO_CONTROLLER = "GetAccountInfoServlet";
    
    private final String UPDATE_ACCOUNT_ACTION = "updateAccount";
    private final String UPDATE_ACCOUNT_PAGE_ACTION = "updateAccountPage";
    private final String UPDATE_ACCOUNT_CONTROLLER = "UpdateAccountServlet";
    private final String UPDATE_ACCOUNT_PAGE = "updateAccount.jsp";
    
    private final String DELETE_ACCOUNT_ACTION = "deleteAccount";
    private final String DELETE_ACCOUNT_CONTROLLER = "DeleteAccountServlet";
    
    private final String ACTIVE_ACCOUNT_ACTION = "activeAccount";
    private final String ACTIVE_ACCOUNT_CONTROLLER = "ActiveAccountServlet";
    

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
        String url = LOGIN_PAGE;
        String action = request.getParameter("action");
        
        try {
            switch (action) {
                case LOGIN_PAGE_ACTION:
                    url = LOGIN_PAGE;
                    break;
                case LOGIN_ACTION:
                    url = LOGIN_CONTROLLER;
                    break;
                case LOGOUT_ACTION:
                    url = LOGOUT_CONTROLLER;
                    break;
                case SHOW_ACCOUNT_LIST_ACTION:
                    url = SHOW_ACCOUNT_LIST_CONTROLLER;
                    break;
                case ADD_ACCOUNT_PAGE_ACTION:
                    url = ADD_ACCOUNT_PAGE;
                    break;
                case ADD_ACCOUNT_ACTION:
                    url = ADD_ACCOUNT_CONTROLLER;
                    break;
                case GET_ACCOUNT_INFO_ACTION:
                    url = GET_ACCOUNT_INFO_CONTROLLER;
                    break;
                case UPDATE_ACCOUNT_PAGE_ACTION:
                    url = UPDATE_ACCOUNT_PAGE;
                    break;
                case UPDATE_ACCOUNT_ACTION:
                    url = UPDATE_ACCOUNT_CONTROLLER;
                    break;
                case DELETE_ACCOUNT_ACTION:
                    url = DELETE_ACCOUNT_CONTROLLER;
                    break;
                case ACTIVE_ACCOUNT_ACTION:
                    url = ACTIVE_ACCOUNT_CONTROLLER;
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
