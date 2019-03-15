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
    private double transferTax;
    private double monthlyTax;
    private double dailyWithdrawLimit;
    private double currentWithdrawLimit;
    private double unblockTax;

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
	switch (accountType) {
	    case ADMIN:
		monthlyTax = 0.0;
		transferTax = 0.0;
		dailyWithdrawLimit = 0.0;
                unblockTax = 0.0; 
		break;
	    case SISWA:
		monthlyTax = 0.0;
		transferTax = 0.0;
		dailyWithdrawLimit = 20.0;
                unblockTax = 0.0;
		break;
	    case BISNIS:
		monthlyTax = 5.0;
		transferTax = 0.0;
		dailyWithdrawLimit = 1000.0;
                unblockTax = 3.0;
		break;
	    case MASA_DEPAN:
		monthlyTax = 1.0;
		transferTax = 1.0;
		dailyWithdrawLimit = 100.0;
                unblockTax = 2.0;
		break;
	}
	dailyWithdrawReset();
    }
    public void unblockPay() {
        if (availableBalance > unblockTax) {
          totalBalance -= unblockTax;
          availableBalance -= unblockTax;  
        }else{
        totalBalance -= availableBalance;
        availableBalance = 0;
        }
    }
            

    public void credit(double amount) {
	totalBalance += amount;
    }

    public void debit(double amount) {
	currentWithdrawLimit -= amount;
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

    public double getTransferTax() {
	return transferTax;
    }

    public void monthlyPayment() {
	if (this.availableBalance > monthlyTax) {
	    this.totalBalance = this.totalBalance - monthlyTax;
	    this.availableBalance = this.availableBalance - monthlyTax;
	} else {
	    this.totalBalance = this.totalBalance - this.availableBalance;
	    this.availableBalance = 0;
	}
    }
    
    public void dailyWithdrawReset() {
	currentWithdrawLimit = dailyWithdrawLimit;
    }

    /**
     * @return the currentWithdrawLimit
     */
    public double getCurrentWithdrawLimit() {
	return currentWithdrawLimit;
    }

    /**
     * @param currentWithdrawLimit the currentWithdrawLimit to set
     */
    public void setCurrentWithdrawLimit(double currentWithdrawLimit) {
	this.currentWithdrawLimit = currentWithdrawLimit;
    }

}
