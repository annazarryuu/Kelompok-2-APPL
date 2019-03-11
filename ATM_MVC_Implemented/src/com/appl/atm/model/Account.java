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
    
    private int accountNumber; // account number
    private int pin; // PIN for authentication
    private double availableBalance; // funds available for withdrawal
    private double totalBalance; // funds available & pending deposits
    private double transferTax;
    private final double[] transferTaxes = {0.0, 0.0, 0.0, 1.0}; //untuk akun masa depan, biaya transfer = $1
    private double monthlyTax;
    private int accType;

    // Account constructor initializes attributes
    public Account(int theAccountNumber, int thePIN, 
	double theAvailableBalance, double theTotalBalance, int theAccType) {

	accountNumber = theAccountNumber;
	pin = thePIN;
	availableBalance = theAvailableBalance;
	totalBalance = theTotalBalance;
        switch(theAccType) {
          case 0 : monthlyTax = 0.0; break;
          case 1 : monthlyTax = 0.0; break;
          case 2 : monthlyTax = 5.0; break;
          case 3 : monthlyTax = 1.0; break;
        }
        accType = theAccType;
    } 

    public void credit(double amount) {
	totalBalance += amount;
    }

    public void debit(double amount) {
	availableBalance -= amount;
	totalBalance -= amount;
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
    
    public double getTransferTax() {
	return transferTax;
    }
    
    public void monthlyPayment()
   {
       this.availableBalance = this.availableBalance - monthlyTax;
       this.totalBalance = this.totalBalance - monthlyTax;
   }
    
}
