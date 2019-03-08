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
    
    displayMenuOfAmounts(bankDatabase);
    if (amounts != 0) {
        bankDatabase.debit(targetAccount, amounts*-1);
        bankDatabase.debit(getAccountNumber(), amounts);
    }
}

  private int displayMenuOfAmounts(BankDatabase bankDatabase) {
      
      Screen screen = getScreen();
      boolean validator;
              
      screen.displayMessage("Transfer Menu\n");
      
      do {
        screen.displayMessage("Input your target account number : ");
        targetAccount = keypad.getInput();
        if (targetAccount == super.getAccountNumber()) {
            validator = false;
            screen.displayMessage("\"Your Target\" not \"Your\" account number! \nIf you want to deposit money into your account, use the deposit option.\n");
        } else if ( !bankDatabase.validateAccount(targetAccount) ) {
            validator = false;
            screen.displayMessage("Is that person exist in your head? Sorry, but he's not real.\n");
        } else {
            validator = true;
        }
      } while ( !validator );
      
      do {
        screen.displayMessage("Input transfer amount : ");
        amounts = keypad.getInput();
        if (amounts < 0) {
            validator = false;
            screen.displayMessage("Yeah, go F7ck your self!\n");
        } else if ( amounts > bankDatabase.getAvailableBalance(targetAccount) ) {
            validator = false;
            screen.displayMessage("You're too poor to do that!\n");            
        } else {
            validator = true;
        }
      } while ( !validator );
      
      return 0;
      
   }

}
