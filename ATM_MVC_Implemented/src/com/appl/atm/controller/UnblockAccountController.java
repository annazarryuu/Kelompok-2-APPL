/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appl.atm.controller;

import com.appl.atm.model.UnblockAccount;
import com.appl.atm.model.Transaction;

/**
 *
 * @author Cahya
 */
public class UnblockAccountController extends TransactionController {
    private UnblockAccount transaction;
    private final static int ACCOUNT_SUCCESSFULLY_UNBLOCKED = 0;
    private final static int FAILED_TO_UNBLOCK_ACCOUNT = -1;    
    
    public UnblockAccountController(Transaction theTransaction) {
	super(theTransaction);
	transaction = (UnblockAccount) getTransaction();
    }
    
    @Override
    public int run() {
        int res = transaction.execute();
        if(res == ACCOUNT_SUCCESSFULLY_UNBLOCKED){
            System.out.println("Account successfully unblocked.");
        } else if(res == FAILED_TO_UNBLOCK_ACCOUNT){
            System.out.println("Failed to unblock account, there`s no account with that account number.");            
        }
        return 0;
    }    

}
