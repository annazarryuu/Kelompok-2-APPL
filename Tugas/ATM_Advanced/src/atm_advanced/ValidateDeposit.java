/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm_advanced;

/**
 *
 * @author Muhammad Reyhan S
 */
public class ValidateDeposit extends Deposit {
    
    private Keypad keypad = new Keypad();
    
    public ValidateDeposit(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, DepositSlot atmDepositSlot) {
        super(userAccountNumber, atmScreen, atmBankDatabase, atmKeypad, atmDepositSlot);
    }
    
    @Override
    public void execute() {
        BankDatabase bankDatabase = getBankDatabase();
        System.out.print("Input account number: ");
        int accNum = keypad.getInput();
        if(bankDatabase.depositValidated(accNum)) {
            System.out.println("Deposit han been validated!");
        } else {
            System.out.println("No such account available!");
        }
    }
    
}
