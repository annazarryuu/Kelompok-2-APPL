/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.controller;

import com.appl.atm.model.BalanceCheck;
import com.appl.atm.model.Transaction;

/**
 *
 * @author Muhammad Reyhan S
 */
public class BalanceCheckController implements TransactionController{
    
    private BalanceCheck transaction;
    
    public BalanceCheckController(Transaction theTransaction) {
        transaction = (BalanceCheck) theTransaction;
    }
    
    @Override
    public int executeTransaction() {
        
        return 0;
    }
    
}
