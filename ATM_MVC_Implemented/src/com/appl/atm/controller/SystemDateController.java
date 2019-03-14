/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appl.atm.controller;


import com.appl.atm.model.DepositCashDispenser;
import com.appl.atm.model.CheckCashDispenser;
import com.appl.atm.model.SystemDate;
import com.appl.atm.model.Transaction;
/**
 *
 * @author Cahya
 */
public class SystemDateController extends TransactionController{
    private SystemDate transaction;
    private final static int CANCELED = 0;

    public SystemDateController(Transaction theTransaction) {
	super(theTransaction);
	transaction = (SystemDate) getTransaction();
    }
    
    @Override
    public int run() {
        int res = transaction.execute();
        
        
        return 0;
    }    
}
