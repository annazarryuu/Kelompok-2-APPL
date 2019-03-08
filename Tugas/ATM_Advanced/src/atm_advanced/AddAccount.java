/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm_advanced;

/**
 *
 * @author User
 */
public class AddAccount extends Transaction {
    private Keypad keypad = new Keypad();
    
    public AddAccount(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
    }
    
    public void execute() {
        BankDatabase bankDatabase = getBankDatabase();
        
        System.out.print("Insert new account number : ");
        int newAccountNumber = keypad.getInput();
        System.out.print("Inser new PIN : ");
        int newPIN = keypad.getInput();
        
        bankDatabase.addAccount(newAccountNumber, newPIN);
    }
}