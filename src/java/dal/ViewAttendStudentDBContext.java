/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Attendence;
import entity.Lession;
import entity.Room;
import entity.Student;
import entity.StudentGroup;
import entity.Subject;
import entity.TimeSlot;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haich
 */
public class ViewAttendStudentDBContext extends DBContext<Attendence>{

    public ArrayList<Attendence> AttendByStudentid(int sid) {
        ArrayList<Attendence> attends = new ArrayList<>();
        try {
            String sql = "select \n"
                    + "s.sname,sg.gname,su.subname,r.rname,ts.tname,a.isPresent,l.isAttended,a.sid,a.capturedtime,a.description\n"
                    + "\n"
                    + "from Attendence a \n"
                    + "inner join Student s on s.sid = a.sid\n"
                    + " inner join Lession l on l.leid = a.leid\n"
                    + " inner join room r on r.rid = l.rid \n"
                    + " inner join StudentGroup  sg on sg.gid=l.gid\n"
                    + " inner join Subject su on su.subid = sg.gid\n"
                    + "inner join TimeSlot ts on ts.tid=l.tid\n"
                    + "where s.sid = ?";
            
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendence att = new Attendence();
                Student s = new Student();
                StudentGroup sg = new StudentGroup();
                Room r = new Room();
                Subject su = new Subject();
                TimeSlot tl= new TimeSlot();
                Lession les = new Lession();
                
                s.setName(rs.getString("sname"));
                sg.setName(rs.getString("gname"));
                su.setName(rs.getString("subname"));
                r.setName(rs.getString("rname"));
                tl.setName(rs.getInt("tname"));
                att.setCapturedtime(rs.getDate("capturedtime"));
                att.setDescription(rs.getString("description"));
                att.setPresent(rs.getBoolean("isPresent"));
                
                attends.add(att);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attends;
    }

    @Override
    public ArrayList<Attendence> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Attendence entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Attendence entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Attendence entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Attendence get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) {
        for (Attendence att : new ViewAttendStudentDBContext().AttendByStudentid(1) ) {
            System.out.println(att);
            
        }
    }
    
}
