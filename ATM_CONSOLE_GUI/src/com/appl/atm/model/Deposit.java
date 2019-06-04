/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

/**
 *
 * @author Tio
 */
public class Deposit extends Transaction {
    
    private int amount;
    private DepositSlot depositSlot;
    
    private final int DEPOSIT_SUCCESFUL = 0;
    private final int ENVELOPE_RECEIVED = 0;
    private final int ENVELOPE_IS_NOT_RECEIVED = -1;
    
    public Deposit (Account account, BankDatabase bankDatabase, DepositSlot depositSlot) {
        super(account, bankDatabase); 
        this.depositSlot = depositSlot;
    }
    
    @Override 
    public int executeTransaction () {
        if ( depositSlot.isEnvelopeReceived() == ENVELOPE_RECEIVED ) {
            Account account = getBankDatabase().getAccount(getUserAccount().getAccountNumber());
	    account.deposit(amount);
	    return DEPOSIT_SUCCESFUL;
	} else {
	    return ENVELOPE_IS_NOT_RECEIVED;
	}
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return the depositSlot
     */
    public DepositSlot getDepositSlot() {
        return depositSlot;
    }

    /**
     * @param depositSlot the depositSlot to set
     */
    public void setDepositSlot(DepositSlot depositSlot) {
        this.depositSlot = depositSlot;
    }
    
}
