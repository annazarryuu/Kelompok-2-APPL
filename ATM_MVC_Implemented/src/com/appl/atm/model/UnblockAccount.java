/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appl.atm.model;

import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;

/**
 *
 * @author Cahya
 */
public class UnblockAccount extends Transaction {
    private Keypad keypad = new Keypad();
    
    public UnblockAccount(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
    }
    
    @Override
    public int execute() {
        BankDatabase bankDatabase = getBankDatabase();
        System.out.print("Insert Account Number : ");
        int input = keypad.getInput();
        return bankDatabase.unblockAccount(input);
    }

}
