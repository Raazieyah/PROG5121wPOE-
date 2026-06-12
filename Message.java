/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mychatapp;

/**
 *
 * @author raazieyah davids
 * ST10465704
 * POE Part 2
 */
public class Message {
    public String messageID;
    public String sender;
    public String receiver;
    public String msg;
    public String messageHash;
    public String status;
    public String recipientCell;
    
    public Message(String messageID, String sender, String reciever, String msg, String messageHash , String status){
        this.messageID = messageID;
        this.sender = sender;
        this.receiver = receiver;
        this.msg = msg;
        this.messageHash = messageHash;
        this.status = status;
    }
    public List<Message> messageList = new ArrayList<>();//add seperate class
    
   boolean checkMessageID(){ //makes sure message id is not more than 10 charaters
       return messageID != null && messageID.length() <= 10;
   }
   
    public int checkRecipientCell(String RecipientCell){// cell number is no longer than 10 numbers
       if (recipientCell == null)return 0;

        recipientCell = recipientCell.replaceAll("\\s+", "");

        if(recipientCell.length() == 10 && recipientCell.startsWith("0") && recipientCell.matches("\\d{10}")){
        return 1;
}else{
       return 0;
}

           }
// user must choose if they want to send,store or disregard their message
    public String SentMessage(){
        String[] options = {"Send", "Disregard", "Store"};
        int choice = javax.swing.JOptionPane.showOptionDialog(null,
                "Choose what to do with the message:",
                "Message action",
                javax.swing.JOptionPane.DEFAULT_OPTION,
                javax.swing.JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);
        return null;
    }

   //prints list of all messages sent
    public String printMessage(){
        StringBuilder sb = new StringBuilder("Messages:\n");
        for(Message msg : messageList){
            sb.append("ID: ").append(msg.messageID)
              .append(" | From: ").append(msg.sender)
              .append(" | To: ").append(msg.receiver)
              .append(" | Msg: ").append(msg.msg)
              .append("\n");
                    
        }
        return sb.toString();
    }

    //returns the total number of overall messages sent
    public int returnTotalMessages(){
        return messageList.size();
    }
    //JSON File
    public void storeMessage(Message msg){
        JSONObject obj = new JSONObject();
        obj.put("id", msg.messageID);
        obj.put("sender", msg.sender);
        obj.put("receiver", msg.receiver);
        obj.put("message", msg.msg);
        
        JSONArray arr = new JSONArray();
        arr.add(obj);
        
        try(FileWriter file = new FileWriter("store_message.json", true)){
            file.write(obj.toJSONString() + "\n");
         }catch(IOException e){
             e.printStackTrace();
         }
        messageList.add(msg);
    }
//POE PART 3
    ArrayList<Message> sentMessages = new ArrayList<>();//Message array lsit
    ArrayList<Message> storedMessages = new ArrayList<>();
    ArrayList<Message> disregardedMessages = new ArrayList<>();

    public void addMessage(Message message) {
        switch (message.status) {
            case "Sent" -> sentMessages.add(message);
            case "Stored" -> storedMessages.add(message);
            case "Disregarded" -> disregardedMessages.add(message);
        }
    }
//display sent messages
    public void displaySentMessages() {
        if (sentMessages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No messages sent yet.");
            return;
        }

        StringBuilder sb = new StringBuilder("Sent Messages:\n");
        for (Message m : sentMessages) {
            sb.append(m.toString()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
//display the longest message stored
    public void displayLongestMessage() {
        Message longest = null;
        for (Message m : sentMessages) {
            if (longest == null || m.msg.length() > longest.msg.length()) {
                longest = m;
            }
        }

        if (longest != null)
            JOptionPane.showMessageDialog(null, "Longest Message:\n" + longest.msg);
        else
            JOptionPane.showMessageDialog(null, "No messages found.");
    }
// search by message id
    public void searchByID(String id) { 
        for (Message m : sentMessages) {
            if (m.messageID.equals(id)) {
                JOptionPane.showMessageDialog(null, "Message Found:\n" + m.toString());
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Message ID not found.");
    }
// searching for the reciepient
    public void searchByRecipient(String recipient) { 
        StringBuilder sb = new StringBuilder();
        for (Message m : sentMessages) {
            if (m.receiver.equals(recipient)) {
                sb.append(m.msg).append("\n");
            }
        }     JOptionPane.showMessageDialog(null, "Messages sent to " + recipient + ":\n" + sb);
else{
            JOptionPane.showMessageDialog(null, "No messages sent to this recipient.");
    }
}
    
    
//delete message using message hash
    public void deleteByMessageHash(String messageHash) { 
        for (int i = 0; i < sentMessages.size(); i++) {
            if (sentMessages.get(i).messageHash.equals(messageHash)) {
                sentMessages.remove(i);
                JOptionPane.showMessageDialog(null, "Message deleted successfully.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Message hash not found.");
    }
    
    
    
    


