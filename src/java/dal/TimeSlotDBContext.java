/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.TimeSlot;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import dal.DBContext;

/**
 *
 * @author haich
 */
public class TimeSlotDBContext extends DBContext<TimeSlot> {

    @Override
    public ArrayList<TimeSlot> list() {
        ArrayList<TimeSlot> slots = new ArrayList<>();
        try {
            
            String sql = "SELECT tid,tname,tstart,tend FROM TimeSlot";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                TimeSlot slot = new TimeSlot();
                slot.setId(rs.getString("tid"));
                slot.setName(rs.getInt("tname"));
                slot.setTstart(rs.getTime("tstart"));
                slot.setTstart(rs.getTime("tend"));
                
                
                slots.add(slot);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimeSlotDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slots;
    }

    @Override
    public void insert(TimeSlot entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TimeSlot entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(TimeSlot entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TimeSlot get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

