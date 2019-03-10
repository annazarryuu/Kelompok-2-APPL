/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import com.appl.atm.view.Screen;

/**
 *
 * @author Annazar
 */
public class BalanceInquiry extends Transaction {
    // BalanceInquiry constructor
    public BalanceInquiry(int userAccountNumber, Screen atmScreen, 
	BankDatabase atmBankDatabase) {

	super(userAccountNumber, atmScreen, atmBankDatabase);
    } 

    @Override
    public int execute() {
	return 0;
    }
}
