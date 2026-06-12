/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.mychatapp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author david
 */
public class MessageTest {
    
    public MessageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of SentMessage method, of class Message.
     */
    @Test
    public void testSentMessage() {
        System.out.println("SentMessage");
        Message instance = new Message();
        String expResult = "";
        String result = instance.SentMessage();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of printMessage method, of class Message.
     */
    @Test
    public void testPrintMessage() {
        System.out.println("printMessage");
        Message instance = new Message();
        String expResult = "";
        String result = instance.printMessage();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of returnTotalMessages method, of class Message.
     */
    @Test
    public void testReturnTotalMessages() {
        System.out.println("returnTotalMessages");
        Message instance = new Message();
        int expResult = 0;
        int result = instance.returnTotalMessages();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of storeMessage method, of class Message.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        .Message.Message msg = null;
        Message instance = new Message();
        instance.storeMessage(msg);
       
    }

    /**
     * Test of checkMessageID method, of class Message.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        Message instance = null;
        boolean expResult = false;
        boolean result = instance.checkMessageID();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of checkRecipientCell method, of class Message.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        String RecipientCell = "";
        Message instance = null;
        int expResult = 0;
        int result = instance.checkRecipientCell(RecipientCell);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addMessage method, of class Message.
     */
    @Test
    public void testAddMessage() {
        System.out.println("addMessage");
        Message message = null;
        Message instance = null;
        instance.addMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displaySentMessages method, of class Message.
     */
    @Test
    public void testDisplaySentMessages() {
        System.out.println("displaySentMessages");
        Message instance = null;
        instance.displaySentMessages();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displayLongestMessage method, of class Message.
     */
    @Test
    public void testDisplayLongestMessage() {
        System.out.println("displayLongestMessage");
        Message instance = null;
        instance.displayLongestMessage();
        
    }

    /**
     * Test of searchByID method, of class Message.
     */
    @Test
    public void testSearchByID() {
        System.out.println("searchByID");
        String id = "";
        Message instance = null;
        instance.searchByID(id);
        
    }

    /**
     * Test of searchByRecipient method, of class Message.
     */
    @Test
    public void testSearchByRecipient() {
        System.out.println("searchByRecipient");
        String recipient = "";
        Message instance = null;
        instance.searchByRecipient(recipient);
        
    }

    /**
     * Test of deleteByMessageHash method, of class Message.
     */
    @Test
    public void testDeleteByMessageHash() {
        System.out.println("deleteByMessageHash");
        String messageHash = "";
        Message instance = null;
        instance.deleteByMessageHash(messageHash);
        
    }
    
}
