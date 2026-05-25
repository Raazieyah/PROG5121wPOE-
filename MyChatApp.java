/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mychatapp;

import java.util.Scanner;
import javax.swing.JOptionPane;

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
        
    //POE PART 2
    
        //Application now displaying welcome message
        JOptionPane.showMessageDialog(null,
                            "Welcome to QuickChat App");
        
        boolean whileLoopControl = true;
        //Users can now choose options from the menu
        while(whileLoopControl){
            String input = JOptionPane.showInputDialog(null, 
                    "Choose an option from the menu"
                            + "1)Send Messages"
                            + "2)Show recently sent messages"
                            + "3)Quit",
                    JOptionPane.QUESTION_MESSAGE);
            
            if (input == null) break;// if input is not from menu options break
            
            int userInput;
            try {
                userInput = Integer.parseInt(input);
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, 
                        "Please enter a valid number between 1 & 3",
                        "Invalid input",
                        JOptionPane.ERROR_MESSAGE);
                continue;
        }
        
        //choose number of messages you would like to send
            if (userInput == 1){
                String numStr = JOptionPane.showInputDialog(null,
                        "Enter number of messages to send (max 5)");
                if(numStr == null) continue;
                
                int num;
                try{
                    num = Integer.parseInt(numStr);
                } catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, 
                            "Thats not a number,"); //number that is entered has to be within the amount of numbers given max 5
                    continue;
                }
                
                if (num > 5) num = 5;
                
                Message[] myMessages = new Message[num];
                
                for(int i = 0; i < num; i++){
                    myMessages[i] = new Message();
                    myMessages[i].messageID = generateID();
                    
                    // enter your name as the sender
                    String sender = JOptionPane.showInputDialog(null,
                            "Enter your name");
                    if (sender == null) break;
                    myMessages[i].sender = sender;
                    
                    //enter the receivers name to whom you would like to send a message
                     String receiver = JOptionPane.showInputDialog(null,
                            "Enter the reciepent name");
                    if (receiver == null) break;
                    myMessages[i].receiver = receiver;
                    
                    //type the message you would like to send the recipient
                     String msg = JOptionPane.showInputDialog(null,
                            "Enter message you want to send");
                    if (msg == null) break;
                    myMessages[i].msg = msg;
                    
                    //message hash will display along with the message
                    String hash = generateMessageHash(myMessages[i].messageID, i, msg);
                    JOptionPane.showMessageDialog(null,
                            "Message Hash: " + hash);
                    
                    //choose what to do to do with the message you have typed from the options below
                    String[] options = {"Send message", "DIsregard message", "Store message to send later"};
                    int choice = JOptionPane.showOptionDialog(null,
                            "Choose an option for this message:",
                            "Message options",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            options,
                            options[0]);
                    
                    switch (choice){//switch case used
                        case 0:
                            JOptionPane.showMessageDialog(null,
                                    "Messsage send");
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(null,
                                    "message disregarded");
                            myMessages[i] = null;
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null,
                                    "Message stored");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,
                                    "No options selected");  //display if non of the options were correctly chosen
                            return;
                    }
                  }
                
                JOptionPane.showMessageDialog(null, "Messsage created: " + num);
            
            }
            //output for option 2 user will be taken back to full menu
            else if (userInput == 2) {
                JOptionPane.showMessageDialog(null, "Coming soon.");
            }
            //output for option 3 menu will completely close
            else if (userInput == 3){
                JOptionPane.showMessageDialog(null, "Goodbye, see you again!");
                break;
            }
            else{// is user enters numbers other than options
                JOptionPane.showMessageDialog(null,
                        "Choice must be 1, 2, or 3.",
                        "Out of Range",
                        JOptionPane.WARNING_MESSAGE);
            }
       }
    }
   
        //generate ID for message
    public static String generateID(){
        return java.util.UUID.randomUUID().toString().substring(0, 8);
    }
    //generate message hash
    public static String generateMessageHash(String messageID, int index, String msg){
        return Integer.toString((messageID + index +msg).hashCode());
    }
        
        
    }

