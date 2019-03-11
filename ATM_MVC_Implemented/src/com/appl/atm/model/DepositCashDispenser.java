/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appl.atm.model;

import com.appl.atm.view.Screen;
import com.appl.atm.view.Keypad;
/**
 *
 * @author Cahya
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class DepositCashDispenser extends Transaction{
    
    CashDispenser cashDispenser;
    double keypadInput;
    private Keypad keypad; // reference to keypad
    private final static int CANCELED = 0;

    public DepositCashDispenser(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, CashDispenser atmCashDispenser, Keypad atmKeypad) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        cashDispenser = atmCashDispenser;
        keypad = atmKeypad;
    }
    
    public int execute(){
       int temp;
       temp = promptDepositAdmin(); //input the cash
       cashDispenser.addCountCash(temp); 
       return temp;
    }
    
    private int promptDepositAdmin(){
        boolean isValidInput = false;
        while(!isValidInput){
            getScreen().displayMessage("\nPlease enter a deposit amount : $"); //deposit amount of cash to cash dispenser
            keypadInput = keypad.getInput();

            if(keypadInput==CANCELED){
                isValidInput = true;
                return CANCELED;
            } else if(keypadInput % 20 == 0){
                isValidInput = true;
            } else {
                getScreen().displayMessage("\nPlease enter a valid amout!");                
            }
        }
        return (int) keypadInput / 20;
    }
}