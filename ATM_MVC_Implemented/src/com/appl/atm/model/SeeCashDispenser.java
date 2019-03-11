/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import com.appl.atm.view.Screen;
/**
 *
 * @author Asus-Pro
 */
public class SeeCashDispenser extends Transaction{
    
    private CashDispenser cashDispenser; // reference to cash dispenser

    public SeeCashDispenser(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, CashDispenser atmCashDispenser) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        cashDispenser = atmCashDispenser;
    }
    
    public int execute(){
        return cashDispenser.getCountCash();
    }
}




