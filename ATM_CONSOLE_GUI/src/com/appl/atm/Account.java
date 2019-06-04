/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm;

/**
 *
 * @author Annazar
 */
public class Account {
    private int accountNumber;
    private int pin;
    private int availableBalance;
    private int totalBalance;
    private int transferCost;
    private int monthlyTax;
    private int dailyWithdrawLimit;
    private int dailyWithdrawAmount;
    
    public Account(int accountNumber, int pin, int availableBalance,
			int totalBalance, int transferCost,
			int monthlyTax, int dailyWithdrawLimit) {
	
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.availableBalance = availableBalance;
		this.totalBalance = totalBalance;
		this.transferCost = transferCost;
		this.monthlyTax = monthlyTax;
		this.dailyWithdrawLimit = dailyWithdrawLimit;
    }
    
    // konstanta untuk deposit
    private final int DEPOSIT_SUCCESS = 0;
    
    public int deposit(int amount) {
		// Deskripsi	: menambah totalBalance sesuai dengan jumlah yang
		//					di-input-kan pada parameter
		// Author		: Annazar
		
		this.totalBalance += amount;
		return DEPOSIT_SUCCESS;
    }

    /**
     * @return the accountNumber
     */
    public int getAccountNumber() {
		return accountNumber;
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
    public int getAvailableBalance() {
		return availableBalance;
    }

    /**
     * @return the totalBalance
     */
    public int getTotalBalance() {
		return totalBalance;
    }
}
