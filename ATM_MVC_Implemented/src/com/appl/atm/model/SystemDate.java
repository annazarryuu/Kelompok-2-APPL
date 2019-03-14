/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.appl.atm.model;

import com.appl.atm.view.Keypad;
import com.appl.atm.view.Screen;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Annazar
 */
public class SystemDate extends Transaction {
   
    private static Date prevDate;
    private static Date currDate;
    private static BankDatabase bankDatabase; 
    private Keypad keypad; // reference to keypad
    Calendar calendar = Calendar.getInstance();
    private int day, month, year;
    
    public SystemDate(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad)
    {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        keypad = atmKeypad;
        if(prevDate == null)
	    prevDate = new Date(System.currentTimeMillis());
	if(currDate == null)
	    currDate = new Date(System.currentTimeMillis());
	if(bankDatabase == null)
	    bankDatabase = atmBankDatabase;
    }


    
    public int execute(){
        getScreen().displayMessageLine("Current Date : " + getPrevDate());
        getScreen().displayMessage("Input Day : ");   
        day = keypad.getInput();
        getScreen().displayMessage("Input Month : ");   
        month = keypad.getInput();
        getScreen().displayMessage("Input Year : ");   
        year = keypad.getInput();

        calendar.set(year, month - 1, day, 0, 0);
        currDate = calendar.getTime();
        prevDate = calendar.getTime();        
        getScreen().displayMessageLine("Current Date : " + getCurrDate());
        return 0;
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
