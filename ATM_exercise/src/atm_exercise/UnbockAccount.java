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
public class UnbockAccount extends Transaction {
    private Keypad keypad;
    
    public UnbockAccount(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
    }
    
    public void execute() {
        BankDatabase bankDatabase = new BankDatabase();
        Account temp = new Account();
        
        System.out.println("Insert Account Number: ");
        int input = keypad.getInput();
        temp = bankDatabase.getAccount(input);
        if (temp != null){
            temp.setIsBlocked();
        }
    }
}
