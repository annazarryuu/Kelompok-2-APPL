/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appl.atm.model;

import java.util.Date;
/**
 *
 * @author Annazar
 */
public class SystemDate {
   
    private static Date prevDate;
    private static Date currDate;
    private static BankDatabase bankDatabase; 
    
    public SystemDate(BankDatabase theBankDatabase)
    {
	if(prevDate == null)
	    prevDate = new Date(System.currentTimeMillis());
	if(currDate == null)
	    currDate = new Date(System.currentTimeMillis());
	if(bankDatabase == null)
	    bankDatabase = theBankDatabase;
    }

    /**
     * @return the prevDate
     */
    public Date getPrevDate() {
	return prevDate;
    }

    /**
     * @param prevDate the prevDate to set
     */
    public void setPrevDate(Date prevDate) {
	this.prevDate = prevDate;
    }

    /**
     * @return the currDate
     */
    public Date getCurrDate() {
	return currDate;
    }

    /**
     * @param currDate the currDate to set
     */
    public void setCurrDate(Date currDate) {
	this.currDate = currDate;
    }
    
    public void dateCheck()
    {
	if(currDate.getYear() > prevDate.getYear() - 1)
	{
	    if(currDate.getMonth() > prevDate.getMonth())
	    {
		if(currDate.getDate() > 2)
		{
		    bankDatabase.monthlyPayment();
		    prevDate = currDate;
		}
	    }
	}
    }
}
