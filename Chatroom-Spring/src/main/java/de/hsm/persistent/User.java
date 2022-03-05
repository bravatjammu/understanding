/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsm.persistent;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author gasimg
 */
public class User {
    @NotEmpty
    private String firstName;
    
    @NotEmpty
    private String lastName;
    
    @NotEmpty
    private String userName;
    
    @NotEmpty
    private String emailID;
    
    private int age;
    
    @NotEmpty
    private String gender;
    
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")
    @NotEmpty
    @Size(min = 5, max = 100)
    private String password;
    
    public User(String firstName, String lastName, String userName, String emailID, int age, String gender, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.emailID = emailID;
        this.age = age;
        this.gender = gender;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getPassword() {
        return password;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmailID() {
        return emailID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public void setPassword(String password) {
        this.password = password;
    }

}
