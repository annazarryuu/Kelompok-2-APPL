/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

/**
 *
 * @author Cahya
 */
public class CashDispenser {
    
    private final static int INITIAL_COUNT = 50;
    private int count; // number of $20 bills remaining
    
    public CashDispenser() {
               count = INITIAL_COUNT; // set count attribute to default
    }

    public void dispenseCash(int amount) {
		// Deskripsi	: mengurangi jumlah cash yang ada pada
		//					Cash Dispenser
		// Author		: Cahya
                
                int billsRequired = amount / 20; // number of $20 bills required
                count -= billsRequired; // update the count of bills
    }

    public boolean isSufficientCashAvailable(int amount) {
		// Deskripsi	: mengecek apakah terdapat cukup cash
		//					pada Cash Dispenser
		// Author		: Cahya
                
                int billsRequired = amount / 20; // number of $20 bills required
                if (count >= billsRequired) {
                    return true; // enough bills available
                }
                else {
                    return false; // not enough bills available
                }
    }
   
}