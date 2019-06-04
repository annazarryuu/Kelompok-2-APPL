/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm;

import java.util.Scanner;

/**
 *
 * @author Annazar
 */
public class ATM {
    
    private boolean isAuthenticated = false;
	private Account currentAccount;
	private BankDatabase bankDatabase;
	
	public ATM() {
		bankDatabase = new BankDatabase();
	}
    
    public void run() {
		while(true) {
			showWelcomeMessage();

			while(!isAuthenticated) {
				isAuthenticated = authenticateUser();
			}

			while(isAuthenticated) {
				isAuthenticated = showMenu();
				showMessageLine("");
			}
		}
    }
    
    private void showWelcomeMessage() {
		showMessageLine("Welcome, customer.");
		showMessageLine("");
    }
	
	private boolean showMenu() {
		showMessageLine("1. Menu");
		showMessageLine("2. Menu");
		showMessageLine("3. Menu");
		showMessageLine("4. Menu");
		showMessageLine("5. Exit");
		showMessage("Input : ");
		if(getInput() == 5) return false;
		return true;
	}
	
	// konstanta untuk otentifikasi user
    private final int AUTHENTICATE_SUCCESS = 0;
    private final int ACCOUNT_NOT_FOUND = -1;
    private final int INVALID_PIN = -2;
    
    private boolean authenticateUser() {
		// Deskripsi	: meminta user memasukkan account number dan pin serta
		//					melakukan otentifikasi terhadap account number dan
		//					pin yang diberikan
		// Author		: Annazar
		
		showMessage("Account Number\t: ");
		int accountNumber = getInput();
		showMessage("PIN\t\t: ");
		int pinNumber = getInput();
		showMessageLine("");
		
		if(bankDatabase.authenticateUser(accountNumber, pinNumber)
				== AUTHENTICATE_SUCCESS) {
			
			currentAccount = bankDatabase.getAccount(accountNumber);
			return true;
		} else {
			return false;
		}
    }
    
    private void showMessage(String message) {
		System.out.print(message);
    }
    
    private void showMessageLine(String message) {
		System.out.println(message);
    }
    
    private int getInput() {
		return new Scanner(System.in).nextInt();
    }
}
