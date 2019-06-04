/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

/**
 *
 * @author Cahya
 * 
 */
public class Withdraw extends Transaction {

    private int amount; // amount to withdraw
    private CashDispenser cashDispenser; // reference to cash dispenser

    /* Constants */
    public static final int WITHDRAWAL_CANCELED = 6;
    public static final int WITHDRAW_SUCCESSFUL = 1;
    public static final int BALANCE_NOT_ENOUGH = 2;
    public static final int CASHDISPENSER_NOT_ENOUGH = 3;


    // Withdrawal constructor
    public Withdraw(Account account, BankDatabase bankDatabase,
	    CashDispenser cashDispenser) {

	// initialize superclass variables
        super(account, bankDatabase);
	this.cashDispenser = cashDispenser;
    }
    @Override
    public int executeTransaction() {
        Account account = getBankDatabase().getAccount(getUserAccount().getAccountNumber());

	if (cashDispenser.isSufficientCashAvailable(amount)) {
	    cashDispenser.dispenseCash(amount);
            int withdrawResult = account.withdraw(amount);
            if(withdrawResult == 1){                
                return WITHDRAW_SUCCESSFUL;
            } else if(withdrawResult == 0){
                return BALANCE_NOT_ENOUGH;                
            } else {
                return -1; //saat ada kasus lain, misal : mencapai daily withdraw limit, dll
            }
	} else {
	    return CASHDISPENSER_NOT_ENOUGH;
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
