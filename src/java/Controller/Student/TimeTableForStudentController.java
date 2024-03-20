package Controller.Student;

import Controller.BaseRequiredAuthenticationController;
import dal.LessionDBContext;
import dal.TimeSlotDBContext;
import entity.Account;
import entity.Lession;
import entity.TimeSlot;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DateTimeHelper;

public class TimeTableForStudentController extends BaseRequiredAuthenticationController {
   
   
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, Account account) throws ServletException, IOException {
    TimeSlotDBContext t = new TimeSlotDBContext();
        ArrayList<TimeSlot> list = t.list();
        req.setAttribute("list",list);
        try{ 
            
            String sid = req.getParameter("id");
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
            ArrayList<Lession> lessions = les.getByStu(sid, from, to);
            
            req.setAttribute("from", from);
            req.setAttribute("to", to);
            req.setAttribute("dates", dates);
            req.setAttribute("lessions", lessions);
            req.getRequestDispatcher("studenttimetable.jsp").forward(req, resp);
        } catch (NumberFormatException ex) {
        }
    }

    }