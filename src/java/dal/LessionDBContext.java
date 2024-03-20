/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Attendence;
import entity.Lecturer;
import entity.Lession;
import entity.Room;
import entity.Student;
import entity.StudentGroup;
import entity.Subject;
import entity.TimeSlot;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author haich
 */
public class LessionDBContext extends DBContext<Lession> {

    public ArrayList<Attendence> getAttendencesBy(int leid) {
        ArrayList<Attendence> atts = new ArrayList<>();
        try {
            String sql = "SELECT \n"
                    + "les.leid,s.sid,s.sname,\n"
                    + "a.aid,a.description,a.isPresent,a.capturedtime,\n"
                    + "s.image\n"
                    + "FROM \n"
                    + "	Student s INNER JOIN Enrollment e ON s.[sid] = e.[sid]\n"
                    + "	INNER JOIN StudentGroup g ON g.gid = e.gid \n"
                    + "	INNER JOIN Lession les ON les.gid = g.gid\n"
                    + "	LEFT JOIN Attendence a ON a.leid = les.leid AND s.sid = a.sid\n"
                    + "WHERE les.leid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, leid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendence a = new Attendence();
                Lession lession = new Lession();
                lession.setId(rs.getInt("leid"));
                a.setLession(lession);

                Student s = new Student();
                s.setImage(rs.getString("image"));
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                a.setStudent(s);
                a.setId(rs.getInt("aid"));
                if (a.getId() != 0) {
                    a.setDescription(rs.getString("description"));
                    a.setPresent(rs.getBoolean("isPresent"));
                    a.setCapturedtime(rs.getDate("capturedtime"));
                }
                atts.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atts;
    }

    public ArrayList<Lession> getByLec(String lid, Date from, Date to) {
        ArrayList<Lession> lessions = new ArrayList<>();
        try {
            String sql = """
                         SELECT les.leid,les.isAttended,les.date,
                        g.gid,g.gname,su.subid,su.subname,
                       t.tid,t.tname,
                       r.rid,r.rname,
                       l.lid,l.lname,
                        t.tstart,t.tend
                      FROM Lession les INNER JOIN StudentGroup g ON g.gid = les.gid
                      INNER JOIN [Subject] su ON su.subid = g.subid
                      INNER JOIN TimeSlot t ON t.tid = les.tid
                      INNER JOIN Room r ON r.rid = les.rid
                       INNER JOIN Lecturer l ON l.lid = les.lid
                      WHERE les.lid=? AND les.[date] >=? AND les.[date]<=? """;
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, lid);
            stm.setDate(2, from);
            stm.setDate(3, to);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lession les = new Lession();
                StudentGroup g = new StudentGroup();
                Subject su = new Subject();
                TimeSlot slot = new TimeSlot();
                Room room = new Room();
                Lecturer lec = new Lecturer();

                les.setId(rs.getInt("leid"));
                les.setIsattended(rs.getInt("isAttended"));
                java.sql.Date datefromDB = rs.getDate("date");
                les.setDate(datefromDB);

                g.setId(rs.getString("gid"));
                g.setName(rs.getString("gname"));
                su.setId(rs.getString("subid"));
                su.setName(rs.getString("subname"));
                les.setSub(su);

                les.setStudentGroup(g);

                slot.setId(rs.getString("tid"));
                slot.setName(rs.getInt("tname"));
                slot.setTstart(rs.getTime("tstart"));
                slot.setTend(rs.getTime("tend"));
                les.setTime(slot);

                room.setId(rs.getString("rid"));
                room.setName(rs.getString("rname"));
                les.setRoom(room);

                lec.setId(rs.getInt("lid"));
                lec.setName(rs.getString("lname"));
                les.setLecturer(lec);

                lessions.add(les);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lessions;
    }

    public ArrayList<Lession> getByStu(String sid, Date from, Date to) {
        ArrayList<Lession> lessions = new ArrayList<>();
        try {
            String sql = "	SELECT les.leid,s.sname,les.date\n"
                    + "                     ,g.gname,su.subname\n"
                    + "                     ,t.tname,t.tstart,t.tend,r.rname,l.lname\n"
                    + "						\n"
                    + "                      FROM Lession les INNER JOIN StudentGroup g ON g.gid = les.gid\n"
                    + "                      INNER JOIN [Subject] su ON su.subid = g.subid\n"
                    + "                      INNER JOIN TimeSlot t ON t.tid = les.tid\n"
                    + "					  INNER JOIN Enrollment  er on er.gid = g.gid\n"
                    + "					  INNER JOIN Student s on s.sid = er.sid\n"
                    + "                      INNER JOIN Room r ON r.rid = les.rid\n"
                    + "                      INNER JOIN Lecturer l ON l.lid = les.lid\n"
                    + "					  INNER JOIN Attendence a on a.sid = s.sid"
                    + "					   where s.sid= ? AND les.[date] >=? AND les.[date]<=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, sid);
            stm.setDate(2, from);
            stm.setDate(3, to);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lession lession = new Lession();
                lession.setId(rs.getInt("leid"));
                java.sql.Date datefromDB = rs.getDate("date");
                lession.setDate(datefromDB);

                Student student = new Student();
                student.setName(rs.getString("sname"));
                lession.setStudent(student);

                StudentGroup group = new StudentGroup();
                group.setName(rs.getString("gname"));
                lession.setStudentGroup(group);

                Subject subject = new Subject();
                subject.setName(rs.getString("subname"));
                lession.setSub(subject);

                TimeSlot slot = new TimeSlot();
                slot.setName(rs.getInt("tname"));
                lession.setTime(slot);

                Room room = new Room();
                room.setName(rs.getString("rname"));
                lession.setRoom(room);

                Lecturer lec = new Lecturer();
                lec.setName(rs.getString("lname"));
                lession.setLecturer(lec);

                lessions.add(lession);

            }

        } catch (SQLException ex) {
            Logger.getLogger(LessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lessions;
    }

    @Override
    public ArrayList<Lession> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Lession entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Lession entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Lession entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lession get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        for (Attendence attendence : new LessionDBContext().getAttendencesBy(1)) {
            System.out.println(attendence);
        }

    }

}
