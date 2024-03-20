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
public class Lession {
    private int id;
    private Lecturer lecturer;
    private Student student;
    private Room room;
    private TimeSlot time;
    private Subject sub;
    private Semesers semesers;
    private StudentGroup studentGroup;
    private int isattended;
    private Date date;
    private Attendence attendence;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public TimeSlot getTime() {
        return time;
    }

    public void setTime(TimeSlot time) {
        this.time = time;
    }

    public Subject getSub() {
        return sub;
    }

    public void setSub(Subject sub) {
        this.sub = sub;
    }

    public Semesers getSemesers() {
        return semesers;
    }

    public void setSemesers(Semesers semesers) {
        this.semesers = semesers;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public int getIsattended() {
        return isattended;
    }

    public void setIsattended(int isattended) {
        this.isattended = isattended;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Attendence getAttendence() {
        return attendence;
    }

    public void setAttendence(Attendence attendence) {
        this.attendence = attendence;
    }

    
}
