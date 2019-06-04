/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.controller;

import com.appl.atm.model.Transaction;
import com.appl.atm.model.Transfer;

/**
 *
 * @author Muhammad Reyhan S
 */
public class TransferController implements TransactionController {

    private Transfer transaction;
    
    public TransferController(Transaction theTransaction) {
        transaction = (Transfer) theTransaction;
    }
    
    @Override
    public int executeTransaction() {
        
        return 0;
    }
    
}
