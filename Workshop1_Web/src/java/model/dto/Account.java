/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

import java.sql.Date;

/**
 *
 * @author Nhatthang
 */
public class Account {
    private String username;
    private String password;
    private String lastName;
    private String firstName;
    private Date dob;
    private boolean gender;
    private String phone;
    private boolean isActive;
    private int role;
    private boolean isDeleted;

    public Account() {
    }
    
    public Account(String username, String password, String lastName, String firstName, Date dob, boolean gender, String phone, boolean isActive, int role, boolean isDeleted) {
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.isActive = isActive;
        this.role = role;
        this.isDeleted = isDeleted;
    }
    
    public Account(String username, String password, String lastName, String firstName, Date dob, boolean gender, String phone, boolean isActive, int role) {
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dob = dob;
        this.gender = gender;
        this.phone = phone;
        this.isActive = isActive;
        this.role = role;
        this.isDeleted = false;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", lastName=" + lastName + ", firstName=" + firstName + ", dob=" + dob + ", gender=" + gender + ", phone=" + phone + ", isActive=" + isActive + ", role=" + role + ", isDeleted=" + isDeleted + '}';
    }
    
    
    
    
    
}
