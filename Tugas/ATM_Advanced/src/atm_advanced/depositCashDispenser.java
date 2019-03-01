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
public class depositCashDispenser {
    
    Screen theScreen = new Screen();
    Keypad theKeypad = new Keypad();
    double keypadInput;
    private final static int CANCELED = 0;
    CashDispenser theCashDispenser = new CashDispenser();
     
    public void execute(){
       int temp;
       temp = promptDepositAdmin();
       theCashDispenser.setCount(temp);
       theScreen.displayMessageLine("Cash has been deposited to cash dispenser");
    }
    
    private int promptDepositAdmin(){
       
       theScreen.displayMessage("\nPlease enter a deposit amount");//deposit amount of cash to cash dispenser
       keypadInput = theKeypad.getInput();
       
       if(keypadInput==CANCELED){
           return CANCELED;
       }else{
           return (int) keypadInput;
       }
       
    }
}