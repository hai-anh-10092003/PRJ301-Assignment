/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import dal.AttendenceDBContext;
import dal.LessionDBContext;
import dal.StudentDBContext;
import entity.Account;
import entity.Attendence;
import entity.Lession;
import entity.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author haich
 */
public class TakeAttendenceContrller extends BaseRequiredAuthenticationController {
   

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
    int leid = Integer.parseInt(req.getParameter("id"));
        StudentDBContext stuDB = new StudentDBContext();
        ArrayList<Student> students = stuDB.getByLession(leid);
        ArrayList<Attendence> atts = new ArrayList<>();
        Lession lession = new Lession();
        lession.setId(leid);
        for (Student student : students) {
            Attendence att = new Attendence();
            att.setLession(lession); 
            att.setStudent(student);
            att.setPresent(req.getParameter("present"+student.getId()).equals("yes"));
            att.setDescription(req.getParameter("description"+student.getId()));
            atts.add(att);
        }
        AttendenceDBContext db = new AttendenceDBContext();
        db.batchupdateByLession(leid, atts);
        resp.sendRedirect("att?id="+leid);
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
      int leid = Integer.parseInt(req.getParameter("id"));
        LessionDBContext db = new LessionDBContext();
        ArrayList<Attendence> atts = db.getAttendencesBy(leid);
        req.setAttribute("atts", atts);
        req.getRequestDispatcher("att.jsp").forward(req, resp);
    }
    

}
