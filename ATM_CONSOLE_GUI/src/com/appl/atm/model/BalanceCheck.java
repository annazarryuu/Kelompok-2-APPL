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
public class BalanceCheck extends Transaction{
    
    /*Constants*/
//    public static final int ACCOUNT_NULL = -1;
    
    public BalanceCheck(Account userAccount, BankDatabase bankDatabase) {
        super(userAccount, bankDatabase);
    }
    
    @Override
    public int executeTransaction() {
        Account acc = getBankDatabase().getAccount(getUserAccount().getAccountNumber());
        return acc.getBalance();
//        if(acc != null) {
//           return acc.getBalance();
//        } else {
//            return ACCOUNT_NULL;
//        }
    }
    
}
