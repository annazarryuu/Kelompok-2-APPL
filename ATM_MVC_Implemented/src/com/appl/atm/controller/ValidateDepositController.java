/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.controller;

import com.appl.atm.model.Account;
import com.appl.atm.model.BankDatabase;
import com.appl.atm.model.Transaction;
import com.appl.atm.model.ValidateDeposit;
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;

/**
 *
 * @author Annazar
 */
public class ValidateDepositController extends TransactionController {
    
    private ValidateDeposit transaction;

    public ValidateDepositController(Transaction theTransaction) {
	super(theTransaction);
	transaction = (ValidateDeposit) getTransaction();
    }

    @Override
    public int run() {
	getScreen().displayMessage("\nInput target account number : ");
	int targetAccountNumber = getKeypad().getInput();
	Account account = getBankDatabase().getAccount(targetAccountNumber);
	
	if (account != null) {
	    transaction.setValidateTarget(targetAccountNumber);
	    transaction.execute();
	    getScreen().displayMessageLine(targetAccountNumber + "'s deposit has been validated");
	} else {
	    getScreen().displayMessageLine("Account not found.");
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
