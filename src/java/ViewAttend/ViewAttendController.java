/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package ViewAttend;


import Controller.BaseRequiredAuthenticationController;
import dal.AttendenceDBContext;
import dal.ViewAttendStudentDBContext;
import entity.Account;
import entity.Attendence;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;


/**
 *
 * @author Laptop K1
 */
public class ViewAttendController extends BaseRequiredAuthenticationController {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Account account) throws ServletException, IOException {
     String studentid = request.getParameter("sid");
    if (studentid == null || studentid.isEmpty()) {
        request.setAttribute("error", "You must enter a valid student id");
    } else {
        try {
            int sid = Integer.parseInt(studentid);
            if (sid <= 0) {
                request.setAttribute("error", "Student id must be a positive integer");
            } else {
                ViewAttendStudentDBContext attDB = new ViewAttendStudentDBContext();
                ArrayList<Attendence> attendances = attDB.AttendByStudentid(sid);
                request.setAttribute("attendances", attendances);
                request.getRequestDispatcher("viewattend.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Student id must be an integer");
        }
     }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account account) throws ServletException, IOException {
       request.getRequestDispatcher("viewattend.jsp").forward(request, response);
    }
}