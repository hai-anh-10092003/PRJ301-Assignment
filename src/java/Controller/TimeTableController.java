/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import dal.LessionDBContext;
import dal.TimeSlotDBContext;
import entity.Account;
import entity.Lession;
import entity.TimeSlot;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import util.DateTimeHelper;

/**
 *
 * @author haich
 */
public class TimeTableController extends BaseRequiredAuthenticationController {

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
          TimeSlotDBContext t = new TimeSlotDBContext();
        ArrayList<TimeSlot> list = t.list();
        req.setAttribute("list",list);
        try{ 
            
            String lid = req.getParameter("id");
            String raw_from = req.getParameter("from");
            String raw_to = req.getParameter("to");
            Date today = new Date();
            java.sql.Date from = null;
            java.sql.Date to = null;
            
            if(raw_from ==null)
            {
                from = DateTimeHelper.convertUtilDateToSqlDate(DateTimeHelper.getWeekStart(today));
            }
            else
            {
                from = java.sql.Date.valueOf(raw_from);
            }
            
            if(raw_to == null)
            {
                to = DateTimeHelper.convertUtilDateToSqlDate(DateTimeHelper.
                        addDaysToDate(DateTimeHelper.getWeekStart(today),6));
            }
            else
            {
                to = java.sql.Date.valueOf(raw_to);
            }
            
            ArrayList<java.sql.Date> dates = DateTimeHelper.getDatesBetween(from, to);
            
            LessionDBContext les = new LessionDBContext();
            ArrayList<Lession> lessions = les.getByLec(lid, from, to);
            
            req.setAttribute("from", from);
            req.setAttribute("to", to);
            req.setAttribute("dates", dates);
            req.setAttribute("lessions", lessions);
            req.getRequestDispatcher("timetable.jsp").forward(req, resp);
        } catch (NumberFormatException ex) {
        }
    }

}
