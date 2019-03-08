/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm_advanced;

import java.util.Date;

/**
 *
 * @author Annazar
 */
public class SystemDate {
    
    private Date prevDate;
    private Date currDate;
    
    public SystemDate()
    {
	prevDate = new Date(System.currentTimeMillis());
	currDate = new Date(System.currentTimeMillis());
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
    
    
    
}
