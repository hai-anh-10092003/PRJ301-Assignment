/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author haich
 */
public class Attendence {
    private int id;
    private Date capturedtime;
    private Boolean present;
    private String description;
    private Lession lession;
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCapturedtime() {
        return capturedtime;
    }

    public void setCapturedtime(Date capturedtime) {
        this.capturedtime = capturedtime;
    }

    public Boolean isPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Lession getLession() {
        return lession;
    }

    public void setLession(Lession lession) {
        this.lession = lession;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Attendence{" + "id=" + id + ", capturedtime=" + capturedtime + ", present=" + present + ", description=" + description + ", lession=" + lession + ", student=" + student + '}';
    }

    
}
