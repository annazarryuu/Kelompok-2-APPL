/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

/**
 *
 * @author Muhammad Reyhan S
 */
public class Transfer extends Transaction {
    
    private int accDest; //account destination
    private int amount; //amount to be transfered
    
    /*Constants*/
    public static final int SUCCESS = 0;
    public static final int INSUFFICIENT_BALANCE = -1;
    public static final int ACC_DEST_NULL = -2;
    
    public Transfer(Account userAccount, BankDatabase bankDatabase) {
        super(userAccount, bankDatabase);
    }
    
    @Override
    public int executeTransaction() {
        Account acc = getBankDatabase().getAccount(getUserAccount().getAccountNumber());
        Account accDestination = getBankDatabase().getAccount(getAccDest());
        if(accDestination != null) {
            int balanceRemaining = acc.getBalance() - (acc.getTransferCost() + getAmount());
            if(balanceRemaining >= 0) {
                int accDestBalance = accDestination.getBalance();
                accDestination.setBalance(accDestBalance + getAmount());
                acc.setBalance(balanceRemaining);
                return SUCCESS;
            } else {
                return INSUFFICIENT_BALANCE;
            }
        } else {
            return ACC_DEST_NULL;
        }
    }

    /**
     * @return the accDest
     */
    public int getAccDest() {
        return accDest;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }
    
}
