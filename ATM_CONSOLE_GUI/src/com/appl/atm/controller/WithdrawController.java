/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appl.atm.controller;
import com.appl.atm.model.Transaction;
import com.appl.atm.model.Withdraw;
/**
 *
 * @author Cahya
 */
public class WithdrawController implements TransactionController {

    private Withdraw transaction;
    //private WithdrawViewController viewController;

/*
    public static final int WITHDRAWAL_CANCELED = 6;
    public static final int WITHDRAW_SUCCESSFUL = 1;
    public static final int BALANCE_NOT_ENOUGH = 2;
    public static final int CASHDISPENSER_NOT_ENOUGH = 3;
*/
    
    public WithdrawController(Transaction theTransaction
            //, ViewController viewController
            ) {
	transaction = (Withdraw) theTransaction;
    }

    @Override
    public int executeTransaction() {

        return 0;
    }

}