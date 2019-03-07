/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm_advanced;

/**
 *
 * @author USER
 */
public class Transfer extends Transaction {
    private int amounts;
    private Keypad keypad;
    private int targetAccount;
    private final static int CANCELED = 6;

public Transfer( int accountNumber, Screen screen, Keypad keypadn, BankDatabase bankDatabase){

    super(accountNumber, screen, bankDatabase);
    keypad = keypadn;
}

 public void execute(){
    BankDatabase bankDatabase = getBankDatabase();
    
    displayMenuOfAmounts();
    bankDatabase.debit(targetAccount, amounts*-1);
    bankDatabase.debit(getAccountNumber(), amounts);
 }

  private int displayMenuOfAmounts() {
      
      Screen screen = getScreen();
      
      screen.displayMessage("Transfer Menu");
      screen.displayMessage("Input your target account number : ");
      targetAccount = keypad.getInput();
      screen.displayMessage("Input transfer amount : ");
      amounts = keypad.getInput();
      return 0;
      
   }

}
