/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.controller;

import com.appl.atm.model.AddPayment;
import com.appl.atm.model.BankDatabase;
import static com.appl.atm.model.Constants.*;
import com.appl.atm.model.Transaction;
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;

/**
 *
 * @author Annazar
 */
public class AddPaymentController extends TransactionController {

    private AddPayment transaction;
    
    public AddPaymentController(Transaction theTransaction) {
	super(theTransaction);
	transaction = (AddPayment) theTransaction;
    }

    @Override
    public int run() {
	getScreen().displayMessage("\nEnter account number of user who must pays\t: ");
	int sender = getKeypad().getInput();

	getScreen().displayMessage("Enter account number of user who will be paid\t: ");
	int target = getKeypad().getInput();

	getScreen().displayMessage("Enter payment amount\t\t\t\t: ");
	int amount = getKeypad().getInput();

	getScreen().displayMessage("Enter payment message\t\t\t\t: ");
	getKeypad().getInputString();
	String message = getKeypad().getInputString();

	transaction.setSender(sender);
	transaction.setTarget(target);
	transaction.setAmount(amount);
	transaction.setMessage(message);
	int res = transaction.execute();
	
	if(res == PAYMENT_ADDED) {
	    getScreen().displayMessage("\nPayment added.\n");
	} else if(res == USER_NOT_FOUND) {
	    getScreen().displayMessage("\nUser not found.\n");
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
