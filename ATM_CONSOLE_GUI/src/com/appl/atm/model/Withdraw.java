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
    public static final int WITHDRAW_SUCCESSFUL = 0;
    public static final int BALANCE_NOT_ENOUGH = -1;
    public static final int DAILY_LIMIT_REACHED = -2;
    public static final int CASHDISPENSER_NOT_ENOUGH = -3;


    // Withdraw constructor
    public Withdraw(Account account, BankDatabase bankDatabase,
	    CashDispenser cashDispenser) {

	// initialize superclass variables
        super(account, bankDatabase);
	this.cashDispenser = cashDispenser;
    }


    @Override
    public int executeTransaction() {
		// Deskripsi	: melakukan withdraw sesuai jumlah amount
		//					yang diinput
		// Author		: Cahya		

                Account account = getBankDatabase().getAccount(getUserAccount().getAccountNumber());

                if (cashDispenser.isSufficientCashAvailable(amount)) {
                    int withdrawResult = account.withdraw(amount);
                    switch(withdrawResult){
                        case 0 : { //sukses
                            cashDispenser.dispenseCash(amount);
                            return WITHDRAW_SUCCESSFUL;
                        }
                        case -1 : { //gagal, balance kurang
                            return BALANCE_NOT_ENOUGH;                
                        }
                        case -2 : { //gagal, sudah mencapai limit harian
                            return DAILY_LIMIT_REACHED;                
                        }
                        default :{                            
                            return -999; //mungkin akan ada kasus lain
                        }
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
