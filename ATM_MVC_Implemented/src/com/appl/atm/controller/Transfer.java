/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.controller;

import com.appl.atm.model.BankDatabase;
import com.appl.atm.model.Transaction;
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;

/**
 *
 * @author Muhammad Reyhan S
 */
public class Transfer extends Transaction {
    private int amounts;
    private Keypad keypad;
    private int targetAccount;
    private final static int CANCELED = 6;

    public Transfer(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad keyPad) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        keypad = keyPad;
    }

    @Override
    public int execute() {
        BankDatabase bankDatabase = getBankDatabase();
    
    displayMenuOfAmounts(bankDatabase);
    if (amounts > 0) {
        bankDatabase.debit(targetAccount, (float) amounts*-1);
        bankDatabase.debit(getAccountNumber(), amounts+(int)bankDatabase.getTransferTax(getAccountNumber()));
        return 0;
    } else return -1;
}

    private int displayMenuOfAmounts(BankDatabase bankDatabase) {
      Screen screen = getScreen();
      boolean validator;
              
      screen.displayMessage("Transfer Menu\n");
      
      do {
        screen.displayMessage("Input your target account number : ");
        targetAccount = keypad.getInput();
        if (targetAccount == super.getAccountNumber()) {
            validator = false;
            screen.displayMessage("\"Your Target\" not \"Your\" account number! \nIf you want to deposit money into your account, use the deposit option.\n");
        } else if ( !bankDatabase.validateAccount(targetAccount) ) {
            validator = false;
            screen.displayMessage("The account number you just inputed is not exist.\n");
        } else {
            validator = true;
        }
      } while ( !validator );
      
      do {
        screen.displayMessage("Input transfer amount : ");
        amounts = keypad.getInput();
	amounts = amounts + (int)getBankDatabase().getTransferTax(getAccountNumber());
        if (amounts < 0) {
            screen.displayMessage("The amount you try to transfer is insufficient!.\n");
        }
      } while (amounts < 0);
      
      return 0;
    }
    
}
