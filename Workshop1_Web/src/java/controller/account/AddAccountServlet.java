/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.account;

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
import model.dao.AccountDao;
import model.dto.Account;

/**
 *
 * @author Nhatthang
 */
public class AddAccountServlet extends HttpServlet {

    private final String ADD_ACCOUNT_PAGE_ACTION = "addAccountPage";
    private final String SHOW_ACCOUNT_LIST_ACTION = "showAccountList";

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

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String dob_txt = request.getParameter("dob");
        String gender_txt = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String isActive_txt = request.getParameter("isActive");
        String role_txt = request.getParameter("role");

        String action = SHOW_ACCOUNT_LIST_ACTION;
        try {
            AccountDao accDao = new AccountDao(getServletContext());
            Date dob = Date.valueOf(dob_txt);
            boolean gender = (gender_txt.equals("1") ? true : false);
            boolean isActive = (isActive_txt == null ? false : true);
            int role = Integer.parseInt(role_txt);
            Account newAcc = new Account(username, password, lastName, firstName, dob, gender, phone, isActive, role);
            int result = accDao.insert(new Account(username, password, lastName, firstName, dob, gender, phone, isActive, role));
//            if (result == 0) {
//                System.err.println("Insert Fail");
//            } else {
//                RequestDispatcher rd = request.getRequestDispatcher("DispatcherAccountServlet?action=showAccountList");
//                rd.forward(request, response);
//            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            String errorMessage = ex.getMessage();
            if (errorMessage.contains("PRIMARY KEY constraint")) {
                request.setAttribute("usernameError", "Username already exists.");
            } else if (errorMessage.contains("UQ_Account_Phone")) {
                request.setAttribute("phoneError", "Phone number already exists.");
            } else {
                request.setAttribute("error", "An unexpected database error occurred.");
            }
            action = ADD_ACCOUNT_PAGE_ACTION;
        }
        RequestDispatcher rd = request.getRequestDispatcher("DispatcherAccountServlet?action=" + action);
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
