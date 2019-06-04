/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.controller;
import com.appl.atm.model.Transaction;
import com.appl.atm.model.Deposit;

/**
 *
 * @author Tio
 */
public class DepositController implements TransactionController{
    
    private Deposit transaction;
//    private DepositViewController viewController;
    
    public DepositController (Transaction transaction
//            , ViewController viewController
    ) {
        this.transaction = (Deposit) transaction;
//        this viewController = (DepositViewController) viewController;
    }
    
    @Override
    public int executeTransaction() {
        
        return 0;
    }
    
}
