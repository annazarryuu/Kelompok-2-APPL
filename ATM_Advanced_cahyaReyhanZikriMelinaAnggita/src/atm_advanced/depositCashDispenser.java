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
public class depositCashDispenser extends Transaction{
    
    CashDispenser cashDispenser;
    Screen theScreen = new Screen();
    Keypad theKeypad = new Keypad();
    double keypadInput;
    private final static int CANCELED = 0;

    public depositCashDispenser(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, CashDispenser atmCashDispenser) {
        super(userAccountNumber, atmScreen, atmBankDatabase);
        theScreen = getScreen();
        cashDispenser = atmCashDispenser;
    }
    
    public void execute(){
       int temp;
       temp = promptDepositAdmin(); //input the cash
       cashDispenser.addCountCash(temp); 
       if(temp != CANCELED){       
           theScreen.displayMessageLine("Cash has been deposited to cash dispenser.");
       } else {
           theScreen.displayMessageLine("Canceled.");           
       }
    }
    
    private int promptDepositAdmin(){
        boolean isValidInput = false;
        while(!isValidInput){
            theScreen.displayMessage("\nPlease enter a deposit amount : $"); //deposit amount of cash to cash dispenser
            keypadInput = theKeypad.getInput();

            if(keypadInput==CANCELED){
                isValidInput = true;
                return CANCELED;
            } else if(keypadInput % 20 == 0){
                isValidInput = true;
            } else {
                theScreen.displayMessage("\nPlease enter a valid amout!");                
            }
        }
        return (int) keypadInput / 20;
    }
}