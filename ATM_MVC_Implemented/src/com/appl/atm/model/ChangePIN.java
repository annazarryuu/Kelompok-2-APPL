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
 * @author Muhammad Reyhan S
 */
public class ChangePIN extends Transaction {

    private Keypad keypad;
    
    public ChangePIN(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        keypad = new Keypad();
    }

    public int execute(int newPIN) {
        Account currAcc = getBankDatabase().getAccount(getAccountNumber());
        
        if(currAcc != null) {
            currAcc.setPin(newPIN);
            return 0;
        } else return -1;
    }
    
    public Keypad getKeypad() {
	return keypad;
    }

    @Override
    public int execute() {
        return 0;
    }
    
}
