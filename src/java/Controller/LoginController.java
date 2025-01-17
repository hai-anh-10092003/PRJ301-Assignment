/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import dal.AccountLecturerDBContext;
import dal.AccountStudentDBCnontext;
import entity.Account;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haich
 */
public class LoginController extends HttpServlet {
   
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    try {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AccountStudentDBCnontext student = new AccountStudentDBCnontext();
        AccountLecturerDBContext lecturer = new AccountLecturerDBContext();
        Account account;
        String role = null;

        if ((account = student.getByUsernamePassword(username, password)) != null) {
            role = "student";
        } else if ((account = lecturer.getByUsernamePassword(username, password)) != null) {
            role = "lecturer";
        }

        if (account != null) {
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            session.setAttribute("role", role); 
            
            if ("student".equals(role)) {
                response.sendRedirect("home_student.jsp?id=" + account.getId());
               
            } else if ("lecturer".equals(role)) {
                 response.sendRedirect("home_lecturer.jsp?id=" + account.getId());
                
                 
            }

            String remember = request.getParameter("remember");
            if (remember != null) {
                Cookie c_user = new Cookie("username", username);
                Cookie c_pass = new Cookie("password", password);

                c_user.setMaxAge(3600 * 24 * 7);
                c_pass.setMaxAge(3600 * 24 * 7);

                response.addCookie(c_pass);
                response.addCookie(c_user);
            }
        } else {
            response.getWriter().println("login failed!");
        }
    } catch (Exception ex) {
        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
