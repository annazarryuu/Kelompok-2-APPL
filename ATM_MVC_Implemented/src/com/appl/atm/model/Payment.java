/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import static com.appl.atm.model.Constants.*;
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;
import java.util.ArrayList;

/**
 *
 * @author Annazar
 */
public class Payment extends Transaction {

    private static ArrayList<Integer> senderAccounts;
    private static ArrayList<Integer> targetAccounts;
    private static ArrayList<Integer> paymentAmounts;
    private static ArrayList<String> messages;
    private int selected;
    private int payAmount;
    
    private Keypad keypad;
    
    public Payment(int userAccountNumber, Screen atmScreen,
	    BankDatabase atmBankDatabase, Keypad atmKeypad) {
	super(userAccountNumber, atmScreen, atmBankDatabase);
	keypad = atmKeypad;
	
	if(senderAccounts == null)
	    senderAccounts = new ArrayList<Integer>();
	if(targetAccounts == null)
	    targetAccounts = new ArrayList<Integer>();
	if(paymentAmounts == null)
	    paymentAmounts = new ArrayList<Integer>();
	if(messages == null)
	    messages = new ArrayList<String>();
    }

    @Override
    public int execute() {
	Transfer transfer = new Transfer(getAccountNumber(), getScreen(), getBankDatabase(), getKeypad());
	
	if(payAmount > getPaymentAmounts().get(selected)) {
	    payAmount = getPaymentAmounts().get(selected);
	}
	
	transfer.setTargetAccount(getTargetAccounts().get(selected));
	transfer.setAmount(payAmount);
	int res = transfer.execute();
	
	if(res == TRANSFER_SUCCESS) {
	    	getPaymentAmounts().set(selected, getPaymentAmounts().get(selected) - payAmount);
		if(getPaymentAmounts().get(selected) == 0) {
		    getSenderAccounts().remove(selected);
		    getPaymentAmounts().remove(selected);
		    getTargetAccounts().remove(selected);
		    getMessages().remove(selected);
		}
	}
	
	return res;
    }
    
    public void setSelected(int theSelected) {
	selected = theSelected;
    }
    
    public void setPayAmount(int thePayAmount) {
	payAmount = thePayAmount;
    }
    
    public int addPayment(int sender, int target, int amount, String message) {
	if (getBankDatabase().getAccount(target) == null || getBankDatabase().getAccount(sender) == null) {
	    return USER_NOT_FOUND;
	} else {
	    getSenderAccounts().add(sender);
	    getTargetAccounts().add(target);
	    getPaymentAmounts().add(amount);
	    getMessages().add(message);
	    
	    return PAYMENT_ADDED;
	}
    }

    /**
     * @return the senderAccounts
     */
    public ArrayList<Integer> getSenderAccounts() {
	return senderAccounts;
    }

    /**
     * @return the targetAccounts
     */
    public ArrayList<Integer> getTargetAccounts() {
	return targetAccounts;
    }

    /**
     * @return the paymentAmounts
     */
    public ArrayList<Integer> getPaymentAmounts() {
	return paymentAmounts;
    }

    /**
     * @return the messages
     */
    public ArrayList<String> getMessages() {
	return messages;
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
