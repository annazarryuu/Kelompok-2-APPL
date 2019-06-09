/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import com.appl.atm.model.Account;
import java.util.ArrayList;

/**
 *
 * @author Annazar
 */
public class BankDatabase {
    private ArrayList<Account> accounts;
    
    public BankDatabase() {
		accounts = new ArrayList<>();
		accounts.add(new BusinessAccount(1234, 1234, 1000, 2000));
		accounts.add(new FutureAccount(2345, 2345, 500, 3000));
		accounts.add(new StudentAccount(3456, 3456, 200, 400));
    }
    
    public Account getAccount(int accountNumber) {
		// Deskripsi	: mencari akun dengan account number yang sesuai
		//					dengan parameter
		// Author		: Annazar
		
		for(Account account : accounts) {
			if(account.getAccountNumber() == accountNumber)
			{
				return account;
			}
		}
		return null;
    }
	
	// konstanta untuk otentifikasi user
    private final int AUTHENTICATE_SUCCESS = 0;
    private final int ACCOUNT_NOT_FOUND = -1;
    private final int INVALID_PIN = -2;
	
	public int authenticateUser(int accountNumber, int pin) {
		// Deskripsi	: melakukan otentifikasi terhadap account number dan
		//					pin yang diberikan
		// Author		: Annazar
		
		Account account = getAccount(accountNumber);
		if(account == null) {
			return ACCOUNT_NOT_FOUND;
		} else if(account.getPin() == pin) {
			return AUTHENTICATE_SUCCESS;
		} else {
			return INVALID_PIN;
		}
	}
}
