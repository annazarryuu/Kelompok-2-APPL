/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import static com.appl.atm.model.Constants.*;

/**
 *
 * @author Annazar
 */
public class Account {
    
    private int accountNumber; // account number
    private int pin; // PIN for authentication
    private double availableBalance; // funds available for withdrawal
    private double totalBalance; // funds available & pending deposits
    private boolean blocked;
    private int triedCount;
    private int accountType;

    // Account constructor initializes attributes
    public Account(int theAccountNumber, int thePIN,
	    double theAvailableBalance, double theTotalBalance,
	    int theAccountType) {

	accountNumber = theAccountNumber;
	pin = thePIN;
	availableBalance = theAvailableBalance;
	totalBalance = theTotalBalance;
	accountType = theAccountType;
	blocked = false;
	triedCount = 0;
    }

    public void credit(double amount) {
	totalBalance += amount;
    }

    public void debit(double amount) {
	availableBalance -= amount;
	totalBalance -= amount;
    }

    public int validatePIN(int thePIN) {
	if (isBlocked()) {
	    return USER_BLOCKED;
	} else if (pin == thePIN) {
	    triedCount = 0;
	    return AUTHENTICATE_SUCCESS;
	} else if (triedCount == 2) {
	    triedCount = 0;
	    setBlocked(true);
	    return USER_BE_BLOCKED;
	} else {
	    triedCount++;
	    return INVALID_PIN;
	}
    }

    /**
     * @return the accountNumber
     */
    public int getAccountNumber() {
	return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
    }

    /**
     * @return the pin
     */
    public int getPin() {
	return pin;
    }

    /**
     * @param pin the pin to set
     */
    public void setPin(int pin) {
	this.pin = pin;
    }

    /**
     * @return the availableBalance
     */
    public double getAvailableBalance() {
	return availableBalance;
    }

    /**
     * @param availableBalance the availableBalance to set
     */
    public void setAvailableBalance(double availableBalance) {
	this.availableBalance = availableBalance;
    }

    /**
     * @return the totalBalance
     */
    public double getTotalBalance() {
	return totalBalance;
    }

    /**
     * @param totalBalance the totalBalance to set
     */
    public void setTotalBalance(double totalBalance) {
	this.totalBalance = totalBalance;
    }

    /**
     * @return the accountType
     */
    public int getAccountType() {
	return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(int accountType) {
	this.accountType = accountType;
    }

    /**
     * @return the blocked
     */
    public boolean isBlocked() {
	return blocked;
    }

    /**
     * @param blocked the blocked to set
     */
    public void setBlocked(boolean blocked) {
	this.blocked = blocked;
    }

}
