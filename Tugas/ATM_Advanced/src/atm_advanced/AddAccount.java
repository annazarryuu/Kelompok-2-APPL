/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm_exercise;

/**
 *
 * @author User
 */
public class AddAccount {
    private Keypad keypad;
    
    public AddAccount(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
    }
    
    public void execute() {
        BankDatabase bankDatabase = new BankDatabase();
        
        System.out.println("Insert new account number : ");
        int newAccountNumber = keypad.getInput();
        System.out.println("Inser new PIN : ");
        int newPIN = keypad.getInput();
        
        bankDatabase.AddAccount(newAccountNumber, newPIN);
    }
}
