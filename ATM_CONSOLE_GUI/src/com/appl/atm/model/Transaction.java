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
public abstract class Transaction {

    private Account userAccount;
    private BankDatabase bankDatabase;

    public Transaction(Account userAccount, BankDatabase bankDatabase){
        this.userAccount = userAccount;
        this.bankDatabase = bankDatabase;
    }
    public int executeTransaction(){

        return 0;
    }

    

    /**
     * @return the userAccount
     */
    public Account getUserAccount() {
        return userAccount;
    }

    /**
     * @param userAccount the userAccount to set
     */
    public void setUserAccount(Account userAccount) {
        this.userAccount = userAccount;
    }

    /**
     * @return the bankDatabase
     */
    public BankDatabase getBankDatabase() {
        return bankDatabase;
    }

    /**
     * @param bankDatabase the bankDatabase to set
     */
    public void setBankDatabase(BankDatabase bankDatabase) {
        this.bankDatabase = bankDatabase;
    }    
}
