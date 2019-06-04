/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm;

/**
 *
 * @author Annazar
 */
public class FutureAccount extends Account {
    
    public FutureAccount(int accountNumber, int pin,
			int availableBalance, int totalBalance) {
	
		super(accountNumber, pin, availableBalance, totalBalance,
			1, 0, 50);
    }
    
}
