/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.*;

/**
 *
 * @author haich
 */
public class TimeSlot {
    private String id;
    private int name;
    private Time tstart;
    private Time tend;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Time getTstart() {
        return tstart;
    }

    public void setTstart(Time tstart) {
        this.tstart = tstart;
    }

    public Time getTend() {
        return tend;
    }

    public void setTend(Time tend) {
        this.tend = tend;
    }

    
}
