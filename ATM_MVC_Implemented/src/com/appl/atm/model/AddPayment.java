/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import static com.appl.atm.model.Constants.*;
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;

/**
 *
 * @author Annazar
 */
public class AddPayment extends Transaction {
    
    private int sender;
    private int target;
    private int amount;
    private String message;
    
    private Keypad keypad;

    public AddPayment(int userAccountNumber, Screen atmScreen,
	    BankDatabase atmBankDatabase, Keypad atmKeypad) {
	
	super(userAccountNumber, atmScreen, atmBankDatabase);
	keypad = atmKeypad;
    }

    @Override
    public int execute() {
	Account senderAccount = getBankDatabase().getAccount(sender);
	Payment payment = new Payment(getAccountNumber(), null, getBankDatabase(), null);
	
	if(senderAccount == null) {
	    return USER_NOT_FOUND;
	} else {
	    return payment.addPayment(sender, target, amount, message);
	}
    }

    /**
     * @return the sender
     */
    public int getSender() {
	return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(int sender) {
	this.sender = sender;
    }

    /**
     * @return the target
     */
    public int getTarget() {
	return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(int target) {
	this.target = target;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
	return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
	this.amount = amount;
    }

    /**
     * @return the message
     */
    public String getMessage() {
	return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
	this.message = message;
    }

    /**
     * @return the keypad
     */
    public Keypad getKeypad() {
	return keypad;
    }

    @Override
    public String toString() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
