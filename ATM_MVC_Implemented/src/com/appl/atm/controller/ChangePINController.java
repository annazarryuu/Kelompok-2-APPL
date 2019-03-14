/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.controller;

import com.appl.atm.model.Account;
import com.appl.atm.model.BankDatabase;
import com.appl.atm.model.ChangePIN;
import com.appl.atm.model.Transaction;
import static com.appl.atm.model.Constants.*;
import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;

/**
 *
 * @author Muhammad Reyhan S
 */
public class ChangePINController extends TransactionController{

    private ChangePIN changePIN;
    
    public ChangePINController(Transaction theTransaction) {
        super(theTransaction);
        changePIN = (ChangePIN) getTransaction();
    }

    @Override
    public int run() {
        int newPIN = promptForPIN(0);
        changePIN.setNewPIN(newPIN);
        int currPIN = promptForPIN(1);
        changePIN.setCurrPIN(currPIN);
        int res = changePIN.execute();
        promptMessage(res);
        return 0;
    }

    private int promptForPIN(int status) {
        //status is for indicator wheter it's an old PIN or a new PIN
        //old PIN is 1 and new PIN is 0
        
        Screen screen = getScreen();
        int PIN = 0;
        
        if(status == 0){
            screen.displayMessage("Please input your new PIN : ");
        } else if(status == 1) {
            screen.displayMessage("Please input your current PIN : ");
        }
        PIN = getKeypad().getInput();
        
        return PIN;
    }
    
    private void promptMessage(int res) {
        Screen screen = getScreen();
        if(res == SAME_PIN_AS_BEFORE) {
            screen.displayMessageLine("Your new PIN is the same as your old PIN, PIN is not changed.");
        } else if(res == PIN_CHANGED_SUCCESSFULLY) {
            screen.displayMessageLine("Change PIN Successful!");
        }
    }
    
    private Screen getScreen() {
	return changePIN.getScreen();
    }
    
    private Keypad getKeypad() {
	return changePIN.getKeypad();
    }
    
    private BankDatabase getBankDatabase() {
	return changePIN.getBankDatabase();
    }
    
}
