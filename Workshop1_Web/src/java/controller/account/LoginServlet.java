/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.AccountDao;

/**
 *
 * @author Nhatthang
 */
public class LoginServlet extends HttpServlet {

    private final String DASHBOARD_ACTION = "showDashboard";
    private final String LOGIN_PAGE_ACTION = "loginPage";

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
        String url = "DispatcherProductServlet?action=" + DASHBOARD_ACTION;
        try {
            AccountDao accDao = new AccountDao(getServletContext());
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            int result = accDao.isExistAccount(username, password);

            if (result == 1) {
                HttpSession sess = request.getSession();
                sess.setAttribute("account", accDao.getObjectByID(username));

                Cookie cu = new Cookie("username", username);
                Cookie cp = new Cookie("password", password);
                Cookie cr = new Cookie("rmb", "1");

                String rmb = request.getParameter("rmb");
                if (rmb == null) {
                    cu.setMaxAge(0);
                    cp.setMaxAge(0);
                    cr.setMaxAge(0);
                } else {
                    cu.setMaxAge(60 * 60 * 24 * 30);
                    cp.setMaxAge(60 * 60 * 24 * 30);
                    cr.setMaxAge(60 * 60 * 24 * 30);
                }
                response.addCookie(cu);
                response.addCookie(cp);
                response.addCookie(cr);
            } else if (result == 0) {
                url = "DispatcherAccountServlet?action=" + LOGIN_PAGE_ACTION;
                request.setAttribute("error", "Username or password is wrong !");
            } else {
                url = "DispatcherAccountServlet?action=" + LOGIN_PAGE_ACTION;
                request.setAttribute("error", "Account is not active !");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher(url);
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
