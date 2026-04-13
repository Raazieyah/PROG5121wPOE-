/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mychatapp;

import java.util.Scanner;

/**
 *
 * @author raazieyah davids
 * PROG POE PART1
 * ST10465704
 */
public class MyChatApp {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Please enter your Username: ");//User inputs a username
        String name = scanner.nextLine();
        if (name.contains("_")&& name.length() <= 5 )// user name condition
        {
            System.out.println("Username succefully captured.");
        } else {
            System.out.println("Username is not correctly formated,please ensure that your username contains an underscore and is no longer than 5 charaters long.");
        }
        
        System.out.println("Please create a password: ");//user inputs a password
        String password = scanner.nextLine();
        if (password.length() != 8 )//conditions for pasword that must be met
        {
            System.out.println("Password successfully captured.");
        }else {
            System.out.println("Password is not correctly formatted please ensure that the password contains atleast eight charaters,a capital letter,a number and a special charater.");
        }
        
        String saPhoneRegex = "^(\\+?27|0)[6-8][0-9]{8}$";//South african regex for phone number
        
        System.out.println("Pleasee enter a south african cell phone number: ");
        String cellNum = scanner.nextLine().trim();//conditions that will be followed
        
        if (cellNum.matches(saPhoneRegex))
        {
            System.out.println("Cell phone number captured succesfully.");
        }else
        {
            System.out.println("Cell phone incorrectly formatted or does not contain international code.");
        }
        
        //login with name and password
         
        System.out.println("Please enter name to login: " + name);
        System.out.println("Please enter your password to login: " + password);
        
        if (password && name == true ){
            System.out.println("You have successfully logged in,");
        }
        
        
        /*
        user input store -
        if user name contains ...the print .... else...
        */
        
    
    }
}
