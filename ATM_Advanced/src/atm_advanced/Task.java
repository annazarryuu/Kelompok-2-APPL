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
public abstract class Task {
   
    abstract public void run();
    abstract protected void performTransactions();
    abstract protected void authenticateUser();
    abstract protected int displayMainMenu();
    abstract protected Transaction createTransaction();
}
