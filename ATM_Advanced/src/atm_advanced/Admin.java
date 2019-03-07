/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm_advanced;

/**
 *
 * @author ACER
 */
public class Admin extends Task{
    private boolean userAuthenticated; // whether user is authenticated
    private int currentAccountNumber; // current user's account number
    private Screen screen; // ATM's screen
    private Keypad keypad; // ATM's keypad
    private CashDispenser cashDispenser; // ATM's cash dispenser
    private DepositSlot depositSlot;
   
    private static final int UNBLOCK_ACCOUNT = 1;
    private static final int ADD_ACCOUNT = 2;
    private static final int VALIDATE_CASH = 3;
    private static final int CEK_DISPENSER = 4;
    private static final int ADD_DISPENSER = 5;
    private static final int EXIT = 6;
    
    public void run() {
      // welcome and authenticate user; perform transactions
      while (true) { 
        
      }
      
   }
    
    protected int displayMainMenu() {   
        screen.displayMessageLine("\nMain menu:");
        screen.displayMessageLine("1 - Unblock Account");
        screen.displayMessageLine("2 - Add Account");        
        screen.displayMessageLine("3 - Validate Account Cash");
        screen.displayMessageLine("4 - Cek Dispenser Cash");      
        screen.displayMessageLine("5 - Add Dispenser Cash");
        screen.displayMessageLine("6 - Exit\n");
        screen.displayMessage("Enter a choice: ");  
        return keypad.getInput(); // return user's selection
    }

    @Override
    protected void performTransactions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void authenticateUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Transaction createTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
