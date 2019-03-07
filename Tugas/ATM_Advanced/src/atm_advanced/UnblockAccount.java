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
public class UnblockAccount extends Transaction {
    private Keypad keypad = new Keypad();
    
    public UnblockAccount(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
    }
    
    @Override
    public void execute() {
        BankDatabase bankDatabase = getBankDatabase();
        System.out.print("Insert Account Number : ");
        int input = keypad.getInput();
        bankDatabase.unblockAccount(input);
    }
}
