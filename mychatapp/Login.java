/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;

/**
 *
 * @author david
 */
public class Login {
    
    // our method class 
     //checking if user name is correct
    public boolean checkUserName(String name) {//
        return name.contains("_") && name.length() <= 5;
    }
    
    //check the string password
    public boolean checkPasswordComplexity(String password){
        boolean length = password.length() >= 8;
        return length;
    }
    //checking if user phone number is valid
    public boolean checkCellPhoneNumber(String cellNum){
        return cellNum.matches("(0[6-8][0-9]{8})|(27[6-8][0-9]{8})");
    }
    
    public String registerUser()//register user using correct output
    {
        if (!checkUserName(name)){
            System.out.println("Username is not correctly formatted,please ensure that your username contains an underscore and is no more than 5 chracters .");
        }
        else if(!checkPasswordCompexity(password)) {
            System.out.println("Password is not correctly formattted,ensure it is atleast 8 charaters,a capital letter and a number.");
        }else{
            return "Registration complete.";
        } 
        
    }
    //user loggewd in with correct name and password
    public boolean loginUser(){
        System.out.println("Attempting to login with username: " + name);
    }
    
    //display login status
    public String returnLoginStatus(){
        if (isLoggedIn){
            return "You have successfukky logged in."
        }else {
            return "Login attempt unsuccessful."
        }
    }
}
