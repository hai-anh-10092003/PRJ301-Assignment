/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author haich
 */
public class Student {
    private int id;
    private String name;
    private int phone;
    private String image;
    private String attend;
    

    public Student() {
    }

    public Student(int id, String name, int phone, String image, String attend) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.image = image;
        this.attend = attend;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAttend() {
        return attend;
    }

    public void setAttend(String attend) {
        this.attend = attend;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", image=" + image + ", attend=" + attend + '}';
    }

   
}
