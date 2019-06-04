/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appl.atm.model;

import java.util.ArrayList;

public class BankDatabase {
    private ArrayList<Account> accounts;

    public Account getAccount(int accountNumber){
        return accounts.get(0);
    }
    public void mothlyPayment(){
        
    }
    public void dailyReset(){
        
    }
}
