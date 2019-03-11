/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.controller;

import com.appl.atm.model.BalanceInquiry;
import com.appl.atm.model.BankDatabase;
import com.appl.atm.model.CashDispenser;
import com.appl.atm.model.Deposit;
import com.appl.atm.model.DepositSlot;
import com.appl.atm.model.Transaction;
import com.appl.atm.model.Withdrawal;
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;
import static com.appl.atm.model.Constants.*;
import com.appl.atm.model.Menu;
import java.util.ArrayList;

/**
 *
 * @author Annazar
 */
public class ATM {

    private int userAuthenticated;
    private int currentAccountNumber; // current user's account number
    private Screen screen; // ATM's screen
    private Keypad keypad; // ATM's keypad
    private CashDispenser cashDispenser; // ATM's cash dispenser
    private DepositSlot depositSlot;
    private BankDatabase bankDatabase; // account information database
    private ArrayList<Menu> menuList;

    public ATM() {
	userAuthenticated = 1;
	currentAccountNumber = 0;
	screen = new Screen();
	keypad = new Keypad();
	cashDispenser = new CashDispenser();
	depositSlot = new DepositSlot();
	bankDatabase = new BankDatabase();
	menuList = new ArrayList<Menu>();
	createMenuList();
    }

    // start ATM 
    public void run() {
	// welcome and authenticate user; perform transactions
	while (true) {
	    // loop while user is not yet authenticated
	    screen.displayMessageLine("\nWelcome!\n");
	    while (userAuthenticated != 0) {
		authenticateUser(); // authenticate user
	    }

	    performTransactions(); // user is now authenticated
	    userAuthenticated = 1; // reset before next ATM session
	    currentAccountNumber = 0; // reset before next ATM session
	    screen.displayMessageLine("\nThank you! Goodbye!");
	}
    }

    // attempts to authenticate user against database
    private void authenticateUser() {
	screen.displayMessage("Please enter your account number\t: ");
	int accountNumber = keypad.getInput(); // input account number
	screen.displayMessage("Enter your PIN\t\t\t\t: "); // prompt for PIN
	int pin = keypad.getInput(); // input PIN

	// set userAuthenticated to boolean value returned by database
	userAuthenticated
		= bankDatabase.authenticateUser(accountNumber, pin);

	// check whether authentication succeeded
	switch (userAuthenticated) {
	    case AUTHENTICATE_SUCCESS:
		currentAccountNumber = accountNumber; // save user's account #
		break;
	    case INVALID_PIN:
		screen.displayMessageLine(
			"Invalid PIN. Please try again.\n");
		break;
	    case USER_BLOCKED:
		screen.displayMessageLine(
			"Your account is blocked. Please contact our customer service.\n");
		break;
	    case USER_BE_BLOCKED:
		screen.displayMessageLine(
			"You have been tried 3 times. Your account is blocked.");
		screen.displayMessageLine(
			"Please contact our customer service.\n");
		break;
	    case USER_NOT_FOUND:
		screen.displayMessageLine(
			"User not found. Please try again.\n");
		break;
	}

    }

    // display the main menu and perform transactions
    private void performTransactions() {
	// local variable to store transaction currently being processed
	Transaction currentTransaction = null;
	TransactionController currentTransactionController = null;

	boolean userExited = false; // user has not chosen to exit

	// loop while user has not chosen option to exit system
	while (!userExited) {
	    // show main menu and get user selection
	    int mainMenuSelection = displayMainMenu();

	    // decide how to proceed based on user's menu selection
	    switch (mainMenuSelection) {
		// user chose to perform one of three transaction types
		case BALANCE_INQUIRY:

		    // initialize as new object of chosen type
		    currentTransaction
			    = createTransaction(mainMenuSelection);
		    currentTransactionController
			    = new BalanceInquiryController(currentTransaction);
		    currentTransactionController.run(); // execute transaction
		    break;

		case WITHDRAWAL:
		    currentTransaction
			    = createTransaction(mainMenuSelection);
		    currentTransactionController
			    = new WithdrawalController(currentTransaction);
		    currentTransactionController.run(); // execute transaction
		    break;

		case DEPOSIT:
		    currentTransaction
			    = createTransaction(mainMenuSelection);
		    currentTransactionController
			    = new DepositController(currentTransaction);
		    currentTransactionController.run(); // execute transaction
		    break;

		case CHANGE_PIN:

		case EXIT: // user chose to terminate session
		    screen.displayMessageLine("\nExiting the system...");
		    userExited = true; // this ATM session should end
		    break;

		default: // 
		    screen.displayMessageLine(
			    "\nYou did not enter a valid selection. Try again.");
		    break;
	    }
	}
    }

    // display the main menu and return an input selection
    private int displayMainMenu() {
	screen.displayMessageLine("\nMain menu:");
	ArrayList<Menu> menuShowed = new ArrayList<Menu>();
	int accountType = bankDatabase.getAccount(currentAccountNumber).getAccountType();
	
	for(int i = 0; i < menuList.size(); i++)
	{
	    if(menuList.get(i).isAvailable(accountType)) {
		menuShowed.add(menuList.get(i));
	    }
	}
	
	for(int i = 1; i < menuShowed.size(); i++) {
	    screen.displayMessageLine(i + " - " + menuShowed.get(i).getKeteranganPilihan());
	}
	screen.displayMessageLine(menuShowed.size() + " " + menuShowed.get(0).getKeteranganPilihan());
	
	screen.displayMessage("Enter a choice: ");
	int choice = keypad.getInput(); // return user's selection
	
	if (choice == 0) {
	    return menuShowed.size();
	} else if (choice == menuShowed.size()) {
	    return EXIT;
	} else {
	    return choice;
	}
    }

    private Transaction createTransaction(int type) {
	Transaction temp = null;

	switch (type) {
	    case BALANCE_INQUIRY:
		temp = new BalanceInquiry(
			currentAccountNumber, screen, bankDatabase);
		break;
	    case WITHDRAWAL:
		temp = new Withdrawal(
			currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);
		break;
	    case DEPOSIT:
		temp = new Deposit(
			currentAccountNumber, screen, bankDatabase, keypad, depositSlot);
		break;

	}

	return temp;
    }

    private void createMenuList() {
	menuList.add(new Menu(EXIT, "Exit\n", true, true, true, true));
	menuList.add(new Menu(BALANCE_INQUIRY, "View my balance", false, true, true, true));
	menuList.add(new Menu(WITHDRAWAL, "Withdraw cash", false, true, true, true));
	menuList.add(new Menu(DEPOSIT, "Deposit funds", false, true, true, true));
	menuList.add(new Menu(TRANSFER, "Transfer balance", false, false, true, true));
	menuList.add(new Menu(CHANGE_PIN, "Change PIN", false, true, true, true));
	menuList.add(new Menu(UNBLOCK_ACCOUNT, "Unblock account", true, false, false, false));
	menuList.add(new Menu(CHECK_DISPENSER_COUNT, "Check amout of cash in dispenser", true, false, false, false));
	menuList.add(new Menu(ADD_DISPENSER_COUNT, "Add amount of cash in dispenser", true, false, false, false));
	menuList.add(new Menu(ADD_ACCOUNT, "Add account to Bank Database", true, false, false, false));
	menuList.add(new Menu(VALIDATE_DEPOSIT, "Deposit Validation", true, false, false, false));
	menuList.add(new Menu(BANK_STATEMENT, "Bank statement", false, true, true, true));
	menuList.add(new Menu(CHANGE_DATE, "Change Date", true, false, false, false));
    }

}
