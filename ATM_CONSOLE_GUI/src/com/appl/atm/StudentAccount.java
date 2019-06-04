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
public class StudentAccount extends Account {
    
    public StudentAccount(int accountNumber, int pin,
			int availableBalance, int totalBalance) {
	
		super(accountNumber, pin, availableBalance, totalBalance,
			0, 0, 20);
    }
    
}
