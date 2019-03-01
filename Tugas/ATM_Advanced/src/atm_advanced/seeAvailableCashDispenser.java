/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm_advanced;

/**
 *
 * @author Asus-Pro
 */
public class seeAvailableCashDispenser extends Transaction{
    
    private CashDispenser theCashDispenser = new CashDispenser();
    private Screen theScreen = new Screen();

    public seeAvailableCashDispenser(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
    }
    
    public void execute(){
        
   
   
    
}
     
    public void seeAvailableCashDispenser(){
        theScreen.displayMessageLine(String.valueOf(theCashDispenser.getCount()));
    }
    
    public void depositCashDispenser(){
        
    }
}




