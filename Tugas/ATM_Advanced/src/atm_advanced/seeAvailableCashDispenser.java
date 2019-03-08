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
    
    private Screen theScreen = new Screen();
    private CashDispenser cashDispenser; // reference to cash dispenser

    public seeAvailableCashDispenser(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, CashDispenser atmCashDispenser) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        theScreen = getScreen();
        cashDispenser = atmCashDispenser;
    }
    
    public void execute(){
        System.out.print("Cash in dispenser : " + cashDispenser.getCountCash() + " bills of $20.\n");
    }
}




