/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.controller;

import com.appl.atm.model.BankDatabase;
import com.appl.atm.model.BankStatement;
import com.appl.atm.model.Statement;
import com.appl.atm.model.Transaction;
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;
import java.util.ArrayList;

/**
 *
 * @author Annazar
 */
public class BankStatementController extends TransactionController {

    private BankStatement transaction;

    public BankStatementController(Transaction theTransaction) {
	super(theTransaction);
	transaction = (BankStatement) getTransaction();

    }

    @Override
    public int run() {
	ArrayList<Statement> bankStatement = new ArrayList<Statement>();

	getScreen().displayMessageLine("\nBank statements menu :");
	getScreen().displayMessageLine("1. All statements");
	getScreen().displayMessageLine("2. Today's transfer statements");
	getScreen().displayMessageLine("3. A month withdraw statements");
	getScreen().displayMessage("\nChoose a menu : ");
	int userChoice = getKeypad().getInput();

	switch (userChoice) {
	    case 1:
		bankStatement = transaction.getBankStatements();
		break;
	    case 2:
		bankStatement = transaction.getBankStatementToday();
		break;
	    case 3:
		int month = 0;
		while (month < 1 || month > 12) {
		    getScreen().displayMessage("Input the month (1 to 12) : ");
		    month = getKeypad().getInput();
		    
		    if((month < 1 || month > 12)) {
			getScreen().displayMessageLine("You have to input between 1 and 12. Try again.");
		    }
		}
		bankStatement = transaction.getBankStatementMonth(month - 1);
		break;
	    default:
	}

	if (bankStatement == null) {
	    getScreen().displayMessage("\nNo Bank Statement for This Account.\n");
	} else {
	    getScreen().displayMessageLine("\nAccount number : " + getAccountNumber());
	    for (int i = 0; i < bankStatement.size(); i++) {
		getScreen().displayMessageLine("- " + bankStatement.get(i).getTransaction().toString()
		    + "( " + bankStatement.get(i).getDate() + " )");
		 //langsung toString biar gausah bedain withdraw / transfer dll
	    }
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
