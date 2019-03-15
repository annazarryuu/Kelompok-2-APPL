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
<<<<<<< HEAD
        System.out.print("Choose account type : ");
        System.out.print("\n1. Siswa\n2. Masa Depan\n3. Bisnis\nInput your choice :");
=======
        System.out.print("Insert type of the account (1. Siswa, 2. Bisnis, 3. Masa Depan) : ");
>>>>>>> Advanced
        int accType = keypad.getInput();
        
        bankDatabase.addAccount(newAccountNumber, newPIN, accType);
    }
}
