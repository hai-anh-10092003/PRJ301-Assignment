/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author haich
 */
public class Account {
    private String username;
    private String password;
    private String id;
    private String displayname;
    private String role;

    public Account() {
    }

    public Account(String username, String password, String id, String displayname, String role) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.displayname = displayname;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
   
