/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;

/**
 *
 * @author Annazar
 */
public class Withdrawal extends Transaction {

    private int amount; // amount to withdraw
    private Keypad keypad; // reference to keypad
    private CashDispenser cashDispenser; // reference to cash dispenser

    // Withdrawal constructor
    public Withdrawal(int userAccountNumber, Screen atmScreen,
	    BankDatabase atmBankDatabase, Keypad atmKeypad,
	    CashDispenser atmCashDispenser) {

	// initialize superclass variables
	super(userAccountNumber, atmScreen, atmBankDatabase);
	keypad = atmKeypad;
	cashDispenser = atmCashDispenser;
    }

    @Override
    public int execute() {
	Account account = getBankDatabase().getAccount(getAccountNumber());

	if (account.getAvailableBalance() < amount) {
	    return 1;
	}

	if (cashDispenser.isSufficientCashAvailable(amount)) {
	    cashDispenser.dispenseCash(amount);
	    account.debit(amount);
	    return 0;
	} else {
	    return 2;
	}
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
     * @return the keypad
     */
    public Keypad getKeypad() {
	return keypad;
    }

    /**
     * @param keypad the keypad to set
     */
    public void setKeypad(Keypad keypad) {
	this.keypad = keypad;
    }

    /**
     * @return the cashDispenser
     */
    public CashDispenser getCashDispenser() {
	return cashDispenser;
    }

    /**
     * @param cashDispenser the cashDispenser to set
     */
    public void setCashDispenser(CashDispenser cashDispenser) {
	this.cashDispenser = cashDispenser;
    }

}
