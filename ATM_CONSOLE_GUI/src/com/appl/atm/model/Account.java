/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appl.atm.model;

/**
 *
 * @author Cahya
 */
public class Account {
    private int accountNumber;
    private int PINNumber;
    private int balance;
    private int transferCost;
    private int mothlyTax;
    private int dailyWithdrawLimit;
    private int dailyWithdrawAmount;
    
    public Account(int accountNumber, int PINNumber, int balance, 
            int transferCost, int monthlyTax, int dailyWithdrawLimit){
        this.accountNumber = accountNumber;
        this.PINNumber = PINNumber;
        this.balance = balance;
        this.transferCost = transferCost;
        this.mothlyTax = monthlyTax;
        this.dailyWithdrawLimit = dailyWithdrawLimit;        
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
     * @return the balance
     */
    public int getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    public int withdraw(int amount){
        if(getBalance() >= amount){
            setBalance(getBalance() - amount);
            return 1; //sukses withdraw
        }
        return 0; //gagal withdraw
        
        //belum ditambahin saat gagal karena withdraw limit
    }

    /**
     * @return the PINNumber
     */
    public int getPINNumber() {
        return PINNumber;
    }

    /**
     * @param PINNumber the PINNumber to set
     */
    public void setPINNumber(int PINNumber) {
        this.PINNumber = PINNumber;
    }

    /**
     * @return the transferCost
     */
    public int getTransferCost() {
        return transferCost;
    }

    /**
     * @param transferCost the transferCost to set
     */
    public void setTransferCost(int transferCost) {
        this.transferCost = transferCost;
    }

    /**
     * @return the mothlyTax
     */
    public int getMothlyTax() {
        return mothlyTax;
    }

    /**
     * @param mothlyTax the mothlyTax to set
     */
    public void setMothlyTax(int mothlyTax) {
        this.mothlyTax = mothlyTax;
    }

    /**
     * @return the dailyWithdrawLimit
     */
    public int getDailyWithdrawLimit() {
        return dailyWithdrawLimit;
    }

    /**
     * @param dailyWithdrawLimit the dailyWithdrawLimit to set
     */
    public void setDailyWithdrawLimit(int dailyWithdrawLimit) {
        this.dailyWithdrawLimit = dailyWithdrawLimit;
    }

    /**
     * @return the dailyWithdrawAmount
     */
    public int getDailyWithdrawAmount() {
        return dailyWithdrawAmount;
    }

    /**
     * @param dailyWithdrawAmount the dailyWithdrawAmount to set
     */
    public void setDailyWithdrawAmount(int dailyWithdrawAmount) {
        this.dailyWithdrawAmount = dailyWithdrawAmount;
    }
}
