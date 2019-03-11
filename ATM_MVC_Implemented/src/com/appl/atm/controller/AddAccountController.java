/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appl.atm.controller;

import com.appl.atm.model.AddAccount;
import com.appl.atm.model.Transaction;

/**
 *
 * @author Cahya
 */
public class AddAccountController extends TransactionController{
    private AddAccount transaction;
    private final static int ACCOUNT_SUCCESSFULLY_CREATED = 0;
    private final static int FAILED_TO_CREATE_ACCOUNT = -1;    
    
    public AddAccountController(Transaction theTransaction) {
	super(theTransaction);
	transaction = (AddAccount) getTransaction();
    }
    
    @Override
    public int run() {
        int res = transaction.execute();
        if(res == ACCOUNT_SUCCESSFULLY_CREATED){
            System.out.println("Account successfully created.");
        } else if(res == FAILED_TO_CREATE_ACCOUNT){
            System.out.println("Failed to create account, there`s someone using that account number.");            
        }
        return 0;
    }
    
}
