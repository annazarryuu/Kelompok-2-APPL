/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appl.atm.controller;

import com.appl.atm.model.Transaction;
import com.appl.atm.model.SeeCashDispenser;

/**
 *
 * @author Cahya
 */
public class SeeCashDispenserController extends TransactionController {
    private SeeCashDispenser transaction;

    public SeeCashDispenserController(Transaction theTransaction) {
	super(theTransaction);
	transaction = (SeeCashDispenser) getTransaction();
    }

    @Override
    public int run() {
        int cashDispenserCashCount = transaction.execute();
        System.out.print("Cash in dispenser : " + cashDispenserCashCount + " bills of $20.\n");        
        return 0;
    }

    
}
