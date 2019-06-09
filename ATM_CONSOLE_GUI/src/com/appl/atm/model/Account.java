/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

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
    
    // konstanta untuk withdraw
    public static final int WITHDRAW_SUCCESSFUL = 0;
    public static final int BALANCE_NOT_ENOUGH = -1;
    public static final int DAILY_LIMIT_REACHED = -2;

    public int withdraw(int amount){
		// Deskripsi	: mengurangi totalBalance dan availableBalance sesuai 
		//					jumlah amount yg di-input
		// Author		: Cahya
                if(dailyWithdrawAmount >= dailyWithdrawLimit){
                    if(availableBalance >= amount){
                        availableBalance -= amount;
                                    totalBalance -= amount;
                        return WITHDRAW_SUCCESSFUL; //sukses withdraw
                    } else {                
                        return BALANCE_NOT_ENOUGH; //gagal withdraw, balance kurang
                    }                    
                } else {
                    return DAILY_LIMIT_REACHED; //gagal withdraw, limit                                                       
                }
                //belum ditambahin saat gagal karena withdraw limit
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
