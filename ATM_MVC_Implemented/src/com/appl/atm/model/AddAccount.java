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

public class AddAccount extends Transaction {
    private Keypad keypad = new Keypad();

    
    public AddAccount(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
    }
    
    public int execute() {
        BankDatabase bankDatabase = getBankDatabase();
        
        getScreen().displayMessage("Insert new account number : ");
        int newAccountNumber = keypad.getInput();
        getScreen().displayMessage("Inser new PIN : ");
        int newPIN = keypad.getInput();
        
        return bankDatabase.addAccount(newAccountNumber, newPIN);
    }
}
