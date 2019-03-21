/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appl.atm.model;

import static com.appl.atm.model.Constants.*;
import java.util.Date;

/**
 *
 * @author Annazar
 */
public class Statement implements Comparable<Statement>{

    private Transaction transaction;
    private int transacionType;
    private Date date;

    public Statement(Transaction theTransaction, int theTransacionType) {
	transaction = theTransaction;
	transacionType = theTransacionType;
	date = new SystemDate(0, null, null, null).getCurrDate();
    }

    /**
     * @return the transaction
     */
    public Transaction getTransaction() {
	return transaction;
    }

    /**
     * @param transaction the transaction to set
     */
    public void setTransaction(Transaction transaction) {
	this.transaction = transaction;
    }

    /**
     * @return the transacionType
     */
    public int getTransacionType() {
	return transacionType;
    }

    /**
     * @param transacionType the transacionType to set
     */
    public void setTransacionType(int transacionType) {
	this.transacionType = transacionType;
    }

    /**
     * @return the date
     */
    public Date getDate() {
	return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
	this.date = date;
    }

    @Override
    public int compareTo(Statement o) {
	if (transacionType == WITHDRAWAL) {
	    return -1 * Integer.compare(((Withdrawal) getTransaction()).getAmount(), ((Withdrawal) o.getTransaction()).getAmount());
	}
	
	return 0;
    }
}
