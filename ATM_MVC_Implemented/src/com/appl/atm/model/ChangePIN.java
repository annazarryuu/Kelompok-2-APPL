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
 * @author Muhammad Reyhan S
 */
public class ChangePIN extends Transaction {

    private Keypad keypad;
    private int newPIN;
    private int currPIN;

    public ChangePIN(int userAccountNumber, Screen atmScreen,
	    BankDatabase atmBankDatabase, Keypad atmKeypad) {

	super(userAccountNumber, atmScreen, atmBankDatabase);
	keypad = atmKeypad;
    }

    public Keypad getKeypad() {
	return keypad;
    }

    @Override
    public int execute() {
        BankDatabase bankDB = getBankDatabase();
	return bankDB.changePIN(newPIN, currPIN, getAccountNumber());
    }

    /**
     * @return the newPIN
     */
    public int getNewPIN() {
        return newPIN;
    }

    /**
     * @param newPIN the newPIN to set
     */
    public void setNewPIN(int newPIN) {
        this.newPIN = newPIN;
    }

    /**
     * @return the currPIN
     */
    public int getCurrPIN() {
        return currPIN;
    }

    /**
     * @param currPIN the currPIN to set
     */
    public void setCurrPIN(int currPIN) {
        this.currPIN = currPIN;
    }
    
}
