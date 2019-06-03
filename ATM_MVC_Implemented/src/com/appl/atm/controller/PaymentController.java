/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.controller;

import com.appl.atm.model.BankDatabase;
import com.appl.atm.model.Payment;
import com.appl.atm.model.Transaction;
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;
import java.util.ArrayList;

/**
 *
 * @author Annazar
 */
public class PaymentController extends TransactionController {
    private Payment transaction;
    
    public PaymentController(Transaction theTransaction) {
	super(theTransaction);
	transaction = (Payment) theTransaction;
    }

    @Override
    public int run() {
	ArrayList<Integer> senderAccounts = transaction.getSenderAccounts();
	ArrayList<Integer> targetAccounts = transaction.getTargetAccounts();
	ArrayList<Integer> paymentAmounts = transaction.getPaymentAmounts();
	ArrayList<String> messages = transaction.getMessages();
	
	ArrayList<Integer> choices = new ArrayList<Integer>();
	
	if(senderAccounts.size() == 0) {
	    getScreen().displayMessage("\nNo Payment.\n\n");
	} else {
	    getScreen().displayMessage("\nPayment List : \n\n");
	    for(int i = 0; i < senderAccounts.size(); i++) {
		if(senderAccounts.get(i).equals(getAccountNumber())) {
		    choices.add(i);
		    getScreen().displayMessage("Payment Number : " + choices.size() + "\n");
		    getScreen().displayMessage("Target : " + targetAccounts.get(i) + "\n");
		    getScreen().displayMessage("Amount : " + paymentAmounts.get(i) + "\n");
		    getScreen().displayMessage("Message : " + messages.get(i) + "\n\n");
		}
	    }


		getScreen().displayMessage("Enter payment number\t\t: ");
		int choice = choices.get(getKeypad().getInput() - 1);
		getScreen().displayMessage("Enter amount you want to pay\t: ");
		int amount = getKeypad().getInput();

		transaction.setSelected(choice);
		transaction.setPayAmount(amount);
		transaction.execute();
	}
	
	return 0;
    }

    private int getAccountNumber() {
	return transaction.getAccountNumber();
    }

    private Screen getScreen() {
	return transaction.getScreen();
    }

    private BankDatabase getBankDatabase() {
	return transaction.getBankDatabase();
    }

    private Keypad getKeypad() {
	return transaction.getKeypad();
    }
}
