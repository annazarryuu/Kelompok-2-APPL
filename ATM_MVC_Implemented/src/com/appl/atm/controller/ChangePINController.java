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
        int newPIN = promptForNewPIN();
        int res = -1;
        if(newPIN != 0){
            res = changePIN.execute(newPIN);
        }
        promptMessage(res);
        return 0;
    }

    private int promptForNewPIN() {
        Screen screen = getScreen();
        BankDatabase bankDatabase = getBankDatabase();
        int currPIN, newPIN = 0;
        Account currAcc = getBankDatabase().getAccount(changePIN.getAccountNumber());
        
        screen.displayMessage("Please input your current PIN : ");
        currPIN = getKeypad().getInput();
        if(currAcc.getPin() == currPIN) {
            do{
                screen.displayMessage("Please input your new PIN : ");
                newPIN = getKeypad().getInput();
                if(currPIN == newPIN) {
                    screen.displayMessageLine("New PIN cannot be same as the old PIN.");
                } else return newPIN;
            }while(currPIN == newPIN);
            
        }
        
        return 0;
    }
    
    private void promptMessage(int res) {
        Screen screen = getScreen();
        if(res == 0) {
            screen.displayMessageLine("Change PIN Success!");
        } else {
            screen.displayMessageLine("Change PIN Failed!");
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
